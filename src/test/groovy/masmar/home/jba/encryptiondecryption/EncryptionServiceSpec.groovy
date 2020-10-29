package masmar.home.jba.encryptiondecryption

import spock.lang.Specification

class EncryptionServiceSpec extends Specification {
    def "should encrypt message with reverse order symbol"() {
        expect:
        new EncryptionService().reverseOrderEncryption("test me") == "gvhg nv"
    }

    def "should encrypt message with key usage"() {
        expect:
        new EncryptionService().keyEncryption("Welcome to hyperskill!", 5) == "\\jqhtrj%yt%m~ujwxpnqq&"
    }

    def "should decrypt message with key usage"() {
        expect:
        new EncryptionService().keyDecryption("\\jqhtrj%yt%m~ujwxpnqq&", 5) == "Welcome to hyperskill!"
    }
}
