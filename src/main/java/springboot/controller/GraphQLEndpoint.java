package springboot.controller;

import com.coxautodev.graphql.tools.SchemaParser;
import exceptions.GraphQLException;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.PeopleRepository;
import resolver.Mutation;
import resolver.Query;

import javax.servlet.annotation.WebServlet;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

    public GraphQLEndpoint() {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        PeopleRepository peopleRepository = new PeopleRepository();
        return SchemaParser.newParser()
                .file("schema/schema.graphqls")
                .resolvers(new Query(peopleRepository), new Mutation(peopleRepository))
                .build()
                .makeExecutableSchema();
    }

    @Override
    protected List<GraphQLError> filterGraphQLErrors(List<GraphQLError> errors) {
        return errors.stream()
                .filter(e -> e instanceof ExceptionWhileDataFetching || super.isClientError(e))
                .map(e -> e instanceof ExceptionWhileDataFetching ? new GraphQLException((ExceptionWhileDataFetching) e) : e)
                .collect(Collectors.toList());
    }
}
