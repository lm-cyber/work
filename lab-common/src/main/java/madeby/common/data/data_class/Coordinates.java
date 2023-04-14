package madeby.common.data.data_class;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coordinates {
    public static final Float MAX_X = 826F;
    public static final Float MIN_Y = -180F;
    private float x; //Максимальное значение поля: 826
    @NonNull
    private Float y; //Значение поля должно быть больше -180, Поле не может быть null

    @Override
    public String toString() {
        return "\tCoordinates" + "\n\t\tx=" + x + "\n\t\ty=" + y + "\n";

    }
}
