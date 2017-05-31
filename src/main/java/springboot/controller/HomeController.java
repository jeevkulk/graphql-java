package springboot.controller;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import schemas.MyGraphQLSchema;

import java.util.Map;

@RestController
public class HomeController {

    @RequestMapping("/home")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/query")
    public Map<String, Object> queryGraphQL() {
        GraphQLSchema graphQLSchema = MyGraphQLSchema.getGraphQLSchema();
        Map<String, Object> resultMap = GraphQL.newGraphQL(graphQLSchema)
                .build()
                .execute("{sayHello}")
                .getData();
        System.out.println(resultMap);
        return resultMap;
    }
}
