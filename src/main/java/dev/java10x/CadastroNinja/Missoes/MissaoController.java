package dev.java10x.CadastroNinja.Missoes;

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
    public MissaoModel criarMissao(@RequestBody MissaoModel missao) {
        return missaoService.criarMissao(missao);
    }

    @GetMapping("/listar")
    public List<MissaoModel> listarMissoes() {
        return missaoService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissaoModel listarMissaoPorId(@PathVariable Long id) {
        return missaoService.listarMissaoPorId(id);
    }

    @PutMapping("/alterar/{id}")
    public MissaoModel alterarMissao(@PathVariable Long id, @RequestBody MissaoModel missaoAtualizada) {
        return missaoService.alterarMissao(id, missaoAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id) {
        missaoService.deletarMissao(id);
    }

}
