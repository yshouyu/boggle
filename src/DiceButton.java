import javafx.scene.control.Button;

/**
 * class DiceButton
 */
public class DiceButton extends Button {

    // Letter is available for use.
    private boolean available = true;

    // Position in the grid
    private int row;

    private int column;

    /**
     * Default constructor
     */
    public DiceButton() {
    }

    /**
     * Constructor with text
     * @param text the button text
     */
    public DiceButton(String text) {
        super(text);
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
