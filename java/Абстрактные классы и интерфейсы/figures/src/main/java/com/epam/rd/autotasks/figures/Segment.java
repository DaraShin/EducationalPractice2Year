package com.epam.rd.autotasks.figures;

public class Segment {
    private Point startPoint;
    private Point endPoint;

    public Segment(Point start, Point end) {
        startPoint = start;
        endPoint = end;
    }

    public double length() {
        return Math.sqrt((startPoint.getX() - endPoint.getX()) * (startPoint.getX() - endPoint.getX()) +
                (startPoint.getY() - endPoint.getY()) * (startPoint.getY() - endPoint.getY()));
    }
}
