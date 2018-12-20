package Chess.Util;

import java.util.ArrayList;
import java.util.Hashtable;

public class Constants {
    public static final String[] COORDINATE_LIST = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8",
            "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8",
            "c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8",
            "d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8",
            "e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8",
            "f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8",
            "g1", "g2", "g3", "g4", "g5", "g6", "g7", "g8",
            "h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8"};
    public static final ArrayList<Character> FILE_LIST = new ArrayList<>();
    public static final ArrayList<Character> PIECE_LIST = new ArrayList<>();
    public static final Hashtable<Integer, Integer> RANK_LIST = new Hashtable<>();
    public static void generateLists() {
        FILE_LIST.add('a');
        FILE_LIST.add('b');
        FILE_LIST.add('c');
        FILE_LIST.add('d');
        FILE_LIST.add('e');
        FILE_LIST.add('f');
        FILE_LIST.add('g');
        FILE_LIST.add('h');
        PIECE_LIST.add('r');
        PIECE_LIST.add('n');
        PIECE_LIST.add('b');
        PIECE_LIST.add('q');
        PIECE_LIST.add('k');
        RANK_LIST.put(1, 7);
        RANK_LIST.put(2, 6);
        RANK_LIST.put(3, 5);
        RANK_LIST.put(4, 4);
        RANK_LIST.put(5, 3);
        RANK_LIST.put(6, 2);
        RANK_LIST.put(7, 1);
        RANK_LIST.put(8, 0);
    }
}
