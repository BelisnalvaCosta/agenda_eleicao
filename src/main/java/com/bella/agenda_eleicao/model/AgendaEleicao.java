package com.bella.agenda_eleicao.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class AgendaEleicao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;

    private int codigo_candidato;
    private String nome_candidato;
    private String partido;
    private String local;
    private String data;
    private String horario;

    @OneToMany
    private List<Convidado> convidados;

    //Este modelo só usa o Getter e setter, (não usa o construtor)
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
