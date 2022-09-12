package com.example.categoriaProdutos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categorias")
@Validated
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_categoria", length = 70, nullable = false)
    @NotBlank(message = "Erro, informe a categoria")
    private String nomeCategoria;

    @Column(name = "descricao_categoria", length = 100, nullable = false)
    @NotBlank(message = "Erro, informe a descrição da categoria")
    private String descricaoCategoria;

    @JsonIgnore
    @OneToMany(mappedBy = "categoriaModel", cascade = CascadeType.ALL)
    private List<CategoriaModel> categoriaModel = new ArrayList<>();


}
