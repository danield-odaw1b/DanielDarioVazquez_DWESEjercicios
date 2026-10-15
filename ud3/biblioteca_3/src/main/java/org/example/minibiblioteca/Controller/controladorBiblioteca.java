package org.example.minibiblioteca.Controller;

import org.example.minibiblioteca.Model.Libro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class controladorBiblioteca {

    private List<Libro> lista = new ArrayList<>();

    public controladorBiblioteca(){inicializarBiblioteca();}

    @GetMapping("/listado")
    public String mostrarListado (Model model, @RequestParam(required = false) Boolean prestado){
        model.addAttribute("biblioteca", filtrarLibros(prestado));
        return "listado";
    }

    @GetMapping("/listado/{id}")
    public String mostrarDetalles (@PathVariable Long id, Model model){
        model.addAttribute("libros",lista);
        return "detalles";
    }

    private List<Libro> filtrarLibros(Boolean prestado){
        return lista.stream()
                .filter(x -> prestado  == x.isPrestado() || prestado == null)
                .collect(Collectors.toList());
    }

    @PostMapping("/listado/toggle/{id}")
    public String cambiarEstado(@PathVariable int id){
        for (int i = 0; i < lista.size(); i++){
            if(lista.get(i).getId() == id){
                Libro l1 = lista.get(i);
                l1.setPrestado(!l1.isPrestado());
                lista.set(i, l1);
                return "redirect:/listado";
            }
        }
        return "redirect:/listado";
    }

    private void inicializarBiblioteca(){
        lista.add(new Libro(0,"el gato con botas","Héctor Pallas",1300,true));
        lista.add(new Libro(1,"Pulgarcito","Iria Sánchez",30,false));
        lista.add(new Libro(2,"Mortadelo y Filemón","Franco Ismael Raguza",1990,true));
        lista.add(new Libro(3,"El hombre invisible","Allen Rivas",881,false));
        lista.add(new Libro(4,"Los juegos de Ender","Julio López",423,false));
    }
}
