package masmar.home.jba.encryptiondecryption

import spock.lang.Specification

class EncryptionServiceSpec extends Specification {
    def "should encrypt message with reverse order symbol"() {
        expect:
        new EncryptionService().reverseOrderEncryption("test me") == "gvhg nv"
    }
}
