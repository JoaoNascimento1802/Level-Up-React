package com.example.consolesAPI.controllers;

import com.example.consolesAPI.dto.ConsolesDTO;
import com.example.consolesAPI.entities.Consoles;
import com.example.consolesAPI.repositories.ConsolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lista")
public class ListaController {


    @Autowired
    ConsolesRepository consolesRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Consoles>> buscar() {
        List<Consoles> lista = consolesRepository.findAll();
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(lista);
        } else {
            return ResponseEntity.ok(lista);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<String> createConsole(@RequestBody ConsolesDTO dados) {
        Consoles newConsole = new Consoles(dados);
        consolesRepository.save(newConsole);
        return ResponseEntity.status(HttpStatus.CREATED).body("Console cadastrado com sucesso!");
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateConsole(@PathVariable Long id, @RequestBody ConsolesDTO dados) {
        Optional<Consoles> existingConsoles = consolesRepository.findById(id);

        if (existingConsoles.isPresent()) {
            Consoles update = existingConsoles.get();
            update.setNome(dados.nome());
            update.setAno(dados.ano());
            update.setDescricao(dados.descricao());
            update.setFavoritar(dados.favoritar());
            update.setUrlImg(dados.urlImg());

            consolesRepository.save(update);

            return ResponseEntity.ok("Atualizado com sucesso !");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
    }

    @DeleteMapping("/dell/{id}")
    public ResponseEntity<?> dellConsole(@PathVariable Long id) {
        Optional<Consoles> existingConsoles = consolesRepository.findById(id);

        if (existingConsoles.isPresent()) {
            consolesRepository.deleteById(id);
            return ResponseEntity.ok("Usuário deletado com sucesso");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado para o ID fornecido: " + id);
        }
    }
}





