package dev.java10x.CadastroNinja.Ninjas;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    // Injeção de dependência
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaRepository.save(ninjaMapper.map(ninjaDTO));
        return ninjaMapper.map(ninja);
    }

    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        List<NinjaDTO> ninjasDTO = new ArrayList<>();
        for (NinjaModel ninja : ninjas) {
            ninjasDTO.add(ninjaMapper.map(ninja));
        }
        return ninjasDTO;
    }

    public NinjaDTO listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        if (ninjaPorId.isPresent()){
            return ninjaMapper.map(ninjaPorId.get());
        }
        return null;
    }

    public NinjaDTO alterarNinja(Long id, NinjaDTO ninjaAtualizado) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()) {
            ninjaAtualizado.setId(id);
            return ninjaMapper.map(ninjaRepository.save(ninjaMapper.map(ninjaAtualizado)));
        }
        return null;
    }

    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return ninjaRepository.existsById(id);
    }


}
