package co.com.sofka.crud.service;

import co.com.sofka.crud.entities.ListEntity;
import co.com.sofka.crud.repository.IListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

/**
 * list services class
 * @author Steveen Rodriguez
 */
@Service
public class ListService {
    /**
     * injection of the IsListRepository interface
     */
    @Autowired
    IListRepository listRepository;

    /**
     * Method to get all lists
     * @return ArrayList of ListEntity
     */
    public ArrayList<ListEntity> getAllList(){
        return (ArrayList<ListEntity>) listRepository.findAll();
    }

    /**
     * Method to save lists
     * @param list
     * @return listRepository.save
     */
    public ListEntity saveList(ListEntity list){
        return listRepository.save(list);
    }

    /**
     * Method to get lists by id
     * @param id
     * @return listRepository.findById
     */
    public Optional<ListEntity> getListById(Long id){
        return listRepository.findById(id);
    }

    /**
     * Method to delete lists by id
     * @param id
     */
    public void deleteListById(Long id){
        Optional<ListEntity> currentList = listRepository.findById(id); // se comporta como wraper evitamos que el método nos devuelva null
        if(currentList.isPresent()){
            ListEntity _currentlist = currentList.get();
            listRepository.delete(_currentlist);
        }else {
            throw new RuntimeException("No existe lista para borrar");
        }
    }

    /**
     * Method to update list by id
     * @param id
     * @param list
     * @return listRepository.save
     */
    public ListEntity updateList(Long id, ListEntity list){
        Optional<ListEntity> currentList = listRepository.findById(id);
        if(currentList.isPresent()){
            ListEntity _list = currentList.get();
            _list.setName(list.getName());
            return listRepository.save(_list);
        }
        throw new RuntimeException("No existe lista para actualizar");
    }
}