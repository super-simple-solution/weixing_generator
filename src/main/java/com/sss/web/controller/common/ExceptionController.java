package com.sss.web.controller.common;

import com.sss.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class ExceptionController {

    @GetMapping("/resourceNotFound")
    public void throwException() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("xiaoming", "xiaoming");
        throw new ResourceNotFoundException(hashMap);
    }

}
