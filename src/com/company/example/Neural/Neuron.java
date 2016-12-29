package com.company.example.Neural;

import com.company.Core.Common.Vector2;
import com.company.Core.Drawing.Graphics;

import java.util.Random;

import static com.company.Main.log;

/**
 * Created by stas on 27.12.16.
 */
public class Neuron extends Vector2 {
    private String name;
    private float[] width;
    public float power;
    private Graphics graphics;
    private Random random;

    public Neuron(float x, float y, String name, float[] width) {
        this.width = width;
        this.random = new Random();
        this.power = 0;
        this.setX(x);
        this.setY(y);
        this.name = name;

        log("[" + name + "] add neuron: ", this.toString());
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public void draw() {
//        graphics.fillRectangle(graphics.getWidth()/2+(int)getX()-2,
//                graphics.getHeight()/2+(int)getY()-1, 5, 3, "#");
        graphics.drawEllipse(new Vector2(graphics.getWidth()/2+(int)getX()-2,
                graphics.getHeight()/2+(int)getY()-1), 3, 2, "#");
        graphics.drawTextHorizontal(graphics.getWidth()/2+(int)getX(), (int)getY() +
                graphics.getHeight()/2, getName());
    }

    public float getPower(float[] w) {
        power = 0;
        for (int i = 0; i < width.length; i++) {
            power += this.width[i] * w[i];
        }
        return power;
    }

    public void randomPosition() {
        setX(getX() + (int)(Math.cos(createRandom(7)) * power));
        setY(getY() + (int)(Math.sin(createRandom(7)) * power));
    }

    public double createRandom(int value) {
        return 2+random.nextDouble() * value*2+value*-1;
    }

    @Override
    public String toString() {
        return "name["+name+"] x[" + getX() + "] y[" + getY() + "]";
    }

    public String getName() {
        return name;
    }
}
