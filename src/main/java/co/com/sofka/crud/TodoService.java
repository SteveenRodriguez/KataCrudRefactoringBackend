package co.com.sofka.crud;

import co.com.sofka.crud.entity.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public Iterable<TodoEntity> list(){
        return repository.findAll();
    }

    public TodoEntity save(TodoEntity todo){
        return repository.save(todo);
    }

    public void delete(Long id){
        repository.delete(get(id));
    }

    public TodoEntity get(Long id){
         return repository.findById(id).orElseThrow();
    }

}
