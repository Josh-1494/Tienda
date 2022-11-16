/*dao = Data Access Object*/
package com.tienda.dao;

import com.tienda.domain.Articulo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

                                    /*Nombre de la CLASE y el tipo de DATO de la LLAVE PRIMARIA*/
public interface ArticuloDao extends JpaRepository<Articulo,Long>{
    
    public List<Articulo> findByDescripcion(String descripcion);
}
