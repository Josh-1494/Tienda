/*dao = Data Access Object*/
package com.tienda.dao;

import com.tienda.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

                                    /*Nombre de la CLASE y el tipo de DATO de la LLAVE PRIMARIA*/
public interface CategoriaDao extends JpaRepository<Categoria,Long>{
    
}
