package com.example.projeto_tdd.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import controller.ProdutoController;

@WebMvcTest(controllers = ProdutoController.class)
public class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deve_retornar_status_200_OK_ao_chamar_o_metodo_obter_todos() throws Exception {
        // Arrange
        var requestBuilder = MockMvcRequestBuilders.get("/api/produtos");

        // Act & Assert
        this.mockMvc.perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
