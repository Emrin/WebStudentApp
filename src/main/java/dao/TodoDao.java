package dao;
import entities.Todo;
import java.util.List;

public interface TodoDao {
    void createTodoTable();
    void insert(Todo todo);
    Todo selectById(int id);
    List<Todo> selectAll();
    void delete(int id);
    void update(Todo todo, int id);
}


