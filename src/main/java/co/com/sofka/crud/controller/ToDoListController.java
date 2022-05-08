package co.com.sofka.crud.controller;

import co.com.sofka.crud.dto.ToDoListDTO;
import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * handler for the ToDoList
 * @author Steveen
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ToDoListController {

    /**
     * injection of the TodoService
     */
    @Autowired
    private TodoService todoService;

    /**
     * Get the all with DTO
     * @return todoService
     */
    @GetMapping(value = "/todos")
    public List<ToDoListDTO> getAllTodoS(){
        return todoService.getAllTodosWithList();
    }

    /**
     * Save ToDos using DTO
     * @param todo
     * @return ResponseEntity
     */
    @PostMapping(value = "/todo")
    public ResponseEntity<ToDoListDTO> saveToDo(@RequestBody ToDoListDTO todo ){
        try {
            ToDoListDTO newToDo = todoService.saveToDo(todo);
            return  new ResponseEntity<>(newToDo, HttpStatus.CREATED);
        }catch (Exception err){
            return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
        }
    }

    /**
     * Update ToDos by id
     * @param id
     * @param todo
     * @return ResponseEntity
     */
    @PutMapping(value = "/todo/{id}")
    public ResponseEntity<TodoEntity> updateTodo(@PathVariable("id") long id, @RequestBody TodoEntity todo){
        try {
            TodoEntity newToDo= todoService.updateTodo(id, todo);
            return new ResponseEntity<>(newToDo, HttpStatus.OK);
        } catch (Exception e){
            System.out.println("No se puede cambiar todo");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Get ToDos by id
     * @param id
     * @return ResponseEntity
     */
    @GetMapping("/todo/{id}")
    public ResponseEntity<TodoEntity> getTodobyId(@PathVariable("id") long id){
        try{
            return new ResponseEntity<>(todoService.getToDoById(id),HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Method to delete all by id
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping("/todo/delete/{id}")
    public ResponseEntity<String> deleteToDo(@PathVariable("id") long id){
        try {
            return new ResponseEntity<>(todoService.deleteToDoById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


}