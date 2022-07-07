package com.epam.rd.autotasks.figures;

import java.util.Arrays;

class Triangle extends Figure {
    private Point[] vertexArray;

    public Triangle(Point vertex1, Point vertex2, Point vertex3) {
        if (vertex1 == null || vertex2 == null || vertex3 == null) {
            throw new IllegalArgumentException();
        }

        double a = (new Segment(vertex1, vertex2)).length();
        double b = (new Segment(vertex2, vertex3)).length();
        double c = (new Segment(vertex3, vertex1)).length();

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException();
        }
        if (Math.abs(a + b - c) <= Math.pow(10, -5) || Math.abs(a + c - b) <= Math.pow(10, -5)
                || Math.abs(b + c - a) <= Math.pow(10, -5)){
            throw new IllegalArgumentException();
        }

        vertexArray = new Point[3];
        vertexArray[0] = vertex1;
        vertexArray[1] = vertex2;
        vertexArray[2] = vertex3;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (!(figure instanceof Triangle)) {
            return false;
        }

        Arrays.sort(vertexArray);
        Arrays.sort(((Triangle) figure).vertexArray);

        for (int i = 0; i < 3; i++) {
            if (vertexArray[i].compareTo(((Triangle) figure).vertexArray[i]) != 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Point centroid() {
        double centerX = (vertexArray[0].getX() + vertexArray[1].getX()+vertexArray[2].getX()) / 3;
        double centerY = (vertexArray[0].getY() + vertexArray[1].getY()+vertexArray[2].getY()) / 3;
        return new Point(centerX, centerY);
    }

    /*ublic Point centroid() {
        Segment side1 = new Segment(vertexArray[0], vertexArray[1]);
        Segment side2 = new Segment(vertexArray[1], vertexArray[2]);

        Segment median1 = new Segment(vertexArray[2], side1.middle());
        Segment median2 = new Segment(vertexArray[0], side2.middle());

        return median1.intersection(median2);
    }*/



    public double area() {
        double a = (new Segment(vertexArray[0], vertexArray[1])).length();
        double b = (new Segment(vertexArray[1], vertexArray[2])).length();
        double c = (new Segment(vertexArray[0], vertexArray[2])).length();

        double halfPerimeter = (a + b + c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }
}
