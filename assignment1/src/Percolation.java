/**
 * Created by brianlevine on 3/14/14.
 */
public class Percolation {

    int size;
    int id;
    int [][] grid;
    boolean [][] open;
    int decrement;

    private void validation(int i, int j){
        if((i > size -1) || i < 0){
            throw new IndexOutOfBoundsException();
        }

        else if((j > size -1) || j < 0){
            throw new IndexOutOfBoundsException();
        }
    }

    public Percolation(int n){
        size = n;
        decrement = (n*n)-1;
        grid = new int[n][n];
        open = new boolean[n][n];
        WeightedQuickUnionUF union = new WeightedQuickUnionUF(size);

        for(int i= n-1; i >= 0; i--){
            for(int j=n-1; j >= 0; j--){
                grid[j][i] = decrement;
                decrement--;
            }
        }
    }//end constructor

    public void open(int i, int j){
        id = grid[i][j];
        validation(i,j);
        open[i][j] = true;
    }

    public boolean isOpen(int i, int j){
        if(open[i][j]){
            return true;
        }
        else
            return false;
    }
//
//    public boolean isFull(int i, int j){
//
//    }
//
//    public boolean percolates(){
//
//    }

public static void main(String[] args){

    Percolation test = new Percolation(5);
    System.out.print(test.grid[1][0]);
    test.validation(0,2);
    }//end main

}//end class