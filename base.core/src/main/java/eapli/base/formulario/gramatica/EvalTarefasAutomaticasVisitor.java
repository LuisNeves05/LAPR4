package eapli.base.formulario.gramatica;

import eapli.base.formulario.gramatica.eapli.base.formulario.gramatica.*;
import eapli.base.formularioPreenchido.domain.Resposta;

import java.util.List;

public class EvalTarefasAutomaticasVisitor extends TarefaAutomaticaBaseVisitor<String> {

    List<Resposta> respostaList;

    public EvalTarefasAutomaticasVisitor(List<Resposta> list){
        this.respostaList = list;
    }

    @Override
    public String visitProg(TarefaAutomaticaParser.ProgContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitExecuta(TarefaAutomaticaParser.ExecutaContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitEnviar_email(TarefaAutomaticaParser.Enviar_emailContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitPesquisa_xml(TarefaAutomaticaParser.Pesquisa_xmlContext ctx) {



        return visitChildren(ctx);
    }


}
