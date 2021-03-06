package school.lemon.changerequest.java.main;

import school.lemon.changerequest.java.employees.*;
import school.lemon.changerequest.java.matrix.Matrix;
import school.lemon.changerequest.java.fractionnumber.FractionNumber;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        FractionNumberDemo.start();
        MatrixDemo.start();
        EmployeeDemo.start();
    }
}

class FractionNumberDemo {
    static void normalizeTest(int dividend, int divisor) {
        FractionNumber normalizeTest = new FractionNumber(dividend, divisor);
        System.out.println(dividend + "/" + divisor + " = " + normalizeTest);
    }

    static void operationTest(int dividend1, int divisor1, int dividend2, int divisor2) {
        FractionNumber value1 = new FractionNumber(dividend1, divisor1);
        FractionNumber value2 = new FractionNumber(dividend2, divisor2);
        System.out.println("\n" + value1 + " + " + value2 + " = " + (value1.add(value2)));
        System.out.println(value1 + " - " + value2 + " = " + (value1.subtract(value2)));
        System.out.println(value1 + " * " + value2 + " = " + (value1.multiply(value2)));
        System.out.println(value1 + " / " + value2 + " = " + (value1.divide(value2)));
    }

    static void start() {

        System.out.println("---------------------------------------------------");
        System.out.println("Start testing class FractionNumbers\n");
        FractionNumber getTest = new FractionNumber(15, 14);
        System.out.println("Dividend = " + getTest.getDividend());
        System.out.println("Divisor = " + getTest.getDivisor());
        getTest = new FractionNumber(15);
        System.out.println("Dividend = " + getTest.getDividend());
        System.out.println("Divisor = " + getTest.getDivisor() + '\n');

        System.out.println("---------------------------------------------------");
        normalizeTest(3, 9);
        normalizeTest(9, 9);
        normalizeTest(9, 3);
        normalizeTest(9, -3);
        normalizeTest(-9, -3);
        normalizeTest(-9, 3);
        normalizeTest(0, 3);

        FractionNumber toDecimalTest = new FractionNumber(1, 4);
        System.out.println("\n1/4 = " + toDecimalTest.getDecimal());
        toDecimalTest = new FractionNumber(2, 3);
        System.out.println("2/3 = " + toDecimalTest.getDecimal());
        toDecimalTest = new FractionNumber(7, 10);
        System.out.println("7/10 = " + toDecimalTest.getDecimal());

        System.out.println("---------------------------------------------------");
        operationTest(1, 5, 3, 5);
        operationTest(1, 4, 4, 1);
        operationTest(2, 5, -3, 5);
        operationTest(-2, 5, -3, 2);

        System.out.println("---------------------------------------------------");
        System.out.println("\nONE = " + FractionNumber.ONE);
        System.out.println("ZERO = " + FractionNumber.ZERO);
        System.out.println("---------------------------------------------------");
    }

}

class MatrixDemo {
    static void start() {

        System.out.println("---------------------------------------------------");
        System.out.println("Start testing class Matrix\n");
        Random rnd = new Random(System.currentTimeMillis());

        Matrix matrixA = new Matrix(3, 3);
        System.out.println("A = \n" + matrixA);
        matrixA.fillWithRandomIntegers(rnd, 10);
        System.out.println(matrixA);


        Matrix matrixB = new Matrix(3, 3);
        System.out.println("B = \n" + matrixB);
        matrixB.fillWithRandomIntegers(rnd, 10);
        System.out.print(matrixB);
        System.out.println("---------------------------------------------------");

        System.out.print("A + B = \n" + matrixA.add(matrixB));
        System.out.println("---------------------------------------------------");

        System.out.print("A - B = \n" + matrixA.subtract(matrixB));
        System.out.println("---------------------------------------------------");


        System.out.print("A * 5 = \n" + matrixA.multiply(5));
        System.out.println("---------------------------------------------------");

        System.out.print("A * (-5) = \n" + matrixA.multiply(-5));
        System.out.println("---------------------------------------------------");


        System.out.print("A * B = \n" + matrixA.multiply(matrixB));
        System.out.println("---------------------------------------------------");

        System.out.print("Transpose A = \n" + matrixA.transpose());
        System.out.println("---------------------------------------------------");

        Matrix matrixC = new Matrix(1, 4);
        matrixC.fillWithRandomIntegers(rnd, 10);
        Matrix matrixD = new Matrix(4, 1);
        matrixD.fillWithRandomIntegers(rnd, 10);
        System.out.println("C = \n" + matrixC);
        System.out.print("D = \n" + matrixD);

        System.out.println("---------------------------------------------------");
        System.out.println("C * D = \n" + matrixC.multiply(matrixD));
        System.out.println("---------------------------------------------------");
        System.out.println("D * C = \n" + matrixD.multiply(matrixC));
        System.out.println("---------------------------------------------------");
        System.out.println("Transpose C = \n" + matrixC.transpose());
        System.out.println("---------------------------------------------------");
        System.out.println("Transpose D = \n" + matrixD.transpose());
        System.out.println("---------------------------------------------------");
    }
}

class EmployeeDemo {
    static void start() {
        System.out.println("---------------------------------------------------");
        System.out.println("Start testing hierarchy Employee\n");
        Manager manager = new Manager(100);
        Programmer programmer = new Programmer(100, 20);
        Accountant accountant = new Accountant(100, 40);
        System.out.println(manager + "\n" + programmer + "\n" + accountant + "\n");

        manager.work(200);
        programmer.work(180);
        accountant.work(160);
        System.out.println(manager + "\n" + programmer + "\n" + accountant + "\n");

        manager.setMonthlySalary(200);
        programmer.setMonthlySalary(200);
        accountant.setMonthlySalary(200);
        System.out.println(manager + "\n" + programmer + "\n" + accountant + "\n");

        Employee[] workers = new Employee[2];
        workers[0] = manager;
        workers[1] = programmer;
        System.out.println("Overall salary = " + accountant.calculateAllSalary(workers));
        System.out.println("---------------------------------------------------");
    }
}