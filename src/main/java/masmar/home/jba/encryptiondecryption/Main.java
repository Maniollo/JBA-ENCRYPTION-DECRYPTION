package masmar.home.jba.encryptiondecryption;

class Main {
    public static void main(String[] args) {
        EncryptionService encryptionService = new EncryptionService();
        String encrypted = encryptionService.reverseOrderEncryption("we found a treasure!");
        System.out.println(encrypted);
    }
}
