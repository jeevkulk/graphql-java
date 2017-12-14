package exceptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ExceptionWhileDataFetching;

public class GraphQLException extends ExceptionWhileDataFetching {

    public GraphQLException(ExceptionWhileDataFetching exceptionWhileDataFetching) {
        super(exceptionWhileDataFetching.getException());
    }

    @Override
    @JsonIgnore
    public Throwable getException() {
        return super.getException();
    }
}
