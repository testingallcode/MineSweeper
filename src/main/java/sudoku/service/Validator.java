package  sudoku.service;

import  sudoku.model.Board;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Validator {

    public Optional<String> validate(Board board) {

        // Priority 1: Row
        for (int r = 0; r < 9; r++) {
            String error = checkRow(board, r);
            if (error != null) return Optional.of(error);
        }

        // Priority 2: Column
        for (int c = 0; c < 9; c++) {
            String error = checkColumn(board, c);
            if (error != null) return Optional.of(error);
        }

        // Priority 3: Subgrid
        String error = checkSubgrid(board);
        if (error != null) return Optional.of(error);

        return Optional.empty();
    }

    private String checkRow(Board board, int row) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int c = 0; c < 9; c++) {
            int val = board.getCell(row, c).getValue();

            if (val == 0) continue;

            if (seen.containsKey(val)) {
                return "Number " + val + " already exists in Row " + (char) ('A' + row) + ".";
            }

            seen.put(val, c);
        }
        return null;
    }

    private String checkColumn(Board board, int col) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            int val = board.getCell(r, col).getValue();

            if (val == 0) continue;

            if (seen.containsKey(val)) {
                return "Number " + val + " already exists in Column " + (col + 1) + ".";
            }

            seen.put(val, r);
        }
        return null;
    }

    private String checkSubgrid(Board board) {

        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {

                Map<Integer, Boolean> seen = new HashMap<>();

                for (int r = boxRow * 3; r < boxRow * 3 + 3; r++) {
                    for (int c = boxCol * 3; c < boxCol * 3 + 3; c++) {

                        int val = board.getCell(r, c).getValue();
                        if (val == 0) continue;

                        if (seen.containsKey(val)) {
                            return "Number " + val + " already exists in the same 3×3 subgrid.";
                        }

                        seen.put(val, true);
                    }
                }
            }
        }
        return null;
    }
}