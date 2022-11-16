package laddergame.domain;

public class Point {
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public Point(int index, boolean left, boolean right) {
        this(index, new Direction(left, right));
    }

    public static Point first(boolean right) {
        return new Point(0, Direction.first(right));
    }

    public Point last() {
        return new Point(this.index + 1, direction.last());
    }

    public Point next(boolean next) {
        return new Point(index + 1, direction.next(next));
    }

    public int move() {
        return this.index + direction.move();
    }

    public int getIndex() {
        return index;
    }

    public Direction getDirection() {
        return direction;
    }
}
