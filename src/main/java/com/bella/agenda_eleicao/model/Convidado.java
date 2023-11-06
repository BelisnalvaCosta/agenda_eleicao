package com.bella.agenda_eleicao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Convidado {

    @Id
    private int codigo_candidato;
    private String nome_candidato;
    private String partido;

    @ManyToOne
    private AgendaEleicao agendaEleicao;

    public int getCodigo_candidato() {
        return codigo_candidato;
    }

    public void setCodigo_candidato(int codigo_candidato) {
        this.codigo_candidato = codigo_candidato;
    }

    public String getNome_candidato() {
        return nome_candidato;
    }

    public void setNome_candidato(String nome_candidato) {
        this.nome_candidato = nome_candidato;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public AgendaEleicao getAgendaEleicao(){
        return agendaEleicao;
    }

    public void setAgendaEleicao(AgendaEleicao agendaEleicao) {
        this.agendaEleicao = agendaEleicao;
    }
}
