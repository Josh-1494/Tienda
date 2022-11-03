package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    //Se definen los 4 metodos de un CRUD
    // Read / Create / Update / Delete
    
    //Retorna la lista de categorias
    //  / READ /  *********************
    public List<Categoria> getCategorias(boolean activos);
    
    //Dado un categoria.id se busca en la tabla y 
    //se retorna todo el objeto Categoria
    //  / READ /  *********************
    public Categoria getCategoria(Categoria categoria);
    
    //Si el categoria.id tien un calor se busca y se actualiza
    //si el categoria.id NO tiene valor, se inserta el objeto en la tabla
    //  / CREATE / UPDATE / **********************
    public void save(Categoria categoria);
    
    //Elimina el registro que tiene el id igual a categoria.id
    //  / DELETE /  *********************
    public void delete(Categoria categoria);
    
}
