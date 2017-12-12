package repository;

import domain.Person;

import java.util.ArrayList;
import java.util.List;

public class PeopleRepository {

    private List<Person> peopleList;

    public PeopleRepository() {
        peopleList = new ArrayList<>();
        peopleList.add(new Person("Jeevan", "Kulkarni", 41, "Mumbai"));
        peopleList.add(new Person("Amit", "Shinde", 35, "Mumbai"));
    }

    public List<Person> getAllPeople() {
        return peopleList;
    }

    public void addPerson(Person person) {
        peopleList.add(person);
    }
}
