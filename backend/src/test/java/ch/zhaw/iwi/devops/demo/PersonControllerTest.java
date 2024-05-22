package ch.zhaw.iwi.devops.demo;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ch.zhaw.iwi.devops.demo.Person;
import ch.zhaw.iwi.devops.demo.PersonController;
import ch.zhaw.iwi.devops.demo.ToDoController;

public final class PersonControllerTest {

    @Test
    public void getPersonTest() {
        PersonController personController = new PersonController();
        personController.init();
        Integer id = 1;
        Person person = personController.getPerson(id);
        Assertions.assertNotNull(person.getName());
    }

    @Test
    public void getAllPersonsTest() {
        PersonController personController = new PersonController();
        personController.init();
        Map<Integer, Person> list = personController.getAllPersons();
        Assertions.assertEquals(3, list.size());
    }

    @Test
    public void newPersonTest() {
        PersonController personController = new PersonController();
        personController.init();
        Integer id = 4;
        Person person = new Person(id, "George Washington");
        personController.createPerson(person);
        Map<Integer, Person> list = personController.getAllPersons();
        Assertions.assertEquals(4, list.size());
    }

    @Test
    public void deletePersonTest() {
        PersonController personController = new PersonController();
        personController.init();
        Integer id = 3;
        personController.deletePerson(id);
        Person personCheck = personController.getPerson(id);
        Assertions.assertNull(personCheck);
    }

    @Test
    public void testTest() {
        ToDoController controller = new ToDoController();
        String message = controller.test();
        String expectedMessage = "ToDo app is up and running!";
        Assertions.assertEquals(expectedMessage, message);
    }

    @Test
    public void testToDo() {
        ToDo todo = new ToDo();
        Assertions.assertNull(todo.getTitle());
    }

    @Test
    public void testcreateTodo() {
        ToDo todo = new ToDo(6, "neues Titel", "neue Description");
        ToDoController toDoController = new ToDoController();
        toDoController.init();
        toDoController.createTodo(todo);
        ToDo toDoFromController = toDoController.getTodo(6);
        Assertions.assertEquals(todo.getDescription(), toDoFromController.getDescription());

    }

    @Test
    public void testPing() {
        ToDoController toDoController = new ToDoController();
        String response = toDoController.ping();
        String expectedResponse = "{ \"status\": \"ok\", \"userId\": \"admin\", \"languageCode\": \"de\",\"version\": \"0.0.1\"}";
        Assertions.assertEquals(expectedResponse, response);
    }

}
