package com.epam.rd.autotasks;

import java.math.BigInteger;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        int cellLetterCode = (int) shot.charAt(0) - (int) 'A';
        int cellNumber = Integer.valueOf(Character.toString(shot.charAt(1))).intValue();
        int bitNumber = (cellNumber - 1) * 8 + cellLetterCode;
        bitNumber = 63 - bitNumber;
        BigInteger shotsBigInt = new BigInteger(String.valueOf(shots));
        shotsBigInt = shotsBigInt.setBit(bitNumber);
        shots = shotsBigInt.longValue();

        BigInteger shipsBigInt = new BigInteger(String.valueOf(ships));
        return shipsBigInt.testBit(bitNumber);
    }

    public String state() {
        BigInteger shotsBigInt = new BigInteger(String.valueOf(shots));
        BigInteger shipsBigInt = new BigInteger(String.valueOf(ships));
        final int SIZE = 8;
        int bitNumber = 64;
        String battleState = "";

        for (int line = 0; line < SIZE; line++) {
            for (int column = 0; column < SIZE; column++) {
                bitNumber--;
                if (shotsBigInt.testBit(bitNumber)) {
                    if (shipsBigInt.testBit(bitNumber)) {
                        battleState += "☒";
                    } else {
                        battleState += "×";
                    }
                } else {
                    if (shipsBigInt.testBit(bitNumber)) {
                        battleState += "☐";
                    } else {
                        battleState += ".";
                    }
                }
            }
            battleState += "\n";
        }
        return battleState;
    }
}
