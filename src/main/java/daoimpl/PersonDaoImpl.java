package daoimpl;

import dao.PersonDao;
import entities.Person;
import util.ConConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PersonDaoImpl implements PersonDao {
    //@Override
    public void createPersonTable() {
        Connection connection = null;
        Statement statement = null;

        try{
            connection = ConConfig.getConnection();
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS person(id int primary key unique auto_increment," +
                    "username varchar(55), password varchar(55), role varchar(55))");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //@Override
    public void insert(Person person) {
        // if role is teacher
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = ConConfig.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO person(username,password,role) VALUES(?, ?, ?)");
            preparedStatement.setString(1, person.getUsername());
            preparedStatement.setString(2, person.getPassword());
            preparedStatement.setString(3, person.getRole());
            preparedStatement.executeUpdate();
            System.out.println("INSERT INTO person (first_name, password, role)" +
                    "VALUES (me, password, student)");

        }catch(Exception e){
            e.printStackTrace();
        } finally{
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //@Override
    public Person selectById(int id) {
        Person person = new Person();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = ConConfig.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                person.setId(resultSet.getInt("id"));
                person.setUsername(resultSet.getString("username"));
                person.setPassword(resultSet.getString("password"));
                person.setRole(resultSet.getString("role"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return person;
    }

    //@Override
    public List<Person> selectAll() {
        List<Person> persons = new ArrayList<Person>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            connection = ConConfig.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM person");

            while(resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setUsername(resultSet.getString("username"));
                person.setPassword(resultSet.getString("password"));
                person.setRole(resultSet.getString("role"));

                persons.add(person);
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return persons;
    }

    //@Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = ConConfig.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM person WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.printf("DELETE FROM person WHERE id = ?");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //@Override
    public void update(Person person, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = ConConfig.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE person SET " +
                    "username = ?, password = ?, role = ? WHERE id = ?");
            preparedStatement.setString(1, person.getUsername());
            preparedStatement.setString(2, person.getPassword());
            preparedStatement.setString(3, person.getRole());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();

            System.out.printf("UPDATE person SET " +
                    "username = ?, password = ?, role = ? WHERE id = ?");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Person copyPerson(Person person){
        Person newPerson = new Person();
        newPerson.setId(person.getId());
        newPerson.setUsername(person.getUsername());
        newPerson.setPassword(person.getPassword());
        newPerson.setRole(person.getRole());
        return newPerson;
    }
}
