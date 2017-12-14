package resolver;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import domain.Person;
import repository.PeopleRepository;

public class Mutation implements GraphQLRootResolver {

    private final PeopleRepository repository;

    public Mutation(PeopleRepository repository) {
        this.repository = repository;
    }

    public Person createPerson(int id, String firstName, String lastName, int age, String city) {
        Person person = new Person(id, firstName, lastName, age, city);
        repository.addPerson(person);
        return person;
    }
}
