package util;

import daoimpl.PersonDaoImpl;
import entities.Person;

import java.util.List;

public class Verify {
    // returns person if finds match in the database, else returns 0;

    public Person CheckUser(String usr, String pwd) {
        Person person = new Person();
        person.setId(0);
        PersonDaoImpl pdi = new PersonDaoImpl();
        List<Person> persons = pdi.selectAll();

        for (Person personT : persons) {
            if (usr.equals(personT.getUsername()) && pwd.equals(personT.getPassword())){
                person = pdi.copyPerson(personT);
            }
        }
        return person;
    }
}
