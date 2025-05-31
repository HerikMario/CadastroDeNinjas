package dev.java10x.CadastroNinja.Missoes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroNinja.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "tb_cadastro_de_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dificuldade")
    private String dificuldade;

    //Uma missão pode conter vários ninjas
    @OneToMany(mappedBy = "missao")
    @JsonIgnore
    private List<NinjaModel> ninjasResponsaveis;

}
