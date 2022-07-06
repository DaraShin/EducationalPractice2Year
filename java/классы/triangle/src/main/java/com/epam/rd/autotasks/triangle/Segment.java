package com.epam.rd.autotasks.triangle;

import static java.lang.Math.sqrt;

public class Segment {
    private Point startPoint;
    private Point endPoint;

    public Segment(Point start, Point end){
        startPoint = start;
        endPoint = end;
    }

    double length() {
        return sqrt((startPoint.getX() - endPoint.getX()) * (startPoint.getX() - endPoint.getX()) +
                (startPoint.getY() - endPoint.getY()) * (startPoint.getY() - endPoint.getY()));
    }

    Point middle() {
        return new Point((startPoint.getX() + endPoint.getX()) / 2, (startPoint.getY() + endPoint.getY()) / 2);
    }

    Point intersection(Segment another) {
        double intersectX, intersectY;
        if(this.startPoint.getX() == this.endPoint.getX() && another.startPoint.getX() == another.endPoint.getX()){
            return null;
        }

        if(this.startPoint.getX() == this.endPoint.getX()){
            intersectX = this.startPoint.getX();
            double tg = (another.endPoint.getY() - another.startPoint.getY()) /
                    (another.endPoint.getX() - another.startPoint.getX());
            intersectY = tg * (intersectX - another.startPoint.getX()) + another.startPoint.getY();
            return  new Point(intersectX, intersectY);
        }

        if(another.startPoint.getX() == another.endPoint.getX()){
            intersectX = another.startPoint.getX();
            double tg = (this.endPoint.getY() - this.startPoint.getY()) /
                    (this.endPoint.getX() - this.startPoint.getX());
            intersectY = tg * (intersectX - this.startPoint.getX()) + this.startPoint.getY();
            return  new Point(intersectX, intersectY);
        }

        double tg1 = (this.endPoint.getY() - this.startPoint.getY()) /
                (this.endPoint.getX() - this.startPoint.getX());
        double tg2 = (another.endPoint.getY() - another.startPoint.getY()) /
                (another.endPoint.getX() - another.startPoint.getX());

        if(tg1 == tg2){
            return null;
        }

        intersectX = (this.startPoint.getX() * tg1 - this.startPoint.getY() -
                another.startPoint.getX() * tg2 + another.startPoint.getY()) / (tg1 - tg2);

        intersectY = (intersectX - this.startPoint.getX()) * tg1 + this.startPoint.getY();
        Point intersectPoint = new Point(intersectX, intersectY);
        return intersectPoint;
    }

}
