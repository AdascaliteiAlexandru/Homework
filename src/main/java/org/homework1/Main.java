package org.homework1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        sum();
        smallest();
        max();
        palindrome();
        prime();
    }

    static void sum() {
        System.out.println("1.The sum of the first 100 numbers higher than 0 is: ");
        //more efficient version
        System.out.println(100 * (100 + 1) / 2);

        /*  for version
        int resp = 0;

        for (int i = 1; i <= 100; ++i)
            resp += i;

        System.out.println(resp);*/
    }

    static void smallest() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("2.Write the array:");
        int number, small = 2147483647;
        String temp;
        do {
            temp = keyboard.nextLine();
            if (temp.isEmpty()) break; //if the string is empty, the input is done
            number = Integer.parseInt(temp);

            if (small > number)
                small = number;
        } while(true);

        System.out.println("The smallest number from the array is: " + small);
    }

    static void max() {
        int maxDigit = 0, digit;
        char c;
        String temp;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("3.Write the number: ");
        temp = keyboard.nextLine();
        for (int i = 0; i < temp.length(); ++i) {
            c = temp.charAt(i);
            digit = Character.getNumericValue(c);
            if (maxDigit < digit)
                maxDigit = digit;
        }

        System.out.println("The maximum digit of the number is: " + maxDigit);
    }

    static void palindrome() {
        System.out.println("4.Write the number: ");
        Scanner keyboard = new Scanner(System.in);
        String number = keyboard.nextLine();
        int n = number.length();
        boolean isPal = true;

        for (int i = 0; i < n/2 && isPal; ++i)
            if (number.charAt(i) != number.charAt(n - i - 1))
                isPal = false;

        if (isPal)
            System.out.println("The number is palindrome");
        else
            System.out.println("The number is not a palindrome");
    }

    static void prime() {
        System.out.println("5.Write the number: ");
        Scanner keyboard = new Scanner(System.in);
        int number = Integer.parseInt(keyboard.nextLine());

        System.out.println("All the prime numbers lower than the given number are: ");
        if (number > 2) {
            System.out.println("2 ");

            boolean isPrime;
            for (int nr = 3; nr < number; nr += 2) {
                isPrime = true;
                for (int i = 2; i <= nr / 2; ++i)
                    if (nr % i == 0) {
                        isPrime = false;
                        break;
                    }

                if (isPrime)
                    System.out.println(nr + " ");
            }
        } else
            System.out.println("There are no prime numbers smaller than this number");
    }
}
