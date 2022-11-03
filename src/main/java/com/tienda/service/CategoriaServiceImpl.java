package com.tienda.service;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    //Se implementan los 4 metodos de un CRUD
    // Read / Create / Update / Delete  -- Mediante CategoriaDao
    
    //Se utiliza una anotacion Autowired para que el objeto categoriaDao
    //Si ya esta en memoria se use ese... sino se crea (Patron singleton)
    
    @Autowired  //Es un enlace automatico
    private CategoriaDao categoriaDao;
        
    
    //Retorna la lista de categorias
    //  / READ /  *********************
    @Override
    @Transactional(readOnly=true)
    public List<Categoria> getCategorias() {
        return (List<Categoria>)categoriaDao.findAll();
    }
    
    //Dado un categoria.id se busca en la tabla y 
    //se retorna todo el objeto Categoria
    //  / READ /  *********************
    @Override
    @Transactional(readOnly=true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }
    
    //Si el categoria.id tien un calor se busca y se actualiza
    //si el categoria.id NO tiene valor, se inserta el objeto en la tabla
    //  / CREATE / UPDATE / **********************
    @Override
    @Transactional
    public void save(Categoria categoria){
        categoriaDao.save(categoria);
    }
    
    //Elimina el registro que tiene el id igual a categoria.id
    //  / DELETE /  *********************
    @Override
    @Transactional
    public void delete(Categoria categoria){
        categoriaDao.delete(categoria);
    }
    
}
