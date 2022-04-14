package util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class APIResponseStructure<T> {
    private boolean isSuccess;
    private Integer responseCode;
    private T response;
    private List<Error> errors;
}
