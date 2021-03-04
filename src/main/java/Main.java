import entities.Coin;
import entities.CoinFactory;
import entities.Coins;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class Main {
    private final static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        getUserCurrency();
    }

    static List<Double> arrayOfNumbers = new ArrayList<>();

    private static void getUserCurrency() {
        int choice;
        Coin coin = null;
        choice = (int) getInput(keyboard::nextInt, "Welcome to currency converter please choose option(1/2)\n1. ILS to USD?\n2. USD to ILS?");

        switch (choice) {
            case 1:
                coin = CoinFactory.getCoinInstance(Coins.ILS);
                break;
            case 2:
                coin = CoinFactory.getCoinInstance(Coins.USD);
                break;
            default:
                System.out.println("Invalid Choice " + choice + " Please Try Again");
                getUserCurrency();
        }

        double input = (double) getInput(keyboard::nextDouble, "Please Enter Amount To Convert");
        double changeResult = coin.calculate(input);
        System.out.println(changeResult);
        arrayOfNumbers.add(changeResult);

        keyboard.nextLine();
        String isEnd = (String) getInput(keyboard::nextLine, "Start over? Y / N.");
        if (isEnd.toUpperCase().equals("Y")) {
            getUserCurrency();
        } else {
            System.out.println("Thanks for using our currency converter");
            writeChangeResult(arrayOfNumbers);
            System.exit(0);
        }

    }

    @SuppressWarnings("rawtypes")
    private static Object getInput(Supplier supplier, String message) {
        try {
            System.out.println(message);
            return supplier.get();
        } catch (InputMismatchException | ClassCastException e) {
            System.out.println("Unexpected value please try again");
            keyboard.nextLine();
            return getInput(supplier, message);
        }
    }

    private static void writeChangeResult(List<Double> changeResult) {
        try {
            File logFile = new File("C:\\Users\\neria\\Music\\converter\\converter\\file.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile));
            writer.write(String.valueOf(changeResult));
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
