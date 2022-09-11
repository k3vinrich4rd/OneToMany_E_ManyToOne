package com.example.categoriaProdutos.service;

import com.example.categoriaProdutos.model.ProdutoModel;
import com.example.categoriaProdutos.model.dto.ProdutoModelDto;
import com.example.categoriaProdutos.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {


    @Autowired
    private IProdutoRepository iProdutoRepository;

    public ProdutoModel cadastrarProduto(ProdutoModel produtoModel) {
        return iProdutoRepository.save(produtoModel);
    }

    public List<ProdutoModel> mostrarProdutos() {
        return iProdutoRepository.findAll();
    }

    public Optional<ProdutoModel> mostrarProdutoViaId(Long id) {
        return iProdutoRepository.findById(id);
    }

    public ProdutoModel atualizarProdutos(ProdutoModel produtoModel) {
        return iProdutoRepository.save(produtoModel);
    }

    public void deletarProduto(Long id) {
        iProdutoRepository.deleteById(id);
    }

    //Query (anotação)
    public List<ProdutoModel> getTodosOsProdutos(){
        return iProdutoRepository.getProdutos();
    }
}
