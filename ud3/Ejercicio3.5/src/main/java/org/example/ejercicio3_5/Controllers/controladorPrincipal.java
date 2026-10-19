package org.example.ejercicio3_5.Controllers;

import org.example.ejercicio3_5.Modelo.Inscripcion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class controladorPrincipal {
    List<Inscripcion> lista = new ArrayList<>();

    public controladorPrincipal(){}

    @GetMapping("/menu")
    public String mostrarMenu(){
        return "menu";
    }

    @GetMapping("/inscripciones")
    public String mostrarListado(Model model){
        model.addAttribute("listado", lista);
        return "inscripciones";
    }

    @GetMapping("/inscripciones/nueva")
    public String mostrarNueva(){
        return "nueva";
    }

    @PostMapping("/inscripciones")
    public String agregarInsripcion(String nombre, String email, Boolean turno, String texto, Boolean normas) {
        int newId = 0;
        if(!lista.isEmpty()){
            for(Inscripcion Ins : lista){
                newId++;
            }
            newId += 1;
        }
        Inscripcion newIns = new Inscripcion(newId, nombre, email, turno, texto, normas);
        lista.add(newIns);

        return "redirect:/inscripciones";
    }
}