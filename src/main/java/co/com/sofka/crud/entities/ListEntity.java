package co.com.sofka.crud.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 *  Class that models and creates a list entity
 * @autor Steveen Rodríguez
 */
@Entity
public class ListEntity {

    /**
     * Class id attribute
     * @strategy: automatically generates the Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //genera ID automático
    private Long id;

    /**
     * Class name attribute
     * @unique: Create a constraint the table so that value of that column is unique
     * @nullable: Create constraint on table to prevent null values from being inserted
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * @Set: Interface tells us that you can not repeat all
     * @OneToMany: A list to many ToDos
     * @mappedBy: points the owning entity
     * @cascade when changes are applied it is reflected in all associated entities
     * @orphanRemoval remove all ToDos when there is no parent list
     * @fetch: returns all available information
     */
    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL, orphanRemoval= true, fetch = FetchType.EAGER)
    private Set<TodoEntity> toDos;

    /**
     * constructor without class parameters
     */

    public ListEntity() {
    }

    /**
     * Constructor class parameters
     * @param id id that takes the numeric control of the list
     * @param name name of list
     */
    public ListEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * get the id
     * @return id of the list
     */
    public Long getId() {
        return id;
    }

    /**
     * change the id
     * @param id id of the list
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get the name
     * @return name the list
     */
    public String getName() {
        return name;
    }

    /**
     * change the name
     * @param name name of the list
     */
    public void setName(String name) {
        this.name = name;
    }
}