package masmar.home.jba.encryptiondecryption;

class UnicodeEncrypter implements Encrypter {
    @Override
    public String encrypt(String message, int key) {
        char[] chars = message.toCharArray();
        StringBuilder outputBuilder = new StringBuilder();
        for (char aChar : chars) {
            outputBuilder.append((char) (aChar + key));
        }
        return outputBuilder.toString();
    }
}
