package masmar.home.jba.encryptiondecryption;

class EncrypterFactory {
    Encrypter createEncrypter(String type) {
        type = type.toLowerCase();
        switch (type) {
            case "unicode":
                return new UnicodeEncrypter();
            case "shift":
                return new ShiftEncrypter();
            default:
                throw new IllegalArgumentException("Unknown type");
        }
    }
}
