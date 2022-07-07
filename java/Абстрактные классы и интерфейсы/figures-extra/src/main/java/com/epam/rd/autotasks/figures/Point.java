package com.epam.rd.autotasks.figures;

import java.lang.Comparable;

class Point implements Comparable<Point> {
    private double x;
    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public int compareTo(Point o) {
        if (Math.abs(this.x - o.x) < Math.pow(10, -10)) {
            if (Math.abs(this.y - o.y) < Math.pow(10, -10)) {
                return 0;
            }
            if (this.y < o.y) {
                return -1;
            }
            if (this.y > o.y) {
                return 1;
            }
        }

        if (this.x < o.x) {
            return -1;
        }

        if (this.x > o.x) {
            return 1;
        }
        return 0;
    }
}
