# RenderSymbols

[![Coverage Status](https://coveralls.io/repos/github/Winster332/RenderSymbols/badge.svg)](https://coveralls.io/github/Winster332/RenderSymbols)
[![Build Status](https://travis-ci.org/Winster332/RenderSymbols.svg?branch=master)](https://travis-ci.org/Winster332/RenderSymbols.svg?branch=master)

![screenshot of sample](https://pp.vk.me/c604821/v604821939/20236/UG2-GZfaurQ.jpg)

A small java library for drawing characters in a terminal or any other output window.

Everything you need is in common и drawing.
Package Neural - side. In Main - visualization of the work of the simplest single-layer neural network.

## Functions
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

## Use

Graphics initialization
```java
Graphics graphics = new Graphics();
```

Surface initialization
```java
Surface surface = new Surface(100, 50);
```

Set the current graphics (because you can create your own based on the existing Graphics)
```java
surface.setGraphics(graphics);
```

Setting the cleaning character
```java
surface.setClearSymbol("0");
```

Surface redrawing
```java
surface.clear();
surface.draw();
```

First you need to draw on graphics, and only then redraw the surface

### Rendering in a separate stream

Render creation
```java
// surface created as described above
ThreadDrawing threadDrawing = new ThreadDrawing(surface);
threadDrawing.setTimeStep(1000); // миллисекунды задержки
threadDrawing.setRendering(true);
```
Render stop:
```java
threadDrawing.setRendering(false);
```

### Render Rendering

A separate class is created that inherits and implements class methods. ListenerLoop
```java
public class App implements ListenerLoop {
    @Override
    public void update() {
        // Logic update
    }

    @Override
    public void draw() {
        surface.clear();
        // there is drawing in Graphics
        surface.draw();
    }
}
```

It is necessary for the renderer to specify the class that needs to be updated and drawn.
```java
threadDrawing.addListenerLoop(listenerLoopApp);
```
