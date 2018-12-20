package Chess.Models;

public class Move {
    private BoardSquare source;
    private BoardSquare destination;
    private boolean capture;

    public Move(BoardSquare src, BoardSquare dest, boolean cap) {
        source = src;
        destination = dest;
        capture = cap;
    }

    public BoardSquare getSource() {
        return source;
    }

    public void setSource(BoardSquare source) {
        this.source = source;
    }

    public BoardSquare getDestination() {
        return destination;
    }

    public void setDestination(BoardSquare destination) {
        this.destination = destination;
    }

    public boolean isCapture() {
        return capture;
    }

    public void setCapture(boolean capture) {
        this.capture = capture;
    }
}
