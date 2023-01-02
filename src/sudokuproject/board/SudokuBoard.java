package sudokuproject.board;

import sudokuproject.SudokuProject;
import sudokuproject.gameFrame.NumBtnsPane;
/**
 * Superclass Sudoku Board
 * @author mpronoitis
 */
public class SudokuBoard {
    private int[] mat[]; 
    private int[] solvedMat[];
    private int N; // number of columns/rows. 
    private int SRN; // square root of N 
    private int K; // No. Of missing digits 
    private double hiddenLevel;
    /**
     * Constructor
     * @param hiddenLevel: the number of tiles that are going to be hidden 
     */
    SudokuBoard(double hiddenLevel) 
    { 
        this.N=SudokuProject.getN();
        this.hiddenLevel=hiddenLevel;
        this.K = (int) (N*N*hiddenLevel); 
  
        // Compute square root of N 
        Double SRNd = Math.sqrt(N); 
        SRN = SRNd.intValue(); 
  
        solvedMat = new int[N][N]; 
        mat = new int[N][N]; 
        
        this.fillValues();
    } 
    /**
     * Returns the matrix of Sudoku with hidden numbers
     * @return mat: matrix of Sudoku with hidden numbers
     */
    public int[][] getMat() {
        return mat;
    }
    /**
     * Returns the solved matrix of Sudoku
     * @return solvedMat: solved matrix of Sudoku
     */
    public int[][] getSolvedMat() {
        return solvedMat;
    }
    /**
     * Fills the sudoku matrix 
     */
    public void fillValues(){ 
        fillDiagonal(); // Fill the diagonal of SRN x SRN matrices 
        fillRemaining(0, SRN);// Fill remaining blocks  
        removeKDigits(); // Remove Randomly K digits to make game 
    } 
    /**
     * Fills the diagonal SRN number of SRN x SRN matrices
     */
    void fillDiagonal(){ 
        for (int i = 0; i<N; i=i+SRN) 
            fillBox(i, i); // for diagonal box, start coordinates->i==j 
    } 
    /**
     * Returns false if given 3 x 3 block contains num 
     * @param rowStart: the row that the block starts
     * @param colStart: the col that the block starts
     * @param num: the number to insert into the 3 x 3 block
     * @return true or false: true if empty, false if number exists
     */
    boolean unUsedInBox(int rowStart, int colStart, int num){ 
        for (int i = 0; i<SRN; i++) 
            for (int j = 0; j<SRN; j++) 
                if (this.solvedMat[rowStart+i][colStart+j]==num) 
                    return false; 
        return true; 
    } 
    /**
     * Fills a 3 x 3 matrix
     * @param row: the row of the box
     * @param col: the col of the box
     */
    void fillBox(int row,int col){ 
        int num; 
        for (int i=0; i<SRN; i++){ 
            for (int j=0; j<SRN; j++){ 
                do{ 
                    num = randomGenerator(N); 
                } 
                while (!unUsedInBox(row, col, num)); 
                this.solvedMat[row+i][col+j] = num; 
            } 
        } 
    } 
    /**
     * Generates a random number
     * @param num: the range of the random number
     * @return random number from 1 to num
     */
    int randomGenerator(int num){ 
        return (int) Math.floor((Math.random()*num+1)); 
    } 
    /**
     * Checks if it is safe to put in cell
     * @param i: number of row
     * @param j: number of column
     * @param num: number to insert
     * @return true or false: if true then it is safe to put in cell, if false then it is unsafe to put in cell
     */
    boolean CheckIfSafe(int i,int j,int num){ 
        return (unUsedInRow(i, num) && unUsedInCol(j, num) && unUsedInBox(i-i%SRN, j-j%SRN, num)); 
    } 
    /**
     * Checks in the row for existence of number
     * @param i: number of row
     * @param num: number to insert
     * @return true or false: true if number does not exist in row, false if number exists in row
     */
    boolean unUsedInRow(int i,int num){ 
        for (int j = 0; j<N; j++) 
           if (this.solvedMat[i][j] == num) 
               return false; 
        return true; 
    } 
    /**
     * Checks in the column for existence of number
     * @param j: number of column
     * @param num: number to insert
     * @return true or false: true if number does not exist in column, false if number exists in column
     */
    boolean unUsedInCol(int j,int num){ 
        for (int i = 0; i<N; i++) 
            if (this.solvedMat[i][j] == num) 
                return false; 
        return true; 
    } 
    /**
     * A recursive function to fill remaining matrix
     * @param i: number row
     * @param j: number of column
     * @return true or false: true if there are still empty cells, false if all matrix is filled
     */
    boolean fillRemaining(int i, int j){ 
        if (j>=N && i<N-1){ 
            i = i + 1; 
            j = 0; 
        } 
        if (i>=N && j>=N) 
            return true; 
  
        if (i < SRN){ 
            if (j < SRN) 
                j = SRN; 
        } 
        else if (i < N-SRN){ 
            if (j==(int)(i/SRN)*SRN) 
                j =  j + SRN; 
        } 
        else{ 
            if (j == N-SRN){ 
                i = i + 1; 
                j = 0; 
                if (i>=N) 
                    return true; 
            } 
        } 
  
        for (int num = 1; num<=N; num++){ 
            if (CheckIfSafe(i, j, num)){ 
                this.solvedMat[i][j] = num; 
                if (fillRemaining(i, j+1)) 
                    return true; 
                this.solvedMat[i][j] = 0; 
            } 
        } 
        return false; 
    } 
    /**
     * Removes the K number of digits to complete game
     */
    public void removeKDigits(){ 
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                this.mat[i][j] = this.solvedMat[i][j]; 
        int count = K; 
        while (count != 0){ 
            int cellId = randomGenerator(N*N-1); 
            // extract coordinates i  and j 
            int i = (cellId/N); 
            int j = cellId%N; 
            
            if (this.mat[i][j] != 0){ 
                count--; 
                this.mat[i][j] = 0; 
            } 
        } 
    }  
    /**
     * Prints the sudoku matrix with hidden numbers
     */
    public void printSudoku(){ 
        System.out.println("Unsolved");
        for (int i = 0; i<N; i++){ 
            for (int j = 0; j<N; j++) 
                System.out.print(mat[i][j] + " "); 
            System.out.println(); 
        } 
        System.out.println(); 
    } 
    /**
     * Prints the solved sudoku matrix
     */
    public void printSolvedSudoku(){ 
        System.out.println("Solved");
        for (int i = 0; i<N; i++){ 
            for (int j = 0; j<N; j++) 
                System.out.print(this.solvedMat[i][j] + " "); 
            System.out.println(); 
        } 
        System.out.println(); 
    } 
    /**
     * Sets a number to a specific position
     * @param row: row to set number
     * @param col: col to set number
     * @param num: number to set
     */
    public void setSpecificPos(int row,int col,int num){
        mat[row][col]=num;
    }
    /**
     * Restarts the Sudoku board
     */
    public void restartBoard(){
        solvedMat = new int[N][N]; 
        mat = new int[N][N]; 
        
        this.fillValues();
        
        NumBtnsPane.getInstance().setAllEnabled(true);
    }
}
