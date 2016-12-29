package com.company.Core.Drawing;

import com.company.Core.Common.ListenerLoop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 28.12.16.
 */
public class ThreadDrawing extends Thread {
    private List<ListenerLoop> loops;
    private Surface surface;
    private int timeStep;
    private boolean isRendering;

    public ThreadDrawing(Surface surface) {
        this.surface = surface;
        loops = new ArrayList<>();
        setTimeStep(1000);
        setRendering(false);
    }

    public void addListenerLoop(ListenerLoop listenerLoop) {
        loops.add(listenerLoop);
    }

    public void removeListenerLoop(ListenerLoop listenerLoop) {
        loops.remove(listenerLoop);
    }

    public void removeListenerLoop(int index) {
        loops.remove(index);
    }

    @Override
    public void run() {
        while (isRendering()) {
            try {
                synchronized (surface) {
                    for (int i = 0; i < loops.size(); i++) {
                        loops.get(i).update();
                        loops.get(i).draw();
                    }
                    Thread.sleep(getTimeStep());
                }
            } catch (Exception ex) {

            }
        }
    }

    public boolean isRendering() {
        return isRendering;
    }

    public void stopDrawing() {
        boolean retry = true;
        while (retry) {
            try {
                this.join();
                retry = false;
            } catch (Exception ex) {}
        }
    }

    public void setRendering(boolean rendering) {
        isRendering = rendering;

        if (isRendering()) {
            run();
        } else stopDrawing();
    }

    public int getTimeStep() {
        return timeStep;
    }

    public Surface getSurface() {
        return surface;
    }

    public void setTimeStep(int timeStep) {
        this.timeStep = timeStep;
    }
}
