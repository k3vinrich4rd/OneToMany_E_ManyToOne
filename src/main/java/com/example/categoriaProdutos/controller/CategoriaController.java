package com.example.categoriaProdutos.controller;

import com.example.categoriaProdutos.model.CategoriaModel;
import com.example.categoriaProdutos.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaModel> cadastrarCategoria(@RequestBody CategoriaModel categoriaModel) {
        CategoriaModel categoria = categoriaService.cadastrarNovaCategoria(categoriaModel);
        return new ResponseEntity<>(categoria, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> exibirCategorias(CategoriaModel categoriaModel) {
        return ResponseEntity.ok(categoriaService.exibirCategoria());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<CategoriaModel>> mostrarViaId(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.exibirCategoraViaId(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CategoriaModel> atualizarCategoria(@RequestBody CategoriaModel categoriaModel) {
        return ResponseEntity.ok(categoriaService.atualizarCategoria(categoriaModel));
    }

    @DeleteMapping(path = "/{id}")
    public void deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
    }

    //Query (anotação)
    @GetMapping(path = "/find-all")
    public ResponseEntity<List<CategoriaModel>> exibirTodasAsCategorias(){
        return ResponseEntity.ok(categoriaService.getTodasAsCategorias());
    }


}
