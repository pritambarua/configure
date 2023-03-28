package com.example.configure.Model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("PersistStore")
public class PersistInfo {
    @Id
    @Field("_id")
    private String emailId;
    private String fName;
    private String lName;

}
