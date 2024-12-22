package com.example.projeto_tdd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjetoTddApplicationTests {

	@Test
	void contextLoads() {


	}
}

/**
 * 
 * Criar uma api de vendas
 * venda > 1000.00 == 15%
 * venda <= 1000.00 == 10%
 * 
 * classe comissão q tenha método calcular() q retorna o valor da comissão do tipo Double
 */