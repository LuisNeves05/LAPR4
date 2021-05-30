package eapli.base.formulario.gramatica;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import eapli.base.formulario.gramatica.ValidaScript;


public class ValidaScript {

    public static boolean validadeGrammarFromString(String string){
        try{
            eapli.base.formulario.gramatica.ValidaScriptLexer lexer = new eapli.base.formulario.gramatica.ValidaScriptLexer(new ANTLRInputStream(string));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            eapli.base.formulario.gramatica.ValidaScriptParser parser = new eapli.base.formulario.gramatica.ValidaScriptParser(tokens);
            return parser.validaExp() != null;
        }catch (Exception e){
            System.out.println("Houve um erro a analisar a gramática");
            return false;
        }
    }
}