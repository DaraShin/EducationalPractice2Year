package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    private Point vertex1;
    private Point vertex2;
    private Point vertex3;
    private Point vertex4;

    public Quadrilateral(Point vertex1, Point vertex2, Point vertex3, Point vertex4) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
        this.vertex4 = vertex4;
    }

    @Override
    public double area() {
        double a = (new Segment(vertex1, vertex2)).length();
        double b = (new Segment(vertex2, vertex3)).length();
        double c = (new Segment(vertex3, vertex4)).length();
        double d = (new Segment(vertex4, vertex1)).length();
        double diagonal1 = (new Segment(vertex1, vertex3)).length();
        double diagonal2 = (new Segment(vertex2, vertex4)).length();

        double halfPerimeter = (a + b + c + d) / 2;

        return Math.sqrt(4 * diagonal1 * diagonal1 * diagonal2 * diagonal2 -
                Math.pow((a * a + c * c - b * b - d * d), 2)) / 4;

    }

    @Override
    public String pointsToString() {
        return vertex1.toString() + vertex2 + vertex3 + vertex4;
    }

    @Override
    public Point leftmostPoint() {
        Point leftPoint = vertex1;

        if (vertex2.getX() < leftPoint.getX()) {
            leftPoint = vertex2;
        }
        if (vertex3.getX() < leftPoint.getX()) {
            leftPoint = vertex3;
        }
        if (vertex4.getX() < leftPoint.getX()) {
            leftPoint = vertex4;
        }
        return leftPoint;
    }
}
