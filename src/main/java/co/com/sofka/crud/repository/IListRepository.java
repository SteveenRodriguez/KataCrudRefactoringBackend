package co.com.sofka.crud.repository;

import co.com.sofka.crud.entities.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * interface that provides CRUD functions (PagingAndSortingRepository )
 * @author Steveen Rodriguez
 */
@Repository
public interface IListRepository extends JpaRepository<ListEntity, Long> {

}
