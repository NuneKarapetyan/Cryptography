package simpleSubstitutionAlgorithm;

import java.util.Locale;
import java.util.Scanner;

public class SimpleSubstitutionAlgorithm {
    public static final String alphabetLowercase = "abcdefghijklmnopqrstuvwxyz";
    public static final String alphabetUppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String alphabetLowercaseForEncrypt = "";
    public static String alphabetUppercaseForEncrypt = "";
    private static final String key = "State Engineering University of Armenia";
    private static Scanner scanner = new Scanner(System.in);

    public static void command() {
        System.out.println("For encryption press 1");
        System.out.println("For decryption press 2");
    }

    public static void start() {

        boolean normalCommand = false;
        while (!normalCommand) {
            command();
            String command = scanner.nextLine();
            switch (command) {
                case "1" -> {
                    normalCommand = true;
                    encryption();
                }
                case "2" -> {
                    normalCommand = true;
                    decryption();
                }
                default -> {
                    System.out.println("Pleas press only 1 or 2");
                }
            }
        }
    }


    public static void alphabetLowercaseForEncrypt() {
        String letter;
        for (int i = 0; i < key.length(); i++) {
            letter = String.valueOf(key.charAt(i)).toLowerCase(Locale.ROOT);
            if (!alphabetLowercaseForEncrypt.contains(letter) && key.charAt(i) != ' ') {
                alphabetLowercaseForEncrypt = alphabetLowercaseForEncrypt.concat
                        (letter);
            }
        }

        for (int i = 0; i < alphabetLowercaseForEncrypt.length(); i++) {
            letter = String.valueOf(alphabetLowercase.charAt(i));
            if (!alphabetLowercaseForEncrypt.contains(letter)) {
                alphabetLowercaseForEncrypt = alphabetLowercaseForEncrypt.concat
                        (letter);
            }
        }
    }

    public static void alphabetUppercaseForEncrypt() {
        String letter;
        for (int i = 0; i < key.length(); i++) {
            letter = String.valueOf(key.charAt(i)).toUpperCase(Locale.ROOT);
            if (!alphabetUppercaseForEncrypt.contains(letter) && key.charAt(i) != ' ') {
                alphabetUppercaseForEncrypt = alphabetUppercaseForEncrypt.concat
                        (letter);
            }
        }


        for (int i = 0; i < alphabetUppercaseForEncrypt.length(); i++) {
            letter = String.valueOf(alphabetUppercase.charAt(i));
            if (!alphabetUppercaseForEncrypt.contains(letter)) {
                alphabetUppercaseForEncrypt = alphabetUppercaseForEncrypt.concat
                        (letter);
            }
        }
    }

    public static void encryption() {
        alphabetLowercaseForEncrypt();
        alphabetUppercaseForEncrypt();

        System.out.println("For encryption input key");
        String inputKey = scanner.nextLine();
        if (inputKey.equals(key)) {
            System.out.println("Key is true ,please enter text");
            System.out.println("Enter text: ");
            String inputText = scanner.nextLine();
            int index;
            String encrypt = "";
            for (int i = 0; i < inputText.length(); i++) {
                if (!Character.isLetter(inputText.charAt(i))) {
                    encrypt += inputText.charAt(i);
                } else if (Character.isLowerCase(inputText.charAt(i))) {
                    index = alphabetLowercase.indexOf(inputText.charAt(i));
                    encrypt = encrypt.concat(String.valueOf(alphabetLowercaseForEncrypt.charAt(index)));
                } else {
                    index = alphabetUppercase.indexOf(inputText.charAt(i));
                    encrypt = encrypt.concat(String.valueOf(alphabetUppercaseForEncrypt.charAt(index)));
                }
            }
            System.out.println("Encrypted text: ");
            System.out.println(encrypt);
        } else {
            System.out.println("Key is wrong,try again or get out");
        }
    }


    private static void decryption() {
        alphabetLowercaseForEncrypt();
        alphabetUppercaseForEncrypt();

        System.out.println("For decryption input key");
        String inputKey = scanner.nextLine();
        if (inputKey.equals(key)) {
            System.out.println("Key is true ,please enter text");
            System.out.println("Enter text: ");
            String inputText = scanner.nextLine();
            int index;
            String decryptText = "";
            for (int i = 0; i < inputText.length(); i++) {
                if (!Character.isLetter(inputText.charAt(i))) {
                    decryptText += inputText.charAt(i);
                } else if (Character.isLowerCase(inputText.charAt(i))) {
                    index = alphabetLowercaseForEncrypt.indexOf(inputText.charAt(i));
                    decryptText = decryptText.concat(String.valueOf(alphabetLowercase.charAt(index)));
                } else {
                    index = alphabetUppercaseForEncrypt.indexOf(inputText.charAt(i));
                    decryptText = decryptText.concat(String.valueOf(alphabetUppercase.charAt(index)));
                }
            }
            System.out.println("Encrypted text: ");
            System.out.println(decryptText);

        } else {
            System.out.println("Key is wrong,try again or get out");
        }
    }
}
