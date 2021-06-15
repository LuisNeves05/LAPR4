package eapli.base.formulario.gramatica;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Set;


public class Script {

    public static boolean validadeGrammarFromString(String string){

            //DATAINICIO MENORIGUAL DATAFIM

            GramaticaLexer lexer = new GramaticaLexer(new ANTLRInputStream(string));
            lexer.removeErrorListeners();
            lexer.addErrorListener(ErrorListener.INSTANCE);

            GramaticaParser parser = new GramaticaParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(ErrorListener.INSTANCE);
        try {
            parser.parseEspecificao();
            return true;
        }catch (ParseCancellationException pce){
            System.out.println("A gramática está incorreta");
            return false;
        }
    }

    public static boolean executaScript(String string){

        EvalGramaticaListener listener = new EvalGramaticaListener();

        GramaticaLexer lexer = new GramaticaLexer(new ANTLRInputStream(string));
        lexer.removeErrorListeners();
        lexer.addErrorListener(ErrorListener.INSTANCE);

        GramaticaParser parser = new GramaticaParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(ErrorListener.INSTANCE);
        try {
            GramaticaParser.ParseValidacaoContext pp = parser.parseValidacao();
            ParseTreeWalker.DEFAULT.walk(listener, pp);
            return true;
        }catch (ParseCancellationException pce){
            System.out.println("Erro na introdução das respostas");
            return false;
        }
    }
}