package main;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        
            while(!chessMatch.getCheckMate()) {

                try {
                    UI.clearScreen();    
                    UI.printMatch(chessMatch, captured);

                    System.out.println();
                    System.out.printf("source: ");
                    ChessPosition source = UI.readChessPosition(sc);

                    boolean[][] possibleMoves = chessMatch.possibleMoves(source); 
                    UI.clearScreen();
                    UI.printBoard(chessMatch.getPieces() , chessMatch.possibleMoves(source));   


                    System.out.println();
                    System.out.printf("tgt: ");
                    ChessPosition tgt = UI.readChessPosition(sc);

                    ChessPiece capturedPiece = chessMatch.performChessMove(source, tgt);       
                    if (capturedPiece != null){
                        captured.add(0, capturedPiece);
                    }

                    if(chessMatch.getPromoted()!=null){
                        System.out.println("Enter piece for promotion (B/H/R/Q)");
                        String type = sc.nextLine();
                        chessMatch.replacePromotedPiece(type);
                    }
                    
                } catch (ChessException e) {
                    System.out.println(e.getMessage());
                    System.out.println("press enter to continue");
                    sc.nextLine();
                }
                 catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                    System.out.println("press enter to continue");
                    sc.nextLine();
                }
                
        
        }
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }
}
