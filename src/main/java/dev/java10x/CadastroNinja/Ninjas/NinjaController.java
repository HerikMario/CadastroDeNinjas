package dev.java10x.CadastroNinja.Ninjas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
       NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
       return ResponseEntity.status(HttpStatus.CREATED)
               .body("Ninja criado com sucesso: " + ninjaDTO.getNome() + " (ID): " + ninjaDTO.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id) {

        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);

        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id " + id + " não existe nos nossos registros...");
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.alterarNinja(id, ninjaAtualizado);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com id " + id + " não encontrado...");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id) {
        boolean exists = ninjaService.existsById(id);

        if (exists) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok(("Ninja com ID " + id + " deletado com sucesso"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não foi encontrado!");
        }
    }

}
