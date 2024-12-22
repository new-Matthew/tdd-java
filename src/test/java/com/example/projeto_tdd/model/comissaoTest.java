package com.example.projeto_tdd.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import model.Comissao;

@SpringBootTest
public class comissaoTest {

    @TestConfiguration
    static class ComissaoConfiguracao {

        @Bean // 
        public Comissao comissao(){
            return new Comissao();
        }

    }
    // pediar emprestado ao spring o objeto de config que está em seu controle
    @Autowired
    Comissao comissao;

    @Test
    public void deve_calcular_150_reais_De_comissao_para_venda_de_1000_reais(){
        // Arrange
        Double valorVenda = 1000.00;
        Double valorComissao = 150.0;

        // Act
        Double valorCalculado = comissao.calcular(valorVenda);
        
        // Assert
        Assertions.assertEquals(valorComissao, valorCalculado);

    };

    @Test
    public void deve_calcular_150_reais_De_comissao_para_venda_de_2000_reais(){
        // Arrange
        Double valorVenda = 2000.00;
        Double valorComissao = 300.0;

        // Act
        Double valorCalculado = comissao.calcular(valorVenda);
        
        // Assert
        Assertions.assertEquals(valorComissao, valorCalculado);

    };

}

