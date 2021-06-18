package eapli.base.formulario.gramatica;

import eapli.base.formularioPreenchido.domain.Resposta;
import org.antlr.v4.runtime.tree.ParseTree;
import eapli.base.formulario.gramatica.eapli.base.formulario.gramatica.TarefaAutomaticaLexer;
import eapli.base.formulario.gramatica.eapli.base.formulario.gramatica.TarefaAutomaticaParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.io.File;
import java.util.List;


public class ScriptTarefasAutomaticas {


    public static boolean validaTarefasAutomaticas(String script) {


        TarefaAutomaticaLexer lexer = new TarefaAutomaticaLexer(new ANTLRInputStream(script));
        lexer.removeErrorListeners();
        lexer.addErrorListener(ErrorListener.INSTANCE);

        TarefaAutomaticaParser parser = new TarefaAutomaticaParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(ErrorListener.INSTANCE);

        try {
            parser.executa();
            return true;
        } catch (ParseCancellationException pce) {
            System.out.println("A gramática do script está incorretaa");
            return false;
        }
    }

    public static boolean executaTarefaAutomatica(String script, List<Resposta> list) {

        EvalTarefasAutomaticasVisitor tarefasAutomaticasVisitor = new EvalTarefasAutomaticasVisitor(list);

        TarefaAutomaticaLexer lexer = new TarefaAutomaticaLexer(new ANTLRInputStream(script));
        lexer.removeErrorListeners();
        lexer.addErrorListener(ErrorListener.INSTANCE);

        TarefaAutomaticaParser parser = new TarefaAutomaticaParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(ErrorListener.INSTANCE);

        try {
            ParseTree pt = parser.executa();
            tarefasAutomaticasVisitor.visit(pt);
            return true;
        } catch (ParseCancellationException pce) {
            System.out.println("A gramática do script está incorretaa");
            return false;
        }
    }
}
