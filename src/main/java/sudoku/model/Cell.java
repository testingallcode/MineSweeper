package sudoku.model;

public class Cell {
    private int value;
    private final boolean preFilled;

    public Cell(int value, boolean preFilled) {
        this.value = value;
        this.preFilled = preFilled;
    }

    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }
    public boolean isPreFilled() { return preFilled; }
    public boolean isEmpty() { return value == 0; }
}