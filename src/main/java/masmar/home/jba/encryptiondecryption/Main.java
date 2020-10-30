package masmar.home.jba.encryptiondecryption;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

class Main {
    public static void main(String[] args) {
        EncryptionService encryptionService = new EncryptionService();
        String mode = "enc";
        int key = 0;
        String data = "";
        String in = null;
        String out = null;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                mode = args[i++ + 1];
                continue;
            }

            if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i++ + 1]);
                continue;
            }

            if (args[i].equals("-in")) {
                try {
                    in = Files.readAllLines(Paths.get(args[i++ + 1])).get(0);
                    continue;
                } catch (IOException e) {
                    System.out.println("File does not exist!");
                }
            }

            if (args[i].equals("-out")) {
                out = args[i++ + 1];
                continue;
            }

            if (args[i].equals("-data")) {
                data = args[i++ + 1];
            }
        }

        if (data.isEmpty() && Objects.nonNull(in)) {
            data = in;
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

        if (Objects.isNull(out)) {
            System.out.println(result);
        } else {
            saveInto(out, result.getBytes());
        }
    }

    private static void saveInto(String outputFileName, byte[] encoded) {
        try (OutputStream outputStream = new FileOutputStream(outputFileName, false)) {
            outputStream.write(encoded);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
