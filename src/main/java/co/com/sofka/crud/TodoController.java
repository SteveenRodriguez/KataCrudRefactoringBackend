package co.com.sofka.crud;

import co.com.sofka.crud.entity.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "api/todos")
    public Iterable<TodoEntity> list(){
        return service.list();
    }
    
    @PostMapping(value = "api/todo")
    public TodoEntity save(@RequestBody TodoEntity todo){
        return service.save(todo);
    }

    @PutMapping(value = "api/todo")
    public TodoEntity update(@RequestBody TodoEntity todo){
        if(todo.getId() != null){
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id")Long id){
        service.delete(id);
    }

    @GetMapping(value = "api/{id}/todo")
    public TodoEntity get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
