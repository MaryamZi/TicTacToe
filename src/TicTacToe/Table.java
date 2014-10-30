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
public class Table {

    private Cell[][] cell = new Cell[3][3];
    private Cell[] edges = new Cell[4];         
    private Cell[] other = new Cell[4];
    private Cell centre;                        //Keep-track of the centre cell
    private PossibleWin[] wins = new PossibleWin[8];    //This contains the cells that are capable of giving a win
    private int no_cellsOccupied = 0;
    
    public Table() {
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                cell[k][l] = new Cell(k, l);
            }
        }
/* ###########################################################################################  */
        for (int k = 0; k < 3; k++) {
            wins[k] = new PossibleWin(cell[k][0], cell[k][1], cell[k][2]);
        }
        for (int k = 3; k < 6; k++) {
            wins[k] = new PossibleWin(cell[0][k-3], cell[1][k-3], cell[2][k-3]);
        }
        wins[6] = new PossibleWin(cell[0][0], cell[1][1], cell[2][2]);
        wins[7] = new PossibleWin(cell[0][2], cell[1][1], cell[2][0]);
        
/* ###########################################################################################  */        
        int i = 0;
        
        for (int k = 0; k < 3; k += 2) {
            for (int l = 0; l < 3; l += 2) {
                edges[i] = cell[k][l];
                i++;
            }
        }
        
        other[0] = cell[0][1];
        other[1] = cell[1][0];
        other[2] = cell[1][2];
        other[3] = cell[2][1];
        
        centre = cell[1][1];  
    }
    
    
    /**
     * This method will select a cell in the table and mark it as a X/O...
     * @param x = x coordinate of the cell
     * @param y = y coordinate of the cell
     * @param x_o = X/O
     */
    public void selectCell(int x, int y, int x_o){     //User or Machine (X/0)
        if(!cell[x][y].isOccupied()){               //
            cell[x][y].setX_o(x_o);
            cell[x][y].setOccupied(true);
            no_cellsOccupied++;
        }
    }
    
    public PossibleWin[] getWins() {
        return wins;
    }
    
    public boolean isCentreFree(){
        if(centre.isOccupied()){
            return false;
        }
        else{
            return true;
        }
      }
    
    public PossibleWin[] x_oSingle(int x_o){
        int[] x_O = {-1, -1};
        PossibleWin[] a = new PossibleWin[8], b = new PossibleWin[8] ;
        int i = 0, j = 0;
       
        for (int k = 0; k < 8; k++) {
            if(wins[k].isSingle() && wins[k].sum() == -2){
                x_O[0] = 0;
                a[i] = wins[k];
                i++;
                
            }
            else if(wins[k].isSingle() && wins[k].sum() == -1){
                x_O[1] = 1;
                b[j] = wins[k];
                j++;
            }
        }
        
        if(x_O[0] == x_o){
            return a;
        }
        if(x_O[1] == x_o){
            return b;
        }
        return null;
        
    }
    
    public Cell oneToWin(int x_o){
        for (int k = 0; k < 8; k++) {
            if(wins[k].oneMoveToWin(x_o)){
                return wins[k].getLastCell();
            }
        }
        return null;
    }
    
    public boolean isACorner(Cell cell){
        for (int k = 0; k < 4; k++) {
            if(cell.getCoordinate_x() == edges[k].getCoordinate_x() && cell.getCoordinate_y() == edges[k].getCoordinate_y() ){
                return true;
            }
        }
        return false;
    }
    
    public boolean isTheCellOccupied(int x, int y){
        return cell[x][y].isOccupied();
    }
    
    public boolean isTheTableFull(){
        if(no_cellsOccupied == 9){
            return true;
        }
        else{
            return false;
        }
        
    }
    
}
