package chess;

import java.util.ArrayList;

public class KnightMoves implements PieceMovesCalculator {

    ChessBoard board;
    ChessPosition currentPosition;

    public KnightMoves(ChessBoard board, ChessPosition currentPosition) {
        this.board = board;
        this.currentPosition = currentPosition;
    }

    public ArrayList<ChessMove> horseMoves(int x, int y) {
        ChessPiece ghostKnight;
        ChessPosition listedPosition;
        ChessMove movedPosition;

        ArrayList<ChessMove> movedList = new ArrayList<ChessMove>();

        if (currentPosition.getRow() + x <= 8 && currentPosition.getColumn() + y > 0 && currentPosition.getRow() + x > 0 && currentPosition.getColumn() + y <= 8) {
            listedPosition = new ChessPosition(currentPosition.getRow() + x, currentPosition.getColumn() + y);
            ghostKnight = board.getPiece(listedPosition);
            if (ghostKnight == null) {
                movedPosition = new ChessMove(currentPosition, listedPosition, null);
                movedList.add(movedPosition);
            } else if (ghostKnight.getTeamColor() != board.getPiece(currentPosition).getTeamColor()) {
                movedPosition = new ChessMove(currentPosition, listedPosition, null);
                movedList.add(movedPosition);
            }
        }
        return movedList;
    }

    @Override
    public ArrayList<ChessMove> validMoves() {
        ArrayList<ChessMove> movedListFinal = new ArrayList<ChessMove>();

        if (horseMoves(1, 2) != null) {
            movedListFinal.addAll(horseMoves(1, 2));

        }
        if (horseMoves(1, -2) != null) {
            movedListFinal.addAll(horseMoves(1, -2));

        }
        if (horseMoves(-1, 2) != null) {
            movedListFinal.addAll(horseMoves(-1, 2));

        }
        if (horseMoves(-1, -2) != null) {
            movedListFinal.addAll(horseMoves(-1, -2));

        }
        if (horseMoves(2, 1) != null) {
            movedListFinal.addAll(horseMoves(2, 1));

        }
        if (horseMoves(-2, 1) != null) {
            movedListFinal.addAll(horseMoves(-2, 1));

        }
        if (horseMoves(2, -1) != null) {
            movedListFinal.addAll(horseMoves(2, -1));

        }
        if (horseMoves(-2, -1) != null) {
            movedListFinal.addAll(horseMoves(-2, -1));
        }


        return movedListFinal;
    }
}

