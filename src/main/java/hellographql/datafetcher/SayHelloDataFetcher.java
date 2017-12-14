package hellographql.datafetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import hellographql.service.SayHelloService;

public class SayHelloDataFetcher implements DataFetcher {

    SayHelloService service = new SayHelloService();

    @Override
    public Object get(DataFetchingEnvironment dataFetchingEnvironment) {
        return service.getData("Hello from GraphQL!!");
    }
}
