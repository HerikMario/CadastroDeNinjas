package dev.java10x.CadastroNinja.Ninjas;

import dev.java10x.CadastroNinja.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_cadastro_de_ninjas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String nome;

    //Coluna será única (CPF, RG, Passaporte...)
    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "idade")
    private int idade;

    //Um ninja tem apenas uma missão
    @ManyToOne
    @JoinColumn(name = "missao_id") //foreing key ou chave estrangeira
    private MissaoModel missao;

}
