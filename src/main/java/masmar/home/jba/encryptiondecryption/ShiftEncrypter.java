package masmar.home.jba.encryptiondecryption;

class ShiftEncrypter implements Encrypter {
    @Override
    public String encrypt(String message, int key) {
        char[] chars = message.toCharArray();
        StringBuilder outputBuilder = new StringBuilder();
        for (char aChar : chars) {
            if (aChar >= 'a' && aChar <= 'z') {
                encryptChar(key, outputBuilder, aChar, 'a', 'z');
            } else if (aChar >= 'A' && aChar <= 'Z') {
                encryptChar(key, outputBuilder, aChar, 'A', 'Z');
            } else {
                outputBuilder.append(aChar);
            }
        }
        return outputBuilder.toString();
    }

    private void encryptChar(int key, StringBuilder outputBuilder, char aChar, char startRange, char endRange) {
        if (aChar + key <= endRange) {
            outputBuilder.append(((char) (aChar + key)));
        } else {
            outputBuilder.append(((char) (startRange + (key - (endRange - aChar + 1)))));
        }
    }
}
