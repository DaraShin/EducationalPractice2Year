package com.epam.rd.autotasks.figures;

import java.lang.reflect.Array;
import java.util.Arrays;

class Quadrilateral extends Figure {
    /*private Point vertex1;
    private Point vertex2;
    private Point vertex3;
    private Point vertex4;*/
    private Point[] vertexArray;

    public Quadrilateral(Point vertex1, Point vertex2, Point vertex3, Point vertex4) {
        if (vertex1 == null || vertex2 == null || vertex3 == null || vertex4 == null) {
            throw new IllegalArgumentException();
        }

        Segment side = new Segment(vertex1, vertex2);
        if (side.lineContainsPoint(vertex3) || side.lineContainsPoint(vertex4)) {
            throw new IllegalArgumentException();
        }
        side = new Segment(vertex1, vertex3);
        if (side.lineContainsPoint(vertex2) || side.lineContainsPoint(vertex4)) {
            throw new IllegalArgumentException();
        }
        side = new Segment(vertex1, vertex4);
        if (side.lineContainsPoint(vertex2) || side.lineContainsPoint(vertex3)) {
            throw new IllegalArgumentException();
        }
        side = new Segment(vertex2, vertex3);
        if (side.lineContainsPoint(vertex1) || side.lineContainsPoint(vertex4)) {
            throw new IllegalArgumentException();
        }
        side = new Segment(vertex2, vertex4);
        if (side.lineContainsPoint(vertex1) || side.lineContainsPoint(vertex3)) {
            throw new IllegalArgumentException();
        }
        side = new Segment(vertex3, vertex4);
        if (side.lineContainsPoint(vertex1) || side.lineContainsPoint(vertex2)) {
            throw new IllegalArgumentException();
        }


        Segment diagonal1 = new Segment(vertex1, vertex3);
        Segment diagonal2 = new Segment(vertex2, vertex4);
        if (diagonal1.intersection(diagonal2) == null) {
            throw new IllegalArgumentException();
        }

        vertexArray = new Point[4];
        vertexArray[0] = vertex1;
        vertexArray[1] = vertex2;
        vertexArray[2] = vertex3;
        vertexArray[3] = vertex4;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (!(figure instanceof Quadrilateral)) {
            return false;
        }

        Point[] vertexArrayCopy = Arrays.copyOf(vertexArray, 4);
        Point[] vertexArrayCopy2 = Arrays.copyOf(((Quadrilateral) figure).vertexArray, 4);
        Arrays.sort(vertexArrayCopy);
        Arrays.sort(vertexArrayCopy2);

        for (int i = 0; i < 4; i++) {
            if (vertexArrayCopy[i].compareTo(vertexArrayCopy2[i]) != 0) {
                return false;
            }
        }

        return true;
    }

    public Point centroid() {
        Triangle triangle1 = new Triangle(vertexArray[0], vertexArray[1], vertexArray[2]);
        Triangle triangle2 = new Triangle(vertexArray[2], vertexArray[3], vertexArray[0]);

        Point center1 = triangle1.centroid();
        Point center2 = triangle2.centroid();

        Triangle triangle3 = new Triangle(vertexArray[1], vertexArray[2], vertexArray[3]);
        Triangle triangle4 = new Triangle(vertexArray[3], vertexArray[1], vertexArray[0]);

        Point center3 = triangle3.centroid();
        Point center4 = triangle4.centroid();

        Segment line1 = new Segment(center1,center2);
        Segment line2 = new Segment(center3,center4);

        return line1.intersection(line2) ;
    }

    public double area() {
        double a = (new Segment(vertexArray[0], vertexArray[1])).length();
        double b = (new Segment(vertexArray[1], vertexArray[2])).length();
        double c = (new Segment(vertexArray[2], vertexArray[3])).length();
        double d = (new Segment(vertexArray[3], vertexArray[0])).length();
        double diagonal1 = (new Segment(vertexArray[0], vertexArray[2])).length();
        double diagonal2 = (new Segment(vertexArray[1], vertexArray[3])).length();

        double halfPerimeter = (a + b + c + d) / 2;

        return Math.sqrt(4 * diagonal1 * diagonal1 * diagonal2 * diagonal2 -
                Math.pow((a * a + c * c - b * b - d * d), 2)) / 4;

    }
}
