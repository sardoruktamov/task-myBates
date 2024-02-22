package uz.javadev.taskmybates.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String address;
}
