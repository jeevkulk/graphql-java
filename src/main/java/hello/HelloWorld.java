package hello;


import graphql.GraphQL;
import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

import java.util.Map;

public class HelloWorld {

    public static void main(String[] args){

        GraphQLObjectType graphQLObjectType = GraphQLObjectType.newObject()
                .name("helloWorldQuery")
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .type(Scalars.GraphQLString)
                        .name("sayHello")
                        .staticValue("Hello World!")
                )
                .build();

        GraphQLSchema graphQLSchema = GraphQLSchema.newSchema()
                .query(graphQLObjectType)
                .build();

        Map<String, Object> resultMap = new GraphQL(graphQLSchema).execute("{sayHello}").getData();

        System.out.println(resultMap);


    }
}


