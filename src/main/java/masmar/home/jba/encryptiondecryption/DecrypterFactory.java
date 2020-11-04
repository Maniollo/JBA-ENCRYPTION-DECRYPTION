package masmar.home.jba.encryptiondecryption;

class DecrypterFactory {
    Decrypter createDecrypter(String type) {
        type = type.toLowerCase();
        switch (type) {
            case "shift":
                return new ShiftDecrypter();
            case "unicode":
                return new UnicodeDecrypter();
            default:
                throw new IllegalArgumentException("Unknown type");
        }
    }
}
