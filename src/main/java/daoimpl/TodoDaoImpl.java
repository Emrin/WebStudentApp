package daoimpl;

import dao.TodoDao;
import entities.Todo;
import util.ConConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDaoImpl implements TodoDao{
    @Override
    public void createTodoTable() {
        Connection connection = null;
        Statement statement = null;

        try{
            connection = ConConfig.getConnection();
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS todo(id int primary key unique auto_increment, task varchar(100))");
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

    @Override
    public void insert(Todo todo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = ConConfig.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO todo(task) VALUES(?)");
            preparedStatement.setString(1, todo.getTask());
            preparedStatement.executeUpdate();
            System.out.println("INSERT INTO todo (task) VALUES (hello)");

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

    @Override
    public Todo selectById(int id) {
        Todo todo = new Todo();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = ConConfig.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM todo WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                todo.setId(resultSet.getInt("id"));
                todo.setTask(resultSet.getString("task"));
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
        return todo;
    }

    @Override
    public List<Todo> selectAll() {
        List<Todo> todos = new ArrayList<Todo>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            connection = ConConfig.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM todo");

            while(resultSet.next()){
                Todo todo = new Todo();
                todo.setId(resultSet.getInt("id"));
                todo.setTask(resultSet.getString("task"));
                todos.add(todo);
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
        return todos;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = ConConfig.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM todo WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.printf("DELETE FROM todo WHERE id = ?");
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

    @Override
    public void update(Todo todo, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = ConConfig.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE todo SET " +
                    "task = ? WHERE id = ?");
            preparedStatement.setString(1, todo.getTask());
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

            System.out.printf("UPDATE todo SET " +
                    "task = ? WHERE id = ?");
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

}
