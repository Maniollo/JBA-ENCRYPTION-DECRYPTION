package masmar.home.jba.encryptiondecryption

import spock.lang.Specification


class UnicodeDecrypterSpec extends Specification {
    def "should decrypt unicode encrypted message"() {
        expect:
        new UnicodeDecrypter().decrypt("\\jqhtrj%yt%m~ujwxpnqq&", 5) == "Welcome to hyperskill!"
    }
}
