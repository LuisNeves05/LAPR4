package eapli.base.tarefaManualAprovacao.persistance;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.formulario.domain.Formulario;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.framework.domain.repositories.DomainRepository;
import java.util.List;

public interface TarefaManualAprovacaoRepositorio extends DomainRepository<Long, TarefaManualAprovacao> {

    List<TarefaManualAprovacao> tarefasManuaisAprovacaoNA(Colaborador colaborador);

   List<Formulario> obterAtividadeRealizacao(TarefaManualAprovacao tarefa);


}