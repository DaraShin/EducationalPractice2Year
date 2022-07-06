package com.epam.rd.autotasks.intersection;

public class Line {
    private int k;
    private int b;

    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public int getK() {
        return k;
    }

    public int getB() {
        return b;
    }

    public Point intersection(Line other) {
        if(this.getK() == other.getK()){
            return  null;
        }

        int intersectX = (other.getB() - this.getB()) / (this.getK() - other.getK());
        int intersectY = this.getK() * intersectX + this.getB();
        return new Point(intersectX, intersectY);
    }

}
