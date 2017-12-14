package schemafirst.resolver;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import schemafirst.domain.Person;
import schemafirst.filter.PersonFilter;
import schemafirst.repository.PeopleRepository;

import java.util.List;

public class Query implements GraphQLRootResolver {

    private final PeopleRepository repository;

    public Query(PeopleRepository repository) {
        this.repository = repository;
    }

    public List<Person> allPeople() {
        return repository.getAllPeople();
    }

    public List<Person> people(PersonFilter personFilter) {
        return repository.getPeople(personFilter);
    }
}
