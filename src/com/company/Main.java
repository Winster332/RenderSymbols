package com.company;


import com.company.Drawing.Graphics;
import com.company.Drawing.Surface;
import com.company.Neural.Network;

public class Main {
    public static void log(String... texts) {
        System.out.print("Log: ");
        for (String text : texts) {
            System.out.print(text);
        }
        System.out.println();
    }
    public static void error(String... texts) {
        System.err.print("Error: ");
        for (String text : texts) {
            System.out.print(text);
        }
        System.out.println();
    }

    public static void drawingNetwork(){
        Graphics graphics = new Graphics();
        Surface surface = new Surface(100, 35);
        surface.setGraphics(graphics);
        surface.setClearSymbol(" ");
        surface.clear();
        Network network = new Network(graphics);

        float yes = 0.8f;
        float no = -0.8f;

        float[] t1 = new float[] {
                yes, yes, no, yes, yes,
                yes, yes, no, yes, yes,
                yes, yes, no, yes, yes,
                yes, yes, no, yes, yes,
                yes, yes, no, yes, yes,
        };
        float[] t2 = new float[] {
                yes, no, no, no, yes,
                yes, yes, no, yes, yes,
                yes, yes, no, yes, yes,
                yes, yes, no, yes, yes,
                no, no, no, no, no,
        };

        network.addNeuron("1", t1);
        network.addNeuron("2", t2);

        network.recognize(t1);

        network.draw();
        surface.draw();
    }

    public static void main(String[] args) throws InterruptedException {
        long time = System.nanoTime();

        for (int i = 0; i < 100; i++) {
            drawingNetwork();
            Thread.sleep(500);
        }

        time = System.nanoTime() - time;
        System.out.println("nano time: " + (time));
    }
}
