package chess.pieces;

import boargame.Board;
import boargame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override

    public String toString(){
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getRow()];
        Position auxPosition = new Position(0, 0);


        // above moves
        auxPosition.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;

        }

        if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        // down moves
        auxPosition.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;

        }

        if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        // left moves
        auxPosition.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;

        }

        if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        // right moves
        auxPosition.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;

        }

        if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        // diagonal up-left moves

        auxPosition.setValues(position.getRow() - 1, position.getColumn()-1);
        if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }


        // diagonal up-right moves

        auxPosition.setValues(position.getRow() - 1, position.getColumn()+  1);
        if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }        

        // diagonal bottom-right moves

        auxPosition.setValues(position.getRow() + 1, position.getColumn()+1);
        if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;

        }

        if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        // diagonal bottom-left moves
        
        auxPosition.setValues(position.getRow() + 1, position.getColumn()-1);
        if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;

        }

        if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }
        
        return mat;
    }

    
    
}