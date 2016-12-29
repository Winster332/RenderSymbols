package com.rendersymbols.core.drawing;

/**
 * Created by stas on 27.12.16.
 */
public class Surface {
    private int width;
    private int height;
    private String buffer[][];
    private String clearSymbol;
    private Graphics graphics;

    public Surface(int width, int height) {
        this.width = width;
        this.height = height;
        this.clearSymbol = "0";

        buffer = new String[width][height];
        clear();
        draw();
    }

    public void clear() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                buffer[i][j] = clearSymbol;
            }
        }
    }

    public String getClearSymbol() {
        return clearSymbol;
    }

    public void setClearSymbol(String clearSymbol) {
        this.clearSymbol = clearSymbol;
    }

    public void setGraphics(Graphics graphics) {
        graphics.setSurface(this);
        this.graphics = graphics;
    }

    public void draw() {
        for (int i = 0; i < 20; i++)
            System.out.println();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(buffer[j][i]);
            }
            System.out.println();
        }
    }

    public void setSymbol(int x, int y, String symbol) {
        if (x < 0 || y< 0) return;

        if (buffer.length < x || buffer[0].length < 0) return;

        buffer[x][y] = symbol;
    }

    public String[][] getBuffer() {
        return buffer;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
