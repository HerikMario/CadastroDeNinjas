package dev.java10x.CadastroNinja.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    private MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    public MissaoModel criarMissao(MissaoModel missao) {
        return missaoRepository.save(missao);
    }

    public List<MissaoModel> listarMissoes() {
        return missaoRepository.findAll();
    }

    public MissaoModel listarMissaoPorId(Long id) {
        Optional<MissaoModel> missaoPorId = missaoRepository.findById(id);
        return missaoPorId.orElse(null);
    }

    public MissaoModel alterarMissao(Long id, MissaoModel missaoAlterada) {
        if (missaoRepository.existsById(id)) {
            missaoAlterada.setId(id);
            missaoRepository.save(missaoAlterada);
        }
        return null;
    }

    public void deletarMissao(Long id) {
        missaoRepository.deleteById(id);
    }

}
