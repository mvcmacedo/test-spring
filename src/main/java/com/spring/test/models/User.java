package com.spring.test.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

import static com.spring.test.models.Risk.*;

@NoArgsConstructor
@Document(collection="User")
public class User {
    @Id
    private ObjectId id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Credit limit is mandatory")
    private float limit;

    @NotBlank(message = "Risk level is mandatory")
    private Risk risk;

    @Getter
    private int interest;

    public User (String n, float l, Risk r) {
        this.name = n;
        this.limit = l;
        this.risk = r;

        switch(r) {
            case A:
                this.interest = 0;
                break;
            case B:
                this.interest = 10;
                break;
            case C:
                this.interest = 20;
                break;
        }
    }

    public String getName() {
        return name;
    }

    public float getLimit() {
        return limit;
    }

    public Risk getRisk() {
        return risk;
    }
}
