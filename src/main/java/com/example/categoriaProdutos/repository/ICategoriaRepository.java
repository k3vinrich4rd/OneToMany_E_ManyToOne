package com.example.categoriaProdutos.repository;

import com.example.categoriaProdutos.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoriaRepository extends JpaRepository<CategoriaModel, Long> {
    @Query("select c from CategoriaModel c")
    public List<CategoriaModel> getTodasAsCategorias();
}
