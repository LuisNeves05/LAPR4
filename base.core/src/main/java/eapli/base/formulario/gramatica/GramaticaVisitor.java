// Generated from C:/Users/luism/Desktop/lei20_21_s4_2dl_4/base.core/src/main/java/eapli/base/formulario/gramatica\Gramatica.g4 by ANTLR 4.9.1
package eapli.base.formulario.gramatica;
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
	 * Visit a parse tree produced by {@link GramaticaParser#parseEspecificao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseEspecificao(GramaticaParser.ParseEspecificaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#parseValidacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseValidacao(GramaticaParser.ParseValidacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#instructionEspecificacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructionEspecificacao(GramaticaParser.InstructionEspecificacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#instructionValidacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructionValidacao(GramaticaParser.InstructionValidacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#servico1dataInicioFimEspecificacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServico1dataInicioFimEspecificacao(GramaticaParser.Servico1dataInicioFimEspecificacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#servico1dataInicioFimValidacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServico1dataInicioFimValidacao(GramaticaParser.Servico1dataInicioFimValidacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#servico1Justificacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServico1Justificacao(GramaticaParser.Servico1JustificacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#dataInicio}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataInicio(GramaticaParser.DataInicioContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#dataFim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataFim(GramaticaParser.DataFimContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#justificacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJustificacao(GramaticaParser.JustificacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#enviar_email}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnviar_email(GramaticaParser.Enviar_emailContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorpo_email(GramaticaParser.Corpo_emailContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opExprMulDiv}
	 * labeled alternative in {@link GramaticaParser#}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpExprMulDiv(GramaticaParser.OpExprMulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opExprSumDif}
	 * labeled alternative in {@link GramaticaParser#}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpExprSumDif(GramaticaParser.OpExprSumDifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link GramaticaParser#}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(GramaticaParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate(GramaticaParser.DateContext ctx);
	/**
	 * Visit a parse tree produced by {@link GramaticaParser#month}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMonth(GramaticaParser.MonthContext ctx);
}