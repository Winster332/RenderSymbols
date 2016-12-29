package com.company.example;

import com.company.core.Common.ListenerLoop;
import com.company.core.Drawing.Graphics;
import com.company.core.Drawing.Surface;
import com.company.core.Drawing.ThreadDrawing;
import com.company.example.Neural.Network;

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

    @Override
    public void update() {
        network.recognize(getObject2());
    }

    @Override
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
