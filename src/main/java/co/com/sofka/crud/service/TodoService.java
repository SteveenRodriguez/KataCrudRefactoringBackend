package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.ToDoListDTO;
import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.repository.ITodoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * To Do services class
 * @author Steveen Rodriguez
 */
@Service
public class TodoService {

    /**
     * injection of the ITodoRepository interface
     */
    @Autowired
    ITodoRepository todoRepository;

    /**
     * ModelMapper injection
     */
    @Autowired
    ModelMapper mapper;

    /**
     * Method to obtain all the toDos through the DTO
     * @return todoRepository
     */
    public List<ToDoListDTO> getAllTodosWithList(){
        return todoRepository.findAll().
                stream().
                map(this::convertEntityToDto). //method reference
                collect(Collectors.toList());
    }

    /**
     * we convert the toDos to a list of ToDos DTOs
     * @param todo
     * @return todoDto
     */
    private ToDoListDTO convertEntityToDto(TodoEntity todo){
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);//permite coincidir solo la última propiedad de jerarquía
        ToDoListDTO todoDto = new ToDoListDTO(); //creamos nuestro DTO
        todoDto = mapper.map(todo, ToDoListDTO.class); //plantilla de creación de objetos
        return todoDto;
    }


    /**
     * method to Save allDos using DTO
     * @param todo
     * @return mapper
     */
    public ToDoListDTO saveToDo(ToDoListDTO todo) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        TodoEntity todoEnt = new TodoEntity();
        todoEnt = mapper.map(todo, TodoEntity.class);
        if(todoEnt.getList() == null){
            throw new RuntimeException("La lista no puede ser vacía cuando se crea un todo");}
        TodoEntity hola = todoRepository.save(todoEnt);
        return mapper.map(hola, ToDoListDTO.class);
    }


    //Metodo para obtener toDos por id
    public TodoEntity getToDoById(Long id){
        Optional<TodoEntity> todo = todoRepository.findById(id);
        if(todo.isPresent()){
            return todo.get();
        } else {
            throw new RuntimeException("No existe todo");
        }
    }

    /**
     * Method to get toDos by id
     * @param id
     * @param todo
     * @return list
     */
    public TodoEntity updateTodo(long id, TodoEntity todo){
        Optional<TodoEntity> currentTodo = todoRepository.findById(id);

        if (currentTodo.isPresent()){
            TodoEntity _currentTodo = currentTodo.get();
            long currentList = _currentTodo.getList().getId();
            long newTodoListId = todo.getList().getId();
            if(currentList != newTodoListId){
                throw new RuntimeException("Cambiar la lista está prohibido");
            }
        }
        if(todo.getId() != null){
            return todoRepository.save(todo);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }


    /**
     * Method to remove allDos by id
     * @param id
     * @return list
     */
    public String deleteToDoById(Long id){
        Optional<TodoEntity> currentTodoById = todoRepository.findById(id);
        if (currentTodoById.isPresent()){
            TodoEntity _currentTodo = currentTodoById.get();
            todoRepository.delete(_currentTodo);
            return "ToDo eliminado";
        } else {
            throw new RuntimeException("No existe el todo a eliminar");
        }
    }
}