package eapli.base.tarefaManualAprovacao.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TarefaManualAprovacaoService {
    public TarefaManualAprovacaoService() {
    }

    public boolean validaDescricaoBreve(final String descBreve) {
        String regex = "(.|[ \\n\\t]){1,40}";
        //todo fazer expressao para todos os tipos de dados

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(descBreve);

        return matcher.find();
    }
}
