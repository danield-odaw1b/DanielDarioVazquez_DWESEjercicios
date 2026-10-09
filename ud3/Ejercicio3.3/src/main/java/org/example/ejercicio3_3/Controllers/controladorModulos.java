package org.example.ejercicio3_3.Controllers;

import org.example.ejercicio3_3.Model.Modulo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class controladorModulos {
    private List<Modulo> lista = new ArrayList<>();

    public controladorModulos(){
        inicializarModulo();
    }

    @GetMapping("/index")
    public String mostrarModulos(@RequestParam(required = false)Integer curso, Model model){
        model.addAttribute("lista", lista);
        return "index";
    }

    private List<Modulo> filtrarModulo(Integer curso){
        return lista.stream().filter(x -> curso  == x.getCurso())
                .collect(Collectors.toList());
    }

    private void inicializarModulo(){
        lista.add(new Modulo(1, "Bases de datos",20,1));
        lista.add(new Modulo(2, "Programación",35,1));
        lista.add(new Modulo(3, "Sostenibilidad",2,1));
        lista.add(new Modulo(4, "Plástica",1,2));
        lista.add(new Modulo(5, "Contornos de desarrollo",3,2));
        lista.add(new Modulo(6, "Sistemas informáticos",24,2));
    }

}