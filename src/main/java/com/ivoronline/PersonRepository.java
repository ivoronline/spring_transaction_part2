package com.ivoronline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public class PersonRepository {

    @Autowired private JdbcTemplate jdbcTemplate;

    public void save(Person person) {
        jdbcTemplate.update(
            " INSERT INTO PEOPLE(NAME, AGE) VALUES(?,?)"
            , new Object[] { person.getName(), person.getAge() }
        );
    }

}
