package personal.tic_tac_toe.model;

import java.util.List;

public class Player {
    private final Color color;
    private final List<int[]> moves;
    private int currentIndex;
    protected Player(Color color, List<int[]> moves) {
        this.color = color;
        this.moves = moves;
        this.currentIndex = 0;
    }

    public Color getColor() {
        return color;
    }

    public  int[] getNextMove(){
        if(currentIndex < moves.size())
            return moves.get(currentIndex++);
        else
            return null;
    }

}
