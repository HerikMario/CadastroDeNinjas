package dev.java10x.CadastroNinja.Missoes.Service;

import dev.java10x.CadastroNinja.Exception.NinjaNotFoundException;
import dev.java10x.CadastroNinja.Missoes.DTO.MissaoCreateDTO;
import dev.java10x.CadastroNinja.Missoes.DTO.MissaoDTO;
import dev.java10x.CadastroNinja.Missoes.Mapper.MissaoMapper;
import dev.java10x.CadastroNinja.Missoes.Model.MissaoModel;
import dev.java10x.CadastroNinja.Missoes.Repository.MissaoRepository;
import dev.java10x.CadastroNinja.Ninjas.NinjaModel;
import dev.java10x.CadastroNinja.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    private MissaoRepository missaoRepository;
    private MissaoMapper missaoMapper;
    private NinjaRepository ninjaRepository;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper, NinjaRepository ninjaRepository) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
        this.ninjaRepository = ninjaRepository;
    }

    public MissaoDTO criarMissao(MissaoCreateDTO missao) {
        List<NinjaModel> ninjaModels = new ArrayList<>();
        for (Long id: missao.getNinjasResponsaveis()) {
            System.out.println("DEBUG - Buscando Ninja ID: " + id);
            NinjaModel ninjaModel = ninjaRepository.findById(id)
                    .orElseThrow(() -> new NinjaNotFoundException(id));
            ninjaModels.add(ninjaModel);
        }
        MissaoModel missaoModel = new MissaoModel(missao.getId(),missao.getNome(),missao.getDificuldade(),ninjaModels);
        for (NinjaModel ninjaModel: ninjaModels) {
            ninjaModel.setMissao(missaoModel);
        }
        return missaoMapper.map(missaoRepository.save(missaoModel));
    }

    public List<MissaoDTO> listarMissoes() {
        List<MissaoDTO> missoesDTO = new ArrayList<>();
        List<MissaoModel> missoesModel = missaoRepository.findAll();
        for(MissaoModel missaoModel : missoesModel) {
            missoesDTO.add(missaoMapper.map(missaoModel));
        }
        return missoesDTO;
    }

    public MissaoDTO listarMissaoPorId(Long id) {
        Optional<MissaoModel> missaoPorId = missaoRepository.findById(id);
        if (missaoPorId.isPresent()) {
            return missaoMapper.map(missaoPorId.get());
        }
        return null;
    }

    public MissaoDTO alterarMissao(Long id, MissaoDTO missaoAlterada) {
        Optional<MissaoModel> missaoExistente = missaoRepository.findById(id);
        if (missaoExistente.isPresent()) {
            missaoAlterada.setId(id);
            return missaoMapper.map(missaoRepository.save(missaoMapper.map(missaoAlterada)));
        }
        return null;
    }

    public void deletarMissao(Long id) {
        missaoRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return missaoRepository.existsById(id);
    }

}
