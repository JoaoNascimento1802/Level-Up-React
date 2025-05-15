package com.example.consolesAPI.controllers;

import com.example.consolesAPI.dto.ConsolesDTO;
import com.example.consolesAPI.entities.Consoles;
import com.example.consolesAPI.repositories.ConsolesRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/console")
@Tag(name = "Consoles", description = "Endpoints relacionados aos consoles de videogame")
public class ConsoleController {

    @Autowired
    ConsolesRepository consolesRepository;

    @GetMapping("/all")
    @Operation(summary = "Listar todos os consoles")
    public ResponseEntity<List<Consoles>> buscar() {
        List<Consoles> lista = consolesRepository.findAll();
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(lista);
        } else {
            return ResponseEntity.ok(lista);
        }
    }

    @PostMapping("/new")
    @Operation(summary = "Cadastrar um novo console")
    public ResponseEntity<String> createConsole(@RequestBody ConsolesDTO dados) {
        Consoles newConsole = new Consoles(dados);
        consolesRepository.save(newConsole);
        return ResponseEntity.status(HttpStatus.CREATED).body("Console cadastrado com sucesso!");
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Editar um console pelo ID")
    public ResponseEntity<?> updateConsole(@PathVariable Long id, @RequestBody ConsolesDTO dados) {
        Optional<Consoles> existingConsoles = consolesRepository.findById(id);

        if (existingConsoles.isPresent()) {
            Consoles update = existingConsoles.get();
            update.setNome(dados.nome());
            update.setAno(dados.ano());
            update.setDescricao(dados.descricao());
            update.setAvaliacao(dados.avaliacao());
            update.setUrlImg(dados.urlImg());

            consolesRepository.save(update);
            return ResponseEntity.ok("Atualizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Console não encontrado");
        }
    }

    @DeleteMapping("/dell/{id}")
    @Operation(summary = "Deletar um console pelo ID")
    public ResponseEntity<?> dellConsole(@PathVariable Long id) {
        Optional<Consoles> existingConsoles = consolesRepository.findById(id);

        if (existingConsoles.isPresent()) {
            consolesRepository.deleteById(id);
            return ResponseEntity.ok("Console deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Console não encontrado para o ID fornecido: " + id);
        }
    }

    @PutMapping("/favorito/{id}")
    @Operation(summary = "Favoritar ou desfavoritar um console")
    public ResponseEntity<?> favoritarConsole(@PathVariable Long id, @RequestParam boolean favorito) {
        Optional<Consoles> consoleOpt = consolesRepository.findById(id);
        if (consoleOpt.isPresent()) {
            Consoles console = consoleOpt.get();
            console.setFavorito(favorito);
            consolesRepository.save(console);
            return ResponseEntity.ok("Console atualizado como favorito = " + favorito);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Console não encontrado");
        }
    }

    @GetMapping("/favoritos")
    @Operation(summary = "Listar apenas os consoles favoritos")
    public ResponseEntity<List<Consoles>> listarFavoritos() {
        List<Consoles> favoritos = consolesRepository.findByFavoritoTrue();
        return favoritos.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(favoritos)
                : ResponseEntity.ok(favoritos);
    }

}
