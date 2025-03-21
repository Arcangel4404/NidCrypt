package org.nidcrypt.com;

import java.util.Scanner;

public class InputForMap {
    private final MainMap mainMap;
    private final EncryptClass encryptClass;
    private final DecryptClass decryptClass;

    public InputForMap(MainMap mainMap) {
        this.mainMap = mainMap;
        this.encryptClass = new EncryptClass(mainMap);
        this.decryptClass = new DecryptClass(mainMap);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("(e) Encrypt with navigation");
            System.out.println("(m) Manual Encrypt");
            System.out.println("(d) Decrypt");
            System.out.println("(q) Quit");
            System.out.print("> ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "e":
                    System.out.print("Enter a string to encrypt: ");
                    String input = scanner.nextLine();
                    System.out.print("Enter movement directions (w/a/s/d): ");
                    String key = scanner.nextLine();
                    String encrypted = encryptClass.encryptString(input, key);
                    System.out.println("Encryptesd String: " + encrypted);
                    System.out.println("Save this key for decryption: " + key);
                    break;

                case "m":
                    System.out.print("Enter a string to encrypt: ");
                    input = scanner.nextLine();
                    System.out.print("Enter movement directions (w/a/s/d): ");
                    key = scanner.nextLine();
                    encrypted = encryptClass.encryptString(input, key);
                    System.out.println("Encrypted String: " + encrypted);
                    System.out.println("Save this key for decryption: " + key);
                    break;

                case "d":
                    System.out.print("Enter a string to decrypt: ");
                    String encryptedText = scanner.nextLine();
                    System.out.print("Enter the decryption key (movement directions w/a/s/d): ");
                    String decryptKey = scanner.nextLine();
                    String decrypted = decryptClass.decryptString(encryptedText, decryptKey);
                    System.out.println("Decrypted String: " + decrypted);
                    break;

                case "q":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
