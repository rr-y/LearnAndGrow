package personal.tic_tac_toe.condition;

import personal.tic_tac_toe.model.Board;
import personal.tic_tac_toe.model.Color;

public class RuleChecker {
    private final Board board;

    public RuleChecker(Board board) {
        this.board = board;
    }


    public boolean rowChecker(int r, Color color){
        for(int i=0;i<board.getSize()[1];i++){
            if(!board.getColor(r, i).equals(color))
                return false;
        }
        return true;
    }

    public boolean colChecker(int c, Color color){
        for(int i=0;i<board.getSize()[0];i++){
            if(!board.getColor(i, c).equals(color))
                return false;
        }
        return true;
    }

    public boolean leftDiagonal(Color color){
        int[] currentPos = new int[]{0, 0};
        while(currentPos[0] < board.getSize()[0] && currentPos[1] < board.getSize()[1]){
            if(!board.getColor(currentPos[0], currentPos[1]).equals(color))
                return false;
            currentPos[0] += 1;
            currentPos[1] += 1;
        }
        return true;
    }

    public boolean rightDiagonal(Color color){
        int[] currentPos = new int[]{board.getSize()[1], 0};
        while(currentPos[0] < board.getSize()[0] && currentPos[1] >= 0){
            if(!board.getColor(currentPos[0], currentPos[1]).equals(color))
                return false;
            currentPos[0] += 1;
            currentPos[1] -= 1;
        }
        return true;
    }
}
