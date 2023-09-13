package org.homework6;

import java.util.Scanner;

public class CalculatorTool {
    public void calculate(String input) {

        int lowestUnit = 5; // numerical value for km
        boolean isAddition = true;
        long totalMm = 0;
        int index = 0;
        while (index < input.length()) {
            if (index > 0 && input.charAt(index) == '-') {
                isAddition = false;
                index += 2;
            } else if (index > 0) {
                isAddition = true;
                index += 2;
            } else
                isAddition = true;
            long number = 0;
            System.out.println(index);
            int j = index;
            while (j < input.length()) {
                if (input.charAt(j) == ' ') {
                    ++j;
                    break;
                }
                int digit = input.charAt(j);
                digit -= 48;
                number = number * 10 + (long)digit;
                ++j;
            }
            index = j;

            if (!isAddition)
                number *= -1;
            System.out.println(number);
            if (index < input.length() - 1) {
                if (input.charAt(index) == 'm' && input.charAt(index + 1) == 'm') {
                    totalMm += number;
                    index += 2;
                    System.out.println("mm");
                    if (lowestUnit > 1)
                        lowestUnit = 1;
                } else if (input.charAt(index) == 'c') {
                    totalMm += number * 10;
                    index += 2;
                    System.out.println("cm");
                    if (lowestUnit > 2)
                        lowestUnit = 2;
                } else if (input.charAt(index) == 'd') {
                    totalMm += number * 100;
                    index += 2;
                    System.out.println("dm");
                    if (lowestUnit > 3)
                        lowestUnit = 3;
                } else if (input.charAt(index) == 'm') {
                    totalMm += number * 1000;
                    ++index;
                    System.out.println("m");
                    if (lowestUnit > 4)
                        lowestUnit = 4;
                } else if (input.charAt(index) == 'k') {
                    totalMm += number * 1000000;
                    index += 2;
                    System.out.println("km");
                }
            } else if (index < input.length() && input.charAt(index) == 'm') {
                totalMm += number * 1000;
                ++index;
                System.out.println("m");
                if (lowestUnit > 4)
                    lowestUnit = 4;
            }
            ++index;
            System.out.println("---");
        }

        switch (lowestUnit) {
            case 2:
                totalMm /= 10;
                break;
            case 3:
                totalMm /= 100;
            case 4:
                totalMm /= 1000;
            case 5:
                totalMm /= 1000000;
        }
        System.out.println(totalMm);
    }
}
