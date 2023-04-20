package madeby.common.data.data_class;

import lombok.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Vehicle implements Comparable<Vehicle> {

    public static final int MIN_LEN_NAME = 1;
    public static final int MIN_ENGINEPOWER = 1;
    public static final int MIN_CAPACITY = 1;
    public static final int MIN_DISTANCE = 1;

    @NonNull
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @NonNull
    private String name; //Поле не может быть null, Строка не может быть пустой
    @NonNull
    private Coordinates coordinates; //Поле не может быть null
    @NonNull
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int enginePower; //Значение поля должно быть больше 0
    private long capacity; //Значение поля должно быть больше 0
    @NonNull
    private Long distanceTravelled; //Поле не может быть null, Значение поля должно быть больше 0
    private VehicleType type; //Поле может быть null

    @Override
    public String toString() {
        return "\nid=" + id
                + "\nname=" + name
                + "\ncoordinates=" + coordinates
                + "\ncreationDate=" + getDayOfCreationDate()
                + "\nenginePower=" + Integer.toString(enginePower)
                + "\ncapacity=" + Long.toString(capacity)
                + "\ndistanceTravelled=" + distanceTravelled
                + "\ntype=" + type
                + '\n';
    }

    public String getDayOfCreationDate() {
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(creationDate);

    }

    @Override
    public int compareTo(@NonNull Vehicle vehicle) {
        int result;
        result = Long.compare(this.capacity, vehicle.getCapacity());
        if (result != 0) {
            return result;
        }
        result = Long.compare(this.distanceTravelled, vehicle.getDistanceTravelled());
        if (result != 0) {
            return result;
        }
        return Integer.compare(this.enginePower, vehicle.getEnginePower());

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public void setDistanceTravelled(Long distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public long getCapacity() {
        return capacity;
    }

    public Long getDistanceTravelled() {
        return distanceTravelled;
    }

    public VehicleType getType() {
        return type;
    }
}
