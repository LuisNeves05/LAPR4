// Generated from C:/Users/luism/Desktop/lei20_21_s4_2dl_4/base.core/src/main/java/eapli/base/formulario/gramatica\Gramatica.g4 by ANTLR 4.9.1
package eapli.base.formulario.gramatica.gramaticaformulario;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GramaticaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GramaticaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(GramaticaParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defineNaoVazio}
	 * labeled alternative in {@link GramaticaParser#valida}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineNaoVazio(GramaticaParser.DefineNaoVazioContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparaAtributos}
	 * labeled alternative in {@link GramaticaParser#valida}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparaAtributos(GramaticaParser.ComparaAtributosContext ctx);
	/**
	 * Visit a parse tree produced by the {@code limitaNomeAtributo}
	 * labeled alternative in {@link GramaticaParser#valida}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitaNomeAtributo(GramaticaParser.LimitaNomeAtributoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atributoExpRegular}
	 * labeled alternative in {@link GramaticaParser#valida}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtributoExpRegular(GramaticaParser.AtributoExpRegularContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#compara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompara(GramaticaParser.ComparaContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#decisao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecisao(GramaticaParser.DecisaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#atributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtributo(GramaticaParser.AtributoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNomes(GramaticaParser.NomesContext ctx);
}