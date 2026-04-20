package sudoku.service;

import sudoku.model.Board;
import sudoku.model.Cell;

public class HintService {

    public String giveHint(Board board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                Cell cell = board.getCell(r, c);

                if (cell.isEmpty()) {
                    int correct = board.getSolution()[r][c];
               

                    return "Hint: Cell " + (char)('A' + r) + (c + 1) + " = " + correct;
                }
            }
        }
        return "No empty cells left.";
    }
}