package com.example.categoriaProdutos.controller;

import com.example.categoriaProdutos.model.ProdutoModel;
import com.example.categoriaProdutos.model.dto.ProdutoModelDto;
import com.example.categoriaProdutos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoModel> cadastrarProduto(@RequestBody ProdutoModel produtoModel) {
        ProdutoModel produtos = produtoService.cadastrarProduto(produtoModel);
        return new ResponseEntity<>(produtos, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> mostrarProdutosCadastrados() {
        return ResponseEntity.ok(produtoService.mostrarProdutos());
    }

    @GetMapping(path = "/dto")
    public ResponseEntity<List<ProdutoModelDto>> mostrarProdutosDto() {
        List<ProdutoModel> list = produtoService.mostrarProdutos();
        List<ProdutoModelDto> produtoModelDtoList = list.stream().map(obj -> new ProdutoModelDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(produtoModelDtoList);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<ProdutoModel>> mostrarProdutoViaId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.mostrarProdutoViaId(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProdutoModel> atualizarProdutos(@RequestBody ProdutoModel produtoModel) {
        return ResponseEntity.ok(produtoService.atualizarProdutos(produtoModel));
    }

    @DeleteMapping(path = "/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }

    //Query (anotação)
    @GetMapping(path = "/find-all")
    public ResponseEntity<List<ProdutoModel>> getTodosProdutos(){
        return ResponseEntity.ok(produtoService.getTodosOsProdutos());
    }


}
