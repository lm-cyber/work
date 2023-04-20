package madeby.common.data.data_class;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Coordinates {
    public static final Double MAX_X = 274.0;
    @NonNull
    private Double x; //Максимальное значение поля: 274, Поле не может быть null
    @NonNull
    private Long y; //Поле не может быть null

    @Override
    public String toString() {
        return "\tCoordinates" + "\n\t\tx=" + x + "\n\t\ty=" + y + "\n";

    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Long y) {
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public Long getY() {
        return y;
    }
}
