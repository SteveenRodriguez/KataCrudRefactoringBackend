package co.com.sofka.crud.dto;
//Data Transfer Object: es un objeto que transporta datos entre procesos
public class ToDoListDTO {
    //atributos
    private Long idToDo;
    private String nameToDo;
    private boolean completed;
    private Long idList;

    //Getters and Setters
    public Long getIdToDo() {
        return idToDo;
    }

    public void setIdToDo(Long idToDo) {
        this.idToDo = idToDo;
    }

    public String getNameToDo() {
        return nameToDo;
    }

    public void setNameToDo(String nameToDo) {
        this.nameToDo = nameToDo;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getIdList() {
        return idList;
    }

    public void setIdList(Long idList) {
        this.idList = idList;
    }
}