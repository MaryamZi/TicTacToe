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
public class Cell {
    private int coordinate_x = 3;   
    private int coordinate_y = 3;
    private int x_o = -1;            //Whether the cell is containing X or O (1/0)
    private int user_machine;   //the cell is selected by   (1/0)
    private boolean occupied = false;

    
    public Cell(int coordinate_x, int coordinate_y, int x_o) {
        this.coordinate_x = coordinate_x;
        this.coordinate_y = coordinate_y;
        this.x_o = x_o;
        occupied = true;
    }

    public Cell(int coordinate_x, int coordinate_y) {
        this.coordinate_x = coordinate_x;
        this.coordinate_y = coordinate_y;
        occupied = false;
    }
    
    public Cell(){
        
    }

    public int getCoordinate_x() {
        return coordinate_x;
    }

    public int getCoordinate_y() {
        return coordinate_y;
    }

    public int getX_o() {
        return x_o;
    }

    public int getUser_machine() {
        return user_machine;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void setUser_machine(int user_machine) {
        this.user_machine = user_machine;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setCoordinate_x(int coordinate_x) {
        this.coordinate_x = coordinate_x;
    }

    public void setCoordinate_y(int coordinate_y) {
        this.coordinate_y = coordinate_y;
    }

    public void setX_o(int x_o) {
        this.x_o = x_o;
    }

}
