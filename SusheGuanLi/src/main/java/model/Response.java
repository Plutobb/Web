package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Response {

    private Boolean success;
    private String code;
    private String message;
    private Integer total;
    private Object data;
    private String stackTrace;


}
