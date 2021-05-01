package com.pb.laboratory.uitls;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;

import javax.servlet.ServletRequest;

public class SnakeToCamelModelAttributeMethodProcessor extends ServletModelAttributeMethodProcessor {
    public SnakeToCamelModelAttributeMethodProcessor(boolean annotationNotRequired) {
        super(annotationNotRequired);
    }

    @Override
    protected void bindRequestParameters(WebDataBinder binder, NativeWebRequest request) {
        SnakeToCamelRequestDataBinder camelRequestDataBinder = new SnakeToCamelRequestDataBinder(binder.getTarget(), binder.getObjectName());
        camelRequestDataBinder.bind((ServletRequest)request.getNativeRequest(ServletRequest.class));
    }
}
