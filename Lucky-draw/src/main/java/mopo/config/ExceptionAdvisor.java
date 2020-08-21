package mopo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;

@Slf4j
@ControllerAdvice
public class ExceptionAdvisor {

    /**
     * 请求数据错误：包括类型转换错误，校验失败
     * @param e
     */
    @ExceptionHandler({
            BindException.class//使用@Valid 验证路径中请求实体校验失败后抛出的异常
            , ConstraintViolationException.class//处理请求参数格式错误 @RequestParam上validate失败后抛出的异常
            , MethodArgumentNotValidException.class//处理请求参数格式错误 @RequestBody上validate失败后抛出的异常
            , MethodArgumentTypeMismatchException.class//请求参数类型转换错误
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleMethodArgumentTypeMismatchException(Throwable e){
        log.debug("================================");
        log.debug("Controller方法参数类型转换错误", e);
    }

    @ExceptionHandler({
            MethodNotAllowedException.class
            , HttpRequestMethodNotSupportedException.class
    })
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public void handleMethodNotAllowedException(Throwable e){
        log.debug("================================");
        log.debug("Controller提供的http方法不支持", e);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNoHandlerFoundException(Throwable e){
        log.debug("================================");
        log.debug("找不到http请求处理器", e);
    }

//    @ExceptionHandler(BaseException.class)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public Object handleBaseException(BaseException e){
//        log.debug("================================");
//        log.debug("服务端自定义异常", e);
//        return ResponseResult.error(e.getCode(), e.getMessage());
//    }
//
//    @ExceptionHandler(Throwable.class)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public Object handleException(Throwable e){
//        log.error("================================");
//        log.error("未知异常", e);
//        return ResponseResult.error();
//    }
}
