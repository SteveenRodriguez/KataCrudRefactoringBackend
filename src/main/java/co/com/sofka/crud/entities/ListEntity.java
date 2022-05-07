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


@Entity
public class ListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //genera ID automático
    private Long id;
    //no permite null y es única
    @Column(nullable = false, unique = true)
    private String name;

    //OneToMany: Una lista a muchos toDos
    //mappedBy: apunta a la entidad propietaria
    //cascade: cuando se aplican cambios se ve reflejado en todas las entidades asociadas
    //OrphanRemoval: remueve todos los toDos cuando no haya una lista padre
    //Fetch: cuando se actualiza la lista, se actualizan todos los todos y nos trae la información
    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL, orphanRemoval= true, fetch = FetchType.EAGER)
    private Set<TodoEntity> toDos; //Interface Set: nos indica que no se pueden repetir toDos

    //Constructores

    public ListEntity() {
    }

    public ListEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    //Getters y setter

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
}