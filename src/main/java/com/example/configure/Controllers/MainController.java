package com.example.configure.Controllers;

import com.example.configure.Dtos.UserDetailsRequestDTO;
import com.example.configure.Model.PersistInfo;
import com.example.configure.Services.PersistIfoStoreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.example.configure.Util.okResponseEntity;

@RestController
@AllArgsConstructor
public class MainController {

    @Autowired
    private final PersistIfoStoreService persistIfoStoreService;

    @GetMapping("/all-users")
    public ResponseEntity<Map<String, Object>> getAllUsers(){
        return okResponseEntity(
                persistIfoStoreService.getAll()
        );
    }

    @PostMapping("/add-user")
    public ResponseEntity<Map<String, Object>> addUser(@RequestBody PersistInfo requestDTO) throws IOException {
        persistIfoStoreService.addOne(requestDTO);
        return okResponseEntity(requestDTO);
    }

    @PostMapping("/user-by-name")
    public ResponseEntity<Map<String, Object>> saveUser(@RequestBody List<String> body){
        return okResponseEntity(persistIfoStoreService.getByName(body));
    }
}
