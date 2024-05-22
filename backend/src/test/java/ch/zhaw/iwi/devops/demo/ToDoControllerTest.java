package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ToDoControllerTest {
    
    @Test
    public void testCreate() {
        ToDoController controller = new ToDoController();
        var todo = new ToDo(1, "t", "d");
        controller.createTodo(1, todo);
        assertEquals(1, controller.count());
        assertEquals(1, controller.todo().size());
    }

    @Test
    void testTest() {
        ToDoController controller = new ToDoController();
        String message = controller.test();
        String exceptedmessage = "ToDo app is up and running!";
        Assertions.assertEquals(exceptedmessage, message);
    }

    @Test
    void testPing() {
        ToDoController controller = new ToDoController();
        String response = controller.ping();
        String expectedResponse = "{ \"status\": \"ok\", \"userId\": \"admin\", \"languageCode\": \"de\",\"version\": \"0.0.1\"}";
        Assertions.assertEquals(expectedResponse, response);
    }

    @Test
    void testDeleteTodo() {
        ToDoController controller = new ToDoController();
        controller.init();
        int initialCount = controller.count();
        
        ToDo deletedTodo = controller.deleteTodo(1);
        assertEquals(initialCount - 1, controller.count());
        assertEquals("Neuer Job", deletedTodo.getTitle());
        assertEquals("5 DevOps Engineers einstellen", deletedTodo.getDescription());
    }

}
