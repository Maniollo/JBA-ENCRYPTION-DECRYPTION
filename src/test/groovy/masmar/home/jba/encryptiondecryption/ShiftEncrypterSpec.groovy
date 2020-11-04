package masmar.home.jba.encryptiondecryption

import spock.lang.Specification


class ShiftEncrypterSpec extends Specification {
    def "should encrypt the message"() {
        expect:
        new ShiftEncrypter().encrypt("Welcome to hyperskill!", 5) == "Bjqhtrj yt mdujwxpnqq!"
    }
}
