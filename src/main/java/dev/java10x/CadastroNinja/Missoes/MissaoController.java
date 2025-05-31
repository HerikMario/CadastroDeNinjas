package dev.java10x.CadastroNinja.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissaoController {

    @PostMapping("/criar")
    public String criarMissao() {
        return "Missao criada";
    }

    @GetMapping("/listar")
    public String listarMissoes() {
        return "Missoes listadas";
    }

    @GetMapping("/listarId")
    public String listarMissaoPorId() {
        return "Missao listada por id";
    }

    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missao alterada";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Missao deletada";
    }

}
