import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ckass Dice
 */
public class Dice {

    private final int NUMBER_OF_SIDES = 6;

    // stores data for the sides of a Die
    private List<String> diceSides;

    /**
     * default constructor
     */
    public Dice() {
        diceSides = new ArrayList<String>();
    }

    /**
     * @return a randomized letter from the Die object.
     */
    public String getLetter() {
        Random random = new Random();
        return diceSides.get(random.nextInt(NUMBER_OF_SIDES));
    }

    /**
     * add a letter to diceSides
     *
     * @param letter the letter
     */
    public void addLetter(String letter) {
        diceSides.add(letter);
    }
}
