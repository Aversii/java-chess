package chess.pieces;

import boargame.Board;
import boargame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
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
            auxPosition.setValues(position.getRow() - 1, position.getColumn()-1); 
            if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
                mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
            } 

            auxPosition.setValues(position.getRow() -1 , position.getColumn() +1); 
            if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
                mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
            }                   
        }

        // black pawn move and diagonals captures
        if (getColor() == Color.BLACK){
            auxPosition.setValues(position.getRow() + 1, position.getColumn()); 
            if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
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
        }



        return mat;
    }


    
    
}
