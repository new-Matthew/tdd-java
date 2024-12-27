package com.example.projeto_tdd.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.projeto_tdd.model.Produto;
import com.example.projeto_tdd.service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(controllers = ProdutoController.class)
public class ProdutoControllerTest {

    @Autowired
    private ProdutoController productController;

    @MockBean
    private ProdutoService produtoService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void deve_retornar_status_200_OK_ao_chamar_o_metodo_obter_todos() throws Exception {
        // Arrange
        // preparou a requisição, preencheu o json, para enviar
        List<Produto> produtos = new ArrayList<Produto>();
        var requestBuilder = MockMvcRequestBuilders.get("/api/produtos");

        when(this.produtoService.obterTodos()).thenReturn(produtos);
        // Act & Assert
        // enviou a requestBuilder
        this.mockMvc.perform(requestBuilder)
        // retorno da requisição é o andExpect
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deve_retornar_produto_por_id() throws Exception {
        // Arrange
        // prepara a requisição(mocka), preencheu o json, para enviar
        Produto produto = new Produto();
        produto.setId(1l); // p dizer q é long faz o l
        produto.setNome("Martelo");
        produto.setQuantidade(10);

        Optional<Produto> optProduto = Optional.of(produto);

        var requestBuilder = MockMvcRequestBuilders.get("/api/produtos/2");

        when(this.produtoService.obterPorId(2l)).thenReturn(optProduto);
        // Act & Assert
        // enviou a requestBuilder
        this.mockMvc.perform(requestBuilder)
        // retorno da requisição é o andExpect
        // comparar o q tiver no value com 2
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1l));
    }

    @Test
    public void deve_adicionar_produto() throws Exception {
        // Arrange
        // prepara a requisição(mocka), preencheu o json, para enviar
        Produto produto = new Produto();
        // criando o produto que será add
        produto.setNome("Martelo");
        produto.setQuantidade(10);

        // converte o produto e transforma em um json
        String json = new ObjectMapper().writeValueAsString(produto);

        // cria a request post
        var requestBuilder = MockMvcRequestBuilders.post("/api/produtos")
        .content(json)
        .contentType(MediaType.APPLICATION_JSON);

        // add o id ao produto que irá ser retornado
        produto.setId(1l);
        when(this.produtoService.adicionar(produto)).thenReturn(produto);
        // Act & Assert
        // enviou a requestBuilder
        this.mockMvc.perform(requestBuilder)
        // retorno da requisição é o andExpect
        // comparar o q tiver no value com 2
        .andExpect(MockMvcResultMatchers.status().isCreated());
    }

}
