# RenderSymbols

![screenshot of sample](https://pp.vk.me/c604821/v604821939/20236/UG2-GZfaurQ.jpg)

Не большая библиотека на java для рисования символами в термилале или любом другом окне вывода

Все необходимое находится в common и drawing.
Пакет Neural - побочный. В Main - визуализация работы простейшей однослойной нейронной сети.

## Функционал
* fillRectangle
* drawRectangle
* drawLine
* drawLines
* drawPolygon
* drawCircle
* drawEllipse
* drawTextHorizontal
* drawTextVetical
* drawPoint

## Использование

Инициализация графики
```java
Graphics graphics = new Graphics();
```

Инициализация поверхности
```java
Surface surface = new Surface(100, 50);
```

Установка текущего graphics(т.к. можно будет создовать свои на основе имеющегося Graphics)
```java
surface.setGraphics(graphics);
```

Установка символа очистки
```java
surface.setClearSymbol("0");
```

Перерисовка поверхности
```java
surface.clear();
surface.draw();
```
Для начала необходимо рисовать на graphics, а уже потом перерисовывать поверхность

## Рендеринг в отдельном потоке

Создание рендера
```java
// surface создается как описано выше
ThreadDrawing threadDrawing = new ThreadDrawing(surface);
threadDrawing.setTimeStep(1000); // миллисекунды задержки
threadDrawing.setRendering(true);
```
Остановка рендера:
```java
threadDrawing.setRendering(false);
```

## Отрисовка с использованием рендера

Создается отдельный класс наследующий и имплементирующий методы класса ListenerLoop
```java
public class App implements ListenerLoop {
    @Override
    public void update() {
        // Обновление логики
    }

    @Override
    public void draw() {
        surface.clear();
        // тут происходит рисование в Graphics
        surface.draw();
    }
}
```

Необходимо рендеру указать класс который необходио обновлять и перерисовывать
```java
threadDrawing.addListenerLoop(listenerLoopApp);
```
