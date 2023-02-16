package ca.sheridancollege.databaseaccess;

import ca.sheridancollege.beans.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class DatabaseAccess {

    private NamedParameterJdbcTemplate jdbc;

    public DatabaseAccess(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Student> getStudent(){

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "Select * from student";

        BeanPropertyRowMapper<Student> studentMapper = new BeanPropertyRowMapper<>(Student.class);

        List<Student> student = jdbc.query(query,namedParameters,studentMapper);

        return student;
    }

    public Student getStudentBasedOnId(long id){

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * FROM student WHERE id = :id";
        namedParameters.addValue("id",id);

        BeanPropertyRowMapper<Student> studentMapper = new BeanPropertyRowMapper<>(Student.class);

        Student student = jdbc.queryForObject(query,namedParameters,studentMapper);

        return student;
    }
}

