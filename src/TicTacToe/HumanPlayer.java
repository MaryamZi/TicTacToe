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
public class HumanPlayer extends Player {
    public HumanPlayer(String name, int x_o) {
        super(name, x_o);
    }
    
    public void play(Table table, int inputX, int inputY){
        table.selectCell(inputX, inputY, getX_o());
    }
}
