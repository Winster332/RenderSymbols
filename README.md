# RenderSymbols

![screenshot of sample](https://pp.vk.me/c604821/v604821939/20236/UG2-GZfaurQ.jpg)

Не большая библиотека на java для рисования символами в термилале или любом другом окне вывода

Все необходимое находится в common и drawing.
Пакет Neural - побочный. В Main - визуализация работы простейшой однослойной нейронной сети.

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
surface.draw();
```

Для начала необходимо рисовать на graphics, а уже потом перерисовывать поверхность
