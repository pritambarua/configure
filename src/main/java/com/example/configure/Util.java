package com.example.configure;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class Util {
    public static ResponseEntity<Map<String, Object>> okResponseEntity(Object response){
        Map<String, Object> data = new HashMap<>();
        data.put("data", response);;

        return ResponseEntity.ok(data);
    }
}
