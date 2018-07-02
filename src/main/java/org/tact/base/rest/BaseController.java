package org.tact.base.rest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/base")
public class BaseController {
	
    @RequestMapping(value = "", method = RequestMethod.GET)
    public <T> T listUsers() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", "two");
        map.put("three", "four");
        
        return (T) map;
    }
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public <T> T test(@RequestParam(value = "age") Integer age) throws Exception {
        
    	Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", "two");
        map.put("three", "four");
        
        if(age < 14){
        	throw new Exception("Not Allowed");
        }
        
        return (T) map;
    }
    
       
}
