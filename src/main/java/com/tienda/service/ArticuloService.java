package com.tienda.service;

import com.tienda.domain.Articulo;
import java.util.List;

public interface ArticuloService {
    //Se definen los 4 metodos de un CRUD
    // Read / Create / Update / Delete
    
    //Retorna la lista de articulos
    //  / READ /  *********************
    public List<Articulo> getArticulos(boolean activos);
    
    //Dado un articulo.id se busca en la tabla y 
    //se retorna todo el objeto Articulo
    //  / READ /  *********************
    public Articulo getArticulo(Articulo articulo);
    
    //Si el articulo.id tien un calor se busca y se actualiza
    //si el articulo.id NO tiene valor, se inserta el objeto en la tabla
    //  / CREATE / UPDATE / **********************
    public void save(Articulo articulo);
    
    //Elimina el registro que tiene el id igual a articulo.id
    //  / DELETE /  *********************
    public void delete(Articulo articulo);
    
}
