package frequencyCharacters;

import java.util.Locale;
import java.util.Scanner;

public class SimpleSubstitutionAlgorithm {
    public static final String alphabetLowercase = "abcdefghijklmnopqrstuvwxyz";
    public static final String alphabetUppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String alphabetLowercaseForEncrypt = "";
    public static String alphabetUppercaseForEncrypt = "";
    private static final String key = "State Engineering University of Armenia";
    private static Scanner scanner = new Scanner(System.in);
    static FrequencyCharacters frequencyCharacters = new FrequencyCharacters();


    public static void start() {
        System.out.println("For encryption input key");
        String inputKey = scanner.nextLine();
        if (inputKey.equals(key)) {
            System.out.println("Key is true ,please enter text");
            encryption();
        } else {
            System.out.println("Key is wrong,try again or get out");
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

        System.out.println("Enter text: ");
        String inputText = scanner.nextLine();
        System.out.println(frequencyCharacters.frequency(inputText));

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

        System.out.println("\nEncrypted text: ");
        System.out.println(encrypt + "\n" + frequencyCharacters.frequency(encrypt.toUpperCase()));
    }
}
