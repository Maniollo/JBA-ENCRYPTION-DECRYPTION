package masmar.home.jba.encryptiondecryption

import spock.lang.Specification


class EncrypterFactorySpec extends Specification {
    def "should return #encrypterType for #type"() {
        expect:
        new EncrypterFactory().createEncrypter(type).class.isCase(encrypter)

        where:
        type      || encrypter
        "shift"   || ShiftEncrypter
        "Shift"   || ShiftEncrypter
        "SHIFT"   || ShiftEncrypter
        "ShiFT"   || ShiftEncrypter
        "unicode" || UnicodeEncrypter
        "UNICODE" || UnicodeEncrypter
        "Unicode" || UnicodeEncrypter
        "uNicOde" || UnicodeEncrypter

        encrypterType = type.equalsIgnoreCase("shift") ? "Shift Encrypter" : "Unicode Encrypter"
    }

    def "should throw IllegalArgumentException when unknown model"() {
        when:
        new EncrypterFactory().createEncrypter("dummy")

        then:
        IllegalArgumentException ex = thrown()
        and:
        ex.message == "Unknown type"
    }

}
