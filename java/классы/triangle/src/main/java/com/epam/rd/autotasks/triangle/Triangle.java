package com.epam.rd.autotasks.triangle;

class Triangle {
    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle(Point a, Point b, Point c) {
        Segment side1 = new Segment(a, b);
        Segment side2 = new Segment(b, c);
        Segment side3 = new Segment(a, c);
        double length1 = side1.length();
        double length2 = side2.length();
        double length3 = side3.length();

        if(length1 + length2 <= length3){
            throw new IllegalArgumentException();
        }

        if(length1 + length3 <= length2){
            throw new IllegalArgumentException();
        }

        if(length2 + length3 <= length1){
            throw new IllegalArgumentException();
        }

        point1 = a;
        point2 = b;
        point3 = c;
    }

    public double area() {
        Segment side1 = new Segment(point1, point2);
        Segment side2 = new Segment(point2, point3);
        Segment side3 = new Segment(point1, point3);
        double length1 = side1.length();
        double length2 = side2.length();
        double length3 = side3.length();

        double halfPerimeter = (length1 + length2 + length3) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - length1) *
                (halfPerimeter - length2) * (halfPerimeter - length3));

    }

    public Point centroid(){
        Segment side1 = new Segment(point1, point2);
        Segment side2 = new Segment(point2, point3);

        Segment median1 = new Segment(point3, side1.middle());
        Segment median2 = new Segment(point1, side2.middle());

        return median1.intersection(median2);
    }

}
