package sudoku;

import sudoku.model.Board;
import sudoku.parser.Command;
import sudoku.parser.CommandParser;
import sudoku.service.*;
import sudoku.userinterface.Printer;

import java.util.Optional;
import java.util.Scanner;

public class MineSweeper {

    private final Scanner scanner = new Scanner(System.in);
    private final MoveService moveService = new MoveService();
    private final Validator validator = new Validator();
    private final HintService hintService = new HintService();
    private final CommandParser parser = new CommandParser();
    private final Printer printer = new Printer();

    public void start() {
        Board board = createBoard();

        System.out.println("Welcome to Sudoku!\n");
        System.out.println("Here is your puzzle:");
        printer.printBoard(board);

        while (true) {
            System.out.println("\nEnter command (e.g., A3 4, C5 clear, hint, check):");
            String input = scanner.nextLine();

            Command cmd = parser.parse(input);

            switch (cmd.type) {

            case INVALID -> {
                System.out.println("Invalid command. Try again.");
                continue;
            }

            case PLACE -> {
                String result = moveService.placeNumber(board, cmd.row, cmd.col, cmd.value);
                System.out.println(result);
            }
            
            case CLEAR -> System.out.println(moveService.clearCell(board, cmd.row, cmd.col));
            case HINT -> System.out.println(hintService.giveHint(board));
            case CHECK -> handleCheck(board);
            case QUIT -> { return; }
        }
            

            System.out.println("\nCurrent grid:");
            printer.printBoard(board);

            if (board.isComplete()) {
                if (validator.validate(board).isEmpty()) {
                    System.out.println("\nYou have successfully completed the Sudoku puzzle!");
                    System.out.println("Press any key to play again...");

                    scanner.nextLine(); 
                    return;
                }
            }
            
        }
    }

    private void handleCheck(Board board) {
        Optional<String> result = validator.validate(board);
        System.out.println(result.orElse("No rule violations detected."));
    }

    private Board createBoard() {

        SudokuGenerator generator = new SudokuGenerator();

        int[][] solution = generator.generateSolution();

       
        int[][] puzzle = generator.generatePuzzle(solution, 30);

        return new Board(puzzle, solution);
    }
    
    public void run() {
        while (true) {
            start();
        }
    }

    public static void main(String[] args) {
        new MineSweeper().run();
    }
}