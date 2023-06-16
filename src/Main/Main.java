package Main;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the initial position of the right rotor: ");
        char initLetterRot1 = Character.toUpperCase(scanner.next().charAt(0));
        System.out.println("Enter the initial position of the central rotor : ");
        char initLetterRot2 = Character.toUpperCase(scanner.next().charAt(0));
        System.out.println("Enter the initial position of the left rotor : ");
        char initLetterRot3 = Character.toUpperCase(scanner.next().charAt(0));
        String message = getUserInput().toUpperCase(Locale.ROOT);
        EnigmaMachine enigmaMachine = new EnigmaMachine(initLetterRot1, initLetterRot2, initLetterRot3, message);
        System.out.println(enigmaMachine.encrypt(3));





    }

    // get user input string
    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a message: ");
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }
}