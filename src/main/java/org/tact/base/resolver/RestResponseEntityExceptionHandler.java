package org.tact.base.resolver;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends
		ResponseEntityExceptionHandler {

	private MappingJackson2JsonView  jsonView = new MappingJackson2JsonView();

	@SuppressWarnings("unchecked")
	@ExceptionHandler({Exception.class})
	public <T> T handleError(Exception ex) {
		return (T) new ModelAndView( jsonView, convertExceptionMap(ex));
	}
	
	public static Map<String, Object> convertExceptionMap(Exception ex) {
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("result", 101);
		map.put("message", ex.getMessage());		
		
		return map;
	}
}