package sudoku.service;

import sudoku.model.Board;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MoveServiceTest {

    MoveService service = new MoveService();

    @Test
    void shouldAcceptValidMove() {
        Board board = TestBoardFactory.createEmptyBoard();

        String result = service.placeNumber(board, 0, 0, 5);

        assertEquals("Move accepted.", result);
        assertEquals(5, board.getCell(0, 0).getValue());
    }

    @Test
    void shouldRejectPrefilledCell() {

        Board board = TestBoardFactory.createPrefilledBoard();

        String result = service.placeNumber(board, 0, 0, 9);

        assertTrue(result.contains("pre-filled"));
    }

    @Test
    void shouldRejectInvalidNumber() {
        Board board = TestBoardFactory.createEmptyBoard();

        String result = service.placeNumber(board, 0, 0, 10);

        assertTrue(result.contains("Invalid number"));
    }

    @Test
    void shouldClearCell() {
        Board board = TestBoardFactory.createEmptyBoard();
        board.getCell(0, 0).setValue(5);

        String result = service.clearCell(board, 0, 0);

        assertEquals("Cell cleared.", result);
        assertEquals(0, board.getCell(0, 0).getValue());
    }
}