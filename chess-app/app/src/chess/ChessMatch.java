package chess;

import boargame.Board;
import boargame.Piece;
import boargame.Position;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRow()][board.getColumn()];
        for (int i = 0; i < board.getRow(); i++) {
            for (int j = 0; j < board.getColumn(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);

            }
        }
        return mat;
    }

    public boolean[][] possibleMoves(ChessPosition srcPosition){
        Position position = srcPosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition tgtPosition) {
        Position source = sourcePosition.toPosition();
        Position tgt = tgtPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, tgt);
        Piece capturedPiece = makeMove(source, tgt);
        return (ChessPiece) capturedPiece;
    }

    private void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)) {
            throw new ChessException("there is no piece on source position");
        }
        if (!board.piece(position).isThereAnypossibleMove())
            throw new ChessException("there is no possible moves at choosen piece");
        {
        }
    }

    private void validateTargetPosition(Position source, Position tgt){
        if(!board.piece(source).possibleMove(tgt)){
            throw new ChessException("chosen piece cant move to tgt position");
        }
    }

    private Piece makeMove(Position source, Position tgt) {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(tgt);
        board.placePiece(p, tgt);
        return capturedPiece;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup() {

        //TEST PIECE MOVE SETUP    
        placeNewPiece('d', 5, new Knight(board, Color.BLACK));//TESTEd PIECE

        placeNewPiece('b', 3, new Rook(board, Color.WHITE));
        placeNewPiece('b', 4, new Rook(board, Color.WHITE));
        placeNewPiece('b', 5, new Rook(board, Color.WHITE));
        placeNewPiece('b', 6, new Rook(board, Color.WHITE));
        placeNewPiece('b', 7, new Rook(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.WHITE));
        placeNewPiece('c', 3, new Rook(board, Color.WHITE));
        placeNewPiece('f', 5, new Rook(board, Color.WHITE));
        placeNewPiece('f', 4, new Rook(board, Color.WHITE));
        placeNewPiece('f', 3, new Rook(board, Color.WHITE));
        placeNewPiece('f', 7, new Rook(board, Color.WHITE));
        placeNewPiece('f', 6, new Rook(board, Color.WHITE));
        placeNewPiece('d', 3, new Rook(board, Color.WHITE));
        placeNewPiece('e', 3, new Rook(board, Color.WHITE));
        placeNewPiece('d', 7, new Rook(board, Color.WHITE));
        placeNewPiece('e', 7, new Rook(board, Color.WHITE)); 
    

/* //ORIGINAL SETUP
        placeNewPiece('a', 1, new Rook(board, Color.WHITE));
        placeNewPiece('b', 1, new Knight(board, Color.WHITE));
        placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));
        placeNewPiece('e', 1, new Queen(board, Color.WHITE));
        placeNewPiece('f', 1, new Bishop(board, Color.WHITE));
        placeNewPiece('g', 1, new Knight(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));
        placeNewPiece('a', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('b', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('c', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('d', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('e', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('f', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('g', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('h', 2, new Pawn(board, Color.WHITE));

        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('b', 8, new Knight(board, Color.BLACK));
        placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
        placeNewPiece('e', 8, new Queen(board, Color.BLACK));
        placeNewPiece('f', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('g', 8, new Knight(board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(board, Color.BLACK));
        placeNewPiece('a', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('b', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('c', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('d', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('e', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('f', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('g', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('h', 7, new Pawn(board, Color.BLACK));  */
    }
}
