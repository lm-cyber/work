package madeby.common.data.data_class;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "vehiclesList")
public class Vehicles {
    @XmlElement(name = "vehicle")
    public ArrayList<Vehicle> vehicleArrayList = new ArrayList();
    public void addVehicle(Vehicle vehicle) {
        vehicleArrayList.add(vehicle);
    }

}
