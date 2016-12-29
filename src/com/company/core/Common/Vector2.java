package com.company.core.Common;

/**
 * Created by stas on 27.12.16.
 */
public class Vector2 {
    private float x;
    private float y;

    public Vector2() {
        x = 0;
        y = 0;
    }

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static Vector2 getVectorFromAngle(float angle) {
        return new Vector2((float)Math.cos(angle), (float)Math.sin(angle));
    }

    public float getAngle(Vector2 v1) {
        return (float)Math.atan2(v1.getY() - getY(), v1.getX() - getX());
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public float getX() {
        return this.x;
    }

    public float getDistance(Vector2 v) {
        return (float)Math.sqrt(Math.pow(v.getX() - getX(), 2) + Math.pow(v.getY() - getY(), 2));
    }

    public Vector2 add(Vector2 v) {
        this.x += v.getX();
        this.y += v.getY();
        return this;
    }

    public void addX(float x) {
        this.setX(getX() + x);
    }

    public void addY(float y) {
        this.setY(getY() + y);
    }

    public static Vector2 toInteger(Vector2 vector) {
        Vector2 v = new Vector2();
        v.setX((int)Math.rint(vector.getX()));
        v.setY((int)Math.rint(vector.getY()));
        return vector;
    }

    @Override
    public String toString() {
        return "x[" + getX() + "] y[" + getY() + "]";
    }
}
