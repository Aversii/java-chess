package chess.pieces;

import boargame.Board;
import boargame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }   

    public ChessMatch getChessMatch() {
        return chessMatch;
    }

    @Override
    public String toString(){
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getRow()];
        Position auxPosition = new Position(0, 0);


        // white pawn move and diagonals captures
        if (getColor() == Color.WHITE){
            auxPosition.setValues(position.getRow() - 1, position.getColumn()); 
            if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
                mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
            }

            auxPosition.setValues(position.getRow()-2, position.getColumn());
            Position auxPosition2 = new Position(position.getRow()-1, position.getColumn());
            if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition) && getBoard().positionExists(auxPosition2)&& !getBoard().thereIsAPiece(auxPosition2) && getMoveCount()== 0){
                mat[auxPosition.getRow()][auxPosition.getColumn()] = true;

            }


            auxPosition.setValues(position.getRow() - 1, position.getColumn()-1); 
            if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
                mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
            } 

            auxPosition.setValues(position.getRow() -1 , position.getColumn() +1); 
            if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
                mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
            }
            
            //SPECIAL MOVE EN PASSANT
        if(position.getRow() == 3 ){
            Position left = new Position(position.getRow(), position.getColumn() -1);
            if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left)==chessMatch.getEnPassantVunerable()){
                mat[left.getRow()-1][left.getColumn()] = true;
            }

            Position right = new Position(position.getRow(), position.getColumn() +1);
            if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right)==chessMatch.getEnPassantVunerable()){
                mat[right.getRow()-1][right.getColumn()] = true;
            }
        }
    }

        // black pawn move and diagonals captures
        if (getColor() == Color.BLACK){
            auxPosition.setValues(position.getRow() + 1, position.getColumn()); 
            if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
                mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
            }

            auxPosition.setValues(position.getRow() +2, position.getColumn());
            Position auxPosition2 = new Position(position.getRow()+1, position.getColumn());
            if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition) && getBoard().positionExists(auxPosition2)&& !getBoard().thereIsAPiece(auxPosition2) && getMoveCount()== 0){
                mat[auxPosition.getRow()][auxPosition.getColumn()] = true;

            }
            auxPosition.setValues(position.getRow() + 1, position.getColumn()-1); 
            if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
                mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
            } 

            auxPosition.setValues(position.getRow() +1 , position.getColumn() +1); 
            if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
                mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
            }       
            //SPECIAL MOVE EN PASSANT
            if(position.getRow() == 4 ){
                Position left = new Position(position.getRow(), position.getColumn() -1);
                if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left)==chessMatch.getEnPassantVunerable()){
                    mat[left.getRow()+1][left.getColumn()] = true;
                }
    
                Position right = new Position(position.getRow(), position.getColumn() +1);
                if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right)==chessMatch.getEnPassantVunerable()){
                    mat[right.getRow()+ 1][right.getColumn()] = true;
                }
            }                        
        }
        return mat;
    }    
    
}
