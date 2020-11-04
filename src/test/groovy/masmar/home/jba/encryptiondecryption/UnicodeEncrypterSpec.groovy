package masmar.home.jba.encryptiondecryption

import spock.lang.Specification


class UnicodeEncrypterSpec extends Specification {
    def "should encrypt the message"() {
        expect:
        new UnicodeEncrypter().encrypt("Welcome to hyperskill!", 5) == "\\jqhtrj%yt%m~ujwxpnqq&"
    }
}
