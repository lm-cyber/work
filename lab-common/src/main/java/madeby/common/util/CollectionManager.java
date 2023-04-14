package madeby.common.util;

import madeby.common.Exception.DontCorrectJsonException;
import madeby.common.data.data_class.Position;
import madeby.common.data.data_class.Worker;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class CollectionManager {
    private final PriorityQueue<Worker> dataCollection;
    private final HashSet<Integer> dataIds;
    private final HashSet<String> organiztionNames;
    private final Date date;
    private int idIterator;


    public CollectionManager() {
        this.dataCollection = new PriorityQueue<>();
        this.dataIds = new HashSet<>();
        this.organiztionNames = new HashSet<>();
        this.date = new Date();
        this.idIterator = 0;
    }

    public void clear() {
        this.dataCollection.clear();
        this.dataIds.clear();
        this.organiztionNames.clear();
    }

    // to do valid data init !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void initData(PriorityQueue<Worker> workers) throws DontCorrectJsonException {
        for (Worker worker : workers) {
            if (worker.getId() < 0) {
                throw new DontCorrectJsonException("id < 0");
            }
            if (dataIds.contains(worker.getId())) {
                throw new DontCorrectJsonException("id constain");
            }
            if (organizationNameCheck(worker.getOrganization().getFullName())) {
                throw new DontCorrectJsonException("fullname of organization contain");
            }
            this.dataCollection.add(worker);
            this.dataIds.add(worker.getId());
            this.organiztionNames.add(worker.getOrganization().getFullName());
        }
    }

    private int getNewId() {
        while (this.dataIds.contains(idIterator)) {
            idIterator++;
        }
        return idIterator;
    }

    public void update(Worker worker, Integer id) {
        worker.setId(id);
        this.dataCollection.add(worker);
        this.dataIds.add(worker.getId());
        this.organiztionNames.add(worker.getOrganization().getFullName());
    }

    private void removeId(Integer id) {
        dataIds.remove(id);
    }

    public boolean isEmpty() {
        return dataCollection.isEmpty();
    }

    public Map<String, List<Worker>> guopByDate() {
        Map<String, List<Worker>> groupedByDate = dataCollection.stream()
                .collect(Collectors.groupingBy(Worker::getDayOfCreationDate));
        return groupedByDate;
    }

    public List<Worker> getAllByPosition(Position position) {
        if (position == null) {
            return dataCollection.stream().filter(x -> x.getPosition() == null).toList();

        }
        return dataCollection.stream().filter(x -> position.equals(x.getPosition())).toList();

    }

    public void poll() {
        dataCollection.poll();
    }

    public long removeGreaterThanThis(Worker worker) {
        long count = dataCollection.stream().filter((x -> x.compareTo(worker) > 0)).count();
        dataCollection.removeAll(dataCollection.stream().filter(x -> x.compareTo(worker) > 0).toList());
        return count;
    }

    public long removeAllByPosition(Position position) {
        if (position == null) {
            long count = dataCollection.stream().filter((x -> x.getPosition() == null)).count();
            List<Worker> workers = dataCollection.stream().filter(x -> x.getPosition() == null).toList();
            for (Worker worker : workers) {
                dataIds.remove(worker.getId());
                organiztionNames.remove(worker.getOrganization().getFullName());
            }
            dataCollection.removeAll(workers);
            return count;
        }
        long count = dataCollection.stream().filter((x -> position.equals(x.getPosition()))).count();
        List<Worker> workers = dataCollection.stream().filter(x -> position.equals(x.getPosition())).toList();
        for (Worker worker : workers) {
            dataIds.remove(worker.getId());
            organiztionNames.remove(worker.getOrganization().getFullName());
        }
        dataCollection.removeAll(workers);
        return count;
    }

    private Integer getMaxSalary() {
        Optional<Integer> maxSalary = dataCollection.stream().map(Worker::getSalary).max(Integer::compare);
        return maxSalary.orElse(0);
    }

    public boolean addIfMax(Worker worker) {
        if (worker.getSalary() > getMaxSalary()) {
            add(worker);
            return true;
        }
        return false;

    }

    private void removeNameOrganization(String name) {
        organiztionNames.remove(name);
    }

    public boolean removeByID(Integer id) {
        if (containsId(id)) {
            Worker worker = dataCollection.stream().filter(x -> id.equals(x.getId())).findAny().get();
            removeId(worker.getId());
            removeNameOrganization(worker.getOrganization().getFullName());
            dataCollection.remove(worker);
            return true;
        }
        return false;
    }


    public PriorityQueue<Worker> getDataCollection() {
        return dataCollection;
    }

    public void add(Worker worker) {
        worker.setId(getNewId());
        this.dataCollection.add(worker);
        this.dataIds.add(worker.getId());
        this.organiztionNames.add(worker.getOrganization().getFullName());
    }

    public boolean organizationNameCheck(String name) {
        return this.organiztionNames.contains(name);
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
