package Main;

public class Plugboard {
    private int[] wiring;

    public Plugboard(int[] wiring) {
        this.wiring = wiring;
    }

    public int getWiring(int index) {
        return wiring[index];
    }

    public int getForward(int letter) {

        return getLetterIndex(letter);
    }
    public int getBackward(int index) {
        return wiring[index];
    }
    //find index of letter
    public int getLetterIndex(int letter) {
        int index = -1;
        for (int i = 0; i < wiring.length; i++) {
            if (wiring[i] == letter) {
                index = i;
                break;
            }
        }
        return index;
    }

}
