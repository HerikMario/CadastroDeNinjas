package dev.java10x.CadastroNinja.Missoes;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    private MissaoRepository missaoRepository;
    private MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    public MissaoDTO criarMissao(MissaoDTO missao) {
        return missaoMapper.map(missaoRepository.save(missaoMapper.map(missao)));
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
        return missaoMapper.map(missaoPorId.orElse(null));
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

}
