import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Adrian
 */
public class DiceGenerate {
	private final int NUMBER_OF_DICE = 25;
	private final int NUMBER_OF_SIDES = 6;
	
	// contains data for each side of each die
	private List<String> diceData;
	
	// contains each Dice object
	private List<Dice> dice = new ArrayList<Dice>();
	
	/**
	 *  Default constructor
	 * @param diceData contains the dice faces to be turned into Dice Objects
	 */
	public DiceGenerate(List<String> diceData) {
		diceData = diceData;
		int counter = 0;
		for (int i = 0; i < NUMBER_OF_DICE; i++) {
			Dice temp = new Dice();
			for (int j = 0; j < NUMBER_OF_SIDES; j++) {
				temp.addLetter(diceData.get(counter).toString());
				counter++;
			}
			dice.add(temp);
		}
	}
	
	/**
	 * 
	 * @return an list containing a random letter from each die in random order
	 */
	public List<String> shakeDice(int size) {
		List<String> temp = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			temp.add(dice.get(i).getLetter());
		}
		long seed = System.nanoTime();
		Collections.shuffle(temp, new Random(seed));
		return temp;
	}
}
