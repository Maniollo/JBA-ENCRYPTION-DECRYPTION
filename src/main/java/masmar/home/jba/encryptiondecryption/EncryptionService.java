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
            if (aChar >= 'a' && aChar <= 'z') {
                if (aChar + key <= 'z') {
                    outputBuilder.append(((char) (aChar + key)));
                } else {
                    outputBuilder.append(((char) ('a' + (key - ('z' - aChar + 1)))));
                }
            } else {
                outputBuilder.append(aChar);
            }
        }
        return outputBuilder.toString();
    }
}
