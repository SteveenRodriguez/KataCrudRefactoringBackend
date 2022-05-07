package co.com.sofka.crud.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //permite generar automáticamente el ID
    private Long id;
    //unique: Creará una restricción en la tabla para que el valor de esa columna sea única
    @Column(nullable = false, unique = true) //nullable: Crea una restricción en la tabla (Not Null) para impedir que se inserten valores nulos.
    private String name;

    @Column(nullable = false)
    private boolean completed;

    //Muchos toDos para una lista (Entities asociadas)
    @ManyToOne(fetch = FetchType.EAGER) //devuelve toda la información disponible
    @JoinColumn(name = "id_list") // Enlaza la entidad toDos a una lista usando su id
    private ListEntity list;


    //Constructores
    public TodoEntity() {
    }

    public TodoEntity(Long id, String name, boolean completed, ListEntity list) {
        this.id = id;
        this.name = name;
        this.completed = completed;
        this.list = list;
    }

    //Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public ListEntity getList() {
        return list;
    }

    public void setList(ListEntity list) {
        this.list = list;
    }
}