/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TicTacToe;

/**
 *
 * @author Suchira
 */
public class Game {
    private final Table gameTable;
    private Player player1, player2;

    public Game(Player player1, Player player2) {
        this.gameTable = new Table();
        this.player1 = player1;
        this.player2 = player2;
    }
    
    public boolean gameOver(){
        PossibleWin[] wins;
        boolean finished = false;
        wins = gameTable.getWins();
            for (int i = 0; i < 8; i++) {  // Check whether there is a winner
                try {
                    if(wins[i].win()){
                        System.out.println("Winner: " + wins[i].whoWon());  //X or O
                        finished = true;
                    }
                    
                } catch (Exception e) {
                }
            }
            if(gameTable.isTheTableFull()){             // check whether the game is finished...
                System.out.println("Game end\n NO WINNER!!! :-(");
                finished = true;
            }
        return finished;
    }
    
    public void swapPlayer(){
        Player temp = player1;
        player1 = player2;
        player2 = temp;
    }

    public Table getGameTable() {
        return gameTable;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
    
    
}
