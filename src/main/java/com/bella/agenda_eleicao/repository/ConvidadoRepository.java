package com.bella.agenda_eleicao.repository;

import com.bella.agenda_eleicao.model.AgendaEleicao;
import com.bella.agenda_eleicao.model.Convidado;
import org.springframework.data.repository.CrudRepository;

public interface ConvidadoRepository extends CrudRepository<Convidado, String> {
    Iterable<Convidado> findByAgendaEleicao(AgendaEleicao agendaEleicao);
    Convidado findByCodigo(String codigo);
}
