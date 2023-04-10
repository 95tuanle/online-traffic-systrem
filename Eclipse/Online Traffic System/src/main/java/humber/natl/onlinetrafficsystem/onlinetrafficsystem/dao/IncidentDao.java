package humber.natl.onlinetrafficsystem.onlinetrafficsystem.dao;

import humber.natl.onlinetrafficsystem.onlinetrafficsystem.models.Incident;

import java.util.List;

public interface IncidentDao {
    List<Incident> readAll();

    void create(Incident incident);

    void delete(long id);
}
