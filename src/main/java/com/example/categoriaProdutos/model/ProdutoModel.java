package com.example.categoriaProdutos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produtos")
//@Validated
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_produto", length = 100, nullable = false)
   // @NotBlank(message = "Erro, nome do produto não informado")
    private String nomeProduto;

    @Column(name = "cor_produto", length = 35, nullable = false)
    //@NotBlank(message = "Erro, cor do produto não informada")
    private String corProduto;

    @Column(name = "marca_produto", length = 50, nullable = false)
   // @NotBlank(message = "Erro, marca do produto não informada")
    private String marcaProduto;

    @Column(name = "valor_produto", length = 200, nullable = false)
    //@NotBlank(message = "Erro, informe o valor do produto")
    private BigDecimal valorProduto;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private CategoriaModel categoriaModel;
}
