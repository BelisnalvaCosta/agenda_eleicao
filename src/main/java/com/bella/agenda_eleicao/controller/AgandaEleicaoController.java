package com.bella.agenda_eleicao.controller;

import com.bella.agenda_eleicao.model.AgendaEleicao;
import com.bella.agenda_eleicao.model.Convidado;
import com.bella.agenda_eleicao.repository.AgendaEleicaoRepository;
import com.bella.agenda_eleicao.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AgandaEleicaoController<codigo> {

    @Autowired
    private AgendaEleicaoRepository er;

    @Autowired
    private ConvidadoRepository cr;

    @RequestMapping(value = "/cadastrarAgendaEleicao", method = RequestMethod.GET)
    public String form() {
        return "agendaEleicao/formAgendaEleicao";
    }

    @RequestMapping(value = "/cadastrarAgendaEleicao", method = RequestMethod.POST)
    public String form(AgendaEleicao agendaEleicao, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "direct:/cadastrarAgendaEleicao";
        }
        er.save(agendaEleicao);
        return "redirect:/cadastrarAgendaEleicao";
    }

    @RequestMapping("/agendaEleicao")
    public ModelAndView listAgendaEleicao() {
        ModelAndView mv = new ModelAndView("index");
        Iterable<AgendaEleicao> agendaEleicao = er.findAll();
        mv.addObject("agendaEleicao", agendaEleicao);
        return mv;
    }

    @RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
    public ModelAndView detalhesAgendaEleicao(@PathVariable("codigo") long codigo) {
        AgendaEleicao agendaEleicao = er.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("agendaEleicao/datelhesAgendaEleicao");
        mv.addObject("agendaEleicao", agendaEleicao);

        Iterable<Convidado> convidados = cr.findByAgendaEleicao(agendaEleicao);
        mv.addObject("convidados", convidados);

        return mv;
    }

    @RequestMapping("/deletarEvento")
    public String deletarEvento(long codigo) {
        AgendaEleicao agendaEleicao = er.findByCodigo(codigo);
        er.delete(agendaEleicao);
        return "direct:/agendaEleicao";
    }

    @RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
    public String detalhesAgendaEleicaoPost(@PathVariable("codigo") long codigo, @Valid Convidado convidado,
            BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "direct:/cadastrarAgendaEleicao";
        }
        AgendaEleicao agendaEleicao = er.findByCodigo(codigo);
        convidado.setAgendaEleicao(agendaEleicao);
        cr.save(convidado);
        attributes.addFlashAttribute("mensagem", "Canvidado adicionado com SUCESSO!");
        return "redirect:/{codigo}";
    }

    @RequestMapping("/deletarConvidado")
    public String deletarConvidado(String codigo) {
        Convidado convidado = cr.findByCodigo(codigo);
        cr.delete(convidado);

        AgendaEleicao agendaEleicao = convidado.getAgendaEleicao();
        long codigoLong = agendaEleicao.getCodigo();
        codigo = "" + codigoLong;
        return "direct:/" + codigo;
    }
}