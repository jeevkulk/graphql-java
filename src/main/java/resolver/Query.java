package resolver;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import domain.Person;
import repository.PeopleRepository;

import java.util.List;

public class Query implements GraphQLRootResolver {

    private final PeopleRepository repository;

    public Query(PeopleRepository repository) {
        this.repository = repository;
    }

    public List<Person> allPeople() {
        return repository.getAllPeople();
    }
}
