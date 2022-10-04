package personal.tic_tac_toe.service;

import personal.tic_tac_toe.condition.RuleChecker;
import personal.tic_tac_toe.model.Board;
import personal.tic_tac_toe.model.Player;

public class GameRunner implements Game{
    private final Board board;
    private final Player player1;
    private final Player player2;
    private final RuleChecker ruleChecker;


    public GameRunner(Board board, Player player1, Player player2, RuleChecker ruleChecker) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.ruleChecker = ruleChecker;
    }

    @Override
    public void initialize() {
        System.out.println("Starting the Game!");
    }

    @Override
    public void run() {
        initialize();
        boolean nexPlayer = false;
        while(true){
            if (nexPlayer) {
                makeMove(player1);
            }else{
                makeMove(player2);
            }
            nexPlayer = !nexPlayer;
            if(isWinner(player1)){
                System.out.println("Woh, player1 won the match");
                end();
                break;
            }

            if(isWinner(player2)){
                System.out.println("Woh, player 2 won the match");
                end();
                break;
            }
        }
    }

    private void makeMove(Player player1) {
        int[] nextMove = player1.getNextMove();
        if(nextMove != null){
            board.makeMoveOnBoard(nextMove[0], nextMove[1], player1.getColor());
        }
    }

    private boolean isWinner(Player player){

        // check for row
        for(int i=0;i<board.getSize()[0];i++){
            if(ruleChecker.rowChecker(i, player.getColor()))
                return true;
        }

        // check for col
        for(int i=0;i<board.getSize()[1];i++){
            if(ruleChecker.colChecker(i, player.getColor()))
                return true;
        }

        return ruleChecker.leftDiagonal(player.getColor()) || ruleChecker.rightDiagonal(player.getColor());
    }



    @Override
    public void end() {
        // clear the board
        System.out.println("Game ended");
        board.clearBoard();
    }

}
