package com.example.categoriaProdutos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produtos")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_produto", length = 100, nullable = false)
    private String nomeProduto;

    @Column(name = "cor_produto", length = 35, nullable = false)
    private String corProduto;

    @Column(name = "marca_produto", length = 50, nullable = false)
    private String marcaProduto;

    @Column(name = "valor_produto", length = 200, nullable = false)
    private BigDecimal valorProduto;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private CategoriaModel categoriaModel;
}
