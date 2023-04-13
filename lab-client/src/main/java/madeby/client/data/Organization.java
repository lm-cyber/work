package madeby.client.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {
    public static final int MIN_LENGTH_FULLNAME = 1;
    public static final float MIN_ANNUAL_TURNOVER = 1;
    public static final long MIN_EMPLOYEES_COUNT = 1;
    @NonNull
    private String fullName; //Строка не может быть пустой, Значение этого поля должно быть уникальным, Поле не может быть null
    @NonNull
    private Float annualTurnover; //Поле не может быть null, Значение поля должно быть больше 0
    @NonNull
    private Long employeesCount; //Поле не может быть null, Значение поля должно быть больше 0
}
