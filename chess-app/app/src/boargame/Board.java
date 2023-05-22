package boargame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRow() {
        return rows;
    }

    public void setRow(int rows) {
        this.rows = rows;
    }

    public int getColumn() {
        return columns;
    }

    public void setColumn(int columns) {
        this.columns = columns;
    }

    



    
    
}
