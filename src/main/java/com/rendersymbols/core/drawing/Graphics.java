package com.rendersymbols.core.drawing;

import com.rendersymbols.core.common.Vector2;

/**
 * Created by stas on 27.12.16.
 */
public class Graphics {
    private Surface surface;

    public Graphics() {
    }

    public void setSurface(Surface surface) {
        this.surface = surface;
    }

    public void fillRectangle(int x, int y, int width, int height, String symbol) {
        for (int j = y; j < y + height; j++)
            for (int i = x; i < x + width; i++)
                drawPoint(i, j, symbol);
    }

    public void drawRectangle(int x, int y, int width, int height, String symbol) {
        drawLine(new Vector2(x, y), new Vector2(x+width, y), symbol);
        drawLine(new Vector2(x+width, y), new Vector2(x+width, y+height-1), symbol);
        drawLine(new Vector2(x+width, y+height-1), new Vector2(x, y+height-1), symbol);
        drawLine(new Vector2(x, y+height-1), new Vector2(x, y), symbol);
    }

    public void drawLines(Vector2[] vertex, String symbol) {
        for (int i = 0, j = 1; i < vertex.length; j = i++) {
            drawLine(vertex[i], vertex[j], symbol);
        }
    }

    public void drawPolygon(Vector2[] vertex, String symbol) {
        Vector2 prevPoint = vertex[0];

        for (int i = 1; i < vertex.length; i++) {
            drawLine(prevPoint, vertex[i], symbol);
            prevPoint = vertex[i];
        }
    }

    public void drawCircle(Vector2 position, int radius, String symbol) {

        for (float angle = 0; angle < Math.PI*2; angle+=Math.PI/(Math.PI*radius)) {
            float x = (float) Math.cos(angle)*radius;
            float y = (float) Math.sin(angle)*radius;

            drawPoint((int)Math.rint(position.getX()+x), (int)Math.rint(position.getY()+y), symbol);
        }
    }

    public void drawEllipse(Vector2 position, int width, float height, String symbol) {

        for (float angle = 0; angle < 180; angle++) {
            float x = (float) Math.cos(angle)*width;
            float y = (float) Math.sin(angle)*height;

            drawPoint((int)Math.rint(position.getX()+x), (int)Math.rint(position.getY()+y), symbol);
        }
    }

    public void drawTextHorizontal(int x, int y, String text) {
        for (int i = 0; i < text.length(); i++) {
            drawPoint(x+i, y, String.valueOf(text.charAt(i)));
        }
    }

    public void drawTextVertical(int x, int y, String text) {
        for (int i = 0; i < text.length(); i++) {
            drawPoint(x, y+i, String.valueOf(text.charAt(i)));
        }
    }

    public int getWidth() {
        return surface.getWidth();
    }


    public int getHeight() {
        return surface.getHeight();
    }

    public void drawLine(Vector2 v1, Vector2 v2, String symbol) {
        drawPoint((int) v1.getX(), (int) v1.getY(), symbol);
        drawPoint((int) v2.getX(), (int) v2.getY(), symbol);

        float angle = v1.getAngle(v2);
        Vector2 vector = Vector2.getVectorFromAngle(angle);
        Vector2 position = new Vector2(v1.getX(), v1.getY());

        int distance = (int)Math.rint(v1.getDistance(v2));

        for (int i = 0; i < distance; i++) {
            int x = (int) Vector2.toInteger(position).getX();
            int y = (int) Vector2.toInteger(position).getY();

            drawPoint(x, y, symbol);

            position.add(vector);
        }
    }

    public void drawPoint(int x, int y, String symbol) {
        surface.setSymbol(x, y, symbol);
    }
}
