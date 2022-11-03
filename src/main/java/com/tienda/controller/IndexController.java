
package com.tienda.controller;

import com.tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
//import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @Autowired //El objeto se crea en menoria si no existe y si existe se usa este 
    private ClienteService clienteService;
    
    @GetMapping("/")
    public String inicio(Model model){
        
        var texto="Estamos en semana 4";
        model.addAttribute("mensaje",texto);
        
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes",clientes);
        
        return "index";
    }
    
}
