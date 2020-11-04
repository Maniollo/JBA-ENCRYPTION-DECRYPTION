package masmar.home.jba.encryptiondecryption;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

class Main {
    public static void main(String[] args) {
        String mode = "enc";
        int key = 0;
        String data = "";
        String in = null;
        String out = null;
        String alg = "shift";

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

            if (args[i].equals("-alg")) {
                alg = args[i++ + 1];
                continue;
            }

            if (args[i].equals("-data")) {
                data = args[i++ + 1];
            }
        }

        if (data.isEmpty() && Objects.nonNull(in)) {
            data = in;
        }

        switch (mode) {
            case "enc":
                Encrypter encrypter = new EncrypterFactory().createEncrypter(alg);
                exportResult(out, encrypter.encrypt(data, key));
                break;
            case "dec":
                Decrypter decrypter = new DecrypterFactory().createDecrypter(alg);
                exportResult(out, decrypter.decrypt(data, key));
                break;
        }
    }

    private static void exportResult(String out, String result) {
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
