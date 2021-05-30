package eapli.base.formulario.gramatica;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;


public class ValidaScript {

    public static boolean validadeGrammarFromString(String string){
        try{
            eapli.base.eapli.base.formulario.gramatica.ValidaScriptLexer lexer = new eapli.base.eapli.base.formulario.gramatica.ValidaScriptLexer(new ANTLRInputStream(string));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            eapli.base.eapli.base.formulario.gramatica.ValidaScriptParser parser = new eapli.base.eapli.base.formulario.gramatica.ValidaScriptParser(tokens);
            return parser.validaExp() != null;
        }catch (Exception e){
            System.out.println("Houve um erro a analisar a gramática");
            return false;
        }
    }
}