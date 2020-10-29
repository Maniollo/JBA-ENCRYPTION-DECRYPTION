package masmar.home.jba.encryptiondecryption;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        EncryptionService encryptionService = new EncryptionService();
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int key = scanner.nextInt();
        String encrypted = encryptionService.keyEncryption(text, key);
        System.out.println(encrypted);
    }
}
