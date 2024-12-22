package com.example.projeto_tdd.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import model.Comissao;

@SpringBootTest
public class comissaoTest {

    @Test
    public void deve_calcular_10_reais_De_comissao_para_venda_de_1000_reais(){
        // Arrange
        Comissao comissao = new Comissao();
        Double valorVenda = 1000.00;
        Double valorComissao = 0.0;

        // Act
        Double valorCalculado = comissao.calcular(valorVenda);
        
        // Assert
        Assertions.assertEquals(valorComissao, valorCalculado);

    };
}

