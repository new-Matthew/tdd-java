package com.example.projeto_tdd.model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import model.Produto;

@SpringBootTest
public class ProdutoTest {

    @Test
    public void deve_calcular_valor_total_produto() {
        // Arrange:
        Produto produto = new Produto();
        produto.setQuantidade(2);
        produto.setAcrescimo(1.0);
        produto.setDesconto(2.0);
        produto.setValor(100.0);

        double resultadoEsperado = 199;

        // Act:

        Double resultado = produto.calcularValorTotal();
        
        // Assert:

        Assertions.assertEquals(resultadoEsperado, resultado);
    }
}

