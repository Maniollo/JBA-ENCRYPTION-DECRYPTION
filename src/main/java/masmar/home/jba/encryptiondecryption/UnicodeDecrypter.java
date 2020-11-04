package masmar.home.jba.encryptiondecryption;

class UnicodeDecrypter implements Decrypter {
    @Override
    public String decrypt(String message, int key) {
        char[] chars = message.toCharArray();
        StringBuilder outputBuilder = new StringBuilder();
        for (char aChar : chars) {
            outputBuilder.append((char) (aChar - key));
        }
        return outputBuilder.toString();
    }
}
