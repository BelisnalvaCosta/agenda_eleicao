package com.bella.agenda_eleicao.controller;

        import com.bella.agenda_eleicao.model.AgendaEleicao;
        import com.bella.agenda_eleicao.repository.AgendaEleicaoRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.servlet.ModelAndView;

@Controller
public class AgandaEleicaoController {

    @Autowired
    private AgendaEleicaoRepository er;

    @RequestMapping(value = "/cadastrarAgendaEleicao", method=RequestMethod.GET)
    public String form(){
        return "agendaEleicao/formAgendaEleicao";
    }

    @RequestMapping(value = "/cadastrarAgendaEleicao", method=RequestMethod.POST)
    public String form(AgendaEleicao agendaEleicao){
        er.save(agendaEleicao);
        return "redirect:/cadastrarAgendaEleicao";
    }

    @RequestMapping("/agendaEleicao")
    public ModelAndView listAgendaEleicao(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<AgendaEleicao> agendaEleicao = er.findAll();
        mv.addObject("agendaEleicao", agendaEleicao);
        return mv;
    }

    @RequestMapping("/{codigo}")
    public ModelAndView detalhesAgendaEleicao(@PathVariable("codigo") long codigo){
        AgendaEleicao agendaEleicao = er.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("agendaEleicao/datelhesAgendaEleicao");
        mv.addObject("agendaEleicao", agendaEleicao);
        System.out.println("agendaEleicao" + agendaEleicao);
        return mv;
    }
}
