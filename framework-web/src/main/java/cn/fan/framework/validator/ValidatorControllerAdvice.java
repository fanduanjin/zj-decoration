package cn.fan.framework.validator;

import cn.fan.core.web.HttpResult;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeCreator;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Description
 * @Date 2020/4/29
 * @Create By admin
 */

@RestControllerAdvice
public class ValidatorControllerAdvice {
    @Autowired
    ObjectMapper objectMapper;
    Logger LOGGER = LoggerFactory.getLogger(ValidatorControllerAdvice.class);

    @ExceptionHandler(ConstraintViolationException.class)
    void handleConstraintViolationException(ConstraintViolationException exception, HttpServletResponse response) throws IOException {
        String msg = exception.getMessage();
        LOGGER.warn(msg);
        String[] msgs = msg.split(": ");
        HttpResult result = HttpResult.FAILD_VALIDATOR(msgs[msgs.length-1]);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        response.setStatus(HttpStatus.OK.value());
        out.print(objectMapper.writeValueAsString(result));

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    void handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,HttpServletResponse response) throws IOException{
        List<FieldError> fieldErrors=exception.getBindingResult().getFieldErrors();
        ArrayNode root= objectMapper.createArrayNode();
        for(FieldError fieldError:fieldErrors){
            ObjectNode jsonNode=objectMapper.createObjectNode();
            jsonNode.put(fieldError.getField(),fieldError.getDefaultMessage());
            root.add(jsonNode);
        }
        HttpResult httpResult=HttpResult.FAILD_RESULT(null);
        String msg=objectMapper.writeValueAsString(httpResult);
        ObjectNode result=(ObjectNode) objectMapper.readTree(msg);
        result.put("msg",root);
        msg=objectMapper.writeValueAsString(result);
        LOGGER.warn(msg);
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out=response.getWriter();
        response.setStatus(HttpStatus.OK.value());
        out.print(msg);
    }
}
