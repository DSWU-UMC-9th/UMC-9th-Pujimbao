package com.example.app.global.resolver;

import com.example.app.global.annotation.ValidPage;
import com.example.app.global.apiPayload.code.PageErrorCode;
import com.example.app.global.apiPayload.exception.PageValidationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.*;
import org.springframework.web.servlet.mvc.method.annotation.ServletWebArgumentResolverAdapter;

@Component
public class PageArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(ValidPage.class)
                && parameter.getParameterType().equals(Integer.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) {

        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        String pageParam = request.getParameter(parameter.getParameterName());

        if (pageParam == null) {
            throw new PageValidationException(PageErrorCode.INVALID_PAGE);
        }

        int page = Integer.parseInt(pageParam);

        if (page < 1) {
            throw new PageValidationException(PageErrorCode.INVALID_PAGE);
        }

        // 프론트 기준 page 1부터 -> JPA Pageable은 0부터
        return page - 1;
    }
}
