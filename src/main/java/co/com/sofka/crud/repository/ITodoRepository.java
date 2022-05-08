package co.com.sofka.crud.repository;

import co.com.sofka.crud.entities.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * interface that provides CRUD functions (PagingAndSortingRepository )
 * @author Steveen Rodriguez
 */
@Repository
public interface ITodoRepository extends JpaRepository<TodoEntity, Long> {
}
