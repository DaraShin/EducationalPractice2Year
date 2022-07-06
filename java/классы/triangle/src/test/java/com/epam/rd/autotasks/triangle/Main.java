package com.epam.rd.autotasks.triangle;


public class Main {
    public static void main(String[] args) {
        {
            double area = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4)).area();
            System.out.println(area);
        }
        {
            Point centroid = new Triangle(new Point(4, 5), new Point(2, 5), new Point(3, -8)).centroid();

            System.out.println(centroid.getX());
            System.out.println(centroid.getY());
        }
    }
}
