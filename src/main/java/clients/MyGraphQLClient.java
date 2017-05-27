package clients;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import schemas.MyGraphQLSchema;

import java.util.Map;


public class MyGraphQLClient {

    public static void main(String[] args){
        GraphQLSchema graphQLSchema = MyGraphQLSchema.getGraphQLSchema();
        Map<String, Object> resultMap = GraphQL.newGraphQL(graphQLSchema)
                .build()
                .execute("{sayHello}")
                .getData();
        System.out.println(resultMap);
    }
}
