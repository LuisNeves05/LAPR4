package eapli.base.formulario.gramatica;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ValidaScript {

    public static boolean validadeGrammarFromString(String string){
        try{
            ValidaScriptLexer lexer = new ValidaScriptLexer(new ANTLRInputStream(string));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ValidaScriptParser parser = new ValidaScriptParser(tokens);
            ParseTree tree = parser.prog(); // parse
            EvalVisitor eval = new EvalVisitor();
            eval.visit(tree);
            return true;
        }catch (Exception e){
            System.out.println("Houve um erro a analisar a gramática");
            return false;
        }
    }
}