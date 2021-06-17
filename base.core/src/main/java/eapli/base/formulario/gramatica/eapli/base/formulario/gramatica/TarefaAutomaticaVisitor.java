// Generated from C:/Users/luism/Desktop/lei20_21_s4_2dl_4/base.core/src/main/java/eapli/base/formulario/gramatica\TarefaAutomatica.g4 by ANTLR 4.9.1
package eapli.base.formulario.gramatica.eapli.base.formulario.gramatica;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TarefaAutomaticaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TarefaAutomaticaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TarefaAutomaticaParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(TarefaAutomaticaParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link TarefaAutomaticaParser#executa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecuta(TarefaAutomaticaParser.ExecutaContext ctx);
	/**
	 * Visit a parse tree produced by {@link TarefaAutomaticaParser#enviar_email}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnviar_email(TarefaAutomaticaParser.Enviar_emailContext ctx);
	/**
	 * Visit a parse tree produced by .
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorpo_email(TarefaAutomaticaParser.Corpo_emailContext ctx);
	/**
	 * Visit a parse tree produced by {@link TarefaAutomaticaParser#pesquisa_xml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPesquisa_xml(TarefaAutomaticaParser.Pesquisa_xmlContext ctx);
	/**
	 * Visit a parse tree produced by {@link TarefaAutomaticaParser#desconto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesconto(TarefaAutomaticaParser.DescontoContext ctx);
	/**
	 * Visit a parse tree produced by {@link TarefaAutomaticaParser#desconto_aplica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesconto_aplica(TarefaAutomaticaParser.Desconto_aplicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link TarefaAutomaticaParser#compara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompara(TarefaAutomaticaParser.ComparaContext ctx);
	/**
	 * Visit a parse tree produced by {@link TarefaAutomaticaParser#numero}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero(TarefaAutomaticaParser.NumeroContext ctx);
	/**
	 * Visit a parse tree produced by {@link TarefaAutomaticaParser#nome_ficheiro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNome_ficheiro(TarefaAutomaticaParser.Nome_ficheiroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opExprMulDiv}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpExprMulDiv(TarefaAutomaticaParser.OpExprMulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opExprSumDif}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpExprSumDif(TarefaAutomaticaParser.OpExprSumDifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(TarefaAutomaticaParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TarefaAutomaticaParser#atributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtributo(TarefaAutomaticaParser.AtributoContext ctx);
}