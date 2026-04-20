package sudoku.service;

import sudoku.model.Board;
import sudoku.model.Cell;

import java.util.Optional;

public class MoveService {

	public String placeNumber(Board board, int r, int c, int value) {

	    Cell cell = board.getCell(r, c);

	    if (cell.isPreFilled()) {
	        return "Invalid move. " + pos(r, c) + " is pre-filled.";
	    }

	    if (value < 1 || value > 9) {
	        return "Invalid number. Must be between 1–9.";
	    }

	  
	    cell.setValue(value);

	    return "Move accepted.";
	}
	


    public String clearCell(Board board, int r, int c) {
        Cell cell = board.getCell(r, c);

        if (cell.isPreFilled()) {
            return "Invalid move. Cannot clear pre-filled cell.";
        }

        cell.setValue(0);
        return "Cell cleared.";
    }

 

    private String pos(int r, int c) {
        return "" + (char) ('A' + r) + (c + 1);
    }
}