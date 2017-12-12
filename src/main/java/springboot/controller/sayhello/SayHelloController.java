package springboot.controller.sayhello;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import schemas.sayhello.ProgrammaticGraphQLSchema;

import java.util.Map;

@RestController
public class SayHelloController {

    @RequestMapping("/query")
    public Map<String, Object> queryGraphQL() {
        GraphQLSchema graphQLSchema = ProgrammaticGraphQLSchema.getGraphQLSchema();
        Map<String, Object> resultMap = GraphQL.newGraphQL(graphQLSchema)
                .build()
                .execute("{sayHello}")
                .getData();
        System.out.println(resultMap);
        return resultMap;
    }
}
