package dev.java10x.CadastroNinja.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    // Injeção de dependência
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Adicionar um ninja
    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    // Listar todos os ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    // Listar ninja por Id
    public NinjaModel listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    // Atualizar ninja
    public NinjaModel alterarNinja(Long id, NinjaModel ninjaAtualizado) {
        if (ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }

    // Deletar ninja por Id - Tem que ser um VOID
    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
    }


}
