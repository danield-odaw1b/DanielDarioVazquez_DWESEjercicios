package org.example.minibiblioteca.Repository;

import org.example.minibiblioteca.Model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Repositorio {
    private List<Libro> lista = new ArrayList<>();
    private long ultimoId = 0;

    public List<Libro> findAll(){ return lista; }




}
