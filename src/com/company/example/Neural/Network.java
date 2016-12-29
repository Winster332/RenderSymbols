package com.company.example.Neural;

import com.company.core.Common.Vector2;
import com.company.core.Drawing.Graphics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 28.12.16.
 */
public class Network {
    private Graphics graphics;
    private List<Neuron> neurons;

    public Network(Graphics graphics) {
        this.graphics = graphics;
        neurons = new ArrayList<>();
    }

    public void addNeuron(String name, float[] width) {
        Neuron neuron = new Neuron(0, 0, name, width);
        neuron.setGraphics(graphics);
        neurons.add(neuron);
    }

    public Neuron recognize(float[] input) {
        int index = 0;
        for (int i = 0; i < neurons.size(); i++) {
            float power1 = neurons.get(i).getPower(input);
            float power2 = neurons.get(index).getPower(input);


            System.out.println("["+neurons.get(i).getName()+"] power:" + power1);

            if (power1 > power2)
                index = i;
        }
        System.out.println("this: " + neurons.get(index).getName());

        neurons.get(index).power /= 5;
        for (int i = 0; i < neurons.size(); i++) {
            neurons.get(i).power*=2;
            neurons.get(i).randomPosition();
        }

        return neurons.get(index);
    }

    public void draw() {
        Vector2 center = new Vector2(graphics.getWidth() / 2 - 2, graphics.getHeight() / 2 - 1);
        graphics.fillRectangle((int)center.getX(), (int)center.getY(), 5, 3, "+");

        for (int i = 0; i < neurons.size(); i++) {
        //    System.out.println(neurons.get(i).add(center).toString());
            graphics.drawLine(new Vector2(center.getX()+2, center.getY()+1), new Vector2(
                    neurons.get(i).getX() + center.getX(),
                    neurons.get(i).getY() + center.getY()), neurons.get(i).getName());
            neurons.get(i).draw();
        }
    }
}
