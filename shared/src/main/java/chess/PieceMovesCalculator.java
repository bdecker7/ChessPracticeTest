package chess;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface PieceMovesCalculator {
    ArrayList<ChessMove> validMoves();
}
