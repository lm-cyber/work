package madeby.client.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;


@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class Worker {

    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @NonNull
    private String name; //Поле не может быть null, Строка не может быть пустой
    @NonNull
    private Coordinates coordinates; //Поле не может быть null

    @NonNull
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @NonNull
    private Integer salary; //Поле не может быть null, Значение поля должно быть больше 0
    @NonNull
    private Position position; //Поле может быть null
    @NonNull
    private Status status; //Поле не может быть null
    @NonNull
    private Organization organization; //Поле не может быть null
}
