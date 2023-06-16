package Main;

public class Rotor {
    private int position;
    private int[][] wiring;
    private int notch;

    public Rotor(int[][] wiring, int notch) {
        this.position = 0;
        this.wiring = wiring;
        this.notch = notch;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        if (position < 0 || position > 25) {
            throw new IllegalArgumentException("Position must be between 0 and 25");
        }
        this.position = position;
    }

    public int getWiring(int index) {
        return wiring[0][index];
    }

    public int getNotch() {
        return notch;
    }

    public void rotate() {
        position = (position + 1) % 26;
    }
    public void rotate(int times) {
        for (int i = 0; i < times; i++)
            rotate();
    }


    public int getForward(int letter) {
        //process the right column of the wiring
        int value = wiring[1][(position + letter) % 26 ];
        //process the left column of the wiring
        return getKey(value);
    }
    public int getBackward(int index) {
        int value = wiring[0][(index + position) % 26];
        return getVal(value);
    }

    //find the key of a value in a hashmap
    public int getKey(int value) {
        if(value > position)
            return value - position;
        else if(value < position)
            return 26 - position + value;
        return 0;
    }
    //find the val
    public int getVal(int key) {
        int index = -1;
        for (int i = 0; i < 26; i++)
            if(wiring[1][i] == key)
                index = i;

        if(index > position)
            return index - position;
        else if(index < position)
            return 26 - position + index;
        return 0;
    }
}

