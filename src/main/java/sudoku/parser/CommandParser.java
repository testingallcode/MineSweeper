package sudoku.parser;

public class CommandParser {

    public Command parse(String input) {
        Command cmd = new Command();

        input = input.trim();

        if (input.equalsIgnoreCase("hint")) {
            cmd.type = Command.Type.HINT;
            return cmd;
        }

        if (input.equalsIgnoreCase("check")) {
            cmd.type = Command.Type.CHECK;
            return cmd;
        }

        if (input.equalsIgnoreCase("quit")) {
            cmd.type = Command.Type.QUIT;
            return cmd;
        }

        String[] parts = input.split(" ");

        if (parts.length != 2) {
            cmd.type = Command.Type.INVALID;
            return cmd;
        }

        // SAFE POSITION PARSING
        if (!parsePosition(cmd, parts[0])) {
            cmd.type = Command.Type.INVALID;
            return cmd;
        }

        if (parts[1].equalsIgnoreCase("clear")) {
            cmd.type = Command.Type.CLEAR;
            return cmd;
        }

        try {
            cmd.value = Integer.parseInt(parts[1]);
            cmd.type = Command.Type.PLACE;
        } catch (NumberFormatException e) {
            cmd.type = Command.Type.INVALID;
        }

        return cmd;
    }

    // prevents ArrayIndexOutOfBounds
    private boolean parsePosition(Command cmd, String pos) {

        pos = pos.toUpperCase();

        if (pos.length() != 2) return false;

        char row = pos.charAt(0);
        char col = pos.charAt(1);

        if (row < 'A' || row > 'I') return false;
        if (col < '1' || col > '9') return false;

        cmd.row = row - 'A';
        cmd.col = col - '1';

        return true;
    }
}