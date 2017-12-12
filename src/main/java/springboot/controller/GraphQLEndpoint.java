package springboot.controller;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.PeopleRepository;
import resolver.Mutation;
import resolver.Query;

import javax.servlet.annotation.WebServlet;

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
}
