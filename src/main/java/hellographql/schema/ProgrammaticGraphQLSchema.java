package hellographql.schema;

import hellographql.datafetcher.SayHelloDataFetcher;
import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

public class ProgrammaticGraphQLSchema {

    public static GraphQLSchema getGraphQLSchema() {

        SayHelloDataFetcher dataFetcher = new SayHelloDataFetcher();

        GraphQLObjectType graphQLObjectType = GraphQLObjectType.newObject()
                .name("helloWorldQuery")
                .field(
                        GraphQLFieldDefinition.newFieldDefinition()
                                .type(Scalars.GraphQLString)
                                .name("sayHello")
                                .dataFetcher(environment -> dataFetcher.get(environment))
                                .build()
                )
                .build();

        GraphQLSchema graphQLSchema = GraphQLSchema.newSchema()
                .query(graphQLObjectType)
                .build();

        return graphQLSchema;
    }
}
