package chess;

import java.util.ArrayList;

public class RookMoves implements PieceMovesCalculator{
    ChessBoard board;
    ChessPosition currentPosition;

    public RookMoves(ChessBoard board, ChessPosition currentPosition){
        this.board = board;
        this.currentPosition= currentPosition;
    }

    public ArrayList<ChessMove> UpDownMoves(int x){
        ChessPiece ghostBishop;
        ChessPosition listedPosition;
        ChessMove movedPosition;

        ArrayList<ChessMove> movedList = new ArrayList<ChessMove>();

        while(currentPosition.getRow()+x <= 8 && currentPosition.getRow()+x > 0){
            listedPosition = new ChessPosition(currentPosition.getRow()+x,currentPosition.getColumn());
            ghostBishop = board.getPiece(listedPosition);
            if(ghostBishop == null){
                movedPosition = new ChessMove(currentPosition,listedPosition,null);
                movedList.add(movedPosition);
            }else if(ghostBishop.getTeamColor() != board.getPiece(currentPosition).getTeamColor()){
                movedPosition = new ChessMove(currentPosition,listedPosition,null);
                movedList.add(movedPosition);
                break;
            }else{break;}


            if (x>0){
                x += 1;
            }else{
                x = x-1;
            }
        }

        return movedList;
    }
    public ArrayList<ChessMove> SideMoves(int x){
        ChessPiece ghostBishop;
        ChessPosition listedPosition;
        ChessMove movedPosition;

        ArrayList<ChessMove> movedList = new ArrayList<ChessMove>();

        while(currentPosition.getColumn()+x <= 8 && currentPosition.getColumn()+x > 0){
            listedPosition = new ChessPosition(currentPosition.getRow(),currentPosition.getColumn()+x);
            ghostBishop = board.getPiece(listedPosition);
            if(ghostBishop == null){
                movedPosition = new ChessMove(currentPosition,listedPosition,null);
                movedList.add(movedPosition);
            }else if(ghostBishop.getTeamColor() != board.getPiece(currentPosition).getTeamColor()){
                movedPosition = new ChessMove(currentPosition,listedPosition,null);
                movedList.add(movedPosition);
                break;
            }else{break;}


            if (x>0){
                x += 1;
            }else{
                x = x-1;
            }
        }

        return movedList;
    }


    @Override
    public ArrayList<ChessMove> validMoves() {
        ArrayList<ChessMove> movedListFinal = new ArrayList<ChessMove>();

        if(UpDownMoves(1) != null) {
            movedListFinal.addAll(UpDownMoves(1));
        }if(UpDownMoves(-1) != null) {
            movedListFinal.addAll(UpDownMoves(-1));
        }if(SideMoves(1) != null) {
            movedListFinal.addAll(SideMoves(1));
        }if(SideMoves(-1) != null) {
            movedListFinal.addAll(SideMoves(-1));
        }
        return movedListFinal;
    }

}
