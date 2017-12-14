package repository;

import domain.Person;
import filter.PersonFilter;

import java.util.ArrayList;
import java.util.List;

public class PeopleRepository {

    private List<Person> peopleList;

    public PeopleRepository() {
        peopleList = new ArrayList<>();
        peopleList.add(new Person(1,"Manish", "Wadhane", 42, "Pune"));
        peopleList.add(new Person(2,"Jeevan", "Kulkarni", 41, "Mumbai"));
        peopleList.add(new Person(3,"Unmesh", "Dhole", 38, "Pune"));
        peopleList.add(new Person(4,"Amit", "Shinde", 35, "Mumbai"));
    }

    public List<Person> getAllPeople() {
        return peopleList;
    }

    public List<Person> getPeople(PersonFilter personFilter) {
        List<Person> filteredPeople = new ArrayList<>();
        for (Person person : peopleList) {
            if (personFilter.getFirstNameStartsWith() != null && !"".equals(personFilter.getFirstNameStartsWith())
                    && person.getFirstName().startsWith(personFilter.getFirstNameStartsWith())) {
                filteredPeople.add(person);
            }
            if (personFilter.getAgeFrom() > 0 && person.getAge() > personFilter.getAgeFrom()) {
                filteredPeople.add(person);
            }
            if (personFilter.getAgeTo() > 0 && person.getAge() < personFilter.getAgeTo()) {
                filteredPeople.add(person);
            }
            if (personFilter.getCity() != null && !"".equals(personFilter.getCity())
                    && personFilter.getCity().equals(person.getCity())) {
                filteredPeople.add(person);
            }
        }
        return filteredPeople;
    }

    public void addPerson(Person person) {
        peopleList.add(person);
    }
}
