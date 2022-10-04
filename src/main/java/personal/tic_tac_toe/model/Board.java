package personal.tic_tac_toe.model;

public class Board {
    private final Cell[][] board;
    public Board(int x1, int y1){
        board = new Cell[x1][y1];
        initializeBoard(x1, y1);
    }

    private void initializeBoard(int x, int y){
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                board[i][j] = new Cell(i, j, Color.NEUTRAL);
            }
        }
    }

    public void clearBoard(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j].setColor(Color.NEUTRAL);
            }
        }
    }


    public int[] getSize(){
        return new int[]{board.length, board[0].length};
    }

    public boolean isValidMoveOnBoard(int x, int y){
        return (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y].getColor().equals(Color.NEUTRAL));
    }

    public void makeMoveOnBoard(int x, int y, Color color){
        board[x][y].setColor(color);
    }

    public Color getColor(int x, int y){
        return board[x][y].getColor();
    }
}
