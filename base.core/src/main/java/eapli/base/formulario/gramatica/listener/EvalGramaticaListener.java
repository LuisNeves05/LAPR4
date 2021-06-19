package eapli.base.formulario.gramatica.listener;

import eapli.base.formulario.gramatica.gramaticaformulario.GramaticaBaseListener;
import eapli.base.formulario.gramatica.gramaticaformulario.GramaticaParser;
import eapli.base.formularioPreenchido.domain.Resposta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        String compara = ctx.compara().getText();

        if (isDate(resposta1) && isDate(resposta2)) {

            SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
            Date date1 = null, date2 = null;
            try {
                date1 = formatter1.parse(resposta1);
                date2 = formatter1.parse(resposta2);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            switch (compara) {
                case "MENOR":
                    if (date1 != null && date1.after(date2)) {
                        System.out.println("A primeira data tem de ser anterior à segunda data!");
                        throww();
                    }
                    break;
                case "MENORIGUAL":
                    if (date1 != null && date1.after(date2)) {
                        System.out.println("A primeira data tem de ser anterior ou no mesmo dia à segunda data!");
                        throww();
                    }
                    break;
                case "MAIOR":
                    if (date1 != null && date1.before(date2)) {
                        System.out.println("A primeira data tem de ser posterior à segunda data");
                        throww();
                    }
                case "MAIORIGUAL":
                    if (date1 != null && date1.equals(date2) || date1 != null && date1.before(date2)) {
                        System.out.println("A primeira data tem de ser posterior ou no mesmo dia da segunda data");
                        throww();
                    }
            }

        } else if (isNumeric(resposta1) && isNumeric(resposta2)) {
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
                                    System.out.println("O atributo "+ indice2 + " não pode ser vazio.");
                                    throww();
                                }
                                break;
                            case "VAZIO":
                                if (!resposta2.isEmpty()) {
                                    System.out.println("O atributo "+ indice2 + " têm que estar vazio.");
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
        String regex = "[1-9]?[0-9]+(.[1-9]?[0-9]+)?";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherAlphaNumericCheck = pattern.matcher(strNum);

        return matcherAlphaNumericCheck.find();
    }

    public boolean isDate(String strDate) {
        String regex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1" +
                "\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcherAlphaNumericCheck = pattern.matcher(strDate);

        return matcherAlphaNumericCheck.find();
    }

    private void throww() {
        throw new IllegalArgumentException();
    }
}
