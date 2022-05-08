package co.com.sofka.crud.service;

import co.com.sofka.crud.entities.ListEntity;
import co.com.sofka.crud.repository.IListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ListService {
    //inyectamos la interface ListRepository
    @Autowired
    IListRepository listRepository;

    //Metodo para obtener todas las listas
    public ArrayList<ListEntity> getAllList(){
        return (ArrayList<ListEntity>) listRepository.findAll();
    }

    //Metodo para guardar listas
    public ListEntity saveList(ListEntity list){
        return listRepository.save(list);
    }

    //Metodo para obtener listas por id
    public Optional<ListEntity> getListById(Long id){
        return listRepository.findById(id);
    }

    //Metodo para eliminar listas por id
    public void deleteListById(Long id){
        Optional<ListEntity> currentList = listRepository.findById(id); // se comporta como wraper evitamos que el método nos devuelva null
        if(currentList.isPresent()){
            ListEntity _currentlist = currentList.get();
            listRepository.delete(_currentlist);
        }else {
            throw new RuntimeException("No existe lista para borrar");
        }
    }

    //Metodo para actualizar lista por id
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