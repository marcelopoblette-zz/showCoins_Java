/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coins;

import java.util.Scanner;

/**
 *
 * @author Marcelo
 */
public class Coins {

    private int cent;

    public int getCent() {
        return cent;
    }

    public void setCent(int cent) {
        this.cent = cent;
    }

    public Coins(int cent) {
        this.cent = cent;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int units;
        units = Integer.parseInt(requestInt());;
        Coins coins = new Coins(units);
        giveCoins(coins.getCent());

        printCoins(giveCoins(coins.getCent()));
    }

    public static boolean verifyInt(String num) {
        try {
            Integer.parseInt(num);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static String requestInt() {

        String number;
        Scanner userInput = new Scanner(System.in);
        boolean iterator = false;
        do {
            do {
                System.out.println("Enter the number of cents; ");
                number = userInput.next();
                if (verifyInt(number) == true) {
                    iterator = false;
                } else {
                    System.out.println("Please, enter a number.");
                    iterator = true;
                }
            } while (iterator);
        } while (iterator);
        return number;
    }

    public static int[] giveCoins(int cent) {
        int dollar = cent / 100;
        cent = cent % 100;

        int quarter = cent / 25;
        cent = cent % 25;

        int dime = cent / 10;
        cent = cent % 10;

        int nickel = cent / 5;
        cent = cent % 5;

        int[] result = {dollar, quarter, dime, nickel, cent};
        return result;
    }

    public static void printCoins(int[] coins) {
        System.out.print(" You have entered ");
        int dollar = coins[0];
        int quarter = coins[1];
        int dime = coins[2];
        int nickel = coins[3];
        int cent = coins[4];
        if (dollar > 0) {
            System.out.print((dollar) + " dollar, ");
        }
        if (quarter > 0) {
            System.out.print((quarter) + " quarter, ");
        }
        if (dime > 0) {
            System.out.print((dime) + " dime, ");
        }
        if (nickel > 0) {
            System.out.print((nickel) + " nickel, ");
        }
        if (cent > 0) {
            System.out.print(cent + " cent(s). ");
        }
    }
}
