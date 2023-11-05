package com.bella.agenda_eleicao.repository;

import com.bella.agenda_eleicao.model.AgendaEleicao;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface AgendaEleicaoRepository extends CrudRepository<AgendaEleicao, String>, JpaSpecificationExecutor<AgendaEleicao> {
    AgendaEleicao findByCodigo(long codigo);
}
