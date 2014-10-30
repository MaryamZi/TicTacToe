/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TicTacToe;

/**
 *
 * @author VIP
 */
public class Player {
    private String name;
    private int x_o;  //1 or 0
    private Player opponentPlayer;
    int x;
    int y;
    
    public Player(String name, int x_o){
        this.name = name; 
        this.x_o = x_o; 
    }
    
    public void play(Table table){
        table.selectCell(x, y, x_o);
    }

    public Player getOpponentPlayer() {
        return opponentPlayer;
    }

    public void setOpponentPlayer(Player opponentPlayer) {
        this.opponentPlayer = opponentPlayer;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX_o() {
        return x_o;
    }

    public void setX_o(int x_o) {
        this.x_o = x_o;
    }
}
