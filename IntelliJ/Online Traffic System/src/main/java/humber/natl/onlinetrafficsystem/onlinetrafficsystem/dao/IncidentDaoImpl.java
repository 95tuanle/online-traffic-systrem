package humber.natl.onlinetrafficsystem.onlinetrafficsystem.dao;

import humber.natl.onlinetrafficsystem.onlinetrafficsystem.models.Incident;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class IncidentDaoImpl implements IncidentDao {
    final
    SessionFactory sessionFactory;

    public IncidentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Incident> readAll() {
        return sessionFactory.getCurrentSession().createQuery("from Incident ", Incident.class).list();
    }

    @Override
    @Transactional
    public void create(Incident incident) {
        sessionFactory.getCurrentSession().persist(incident);
    }

    @Override
    @Transactional
    public void delete(long id) {
        // Delete the incident
        Session session = sessionFactory.getCurrentSession();
        Incident incident = session.get(Incident.class, id);

        if (incident != null) {
            session.remove(incident);
        }
    }


}
