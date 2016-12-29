package com.rendersymbols.example;

import com.rendersymbols.core.common.ListenerLoop;
import com.rendersymbols.core.drawing.Graphics;
import com.rendersymbols.core.drawing.Surface;
import com.rendersymbols.core.drawing.ThreadDrawing;
import com.rendersymbols.example.Neural.Network;

/**
 * Created by User on 12/29/2016.
 */
public class App implements ListenerLoop {
    private float yes = 0.8f;
    private float no = -0.8f;

    private Surface surface;
    private Graphics graphics;
    private ThreadDrawing threadDrawing;
    private Network network;

    public App() {
        createRenderer();
        createNetwork();

        threadDrawing.setRendering(true);
    }

    public void update() {
        network.recognize(getObject2());
    }

    public void draw() {
        surface.clear();
        network.draw();
        surface.draw();
    }

    private void createRenderer() {
        graphics = new Graphics();
        surface = new Surface(100, 35);
        surface.setGraphics(graphics);
        surface.setClearSymbol(" ");
        surface.clear();
        threadDrawing = new ThreadDrawing(surface);
        threadDrawing.addListenerLoop(this);
    }

    private void createNetwork() {
        network = new Network(graphics);
        network.addNeuron("1", getObject1());
        network.addNeuron("2", getObject2());
    }

    private float[] getObject1() {
        return new float[] {
                yes, yes, no, yes, yes,
                yes, yes, no, yes, yes,
                yes, yes, no, yes, yes,
                yes, yes, no, yes, yes,
                yes, yes, no, yes, yes,
        };
    }
    private float[] getObject2() {
        return new float[] {
                yes, no, no, no, yes,
                yes, yes, no, yes, yes,
                yes, yes, no, yes, yes,
                yes, yes, no, yes, yes,
                no, no, no, no, no,
        };
    }
}
