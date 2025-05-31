package dev.java10x.CadastroNinja.Ninjas;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    // CRUD --> CREATE, READ, UPDATE E DELETE

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public String listarNinjas() {
        return "Ninjas listados";
    }

    // Procurar ninja por ID (READ)
    @GetMapping("/listarId")
    public String listarNinjaPorId() {
        return "Ninja listado por id";
    }

    // Alterar dados do ninja (UPDATE)
    @PutMapping("/alterar")
    public String alterarNinja() {
        return "Ninja alterado";
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/deletar")
    public String deletarNinja() {
        return "Ninja deletado";
    }

}
