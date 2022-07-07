package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException();
        }
        if(center == null){
            throw new IllegalArgumentException();
        }

        this.center = center;
        this.radius = radius;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure instanceof Circle) {
            if (this.center.compareTo( ((Circle) figure).center) == 0){
                if(Math.abs(this.radius - ((Circle) figure).radius) < Math.pow(10,-5)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Point centroid() {
        return center;
    }
}
