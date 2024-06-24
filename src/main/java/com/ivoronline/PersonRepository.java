package com.ivoronline;

import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class PersonRepository {

  //=========================================================================================================
  // INSERT
  //=========================================================================================================
  public void save(Connection connection, Person person) throws SQLException {
    String    sql       = "INSERT INTO PEOPLE (NAME, AGE) VALUES ('"+person.getName()+"',"+person.getAge()+")";
    Statement statement = connection.createStatement();
              statement.executeUpdate(sql);
  }

}
