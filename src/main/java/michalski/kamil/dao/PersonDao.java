package michalski.kamil.dao;


import michalski.kamil.model.Person;

import java.util.List;

public interface PersonDao {
    void save(Person person);
    List getAll();
    List<Person> findBySurname(String surname);

}
