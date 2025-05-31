package dev.java10x.CadastroNinja.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissaoMapper {

    public MissaoDTO map(MissaoModel missaoModel) {
        return new MissaoDTO(
                missaoModel.getId(),
                missaoModel.getNome(),
                missaoModel.getDificuldade(),
                missaoModel.getNinjasResponsaveis()
        );
    }

    public MissaoModel map(MissaoDTO missaoDTO) {
        return new MissaoModel(
                missaoDTO.getId(),
                missaoDTO.getNome(),
                missaoDTO.getDificuldade(),
                missaoDTO.getNinjasResponsaveis()
        );
    }
}
