package clients.sayhello;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import schemas.sayhello.ProgrammaticGraphQLSchema;

import java.util.Map;


public class ProgrammaticGraphQLClient {

    public static void main(String[] args){
        GraphQLSchema graphQLSchema = ProgrammaticGraphQLSchema.getGraphQLSchema();
        Map<String, Object> resultMap = GraphQL.newGraphQL(graphQLSchema)
                .build()
                .execute("{sayHello}")
                .getData();
        System.out.println(resultMap);
    }
}
