package co.com.sofka.crud.repository;

import co.com.sofka.crud.entities.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//interface que proporciona funciones CRUD (PagingAndSortingRepository )
@Repository
public interface ListRepository extends JpaRepository<ListEntity, Long> {

}
