package co.com.sofka.crud.repository;

import co.com.sofka.crud.entities.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//interface que proporciona funciones CRUD (PagingAndSortingRepository )
@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}
