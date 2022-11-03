package com.tienda.service;

import com.tienda.dao.ArticuloDao;
import com.tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService{
    //Se implementan los 4 metodos de un CRUD
    // Read / Create / Update / Delete  -- Mediante ArticuloDao
    
    //Se utiliza una anotacion Autowired para que el objeto articuloDao
    //Si ya esta en memoria se use ese... sino se crea (Patron singleton)
    
    @Autowired  //Es un enlace automatico
    private ArticuloDao articuloDao;
        
    
    //Retorna la lista de articulos
    //  / READ /  *********************
    @Override
    @Transactional(readOnly=true)
    public List<Articulo> getArticulos() {
        return (List<Articulo>)articuloDao.findAll();
    }
    
    //Dado un articulo.id se busca en la tabla y 
    //se retorna todo el objeto Articulo
    //  / READ /  *********************
    @Override
    @Transactional(readOnly=true)
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }
    
    //Si el articulo.id tien un calor se busca y se actualiza
    //si el articulo.id NO tiene valor, se inserta el objeto en la tabla
    //  / CREATE / UPDATE / **********************
    @Override
    @Transactional
    public void save(Articulo articulo){
        articuloDao.save(articulo);
    }
    
    //Elimina el registro que tiene el id igual a articulo.id
    //  / DELETE /  *********************
    @Override
    @Transactional
    public void delete(Articulo articulo){
        articuloDao.delete(articulo);
    }
    
}
