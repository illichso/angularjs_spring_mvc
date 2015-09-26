package com.illichso.mvc;

import com.illichso.entity.BlogEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BlogEntryController {

    @RequestMapping("/test1")
    public ResponseEntity<Object> test1(){
        BlogEntity entity = new BlogEntity("Test Blog Entry");
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @RequestMapping("/test")
    public @ResponseBody BlogEntity test(){
        BlogEntity entity = new BlogEntity("Test Blog Entry");
        return entity;
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public @ResponseBody BlogEntity test(@RequestBody BlogEntity entity){
        return entity;
    }
}
