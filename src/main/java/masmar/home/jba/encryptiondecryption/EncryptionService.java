package masmar.home.jba.encryptiondecryption;

class EncryptionService {
    String reverseOrderEncryption(String message) {
        char[] chars = message.toCharArray();
        StringBuilder outputBuilder = new StringBuilder();
        for (char aChar : chars) {
            if (aChar >= 'a' && aChar <= 'z') {
                outputBuilder.append(((char) ('z' - (aChar - 'a'))));
            } else {
                outputBuilder.append(aChar);
            }
        }
        return outputBuilder.toString();
    }

    String keyEncryption(String message, int key) {
        char[] chars = message.toCharArray();
        StringBuilder outputBuilder = new StringBuilder();
        for (char aChar : chars) {
            outputBuilder.append((char) (aChar + key));
        }
        return outputBuilder.toString();
    }

    String keyDecryption(String message, int key) {
        char[] chars = message.toCharArray();
        StringBuilder outputBuilder = new StringBuilder();
        for (char aChar : chars) {
            outputBuilder.append((char) (aChar - key));
        }
        return outputBuilder.toString();
    }
}
