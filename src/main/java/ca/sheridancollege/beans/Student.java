package ca.sheridancollege.beans;

import lombok.Data;

@Data
public class Student {

    private Long id;
    private String first_name;
    private String last_name;
    private String program_name;
    private int program_year;
    private boolean program_coop;
    private boolean program_internship;

}
