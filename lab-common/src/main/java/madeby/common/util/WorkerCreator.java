package madeby.common.util;

import madeby.common.data.data_class.Coordinates;
import madeby.common.data.data_class.Organization;
import madeby.common.data.data_class.Position;
import madeby.common.data.data_class.Worker;

import java.util.Date;

public final class WorkerCreator {

    private WorkerCreator() {
    }

    public static Worker createWorker(InputManager inputManager, OutputManager outputManager, CollectionManager collectionManager) {
        Coordinates.CoordinatesBuilder coordinatesBuilder = Coordinates.builder();
        outputManager.println("add position(\"\")");
        Position position;
        if (!inputManager.nextLine().equals("")) {
            position = inputManager.readPositionValue("MANAGER\nLABORER\nDEVELOPER\nCLEANER", outputManager);
        } else {
            position = null;
        }
        coordinatesBuilder.x(inputManager.readFloatValue("coordinatesX(Float)", outputManager, x -> x < Coordinates.MAX_X));
        coordinatesBuilder.y(inputManager.readFloatValue("coordinatesY(Float)", outputManager, x -> x > Coordinates.MIN_Y));
        Worker.WorkerBuilder workerBuilder = Worker.builder();
        workerBuilder.id(-1);
        workerBuilder.position(position);
        workerBuilder.coordinates(coordinatesBuilder.build());
        workerBuilder.name(inputManager.readStringWithPredicatValue("name", outputManager, x -> x.length() > 0));
        workerBuilder.creationDate(new Date());
        workerBuilder.salary(inputManager.readIntegerValueWithPredicate("salary", outputManager, x -> x > 0));
        workerBuilder.status(inputManager.readStatusValue("FIRED\nHIRED\nRECOMMENDED_FOR_PROMOTION\nREGULAR\nPROBATION", outputManager));
        Organization.OrganizationBuilder organizationBuilder = Organization.builder();
        organizationBuilder.fullName(inputManager.readStringWithPredicatValue("Organization full name", outputManager, x -> {
            return x.length() >= Organization.MIN_LENGTH_FULLNAME && collectionManager.organizationNameCheck(x);
        }));
        organizationBuilder.annualTurnover(inputManager.readFloatValueWithPredicate("Annual Turnover", outputManager, x -> x >= Organization.MIN_ANNUAL_TURNOVER));
        organizationBuilder.employeesCount(inputManager.readLongValueWithPrediction("employees Count", outputManager, x -> x >= Organization.MIN_EMPLOYEES_COUNT));
        workerBuilder.organization(organizationBuilder.build());
        return workerBuilder.build();

    }
}
