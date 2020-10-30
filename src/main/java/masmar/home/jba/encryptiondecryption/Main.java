package masmar.home.jba.encryptiondecryption;

class Main {
    public static void main(String[] args) {
        EncryptionService encryptionService = new EncryptionService();
        String mode = "enc";
        int key = 0;
        String data = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                mode = args[i++ + 1];
                continue;
            }

            if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i++ + 1]);
                continue;
            }

            if (args[i].equals("-data")) {
                data = args[i++ + 1];
            }
        }

        String result = "";
        switch (mode) {
            case "enc":
                result = encryptionService.keyEncryption(data, key);
                break;
            case "dec":
                result = encryptionService.keyDecryption(data, key);
                break;
        }

        System.out.println(result);
    }
}
