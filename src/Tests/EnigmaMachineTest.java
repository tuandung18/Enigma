import Main.EnigmaMachine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnigmaMachineTest {

    @Test
    void getUserInput() {
    }

    @Test
    void encrypt() {
        EnigmaMachine enigmaMachine = new EnigmaMachine('M', 'C', 'K', "ENIGMA REVEALED");
        assertEquals("QMJIDO MZWZJFJR", enigmaMachine.encrypt(3));
    }
}