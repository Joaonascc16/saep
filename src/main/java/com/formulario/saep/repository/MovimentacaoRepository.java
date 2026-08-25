package com.formulario.saep.repository;

import com.formulario.saep.entity.MovimentacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<MovimentacaoEntity, Long> {
}