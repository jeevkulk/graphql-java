package datafetchers;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import services.MyService;

public class MyDataFetcher implements DataFetcher {

    MyService service = new MyService();

    @Override
    public Object get(DataFetchingEnvironment dataFetchingEnvironment) {
        return service.getData("Hello");
    }
}
