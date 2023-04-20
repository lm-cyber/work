package madeby.common;

import madeby.common.data.data_class.Coordinates;
import madeby.common.data.data_class.Vehicle;
import madeby.common.data.data_class.VehicleType;
import madeby.common.data.data_class.Vehicles;
import madeby.common.util.XmlUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        Vehicles vehicles = new Vehicles();

        Vehicle vehicle = new Vehicle();
        vehicle.setId(1);
        vehicle.setName("Name");
        vehicle.setCreationDate(new Date());
        vehicle.setCoordinates(new Coordinates(10.2, 1L));
        vehicle.setEnginePower(2);
        vehicle.setCapacity(3);
        vehicle.setDistanceTravelled(4L);
        vehicle.setType(VehicleType.PLANE);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setId(2);
        vehicle2.setName("Name2");
        vehicle2.setCreationDate(new Date());
        vehicle2.setCoordinates(new Coordinates(1.0, 2L));
        vehicle2.setEnginePower(10);
        vehicle2.setCapacity(8);
        vehicle2.setDistanceTravelled(0L);
        vehicle2.setType(VehicleType.SPACESHIP);

        vehicles.addVehicle(vehicle);
        vehicles.addVehicle(vehicle2);

        XmlUtils xml = new XmlUtils();
//        xml.serialize(vehicles, "./vehicles.xml");

        Vehicles vehicles2 = xml.deserialize("./vehicles.xml");

    }
}
