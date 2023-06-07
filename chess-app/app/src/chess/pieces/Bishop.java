package chess.pieces;

import boargame.Board;
import boargame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColumn()];

        Position auxPosition = new Position(0, 0);

        // DIAGONAL TOP-LEFT MOVES.
        auxPosition.setValues(position.getRow() - 1, position.getColumn()-1);
        while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
            auxPosition.setRow(auxPosition.getRow() - 1);
            auxPosition.setColumn(auxPosition.getColumn()-1);
        }

        if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }


        // DIAGONAL TOP-RIGHT MOVES.
        auxPosition.setValues(position.getRow() - 1, position.getColumn()+  1);
        while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
            auxPosition.setRow(auxPosition.getRow() - 1);
            auxPosition.setColumn(auxPosition.getColumn()+1);
        }

        if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }        

        // DIAGONAL BOTTOM-LEFT MOVES.
        auxPosition.setValues(position.getRow() + 1, position.getColumn()+1);
        while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
            auxPosition.setRow(auxPosition.getRow() + 1);
            auxPosition.setColumn(auxPosition.getColumn() +1);

        }

        if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        // DIAGONAL BOTTOM-RIGHT MOVES.        
        auxPosition.setValues(position.getRow() + 1, position.getColumn()-1);
        while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
            auxPosition.setRow(auxPosition.getRow() +1);
            auxPosition.setColumn(auxPosition.getColumn() -1);

        }

        if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }
        
        return mat;
    }

    
    
}
