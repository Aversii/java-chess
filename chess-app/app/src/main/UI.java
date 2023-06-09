 package main;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    public static ChessPosition readChessPosition(Scanner sc){
        try {
            String s = sc.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
            return new ChessPosition(column, row);
        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading chessPosition, valid values are between a1 to h8");
        }

    }

    public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured){
        printBoard(chessMatch.getPieces());
        System.out.println();
        printCapturedPieces(captured);
        System.out.println();
        System.out.println("turn : " + chessMatch.getTurn());

        if(!chessMatch.getCheckMate()){
            System.out.println("waiting for " + chessMatch.getCurrentPlayer() + " pieces to play.");

            if(chessMatch.getCheck()){
                System.out.println("CHECK!");
            } 
        }else{
            System.out.println("CHECKMATE");
            System.out.println("GG! WINNER IS: " + chessMatch.getCurrentPlayer());
        }

    }

    
    

    public static void printBoard(ChessPiece[][] pieces){
        for (int i = 0; i<pieces.length; i++){
            System.out.print((8-i)+ " ");
            for (int j = 0; j<pieces.length;j++){
                printPiece(pieces[i][j],false);

            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves){
        for (int i = 0; i<pieces.length; i++){
            System.out.print((8-i)+ " ");
            for (int j = 0; j<pieces.length;j++){
                printPiece(pieces[i][j], possibleMoves[i][j]);

            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    private static void printPiece(ChessPiece piece, boolean background){
        if(background){
            System.out.print(ANSI_RED);
        }
        if (piece == null){
            System.out.print("-" + ANSI_RESET);
        }
        else{
            if (piece.getColor() == Color.WHITE){
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }else if(piece.getColor()==Color.BLACK){
                System.out.print(ANSI_PURPLE + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }

    public static void printCapturedPieces(List<ChessPiece> captured){
        
        List<ChessPiece> white = captured.stream().filter(x -> x.getColor()== Color.WHITE).collect(Collectors.toList());
        List<ChessPiece> black = captured.stream().filter(x -> x.getColor()== Color.BLACK).collect(Collectors.toList());

        System.out.print("captured pieces ");
        System.out.print(ANSI_WHITE);
        System.out.println("White: ");
        System.out.println(Arrays.toString(white.toArray()));
        System.out.print(ANSI_RESET);

        
        System.out.print("captured pieces ");
        System.out.print(ANSI_PURPLE);
        System.out.println("black: ");
        System.out.println(Arrays.toString(black.toArray()));
        System.out.print(ANSI_RESET);

        
    }   
}
