package eapli.base.formulario.gramatica;

import eapli.base.formularioPreenchido.domain.Resposta;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.List;


public class Script {

    private List<Resposta> list = new ArrayList<>();

    public Script(List<Resposta> list){
        this.list = list;
    }

    public static boolean validadeGrammarFromString(String string){

            GramaticaLexer lexer = new GramaticaLexer(new ANTLRInputStream(string));
            lexer.removeErrorListeners();
            lexer.addErrorListener(ErrorListener.INSTANCE);

            GramaticaParser parser = new GramaticaParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(ErrorListener.INSTANCE);
        try {
            parser.valida();
            return true;
        }catch (ParseCancellationException pce){
            System.out.println("A gramática está incorreta");
            return false;
        }
    }


    public static boolean executa(List<Resposta> list, String scriptValidacao) {

        try {
            EvalGramaticaListener listener = new EvalGramaticaListener(list);

            GramaticaLexer lexer = new GramaticaLexer(new ANTLRInputStream(scriptValidacao));
            lexer.removeErrorListeners();
            lexer.addErrorListener(ErrorListener.INSTANCE);

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            GramaticaParser parser = new GramaticaParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(ErrorListener.INSTANCE);

            GramaticaParser.ProgContext pp = parser.prog();
            ParseTreeWalker.DEFAULT.walk(listener, pp);

        } catch (ParseCancellationException | IllegalArgumentException e){
            return false;
        }
        return true;

    }

}