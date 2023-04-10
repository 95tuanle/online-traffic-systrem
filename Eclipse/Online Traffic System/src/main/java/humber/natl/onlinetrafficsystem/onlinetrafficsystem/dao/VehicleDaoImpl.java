package humber.natl.onlinetrafficsystem.onlinetrafficsystem.dao;

import humber.natl.onlinetrafficsystem.onlinetrafficsystem.models.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class VehicleDaoImpl implements VehicleDao {
    final
    SessionFactory sessionFactory;

    public VehicleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Vehicle> readAll() {
        return sessionFactory.getCurrentSession().createQuery("from Vehicle ", Vehicle.class).list();
    }

    @Override
    @Transactional
    public void create(Vehicle vehicle) {
        sessionFactory.getCurrentSession().persist(vehicle);
    }

    @Override
    @Transactional
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Vehicle vehicle = session.get(Vehicle.class, id);
        if (vehicle != null) {
            session.remove(vehicle);
        }
    }
}
