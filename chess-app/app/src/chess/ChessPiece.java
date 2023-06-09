package chess;

import boargame.Board;
import boargame.Piece;
import boargame.Position;

public abstract class ChessPiece extends Piece {

    private Color color;
    private int moveCount;





    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int increaseMoveCount() {
        return moveCount++;
    }

    public int decreaseMoveCount() {
        return moveCount--;
    }

    public int getMoveCount() {
        return moveCount;
    }




    

    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);

    }

    protected boolean isThereOpponentPiece(Position position){
        ChessPiece  piece = (ChessPiece) getBoard().piece(position);
        return piece != null && piece.getColor() != color;
    }




    

    
    
    
}
