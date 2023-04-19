package madeby.common.util;

import madeby.common.Exception.DontCorrectJsonException;
import madeby.common.data.data_class.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.stream.Collectors;

public class CollectionManager {
    private final ArrayList<Vehicle> dataCollection;
    private final HashSet<Integer> dataIds;
    private final Date date;
    private int idIterator;


    public CollectionManager() {
        this.dataCollection = new ArrayList<>();
        this.dataIds = new HashSet<>();
        this.date = new Date();
        this.idIterator = 0;
    }

    public void clear() {
        this.dataCollection.clear();
        this.dataIds.clear();
    }

    public void initData(ArrayList<Vehicle> vehicles) throws DontCorrectJsonException {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() < 0) {
                throw new DontCorrectJsonException("id < 0");
            }
            if (dataIds.contains(vehicle.getId())) {
                throw new DontCorrectJsonException("id constain");
            }

            this.dataCollection.add(vehicle);
            this.dataIds.add(vehicle.getId());
        }
    }

    public ArrayList<Vehicle> printDescending() {
        return dataCollection.stream().sorted(Collections.reverseOrder()).collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Vehicle> filterStartsWithName(String nameStart) {
        return dataCollection.stream().filter(x -> x.getName().startsWith(nameStart)).collect(Collectors.toCollection(ArrayList::new));
    }

    private int getNewId() {
        while (this.dataIds.contains(idIterator)) {
            idIterator++;
        }
        return idIterator;
    }

    public boolean update(Vehicle vehicle, Integer id) {
        if (removeByID(id)) {
            vehicle.setId(id);
            this.dataCollection.add(vehicle);
            this.dataIds.add(vehicle.getId());
            return true;
        }
        return false;
    }

    public ArrayList<Vehicle> getCopyOfData() {
        return (ArrayList<Vehicle>) dataCollection.clone();
    }

    public void removeFirst() {
        dataCollection.remove(0);
    }

    public boolean insertAt(Vehicle vehicle, Integer index) {
        if (checkIndex(index)) {
            dataCollection.add(index, vehicle);
            return true;
        }
        return false;
    }

    public boolean checkIndex(Integer index) {
        return index > 0 && index < dataCollection.size();
    }

    private void removeId(Integer id) {
        dataIds.remove(id);
    }

    @Override
    public String toString() {
        return dataCollection.toString();
    }

    public boolean isEmpty() {
        return dataCollection.isEmpty();
    }


    public Long sumOfDistanceTravelled() {
        return dataCollection.stream().mapToLong(Vehicle::getDistanceTravelled).sum();
    }


    public long removeLower(Vehicle vehicle) {
        long count = dataCollection.stream().filter((x -> x.compareTo(vehicle) > 0)).count();
        dataCollection.removeAll(dataCollection.stream().filter(x -> x.compareTo(vehicle) > 0).toList());
        return count;
    }


    public boolean removeByID(Integer id) {
        if (containsId(id)) {
            Vehicle vehicle = dataCollection.stream().filter(x -> id.equals(x.getId())).findAny().get();
            removeId(vehicle.getId());
            dataCollection.remove(vehicle);
            return true;
        }
        return false;
    }


    public void add(Vehicle vehicle) {
        vehicle.setId(getNewId());
        vehicle.setCreationDate(new Date());
        this.dataCollection.add(vehicle);
        this.dataIds.add(vehicle.getId());
    }


    public String info() {
        return "type:" + dataCollection.getClass().toString()
                + "\ndate:" + date.toString() + "\n"
                + "count_elem:" + Integer.toString(dataCollection.size()) + "\n";
    }

    public boolean containsId(Integer id) {
        return this.dataIds.contains(id);
    }

}
