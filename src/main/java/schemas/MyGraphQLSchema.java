package schemas;

import datafetchers.MyDataFetcher;
import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

public class MyGraphQLSchema {

    public static GraphQLSchema getGraphQLSchema() {

        MyDataFetcher dataFetcher = new MyDataFetcher();

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
