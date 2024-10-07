package cleancode.minesweeper.tobe;

public class GameBoard {

    private final Cell[][] board;

    public GameBoard(int rowSize, int colSize) {
        board = new Cell[rowSize][colSize];
    }

}
