package hellographql.client;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import hellographql.schema.ProgrammaticGraphQLSchema;

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
