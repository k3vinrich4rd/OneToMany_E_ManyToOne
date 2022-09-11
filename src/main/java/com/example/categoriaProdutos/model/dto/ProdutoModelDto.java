package com.example.categoriaProdutos.model.dto;

import com.example.categoriaProdutos.model.ProdutoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoModelDto {
    private Long id;
    private String nomeProduto;
    private String corProduto;
    private String marcaProduto;

    public ProdutoModelDto(ProdutoModel obj) {
        this.id = obj.getId();
        this.nomeProduto = obj.getNomeProduto();
        this.corProduto = obj.getCorProduto();
        this.marcaProduto = obj.getMarcaProduto();
    }
}
