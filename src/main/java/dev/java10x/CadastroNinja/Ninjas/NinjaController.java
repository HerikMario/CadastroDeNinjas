package dev.java10x.CadastroNinja.Ninjas;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // CRUD --> CREATE, READ, UPDATE E DELETE

    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    // Procurar ninja por ID (READ)
    @GetMapping("/ninjaId")
    public String mostrarNinjaPorId() {
        return "Mostrar ninja por id";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas() {
        return "Mostrar todos os ninjas";
    }

    // Alterar dados do ninja (UPDATE)
    @PutMapping("/alterarId")
    public String alterarNinjaPorId() {
        return "Ninja alterado por id";
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/deletarId")
    public String deletarNinjaPorId() {
        return "Ninja deletado por id";
    }

}
