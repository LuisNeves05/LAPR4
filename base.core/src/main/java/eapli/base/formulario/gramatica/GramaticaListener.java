// Generated from C:/Users/luism/Desktop/lei20_21_s4_2dl_4/base.core/src/main/java/eapli/base/formulario/gramatica\Gramatica.g4 by ANTLR 4.9.1
package eapli.base.formulario.gramatica;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GramaticaParser}.
 */
public interface GramaticaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(GramaticaParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(GramaticaParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code defineNaoVazio}
	 * labeled alternative in {@link GramaticaParser#valida}.
	 * @param ctx the parse tree
	 */
	void enterDefineNaoVazio(GramaticaParser.DefineNaoVazioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code defineNaoVazio}
	 * labeled alternative in {@link GramaticaParser#valida}.
	 * @param ctx the parse tree
	 */
	void exitDefineNaoVazio(GramaticaParser.DefineNaoVazioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparaAtributos}
	 * labeled alternative in {@link GramaticaParser#valida}.
	 * @param ctx the parse tree
	 */
	void enterComparaAtributos(GramaticaParser.ComparaAtributosContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparaAtributos}
	 * labeled alternative in {@link GramaticaParser#valida}.
	 * @param ctx the parse tree
	 */
	void exitComparaAtributos(GramaticaParser.ComparaAtributosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code limitaNomeAtributo}
	 * labeled alternative in {@link GramaticaParser#valida}.
	 * @param ctx the parse tree
	 */
	void enterLimitaNomeAtributo(GramaticaParser.LimitaNomeAtributoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code limitaNomeAtributo}
	 * labeled alternative in {@link GramaticaParser#valida}.
	 * @param ctx the parse tree
	 */
	void exitLimitaNomeAtributo(GramaticaParser.LimitaNomeAtributoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atributoExpRegular}
	 * labeled alternative in {@link GramaticaParser#valida}.
	 * @param ctx the parse tree
	 */
	void enterAtributoExpRegular(GramaticaParser.AtributoExpRegularContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atributoExpRegular}
	 * labeled alternative in {@link GramaticaParser#valida}.
	 * @param ctx the parse tree
	 */
	void exitAtributoExpRegular(GramaticaParser.AtributoExpRegularContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#compara}.
	 * @param ctx the parse tree
	 */
	void enterCompara(GramaticaParser.ComparaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#compara}.
	 * @param ctx the parse tree
	 */
	void exitCompara(GramaticaParser.ComparaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#decisao}.
	 * @param ctx the parse tree
	 */
	void enterDecisao(GramaticaParser.DecisaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#decisao}.
	 * @param ctx the parse tree
	 */
	void exitDecisao(GramaticaParser.DecisaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#atributo}.
	 * @param ctx the parse tree
	 */
	void enterAtributo(GramaticaParser.AtributoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#atributo}.
	 * @param ctx the parse tree
	 */
	void exitAtributo(GramaticaParser.AtributoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#}.
	 * @param ctx the parse tree
	 */
	void enterNomes(GramaticaParser.NomesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#}.
	 * @param ctx the parse tree
	 */
	void exitNomes(GramaticaParser.NomesContext ctx);
}