package dev.java10x.CadastroNinja.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO){
            return new NinjaModel(
                    ninjaDTO.getId(),
                    ninjaDTO.getNome(),
                    ninjaDTO.getEmail(),
                    ninjaDTO.getIdade(),
                    ninjaDTO.getRank(),
                    ninjaDTO.getMissao());
    }

    public NinjaDTO map(NinjaModel ninjaModel) {
        return new NinjaDTO(
                ninjaModel.getId(),
                ninjaModel.getNome(),
                ninjaModel.getEmail(),
                ninjaModel.getIdade(),
                ninjaModel.getMissao(),
                ninjaModel.getRank());
    }

}
