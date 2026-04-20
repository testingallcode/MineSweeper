package sudoku.userinterface;

import sudoku.model.Board;

public class Printer {

    public void printBoard(Board board) {
        System.out.println("    1 2 3 4 5 6 7 8 9");

        for (int r = 0; r < 9; r++) {
            System.out.print("  " + (char)('A' + r) + " ");

            for (int c = 0; c < 9; c++) {
                int val = board.getCell(r, c).getValue();
                System.out.print((val == 0 ? "_" : val) + " ");
            }

            System.out.println();
        }
    }
}