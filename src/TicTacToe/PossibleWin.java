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
public class PossibleWin {
    private Cell[] aWin = new Cell[3];
    private Cell lastCell;
    private int j = 0;
    private boolean full = false;
    private int freeCells = 0;
    
    public PossibleWin(Cell cell1, Cell cell2, Cell cell3) {
        aWin[0] = cell1; 
        aWin[1] = cell2; 
        aWin[2] = cell3; 
    }
    
    public boolean oneMoveToWin(int x_o){
        for (int i = 0; i < 3; i++) {       // counting number of free cells
            if (!aWin[i].isOccupied()) {
                freeCells++;
            }
        }
        
        if((freeCells == 1) && (aWin[0].getX_o() == x_o || aWin[1].getX_o() == x_o)){
            if((aWin[0].getX_o() == aWin[1].getX_o()) || (aWin[0].getX_o() == aWin[2].getX_o()) || (aWin[1].getX_o() == aWin[2].getX_o())){
                freeCells = 0;
                return true;
            }
            else{
                freeCells = 0;
                return false;
            }
        }

        else{
            freeCells = 0;
            return false;
        }
    }
    
    public boolean win(){
        if((aWin[0].getX_o() == -1) &&(aWin[1].getX_o() == -1) &&(aWin[2].getX_o() == -1)){
            return false;
        }
        if(aWin.length != 0 && (aWin[0].getX_o() == aWin[1].getX_o()) &&(aWin[1].getX_o() == aWin[2].getX_o()) ){
            return true;
        }
        else{
            return false;
        } 
    }
    public int whoWon(){
        return aWin[0].getX_o();
    }
    
    public Cell[] corners(){
        Cell[] c = new Cell[2];
        if(isAConner(aWin[0])){
            c[0] = aWin[0];
        }
        else{
            c[0] = new Cell();
        }
        if(isAConner(aWin[1])){
            c[1] = aWin[1];
        }
        else{
            c[1] = new Cell();
        }
        
        return c; 
    }

    public int sum(){
        int t = 0;
        for (int i = 0; i < 3; i++) {
            t += aWin[i].getX_o();
        }
        return t;
    }
    
    /* Is the possibleWin is single */
    public boolean isSingle(){
        if((sum() != -3)){
            if (((aWin[0].getX_o() == -1 && aWin[1].getX_o() == -1) || (aWin[0].getX_o() == -1 && aWin[2].getX_o() == -1) || (aWin[1].getX_o() == -1 && aWin[2].getX_o() == -1))) {
                return true;
            }
            else{
                return false;
            }
            
        }
        else{
            return false;
        } 
    }

    public Cell getLastCell() {
        for (int i = 0; i < 3; i++) {
            if(!aWin[i].isOccupied()){
                lastCell = aWin[i];
            }
        }
        return lastCell;
    }
    
    public boolean isAConner(Cell cell){
        for (int k = 0; k < 3; k += 2) {
            for (int l = 0; l < 3; l += 2) {
                if(cell.getCoordinate_x() == k && cell.getCoordinate_y() == l){
                    return true;
                }
                
            }
        }
        return false;
    }
    
    public Cell[] getTwoEnds(){
        Cell[] c = {aWin[0], aWin[2]};
        return c;
    }
    
}
