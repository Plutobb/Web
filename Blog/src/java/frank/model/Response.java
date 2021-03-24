package frank.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response {//前端解析json字符串，统一的数据格式

    private boolean success;
    private String message;
    private String stackTrace;
    private Object data;
}
