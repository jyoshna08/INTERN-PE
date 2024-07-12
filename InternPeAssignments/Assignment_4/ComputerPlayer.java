package InternPeAssignments.Assignment_4;

import java.util.Random;

public class ComputerPlayer {
    private Random random;

    public ComputerPlayer() {
        random = new Random();
    }

    public int getMove(Board board) {
        int column;
        do {
            column = random.nextInt(board.getColumns());
        } while (!board.makeMove(column, board.getComputer()));
        return column;
    }
}

