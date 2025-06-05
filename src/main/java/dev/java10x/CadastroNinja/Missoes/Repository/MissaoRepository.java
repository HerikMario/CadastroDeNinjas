package dev.java10x.CadastroNinja.Missoes.Repository;

import dev.java10x.CadastroNinja.Missoes.Model.MissaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissaoRepository extends JpaRepository<MissaoModel, Long> {



}
