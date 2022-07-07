package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    private Point vertex1;
    private Point vertex2;
    private Point vertex3;

    public Triangle(Point vertex1, Point vertex2, Point vertex3) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
    }

    @Override
    public double area() {
        double a = (new Segment(vertex1, vertex2)).length();
        double b = (new Segment(vertex2, vertex3)).length();
        double c = (new Segment(vertex3, vertex1)).length();

        double halfPerimeter = (a + b + c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

    @Override
    public String pointsToString(){
        return  vertex1.toString() + vertex2.toString() + vertex3.toString();
    }

    @Override
    public Point leftmostPoint() {
        Point leftPoint = vertex1;
        if(vertex2.getX() < leftPoint.getX()){
            leftPoint = vertex2;
        }
        if(vertex3.getX() < leftPoint.getX()){
            leftPoint = vertex3;
        }
        return leftPoint;
    }
}
