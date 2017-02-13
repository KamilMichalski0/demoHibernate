package michalski.kamil.dao;



import michalski.kamil.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;



@Repository
public class PersonDaoHibernate implements PersonDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public void save(Person person) {
        entityManager.persist(person);
    }

    @Override
    @Transactional
    public List<Person> getAll() {
        return entityManager.createQuery("SELECT p FROM Person p").getResultList();
    }

    @Override
    @Transactional
    public List<Person> findBySurname(String surname) {
        Query query = entityManager.createQuery("SELECT p FROM Person p WHERE p.surname='" + surname + "'");
        return query.getResultList();
    }
}
