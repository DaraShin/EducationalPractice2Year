package com.epam.rd.autotasks.arithmeticexpressions;

import java.util.*;

public class Expressions {

    public static Variable var(String name, int value) {
        return new Variable(name, value);
    }

    public static Expression val(int value) {
        Expression valExpr = new Expression() {
            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                return value >= 0 ? Integer.toString(value) : "(" + value + ")";
            }
        };

        return valExpr;
    }

    public static Expression sum(Expression... members) {
        Expression sumExpr = new Expression() {
            @Override
            public int evaluate() {
                int sum = 0;
                for (Expression summand : members) {
                    sum += summand.evaluate();
                }
                return sum;
            }

            @Override
            public String toExpressionString() {
                String expressionString = "(";
                for (int i = 0; i <= members.length - 2; i++) {
                    expressionString += members[i].toExpressionString() + " + ";
                }
                expressionString += members[members.length - 1].toExpressionString();
                expressionString += ")";
                return expressionString;
            }
        };
        return sumExpr;
    }

    public static Expression product(Expression... members) {
        Expression prodExpr = new Expression() {
            @Override
            public int evaluate() {
                int product = 1;
                for (Expression multiplier : members) {
                    product *= multiplier.evaluate();
                }
                return product;
            }

            @Override
            public String toExpressionString() {
                String expressionString = "(";
                for (int i = 0; i <= members.length - 2; i++) {
                    expressionString += members[i].toExpressionString() + " * ";
                }
                expressionString += members[members.length - 1].toExpressionString();
                expressionString += ")";
                return expressionString;
            }
        };
        return prodExpr;
    }

    public static Expression difference(Expression minuend, Expression subtrahend) {
        Expression diffExpr = new Expression() {
            @Override
            public int evaluate() {
                return minuend.evaluate() - subtrahend.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + minuend.toExpressionString() + " - " + subtrahend.toExpressionString() + ")";
            }
        };
        return diffExpr;
    }

    public static Expression fraction(Expression dividend, Expression divisor) {
        Expression fractionExpr = new Expression() {
            @Override
            public int evaluate() {
                return dividend.evaluate() / divisor.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + dividend.toExpressionString() + " / " + divisor.toExpressionString() + ")";
            }
        };
        return fractionExpr;
    }

}
