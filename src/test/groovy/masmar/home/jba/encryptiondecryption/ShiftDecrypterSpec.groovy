package masmar.home.jba.encryptiondecryption

import spock.lang.Specification


class ShiftDecrypterSpec extends Specification {
    def "should decrypt shifted encrypted message"() {
        expect:
        new ShiftDecrypter().decrypt("Bjqhtrj yt mdujwxpnqq!", 5) == "Welcome to hyperskill!"
    }
}
