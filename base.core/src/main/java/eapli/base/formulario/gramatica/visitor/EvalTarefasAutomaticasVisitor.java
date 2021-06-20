package eapli.base.formulario.gramatica.visitor;

import eapli.base.Utils.Email;
import eapli.base.Utils.XMLUtils;
import eapli.base.formulario.gramatica.eapli.base.formulario.gramatica.TarefaAutomaticaBaseVisitor;
import eapli.base.formulario.gramatica.eapli.base.formulario.gramatica.TarefaAutomaticaParser;
import eapli.base.formularioPreenchido.domain.Resposta;

import java.util.List;

public class EvalTarefasAutomaticasVisitor extends TarefaAutomaticaBaseVisitor<String> {

    private final List<Resposta> respostaList;
    private final String email;
    private final XMLUtils xmlUtils = new XMLUtils();

    public EvalTarefasAutomaticasVisitor(List<Resposta> list, String email) {
        this.respostaList = list;
        this.email = email;
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

        double precoFinal;

        /**
         * Vai buscar o indice do atributo à gramática
         *
         * Neste caso é o indice da resposta correspondente ao nome do ficheiro xml
         */
        int indiceFile = Integer.parseInt(visitAtributo(ctx.nome_ficheiro));
        String filename = respostaList.get(indiceFile).resposta();


        /**
         * Vai buscar o indice do atributo à gramatica
         *
         * Neste caso o indice ira corresponder ao id do produto a pesquisar
         */
        int indiceItemProcurar = Integer.parseInt(visitAtributo(ctx.id_a_pesquisar));
        String itemProcurar = respostaList.get(indiceItemProcurar).resposta();


        /**
         * Vai buscar o indice da quantidade do determinado produto a ser vendido
         */
        int indiceQuantidade = Integer.parseInt(visitDesconto(ctx.desconto()));
        int quantidade = Integer.parseInt(respostaList.get(indiceQuantidade).resposta());

        /**
         * Vai buscar o tipo de comparação que o gestor especificou
         */
        String compara = visitCompara(ctx.desconto().compara());

        /**
         * Vai buscar o limite definido pelo gestor
         */
        int limite = Integer.parseInt(visitNumero(ctx.desconto().numero()));

        /**
         * Vai buscar o desconto a aplicar caso se verifique a condição imposta pelo gestor
         */
        double descontoAplicar = Integer.parseInt(visitDesconto_aplica(ctx.desconto().desconto_aplica()));

        /**
         * Vai buscar a categoria especificada pelo gestor que tem direito a desconto extra
         */
        String categoriaDescontoNome = visitSe_categoria(ctx.desconto().se_categoria());
        double categoriaDesconto = Integer.parseInt(visitDesconto_aplica(ctx.desconto().se_categoria().desconto_aplica()));

        /**
         * Pesquisa no ficheiro especificado pelo Utilizador para obter o preco e a categoria do mesmo
         */
        int preco = Integer.parseInt(xmlUtils.xml(filename, itemProcurar, "preco").get(0));
        String categoria = xmlUtils.xml(filename, itemProcurar, "categoria").get(0);

        /**
         * Calcula valor total (preco unitario * quantidade)
         */
        int valorTotal = preco * quantidade;

        switch (compara) {
            case "MENOR":
                if (quantidade < limite) {
                    descontoAplicar = 0;
                }
                break;
            case "MENORIGUAL":
                if (quantidade <= limite) {
                    descontoAplicar = (valorTotal * 0.05);
                }
                break;
            case "MAIOR":
                if (quantidade > limite) {
                    descontoAplicar = valorTotal * 0.1;
                }
                break;
            case "MAIORIGUAL":
                if (quantidade >= limite) {
                    descontoAplicar = valorTotal * 0.12;
                }
                break;
            default:
                System.out.println("Ocorreu um erro muito inesperado");
        }

        if (categoriaDescontoNome.equals(categoria)) {
            descontoAplicar = descontoAplicar - descontoAplicar * (categoriaDesconto / 100);
        }

        /**
         * Calcula preco final após descontos
         */
        precoFinal = valorTotal - descontoAplicar;


        String textfinal = "Saudações camarada, \n\n A seu pedido, aqui estão os valores de desconto aplicados: \n Valor Total: "
                + valorTotal + " Desconto a aplicar: " + descontoAplicar + " \n\n Preço final: " + precoFinal;
        Email.sendEmail(this.email, textfinal);
        return "";
    }

    @Override
    public String visitAtributo(TarefaAutomaticaParser.AtributoContext ctx) {
        return ctx.NUMERO().getText();
    }

    @Override
    public String visitDesconto(TarefaAutomaticaParser.DescontoContext ctx) {
        return visitAtributo(ctx.atribquanti);
    }

    @Override
    public String visitCompara(TarefaAutomaticaParser.ComparaContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitNumero(TarefaAutomaticaParser.NumeroContext ctx) {
        return ctx.NUMERO().getText();
    }


    @Override
    public String visitDesconto_aplica(TarefaAutomaticaParser.Desconto_aplicaContext ctx) {
        return ctx.NUMERO().getText();
    }

    @Override
    public String visitSe_categoria(TarefaAutomaticaParser.Se_categoriaContext ctx) {
        return ctx.NAME().getText();
    }
}
