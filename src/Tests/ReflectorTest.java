import Main.Reflector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReflectorTest {
    // test for getForward()
    @Test
    void testGetForward() {
        Reflector reflector = new Reflector("ABCDEFGDIJKGMKMIEBFTCVVJAT".chars().map(c -> c - 'A').toArray());
        assertEquals(23, reflector.getForward(9));
        assertEquals(9, reflector.getForward(23));
        assertEquals(20, reflector.getForward(2));

    }

}