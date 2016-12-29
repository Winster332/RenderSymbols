package com.rendersymbols.core.drawing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 12/30/2016.
 */
public class SurfaceTest {
    private Surface surface;
    private int WIDTH = 100;
    private int HEIGHT = 30;

    @Before
    public void setup() {
        surface = new Surface(WIDTH, HEIGHT);

        assertNotNull(surface);
    }

    @Test
    public void clear() throws Exception {
        surface.clear();
    }

    @Test
    public void getClearSymbol() throws Exception {
        surface.setClearSymbol("13");
        assertEquals("13", surface.getClearSymbol());
    }

    @Test
    public void setClearSymbol() throws Exception {
        surface.setClearSymbol("1");
        assertEquals("1", surface.getClearSymbol());
    }

    @Test
    public void setGraphics() throws Exception {
        Graphics graphics = new Graphics();
        surface.setGraphics(graphics);

        assertNotNull(graphics.getSurface());
    }

    @Test
    public void draw() throws Exception {
        Graphics graphics = new Graphics();
        surface.setGraphics(graphics);

        surface.draw();

        assertEquals(WIDTH, surface.getBuffer().length);
        assertEquals(HEIGHT, surface.getBuffer()[1].length);
    }

    @Test
    public void setSymbol() throws Exception {
        Graphics graphics = new Graphics();
        surface.setGraphics(graphics);

        surface.setSymbol(2, 2, "Y");
        surface.draw();

        assertEquals("Y", surface.getBuffer()[2][2]);
    }

    @Test
    public void getBuffer() throws Exception {
        assertEquals(WIDTH, surface.getBuffer().length);
        assertEquals(HEIGHT, surface.getBuffer()[1].length);
    }

    @Test
    public void getHeight() throws Exception {
        assertEquals(HEIGHT, surface.getHeight());
    }

    @Test
    public void getWidth() throws Exception {
        assertEquals(WIDTH, surface.getWidth());
    }

}