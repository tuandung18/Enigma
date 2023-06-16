package Main;

public class Reflector {
    private int[] wiring;

    public Reflector(int[] wiring) {
        this.wiring = wiring;
    }

    public int getWiring(int index) {
        return wiring[index];
    }

    public int getForward(int index) {
        // find the index of the second occurrence of the letter at index in the wiring
        int secondIndex = index;
        for (int i = 0; i < wiring.length; i++)
            if (wiring[i] == wiring[index] && i != index) {
                secondIndex = i;
                break;
            }
        return secondIndex;
    }

}
