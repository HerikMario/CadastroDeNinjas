package dev.java10x.CadastroNinja.Missoes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissaoCreateDTO {

    private Long id;
    private String nome;
    private String dificuldade;
    private List<Long> ninjasResponsaveis;

}