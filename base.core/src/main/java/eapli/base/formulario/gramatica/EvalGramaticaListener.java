package eapli.base.formulario.gramatica;

import eapli.base.formulario.gramatica.gramaticaformulario.GramaticaBaseListener;
import eapli.base.formulario.gramatica.gramaticaformulario.GramaticaParser;
import eapli.base.formularioPreenchido.domain.Resposta;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvalGramaticaListener extends GramaticaBaseListener {

    private List<Resposta> respostas;

    public EvalGramaticaListener(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    @Override
    public void exitDefineNaoVazio(GramaticaParser.DefineNaoVazioContext ctx) {

        int indice = Integer.parseInt(ctx.atributo().NUMERO().getText());

        if (respostas.get(indice).resposta().isEmpty() || respostas.get(indice).resposta().equals("")) {
            throw new IllegalArgumentException("A resposta não pode ser vazia/nula");
        }
    }

    @Override
    public void exitComparaAtributos(GramaticaParser.ComparaAtributosContext ctx) {
        int indice1 = Integer.parseInt(ctx.left.NUMERO().getText());
        int indice2 = Integer.parseInt(ctx.right.NUMERO().getText());
        String resposta1 = respostas.get(indice1).resposta();
        String resposta2 = respostas.get(indice2).resposta();


        System.out.println(resposta1 + " esta e a resposta 1");
        System.out.println(resposta2 + " esta e a resposta 2");

        String compara = ctx.compara().getText();

        if (isNumeric(resposta1) && isNumeric(resposta2)) {
            double primeiro = Double.parseDouble(resposta1);
            double segundo = Double.parseDouble(resposta2);

            switch (compara) {
                case "MENOR":
                    if (primeiro >= segundo) {
                        System.out.println("O primeiro atributo tem de ser menor que o segundo!");
                        throww();
                    }
                    break;
                case "MENORIGUAL":
                    if (primeiro > segundo) {
                        System.out.println("O primeiro atributo tem de ser menor ou igual que o segundo!");
                        throww();
                    }
                    break;
                case "MAIOR":
                    if (primeiro <= segundo) {
                        System.out.println("O primeiro atributo tem de ser maior que o segundo!");
                        throww();
                    }
                case "MAIORIGUAL":
                    if (primeiro < segundo) {
                        System.out.println("O primeiro atributo tem de ser maior ou igual que o segundo!");
                        throww();
                    }
                case "IGUAL":
                    if (primeiro == segundo) {
                        System.out.println("O primeiro atributo tem de ser igual ao segundo!");
                        throww();
                    }
                default:
                    System.out.println("Comparação não reconhecida");
                    throww();
            }
        } else {

            switch (compara) {

                case "NAOVAZIO":
                    if (!resposta1.isEmpty()) {
                        String decisao = ctx.decisao().getText();

                        switch (decisao) {
                            case "NAOVAZIO":
                                if (resposta2.isEmpty()) {
                                    throww();
                                }
                                break;
                            case "VAZIO":
                                if (!resposta2.isEmpty()) {
                                    throww();
                                }
                                break;
                        }

                    }
                    break;
                case "VAZIO":

                    if (resposta1.isEmpty()) {
                        String decisao = ctx.decisao().getText();

                        switch (decisao) {
                            case "NAOVAZIO":
                                if (resposta2.isEmpty()) {
                                    throww();
                                }
                                break;
                            case "VAZIO":
                                if (!resposta2.isEmpty()) {
                                    throww();
                                }
                        }
                    }
                    break;
                case "NAME":
                    String decisao = ctx.decisao().getText();

                    switch (decisao) {
                        case "NAOVAZIO":
                            if (resposta2.isEmpty()) {
                                throww();
                            }
                            break;
                        case "VAZIO":
                            if (!resposta2.isEmpty()) {
                                throww();
                            }
                    }
            }
        }
    }

    @Override
    public void exitLimitaNomeAtributo(GramaticaParser.LimitaNomeAtributoContext ctx) {
        int indice = Integer.parseInt(ctx.atributo().NUMERO().getText());
        String resposta = respostas.get(indice).resposta();

        if (!resposta.equals(ctx.nomes().NAME().getText())) {
            System.out.println("A resposta introduzida não corresponde às opções pre-definidas");
            throww();
        }
    }

    public boolean isNumeric(String strNum) {
        String regex = "(.|[ \\n\\t]){1,500}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherAlphaNumericCheck = pattern.matcher(strNum);

        return matcherAlphaNumericCheck.find();
    }

    private void throww() {
        throw new IllegalArgumentException();
    }
}
