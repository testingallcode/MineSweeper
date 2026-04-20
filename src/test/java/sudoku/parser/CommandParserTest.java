package sudoku.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {

    CommandParser parser = new CommandParser();

    @Test
    void shouldParsePlaceCommand() {
        Command cmd = parser.parse("A3 5");

        assertEquals(Command.Type.PLACE, cmd.type);
    }

    @Test
    void shouldParseLowerCase() {
        Command cmd = parser.parse("a3 5");

        assertEquals(Command.Type.PLACE, cmd.type);
    }

    @Test
    void shouldParseHint() {
        Command cmd = parser.parse("hint");

        assertEquals(Command.Type.HINT, cmd.type);
    }

    @Test
    void shouldReturnInvalid_forBadInput() {
        Command cmd = parser.parse("A10 5");

        assertEquals(Command.Type.INVALID, cmd.type);
    }
}