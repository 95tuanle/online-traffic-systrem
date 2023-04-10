package humber.natl.onlinetrafficsystem.onlinetrafficsystem.dao;

import humber.natl.onlinetrafficsystem.onlinetrafficsystem.models.Vehicle;

import java.util.List;

public interface VehicleDao {
    List<Vehicle> readAll();

    void create(Vehicle vehicle);

    void delete(long id);
}
