package Main;

public class EnigmaMachine {
    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private  Reflector reflector;
    private  Plugboard plugboard;
    private Rotor rotor1;
    private Rotor rotor2;
    private Rotor rotor3;
    private final Rotor[] rotors = new Rotor[3];

    private String input;

    public Rotor getRotor1() {
        return rotor1;
    }

    public Rotor getRotor2() {
        return rotor2;
    }

    public Rotor getRotor3() {
        return rotor3;
    }

    public EnigmaMachine(char initLetterRot1, char initLetterRot2, char initLetterRot3, String input) {
        this.input = input;
        initIOandReflector();
        initRotors(initLetterRot1, initLetterRot2, initLetterRot3);
    }

    // create a hashmap<Integer,Integer> from 2 strings
    public int[][] creatWiring(String string1, String string2) {
        int[][] wiring = new int[2][26];
        for (int i = 0; i < string1.length(); i++) {
            wiring[0][i] = string1.charAt(i) - 'A';
            wiring[1][i] = string2.charAt(i) - 'A';
        }
        return wiring;
    }

    private void initRotors(char initLetterRot1, char initLetterRot2, char initLetterRot3 ) {
        this.input = input;
        rotor1 = new Rotor(creatWiring(ALPHABET ,"EKMFLGDQVZNTOWYHXUSPAIBRCJ"),
                 'Q'- 'A');
        rotor1.rotate(initLetterRot1 - 'A');
        rotor2 = new Rotor(creatWiring(ALPHABET,"AJDKSIRUXBLHWTMCQGZNPYFVOE"),
                'E' - 'A');
        rotor2.rotate(initLetterRot2 - 'A');
        rotor3 = new Rotor(creatWiring(ALPHABET,"BDFHJLCPRTXVZNYEIWGAKMUSQO"),
                'V' - 'A');
        rotor3.rotate(initLetterRot3 - 'A');
        rotors[0] = rotor3;
        rotors[1] = rotor2;
        rotors[2] = rotor1;
    }
    private void initIOandReflector() {
        reflector = new Reflector("ABCDEFGDIJKGMKMIEBFTCVVJAT".chars().map(c -> c - 'A').toArray());
        plugboard = new Plugboard(ALPHABET.chars().map(c -> c - 'A').toArray());
    }


    // encrypt the string
    public String encrypt(int rotorsNumber) {
        StringBuilder output = new StringBuilder();
        // for each letter in the input string
        for (int i = 0; i < input.length(); i++) {
            // rotate the rotors
            if (input.charAt(i) == ' ') {
                output.append(' ');
                continue;
            }
            rotate();
            // convert the letter to an integer
            int letter = input.charAt(i)- 'A';
            // pass the letter through the plugboard
            letter = plugboard.getForward(letter);
            // pass the letter through the rotors
            letter = forwardRotor(letter);
            // pass the letter through the reflector
            letter = reflector.getForward(letter);
            // pass the letter through the rotors in reverse
            letter = backwardRotor(letter);
            // pass the letter through the plugboard
            letter = plugboard.getBackward(letter);
            // convert the letter back to a character
            char encryptedLetter = (char) (letter + 'A');
            // add the encrypted letter to the output string
            output.append(encryptedLetter);


        }
        return output.toString();
    }

    private int backwardRotor(int letter) {
        for (int i = rotors.length - 1; i >= 0; i--)
            letter = rotors[i].getBackward(letter);
        return letter;
    }

    private int forwardRotor(int letter) {
        for (Rotor rotor : rotors)
            letter = rotor.getForward(letter);
        return letter;
    }



    /**
     * Rotate the rotors
     * IMPORTANT: The rotors rotate before the letter is encrypted, but
     * we have to check if the notch is in the correct position BEFORE
     * rotating the next rotor. ( Else we could never check the first letter )
     */
    private void rotate() {

        if (compareNotch(getRotor3())) {
            rotor2.rotate();
        }
        if (compareNotch(getRotor2())) {
            rotor2.rotate();
            rotor1.rotate();
        }
        if (compareNotch(getRotor1())) {
            rotor1.rotate();
        }
        rotor3.rotate();
    }

    private boolean compareNotch(Rotor rotor) {
        return rotor.getWiring(rotor.getPosition()) == rotor.getNotch();
    }


}
