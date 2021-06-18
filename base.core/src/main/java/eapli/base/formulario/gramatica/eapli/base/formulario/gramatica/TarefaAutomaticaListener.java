// Generated from C:/Users/luism/Desktop/lei20_21_s4_2dl_4/base.core/src/main/java/eapli/base/formulario/gramatica\TarefaAutomatica.g4 by ANTLR 4.9.1
package eapli.base.formulario.gramatica.eapli.base.formulario.gramatica;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TarefaAutomaticaParser}.
 */
public interface TarefaAutomaticaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TarefaAutomaticaParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(TarefaAutomaticaParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefaAutomaticaParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(TarefaAutomaticaParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefaAutomaticaParser#executa}.
	 * @param ctx the parse tree
	 */
	void enterExecuta(TarefaAutomaticaParser.ExecutaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefaAutomaticaParser#executa}.
	 * @param ctx the parse tree
	 */
	void exitExecuta(TarefaAutomaticaParser.ExecutaContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefaAutomaticaParser#pesquisa_xml}.
	 * @param ctx the parse tree
	 */
	void enterPesquisa_xml(TarefaAutomaticaParser.Pesquisa_xmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefaAutomaticaParser#pesquisa_xml}.
	 * @param ctx the parse tree
	 */
	void exitPesquisa_xml(TarefaAutomaticaParser.Pesquisa_xmlContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefaAutomaticaParser#enviar_email}.
	 * @param ctx the parse tree
	 */
	void enterEnviar_email(TarefaAutomaticaParser.Enviar_emailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefaAutomaticaParser#enviar_email}.
	 * @param ctx the parse tree
	 */
	void exitEnviar_email(TarefaAutomaticaParser.Enviar_emailContext ctx);
	/**
	 * Enter a parse tree produced by .
	 * @param ctx the parse tree
	 */
	void enterCorpo_email(TarefaAutomaticaParser.Corpo_emailContext ctx);
	/**
	 * Exit a parse tree produced by .
	 * @param ctx the parse tree
	 */
	void exitCorpo_email(TarefaAutomaticaParser.Corpo_emailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefaAutomaticaParser#desconto}.
	 * @param ctx the parse tree
	 */
	void enterDesconto(TarefaAutomaticaParser.DescontoContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefaAutomaticaParser#desconto}.
	 * @param ctx the parse tree
	 */
	void exitDesconto(TarefaAutomaticaParser.DescontoContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefaAutomaticaParser#desconto_aplica}.
	 * @param ctx the parse tree
	 */
	void enterDesconto_aplica(TarefaAutomaticaParser.Desconto_aplicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefaAutomaticaParser#desconto_aplica}.
	 * @param ctx the parse tree
	 */
	void exitDesconto_aplica(TarefaAutomaticaParser.Desconto_aplicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefaAutomaticaParser#se_categoria}.
	 * @param ctx the parse tree
	 */
	void enterSe_categoria(TarefaAutomaticaParser.Se_categoriaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefaAutomaticaParser#se_categoria}.
	 * @param ctx the parse tree
	 */
	void exitSe_categoria(TarefaAutomaticaParser.Se_categoriaContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefaAutomaticaParser#compara}.
	 * @param ctx the parse tree
	 */
	void enterCompara(TarefaAutomaticaParser.ComparaContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefaAutomaticaParser#compara}.
	 * @param ctx the parse tree
	 */
	void exitCompara(TarefaAutomaticaParser.ComparaContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefaAutomaticaParser#numero}.
	 * @param ctx the parse tree
	 */
	void enterNumero(TarefaAutomaticaParser.NumeroContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefaAutomaticaParser#numero}.
	 * @param ctx the parse tree
	 */
	void exitNumero(TarefaAutomaticaParser.NumeroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opExprMulDiv}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 */
	void enterOpExprMulDiv(TarefaAutomaticaParser.OpExprMulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opExprMulDiv}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 */
	void exitOpExprMulDiv(TarefaAutomaticaParser.OpExprMulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opExprSumDif}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 */
	void enterOpExprSumDif(TarefaAutomaticaParser.OpExprSumDifContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opExprSumDif}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 */
	void exitOpExprSumDif(TarefaAutomaticaParser.OpExprSumDifContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(TarefaAutomaticaParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(TarefaAutomaticaParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TarefaAutomaticaParser#atributo}.
	 * @param ctx the parse tree
	 */
	void enterAtributo(TarefaAutomaticaParser.AtributoContext ctx);
	/**
	 * Exit a parse tree produced by {@link TarefaAutomaticaParser#atributo}.
	 * @param ctx the parse tree
	 */
	void exitAtributo(TarefaAutomaticaParser.AtributoContext ctx);
}