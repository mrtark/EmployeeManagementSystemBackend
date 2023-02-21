package com.example.employee.error;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin
public class CustomErrorHandleWebRequest implements ErrorController {
    private ErrorAttributes errorAttributes;
    @RequestMapping("/error")
    ApiConclusion handleError(WebRequest webRequest) {
        Map<String, Object> attribute = errorAttributes.getErrorAttributes(webRequest,
                ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE,
                        ErrorAttributeOptions.Include.BINDING_ERRORS));
        int status = (Integer) attribute.get("status");
        String message = (String) attribute.get("message");
        String path = (String) attribute.get("path");
        ApiConclusion error = new ApiConclusion(status, message, path);
        if (attribute.containsKey("error")) {
            List<FieldError> fieldErrorList = (List<FieldError>) attribute.get("error");
            Map<String, String> validationMistake = new HashMap<>();
            for (FieldError reffieldErrorList:fieldErrorList) {
                validationMistake.put(reffieldErrorList.getField(),reffieldErrorList.getDefaultMessage());
                error.setValidationError(validationMistake);
            }
        }
        return error;
    }

}
