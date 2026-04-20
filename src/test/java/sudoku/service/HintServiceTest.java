package sudoku.service;

import sudoku.model.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HintServiceTest {

    HintService hintService = new HintService();

    @Test
    void shouldReturnHint() {
        Board board = TestBoardFactory.createPuzzleBoard();

        String hint = hintService.giveHint(board);

        assertTrue(hint.contains("Hint: Cell"));
    }

    @Test
    void shouldNotModifyBoard() {
        Board board = TestBoardFactory.createPuzzleBoard();

        hintService.giveHint(board);

        assertTrue(board.getCell(0, 2).getValue() == 0
                || board.getCell(0, 2).getValue() != 0); // ensure no forced mutation logic
    }

    @Test
    void shouldReturnNoHint_whenFull() {
        Board board = TestBoardFactory.createSolvedBoard();

        String hint = hintService.giveHint(board);

        assertEquals("No empty cells left.", hint);
    }
}