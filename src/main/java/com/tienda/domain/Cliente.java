
package com.tienda.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
    
    /*Se agrega esto cuando se tiene una entidad autoincrementoria en la BD*/
    private static final long serialVersionUID = 1L;
    
    /*Esto es para decirle que es una llave primaria*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//IDENTITY es para delegarle el autoincremental a la BD
    private Long idCliente; //idCliente = id_Cliente
                //NOMBRE EN //  JAVA    =    BD
                /*  EJEMPLOS:
                             idCategoriaArticulo   = JAVA
                             id_categoria_articulo = BD
                */

    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    
    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }
    
}
