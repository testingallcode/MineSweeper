package sudoku.integration;

import org.junit.jupiter.api.Test;
import sudoku.*;

import static org.junit.jupiter.api.Assertions.*;

class GameFlowTest {

    @Test
    void shouldCompleteGameFlow() {
        MineSweeper game = new MineSweeper();

        
        assertNotNull(game);
    }

    @Test
    void shouldNotBreakOnInvalidMoves() {
    	MineSweeper game = new MineSweeper();

        assertDoesNotThrow(() -> {
          
        });
    }
}