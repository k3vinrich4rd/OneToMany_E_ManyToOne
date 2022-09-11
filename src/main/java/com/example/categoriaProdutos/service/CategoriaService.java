package com.example.categoriaProdutos.service;

import com.example.categoriaProdutos.model.CategoriaModel;
import com.example.categoriaProdutos.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {


    @Autowired
    private ICategoriaRepository iCategoriaRepository;

    public CategoriaModel cadastrarNovaCategoria(CategoriaModel categoriaModel) {
        return iCategoriaRepository.save(categoriaModel);
    }

    public List<CategoriaModel> exibirCategoria() {
        return iCategoriaRepository.findAll();
    }

    public Optional<CategoriaModel> exibirCategoraViaId(Long id) {
        return iCategoriaRepository.findById(id);
    }

    public CategoriaModel atualizarCategoria(CategoriaModel categoriaModel) {
        return iCategoriaRepository.save(categoriaModel);
    }

    public void deletarCategoria(Long id) {
        iCategoriaRepository.deleteById(id);
    }

    //Query (anotação)
    public List<CategoriaModel> getTodasAsCategorias(){
        return iCategoriaRepository.getTodasAsCategorias();
    }
}

