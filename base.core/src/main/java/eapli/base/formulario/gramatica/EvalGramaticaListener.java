package eapli.base.formulario.gramatica;

public class EvalGramaticaListener extends GramaticaBaseListener{

    //TODO METODOS QUE VAO EXECUTAR A VALIDAÇÃO DAS RESPOSTAS INSERIDAS

    @Override
    public void enterServico1dataInicioFimEspecificacao(GramaticaParser.Servico1dataInicioFimEspecificacaoContext ctx) {

        String datainicio = ctx.dataInicio().getText();
        String dataFim = ctx.dataFim().getText();

        System.out.println(datainicio + " Inicio");
        System.out.println(dataFim + " Inicio");
        System.out.println("\n nice");

    }
}
