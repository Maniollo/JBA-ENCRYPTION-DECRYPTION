package masmar.home.jba.encryptiondecryption;

class ShiftDecrypter implements Decrypter {
    @Override
    public String decrypt(String message, int key) {
        char[] chars = message.toCharArray();
        StringBuilder outputBuilder = new StringBuilder();
        for (char aChar : chars) {
            if (aChar >= 'a' && aChar <= 'z') {
                decryptChar(key, outputBuilder, aChar, 'a', 'z');
            } else if (aChar >= 'A' && aChar <= 'Z') {
                decryptChar(key, outputBuilder, aChar, 'A', 'Z');
            } else {
                outputBuilder.append(aChar);
            }
        }
        return outputBuilder.toString();
    }

    private void decryptChar(int key, StringBuilder outputBuilder, char aChar, char beginRange, char endRange) {
        if (aChar - key >= beginRange) {
            outputBuilder.append(((char) (aChar - key)));
        } else {
            outputBuilder.append(((char) (endRange - (key - (aChar - beginRange + 1)))));
        }
    }
}
