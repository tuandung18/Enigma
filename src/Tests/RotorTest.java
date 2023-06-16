import Main.EnigmaMachine;
import Main.Rotor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotorTest {

    EnigmaMachine enigmaMachine = new EnigmaMachine('M', 'C', 'K', "ENIGMA REVEALED");
    @Test
    void rotate() {
        Rotor testRotor = enigmaMachine.getRotor3();
        assertEquals('K' - 'A', testRotor.getPosition() );

    }

    @Test
    void getForward() {
        Rotor testRotor = enigmaMachine.getRotor1();
        assertEquals(9, testRotor.getForward(22));
    }

    @Test
    void getBackward() {
        Rotor testRotor = enigmaMachine.getRotor1();
        Rotor testRotor2 = enigmaMachine.getRotor2();
        Rotor testRotor3 = enigmaMachine.getRotor3();
        testRotor3.rotate(5);
        assertEquals(14, testRotor3.getBackward(18));
    }

    @Test
    void getVal() {

    }
}