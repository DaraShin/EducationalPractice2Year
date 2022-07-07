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

    Point middle() {
        return new Point((startPoint.getX() + endPoint.getX()) / 2, (startPoint.getY() + endPoint.getY()) / 2);
    }

    Point intersection(Segment another) {
        double tg1 = (this.endPoint.getY() - this.startPoint.getY()) /
                (this.endPoint.getX() - this.startPoint.getX());
        double tg2 = (another.endPoint.getY() - another.startPoint.getY()) /
                (another.endPoint.getX() - another.startPoint.getX());

        if(tg1 == tg2){
            return null;
        }

        double intersectX = (this.startPoint.getX() * tg1 - this.startPoint.getY() -
                another.startPoint.getX() * tg2 + another.startPoint.getY()) / (tg1 - tg2);

        double intersectY = (intersectX - this.startPoint.getX()) * tg1 + this.startPoint.getY();
        Point intersectPoint = new Point(intersectX, intersectY);

        if(this.segmentContainsPoint(intersectPoint) && another.segmentContainsPoint(intersectPoint)){
            return intersectPoint;
        }

        return null;

    }

    public boolean lineContainsPoint(Point point){
        double tg1 = (this.endPoint.getY() - this.startPoint.getY()) /
                (this.endPoint.getX() - this.startPoint.getX());
        double tg2 = (point.getY() - this.startPoint.getY()) /
                (point.getX() - this.startPoint.getX());
        return  tg1 == tg2;
    }

    private boolean segmentContainsPoint(Point point){
        if(point.getX() >= Math.min(this.startPoint.getX(), this.endPoint.getX()) &&
                point.getX() <= Math.max(this.startPoint.getX(), this.endPoint.getX())){
            if(point.getY() >= Math.min(this.startPoint.getY(), this.endPoint.getY()) &&
                    point.getY() <= Math.max(this.startPoint.getY(), this.endPoint.getY())){
                return  true;
            }
        }
        return  false;
    }
}
