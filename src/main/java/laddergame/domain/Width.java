package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;

import java.util.Objects;

public class Width {
    public static final int MINIMUM_WIDTH = 1;

    private final Count width;

    public Width(int width) {
        validateOverMinimum(width);
        this.width = new Count(width);
    }

    public Width(Players players) {
        this(players.count() - 1);
    }

    private void validateOverMinimum(int width) {
        if (width < MINIMUM_WIDTH) {
            throw new LadderGameException(ErrorCode.WIDTH_UNDER_MINIMUM);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Width width1 = (Width) o;
        return Objects.equals(width, width1.width);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width);
    }

    public boolean bigger(Count count) {
        return this.width.bigger(count);
    }

    @Override
    public String toString() {
        return "Width{" +
                "width=" + width +
                '}';
    }
}
