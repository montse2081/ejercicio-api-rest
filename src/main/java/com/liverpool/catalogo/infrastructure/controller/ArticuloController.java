package com.liverpool.catalogo.infrastructure.controller;

import com.liverpool.catalogo.domain.model.Articulo;
import com.liverpool.catalogo.domain.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/catalogo")
public class ArticuloController {

    @Autowired
    private ArticuloRepository articuloRepository;

    @GetMapping(path = "/articulos")
    public ResponseEntity<Object> getAllArticles() {
        List<Articulo> articulos = articuloRepository.findAll();
        return articulos.size() > 0 ?
                new ResponseEntity<>(articulos, OK) : new ResponseEntity<>(NOT_FOUND);
    }

    @GetMapping(path = "/articulos/{id}")
    public ResponseEntity<Object> getArticleById(@PathVariable(value = "id") String id) {
        Optional<Articulo> articulo = articuloRepository.findById(id);
        return articulo.isPresent() ?
                new ResponseEntity<>(articulo, OK) : new ResponseEntity<>(NOT_FOUND);
    }

    @PutMapping(path = "/articulos/{id}")
    public Articulo updateArticulo(@PathVariable(value = "id") String id, @Valid @RequestBody
            Articulo articulo) {
        return articuloRepository.findById(id).map(articulo1 -> {
            articulo1.setDescripcion(articulo.getDescripcion());
            articulo1.setModelo(articulo.getModelo());
            return articuloRepository.save(articulo1);
        }).orElseGet(() -> {
            articulo.setId(id);
            return articuloRepository.save(articulo);
        });
    }

}
