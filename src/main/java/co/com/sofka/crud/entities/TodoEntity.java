package co.com.sofka.crud.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *  Class that models and creates a ToDo entity
 * @autor Steveen Rodríguez
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TodoEntity {
    /**
     * Class id attribute
     * @strategy: automatically generates the Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //permite generar automáticamente el ID
    private Long id;

    /**
     * Class name attribute
     * @unique: Create a constraint the table so that value of that column is unique
     * @nullable: Create constraint on table to prevent null values from being inserted
     */
    @Column(nullable = false, unique = true)
    private String name;
    /**
     * Class completion attribute
     * @nullable: Create constraint on table to prevent null values from being inserted
     */
    @Column(nullable = false)
    private boolean completed;
    /**
     * Class list attribute
     * @ManuyToOne: Many ToDos for a list (associated entities)
     * @fetch: returns all available information
     * @JoinColumn: Bind the ToDos entity to a list using its id
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_list")
    private ListEntity list;
}