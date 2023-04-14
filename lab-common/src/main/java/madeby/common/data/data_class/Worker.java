package madeby.common.data.data_class;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class Worker implements Comparable<Worker> {

    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @NonNull
    private String name; //Поле не может быть null, Строка не может быть пустой
    @NonNull
    private Coordinates coordinates; //Поле не может быть null

    @NonNull
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @NonNull
    private Integer salary; //Поле не может быть null, Значение поля должно быть больше 0

    private Position position; //Поле может быть null
    @NonNull
    private Status status; //Поле не может быть null
    @NonNull
    private Organization organization; //Поле не может быть null


    public String getDayOfCreationDate() {
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(creationDate);

    }

    @Override
    public int compareTo(@NonNull Worker worker) {
        return worker.getSalary().compareTo(this.getSalary());
    }

    @Override
    public String toString() {
        return "Worker"
                + "\nid=" + id
                + "\nname=" + name
                + "\ncoordinates=" + coordinates
                + "\ncreationDate=" + creationDate
                + "\nsalary=" + salary
                + "\nposition=" + position
                + "\nstatus=" + status
                + "\norganization=" + organization
                + '\n';
    }
}
