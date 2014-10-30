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
public class MachinePlayer extends Player {
    public MachinePlayer(String name, int x_o) {
        super(name, x_o);
    }
    
    public int[] chose(Table table){
        
        System.out.println("Machine's turn...");
                Cell lastMove = table.oneToWin(getX_o());
                Cell oppLastMove = table.oneToWin(getOpponentPlayer().getX_o());
                int x = 0, y = 0;
                
//                System.out.println("oppLastMove" + oppLastMove);
                
                if(lastMove != null){   //if the current player has one move to win, occupie the relavant cell and win
                    x = lastMove.getCoordinate_x();
                    y = lastMove.getCoordinate_y();
                    table.selectCell(x, y, 0);
                }
                
                else if(oppLastMove != null){       //if the opponent has one move to win, occupie the relavant cell and block the opponent's win
                    x = oppLastMove.getCoordinate_x();
                    y = oppLastMove.getCoordinate_y();
                    table.selectCell(x, y, 0);
                }
                
                else if(table.isCentreFree()){      //If centre is free occupie the centre
                    x = 1;
                    y = 1;
                    table.selectCell(x, y, 0);
                }
                
                else if(table.x_oSingle(1) != null && table.x_oSingle(1).length != 0){ // if the opponent has a PossibleWin block with a single occupied cell, fill a coner in that block or a middle cell
                    PossibleWin[] wayToGo = table.x_oSingle(1);
                    Cell[] corners;
                    Cell corner = null;
                    int i;
                    for (i = 0; wayToGo[i] != null && i < wayToGo.length ; i++) {
                        corners = wayToGo[i].corners();
                        
                        if(corners[0].getCoordinate_x() == 3 && corners[1].getCoordinate_x() == 3){ //if the cell is not an edge
                            continue;
                        }
                        int j ;
                        for (j = 0; j < 2; j++) {
                            if (!corners[j].isOccupied() && corners[j].getCoordinate_x() != 3) {
                                System.out.println("corner ekak..." + corners[j].getCoordinate_x() + "," + corners[j].getCoordinate_y());
                                corner = corners[j];
                                break;
                            }
                        }
                        if( j < 2){
                            break;
                        }
                    }
                    
                    if(i == wayToGo.length || wayToGo[i] == null){ //If there is no edge to fill
                        for (int j = 0; j < wayToGo.length; j++) {
                            Cell[] twoEnds = wayToGo[j].getTwoEnds();
                            int k;
                            for (k = 0; k < 2; k++) {
                                if(!twoEnds[k].isOccupied()){
                                    corner = twoEnds[k];
                                    break;
                                }
                            }
                            if(k < 2){
                                break;
                            }
                        }
                    }
                    x = corner.getCoordinate_x();
                    y = corner.getCoordinate_y();
                    System.out.println("Meka athule x:" + x + "y:" + y);
                    table.selectCell(x, y, 0);
                }
                else if(table.x_oSingle(0) != null){
                    PossibleWin[] wayToGo = table.x_oSingle(1);
                    Cell[] corners;
                    Cell corner = null;
                    int i;
                    for (i = 0; wayToGo[i] != null && i < wayToGo.length; i++) {
                        corners = wayToGo[i].corners();
                        
                        if(corners[0].getCoordinate_x() == 3 && corners[1].getCoordinate_x() == 3){ //if the cell is not an edge
                            continue;
                        }
                        int j ;
                        for (j = 0; j < 2; j++) {
                            if (corners[j].getCoordinate_x() != 3) {
                                corner = corners[j];
                                break;
                            }
                        }
                        if( j < 2){
                            break;
                        }
                    }
                    
                    if(i == wayToGo.length || wayToGo[i] == null){ //If there is no edge to fill
                        for (int j = 0; j < wayToGo.length; j++) {
                            Cell[] twoEnds = wayToGo[j].getTwoEnds();
                            int k;
                            for (k = 0; k < 2; k++) {
                                if(!twoEnds[k].isOccupied()){
                                    corner = twoEnds[k];
                                    break;
                                }
                            }
                            if(k < 2){
                                break;
                            }
                        }
                    }
                    x = corner.getCoordinate_x();
                    y = corner.getCoordinate_y();
                    table.selectCell(x, y, 0);
                }
                int[] choosed = {x, y};
                System.out.println("Machine select: " + x + " " + y);
            
            
            return choosed;
    }
    
    public void play(Table table, int inputX, int inputY){
        table.selectCell(inputX, inputY, getX_o());
    }
}
