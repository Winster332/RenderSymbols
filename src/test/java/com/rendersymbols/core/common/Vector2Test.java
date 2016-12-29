package com.rendersymbols.core.common;

import org.junit.Before;
import org.junit.Test;

import static com.rendersymbols.Main.log;
import static org.junit.Assert.*;

/**
 * Created by User on 12/30/2016.
 */
public class Vector2Test {
    @Test
    public void create() throws Exception {
        Vector2 vector1 = new Vector2();
        Vector2 vector2 = new Vector2(0, 0);

        assertNotNull(vector1);
        assertNotNull(vector2);

        assertEquals(vector1.toString(), vector2.toString());
    }

    @Test
    public void getVectorFromAngle() throws Exception {
        Vector2 vector = Vector2.getVectorFromAngle(1);
        log(vector.toString());

        assertEquals(new Vector2(0.5403023f, 0.84147096f).toString(), vector.toString());
    }

    @Test
    public void getAngle() throws Exception {
        Vector2 vector = new Vector2(10, 10);
        Vector2 vector2 = new Vector2(42, 32);
        float angle = vector.getAngle(vector2);

        log(String.valueOf(angle));

        assertEquals(String.valueOf(0.60228735f), String.valueOf(angle));
    }

    @Test
    public void setX() throws Exception {
        Vector2 vector1 = new Vector2(100, 0);
        Vector2 vector2 = new Vector2();
        vector2.setX(100);

        assertEquals(vector1.toString(), vector2.toString());
    }

    @Test
    public void setY() throws Exception {
        Vector2 vector1 = new Vector2(0, 150);
        Vector2 vector2 = new Vector2();
        vector2.setY(150);
        assertEquals(vector1.toString(), vector2.toString());
    }

    @Test
    public void getY() throws Exception {
        Vector2 vector = new Vector2(0, 150);

        assertEquals(150, (int)vector.getY());
    }

    @Test
    public void getX() throws Exception {
        Vector2 vector = new Vector2(10, 0);

        assertEquals(10, (int)vector.getX());
    }

    @Test
    public void getDistance() throws Exception {
        Vector2 vector1 = new Vector2(0, 150);
        Vector2 vector2 = new Vector2(150, 0);
        float distance = vector1.getDistance(vector2);

        log(String.valueOf(distance));

        assertEquals(String.valueOf(212.13203), String.valueOf(distance));
    }

    @Test
    public void add() throws Exception {
        Vector2 vector1 = new Vector2(0, 150);
        Vector2 vector2 = new Vector2(150, 0);
        Vector2 result = new Vector2(150, 150);

        vector1.add(vector2);

        log(String.valueOf(result.toString()));

        assertEquals(result.toString(), vector1.toString());
    }

    @Test
    public void addX() throws Exception {
        Vector2 vector1 = new Vector2(0, 150);
        Vector2 result = new Vector2(150, 150);

        vector1.addX(150);

        log(String.valueOf(result.toString()));

        assertEquals(result.toString(), vector1.toString());
    }

    @Test
    public void addY() throws Exception {
        Vector2 vector1 = new Vector2(0, 150);
        Vector2 result = new Vector2(0, 300);

        vector1.addY(150);

        log(String.valueOf(result.toString()));

        assertEquals(result.toString(), vector1.toString());
    }

    @Test
    public void toInteger() throws Exception {
        Vector2 vector1 = new Vector2(130.213f, 150.9f);
        Vector2 vector2 = new Vector2(130, 151);

        int resultX = (int)Vector2.toInteger(vector1).getX();
        int resultY = (int)Vector2.toInteger(vector1).getY();

        assertEquals(vector2.toString(), new Vector2(resultX, resultY).toString());
    }
}