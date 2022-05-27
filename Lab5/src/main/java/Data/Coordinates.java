package Data;
/**
 * class for coordinates values (x, y)
 */
public class Coordinates {
    private final Long x;
    private final Float y;


    public Coordinates(Long x, Float y) {
        this.x = x;
        this.y = y;
    }

    public Long getX() {
        return x;
    }

    /**
     *
     * @return X coordinate
     */

    public Float getY() {
        return y;
    }

    /**
     *
     * @return y coordinate
     */
}
