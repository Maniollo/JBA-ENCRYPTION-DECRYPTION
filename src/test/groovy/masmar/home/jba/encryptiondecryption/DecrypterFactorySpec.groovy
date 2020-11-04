package masmar.home.jba.encryptiondecryption

import spock.lang.Specification


class DecrypterFactorySpec extends Specification {
    def "should return #decrypterType for #type"() {
        expect:
        new DecrypterFactory().createDecrypter(type).class.isCase(decrypter)

        where:
        type      || decrypter
        "shift"   || ShiftDecrypter
        "Shift"   || ShiftDecrypter
        "SHIFT"   || ShiftDecrypter
        "ShiFT"   || ShiftDecrypter
        "unicode" || UnicodeDecrypter
        "UNICODE" || UnicodeDecrypter
        "Unicode" || UnicodeDecrypter
        "uNicOde" || UnicodeDecrypter

        decrypterType = type.equalsIgnoreCase("shift") ? "Shift Decrypter" : "Unicode Decrypter"
    }

    def "should throw IllegalArgumentException when unknown model"() {
        when:
        new DecrypterFactory().createDecrypter("dummy")

        then:
        IllegalArgumentException ex = thrown()
        and:
        ex.message == "Unknown type"
    }
}
