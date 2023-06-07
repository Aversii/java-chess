package chess.pieces;

import boargame.Board;
import boargame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;


    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString(){
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece piece = (ChessPiece)getBoard().piece(position);
        return piece == null || piece.getColor() != getColor();
    }

    public boolean canCastling(Position position){
        ChessPiece piece = (ChessPiece)getBoard().piece(position);
        return  piece != null && piece instanceof Rook && piece.getColor() == getColor() && piece.getMoveCount()== 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getRow()];
        Position auxPosition = new Position(0, 0);

        // above moves
        auxPosition.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;

        }

        if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition) && canMove(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        // down moves
        auxPosition.setValues(position.getRow() +  1, position.getColumn());
        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;

        }

        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        // left moves
        auxPosition.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;

        }

        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        // right moves
        auxPosition.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;

        }

        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        // diagonal up-left moves

        auxPosition.setValues(position.getRow() - 1, position.getColumn()-1);
        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }


        // diagonal up-right moves

        auxPosition.setValues(position.getRow() - 1, position.getColumn()+  1);
        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }        

        // diagonal bottom-right moves

        auxPosition.setValues(position.getRow() + 1, position.getColumn()+1);
        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;

        }

        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        // diagonal bottom-left moves
        
        auxPosition.setValues(position.getRow() + 1, position.getColumn()-1);
        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;

        }

        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            mat[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        //Castling

        if(getMoveCount()==0 && !chessMatch.getCheck()){
            //king side castling

            Position positionR1 = new Position(position.getRow(), position.getColumn()+3);
            if(canCastling(positionR1)){
                Position p1 = new Position(position.getRow(), position.getColumn()+1);
                Position p2 = new Position(position.getRow(), position.getColumn()+2);
                if(getBoard().piece(p1)==null && getBoard().piece(p2) == null){
                    mat[position.getRow()][position.getColumn()+2] = true;
                }
            }

            //Queen side castling

            Position positionR2 = new Position(position.getRow(), position.getColumn()-4);
            if(canCastling(positionR2)){
                Position p1 = new Position(position.getRow(), position.getColumn()-1);
                Position p2 = new Position(position.getRow(), position.getColumn()-2);
                Position p3 = new Position(position.getRow(), position.getColumn()-3);


                if(getBoard().piece(p1)==null && getBoard().piece(p2) == null && getBoard().piece(p3)==null){
                    mat[position.getRow()][position.getColumn()-2] = true;
                }
            }
        }        
        return mat;
    }     
}