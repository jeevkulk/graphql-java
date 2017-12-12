package datafetchers.sayhello;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import services.sayhello.SayHelloService;

public class SayHelloDataFetcher implements DataFetcher {

    SayHelloService service = new SayHelloService();

    @Override
    public Object get(DataFetchingEnvironment dataFetchingEnvironment) {
        return service.getData("Hello");
    }
}
