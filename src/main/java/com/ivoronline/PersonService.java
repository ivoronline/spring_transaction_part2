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

        //FIRST RECORD IS ALWAYS INSERTED
        personRepository.save(new Person(0, "First Person", 10));

        //GET DB CONNECTION
        Connection connection = dataSource.getConnection();

        //TRANSACTION
        try (connection) {           //Call connection.close() at the end of try block

            //START TRANSACTION
            connection.setAutoCommit(false);

            //EXECUTE SQL STATEMENTS
            for (int age = 1; age <= 5; age++) {
                if(age==4) { throw new RuntimeException("Exception"); }
                personRepository.save(new Person(0, "John", age));
                System.out.println("Record inserted");
            }

            //COMMIT TRANSACTION
            connection.commit();

        } catch (RuntimeException e) {
            //ROLLBACK TRANSACTION
            connection.rollback();   //throws java.sql.SQLRecoverableException
        }

    }

}
