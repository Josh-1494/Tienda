
package com.tienda.controller;

import com.tienda.domain.Articulo;
import com.tienda.service.ArticuloService;
import com.tienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticuloController {
    
    @Autowired //El objeto se crea en menoria si no existe y si existe se usa este 
    private ArticuloService articuloService;
    
    @Autowired //El objeto se crea en menoria si no existe y si existe se usa este 
    private CategoriaService categoriaService;
    
    @GetMapping("/articulo/listado")
    public String inicio(Model model){
        
        
        var articulos = articuloService.getArticulos(false);
        model.addAttribute("articulos",articulos);
        
        return "/articulo/listado";
    }
    
    /*----------------------findByDescripcion-------------------------*/
    @GetMapping("/articulo/buscar/")
    public String buscarArticuloxdescripcion(String descripcion, Model model){
        var articulos = articuloService.getArticuloPorDescripcion(descripcion);
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias",categorias);
        model.addAttribute("articulo",articulos.get(0));
        return "/articulo/modificar";
    }    
    /*----------------------findByDescripcion-------------------------*/
    
    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo, Model model){
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias",categorias);
        return "/articulo/modificar";
    }
    
    @PostMapping("/articulo/guardar")
    public String guardarArticulo(Articulo articulo){
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }
    
    @GetMapping("/articulo/modificar/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model){
        articulo = articuloService.getArticulo(articulo);
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias",categorias);
        model.addAttribute("articulo",articulo);
        return "/articulo/modificar";
    }
    
    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo){
        articuloService.delete(articulo);
        return "redirect:/articulo/listado";
    }
    
}
