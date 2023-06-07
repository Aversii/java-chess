package chess.pieces;

import boargame.Board;
import boargame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override

    public String toString(){
        return "H";
    }
    
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getRow()];
        Position auxPosition = new Position(0,0);

                // up left and up right moves
                auxPosition.setValues(position.getRow() - 2, position.getColumn()-1);
                if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
                    mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        
                }
        
                if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
                    mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
                }

                auxPosition.setValues(position.getRow() - 2, position.getColumn()+1);
                if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
                    mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        
                }
        
                if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
                    mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
                }

                // down left and down right moves
                auxPosition.setValues(position.getRow() + 2, position.getColumn()-1);
                if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
                    mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        
                }
        
                if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
                    mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
                }

                auxPosition.setValues(position.getRow() + 2, position.getColumn()+1);
                if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
                    mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        
                }
        
                if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
                    mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
                } 
                
                // left up and left down moves
                auxPosition.setValues(position.getRow() -1, position.getColumn() -2);
                if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
                    mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        
                }
        
                if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
                    mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
                }

                auxPosition.setValues(position.getRow() + 1, position.getColumn()-2);
                if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
                    mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        
                }
        
                if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
                    mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
                }
                
                // right up and right down moves
                auxPosition.setValues(position.getRow() -1, position.getColumn() +2);
                if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
                    mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        
                }
        
                if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
                    mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
                }

                auxPosition.setValues(position.getRow() + 1, position.getColumn() +2);
                if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
                    mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        
                }
        
                if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
                    mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
                }                
        return mat;
    }
    
}
