package com.epam.rd.autotasks;

public enum Direction {
    N(0),
    NE(45),
    E(90),
    SE(135),
    S(180),
    SW(225),
    W(270),
    NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public static Direction ofDegrees(int degrees) {
        /*return switch (degrees) {
            case 0 -> N;
            case 45 -> NE;
            case 90 -> E;
            case 135 -> SE;
            case 180 -> S;
            case 225 -> SW;
            case 270 -> W;
            case 315 -> NW;
            default -> null;
        };*/

        degrees = Direction.standartDegrees(degrees);

        if (degrees % 45 != 0) {
            return null;
        }

        int ordinal = degrees / 45;
        return Direction.values()[ordinal];
    }

    public static Direction closestToDegrees(int degrees) {
        degrees = Direction.standartDegrees(degrees);

        Direction exactValue = ofDegrees(degrees);
        if (exactValue != null) {
            return exactValue;
        }

        int idx = (degrees+22)%360/45;
        return Direction.values()[idx];

        /*if ((degrees >= 338 && degrees <= 359) || (degrees >= 2 && degrees <= 22)) {
            return N;
        }
        if (degrees >= 23 && degrees <= 67) {
            return NE;
        }
        if (degrees >= 68 && degrees <= 112) {
            return E;
        }
        if (degrees >= 113 && degrees <= 157) {
            return SE;
        }
        if (degrees >= 158 && degrees <= 202) {
            return S;
        }
        if (degrees >= 203 && degrees <= 247) {
            return SW;
        }
        if (degrees >= 248 && degrees <= 292) {
            return W;
        }
        if (degrees >= 293 && degrees <= 337) {
            return NW;
        }
        return null;*/
    }

    public Direction opposite() {
        int idx = ((this.degrees + 180) % 360) / 45;
        return Direction.values()[idx];
    }

    public int differenceDegreesTo(Direction direction) {
        int absDifference = Math.abs(this.degrees - direction.degrees);
        int distance = Math.min(absDifference, 360 - absDifference);
        return distance;
    }

    private static int standartDegrees(int degrees){
        while (degrees < 0) {
            degrees += 360;
        }
        degrees = degrees % 360;
        return degrees;
    }
}
