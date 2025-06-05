package dev.java10x.CadastroNinja.Missoes.Controller;

import dev.java10x.CadastroNinja.Missoes.DTO.MissaoCreateDTO;
import dev.java10x.CadastroNinja.Missoes.DTO.MissaoDTO;
import dev.java10x.CadastroNinja.Missoes.Service.MissaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissaoController {

    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissaoCreateDTO missao) {
        System.out.println("DEBUG - Recebido no Controller: " + missao);
        MissaoDTO missaoCriada = missaoService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("A missao " + missaoCriada.getNome() + " foi criada no banco de dados com o Id " + missaoCriada.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissaoDTO>> listarMissoes() {
        List<MissaoDTO> missoes = missaoService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissaoPorId(@PathVariable Long id) {
        MissaoDTO missao = missaoService.listarMissaoPorId(id);
        if (missao != null) {
            return ResponseEntity.ok(missao);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missao com o id " + id + " não encontrada");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissaoDTO missaoAtualizada) {
        MissaoDTO missao = missaoService.alterarMissao(id, missaoAtualizada);
        if (missao != null) {
            return ResponseEntity.ok(missao);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missão não encontrada, impossível alterar...");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {
        boolean exists = missaoService.existsById(id);
        if (exists) {
            missaoService.deletarMissao(id);
            return ResponseEntity.ok("Missao deletada com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missao não encontrada...");
    }

}
