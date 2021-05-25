package eapli.base.formulario.gramatica;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CalculosGrammar {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\luism\\Desktop\\lei20_21_s4_2dl_4\\base.core\\src\\main\\java\\eapli\\base\\formulario\\gramatica\\teste.txt"));

        GramaticaLexer lexer = new GramaticaLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GramaticaParser parser = new GramaticaParser(tokens);
        ParseTree tree = parser.prog(); // parse
        EvalVisitor eval = new EvalVisitor();
        eval.visit(tree);
    }
}
