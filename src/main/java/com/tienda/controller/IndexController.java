
package com.tienda.controller;

import com.tienda.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @Autowired //El objeto se crea en menoria si no existe y si existe se usa este 
    private ArticuloService articuloService;
    
    @GetMapping("/")
    public String inicio(Model model){
                
        var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos",articulos);
        
        return "index";
    }
    
}
