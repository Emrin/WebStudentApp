import daoimpl.PersonDaoImpl;
import daoimpl.TodoDaoImpl;
import entities.Person;
import entities.Todo;
import util.ConConfig;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String [] args) {
        boolean logged = false;

        PersonDaoImpl pdi = new PersonDaoImpl();
        TodoDaoImpl tdi = new TodoDaoImpl();
        pdi.createPersonTable(); // will create a table 'person' if it doesn't exist
        tdi.createTodoTable();

        System.out.println("Login screen");

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter username: ");
        String usr = reader.next();
        System.out.println("Enter password: ");
        String pswd = reader.next();

        System.out.println("Verifying...");

        // Look for username, if found check password, if matching set boolean




        // Adding elements to tables
//        Person person = new Person("Art", "pwd3", "student");
//        pdi.insert(person);
//
//        Todo todo = new Todo("Work hard");
//        tdi.insert(todo);

        // Selecting element by id
//        Person person = pdi.selectById(1);
//        System.out.println(person.getId()+", "+person.getUsername()+", "+person.getPassword()+", "+person.getRole());Person person = pdi.selectById(1);

//        Todo todo = tdi.selectById(1);
//        System.out.println(todo.getId()+", "+todo.getTask());

        // Deleting elements
//        pdi.delete(3);
//        tdi.delete(3);

        // Updating elements
//        Person person = new Person("Tom", "pwd2", "teacher");
//        pdi.update(person,1);
//        Todo todo = new Todo("More homework");
//        tdi.update(todo,1);

        // Display elements
//        List<Person> persons = pdi.selectAll();
//        for(Person personT : persons){
//            System.out.println(personT.getId()+", "+personT.getUsername()+", "
//                    +personT.getPassword()+", "+personT.getRole());
//        }
//
//        List<Todo> todos = tdi.selectAll();
//        for(Todo todoT : todos){
//            System.out.println(todoT.getId()+", "+todoT.getTask());
//        }


    }
}
