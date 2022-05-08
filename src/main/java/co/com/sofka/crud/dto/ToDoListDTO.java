package co.com.sofka.crud.dto;
//Data Transfer Object: es un objeto que transporta datos entre procesos

/**
 * class of DTO
 * @autor Steveen Rodríguez
 */
public class ToDoListDTO {
    /**
     * class attribute
     */
    private Long idToDo;
    private String nameToDo;
    private boolean completed;
    private Long idList;

    /**
     *  get the IdToDo
     * @return idToDo
     */
    public Long getIdToDo() {
        return idToDo;
    }

    /**
     * change the idToDo attribute
     * @param idToDo idToDo of the class entity ToDo
     */
    public void setIdToDo(Long idToDo) {
        this.idToDo = idToDo;
    }

    /**
     * get the NameToDo
     * @return nameToDo
     */
    public String getNameToDo() {
        return nameToDo;
    }

    /**
     * change the NameToDo attribute
     * @param nameToDo
     */
    public void setNameToDo(String nameToDo) {
        this.nameToDo = nameToDo;
    }

    /**
     * get the isCompleted
     * @return completed
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * change the Completed
     * @param completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * get the idList
     * @return idList
     */
    public Long getIdList() {
        return idList;
    }

    /**
     * chante the idList
     * @param idList
     */
    public void setIdList(Long idList) {
        this.idList = idList;
    }
}