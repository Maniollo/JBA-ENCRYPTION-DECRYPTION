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
}
