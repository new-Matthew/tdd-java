package com.example.projeto_tdd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto_tdd.model.Produto;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController { // receber alguma coisa e retornar algo
    @GetMapping
    public ResponseEntity<List<Produto>> obterTodos(){
        List<Produto> produtos = new ArrayList<Produto>();

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> obterPorId(@PathVariable Long id){
        Optional<Produto> produto = Optional.of(new Produto());

        return new ResponseEntity<>(produto, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Produto> adicionar(@RequestBody Produto produto) {
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

}
