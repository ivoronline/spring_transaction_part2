package com.ivoronline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class PersonService {

    @Autowired private PersonRepository personRepository;
    @Autowired private DataSource       dataSource;

    public void insertRecords() throws SQLException {

        //GET DB CONNECTION
        Connection connection = dataSource.getConnection();

        //FIRST RECORD IS ALWAYS INSERTED
        Person person1 = new Person(0, "First Person", 10);
        personRepository.save(connection, person1);

        //TRANSACTION
        try { //It doesn't work with try(connection) => throws java.sql.SQLRecoverableException

            //START TRANSACTION
            //connection.setAutoCommit(false);

            //EXECUTE SQL STATEMENTS
            for (int age = 1; age <= 2; age++) {
                if(age==2) { throw new Exception("Exception"); }
                Person person = new Person(age, "John", age);
                personRepository.save(connection, person);
                System.out.println("Record inserted");
            }

            //COMMIT TRANSACTION
            connection.commit();

        } catch (Exception e) {
            //ROLLBACK TRANSACTION
            connection.rollback();   //throws java.sql.SQLRecoverableException
        }
        finally {
          connection.close();
        }

    }

}
