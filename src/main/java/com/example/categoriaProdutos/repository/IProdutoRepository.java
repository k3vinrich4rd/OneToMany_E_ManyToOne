package com.example.categoriaProdutos.repository;

import com.example.categoriaProdutos.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProdutoRepository extends JpaRepository<ProdutoModel, Long> {

    @Query("select p from ProdutoModel p")
    public List<ProdutoModel> getProdutos();
}
