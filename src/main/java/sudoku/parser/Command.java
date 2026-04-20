package sudoku.parser;

public class Command {

    public enum Type {
        PLACE, CLEAR, HINT, CHECK, QUIT, INVALID
    }

    public Type type;
    public int row;
    public int col;
    public int value;
}