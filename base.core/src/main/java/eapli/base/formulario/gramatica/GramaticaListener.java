// Generated from C:/Users/luism/Desktop/lei20_21_s4_2dl_4/base.core/src/main/java/eapli/base/formulario/gramatica\Gramatica.g4 by ANTLR 4.9.1
package eapli.base.formulario.gramatica;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GramaticaParser}.
 */
public interface GramaticaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#parseEspecificao}.
	 * @param ctx the parse tree
	 */
	void enterParseEspecificao(GramaticaParser.ParseEspecificaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#parseEspecificao}.
	 * @param ctx the parse tree
	 */
	void exitParseEspecificao(GramaticaParser.ParseEspecificaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#parseValidacao}.
	 * @param ctx the parse tree
	 */
	void enterParseValidacao(GramaticaParser.ParseValidacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#parseValidacao}.
	 * @param ctx the parse tree
	 */
	void exitParseValidacao(GramaticaParser.ParseValidacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#instructionEspecificacao}.
	 * @param ctx the parse tree
	 */
	void enterInstructionEspecificacao(GramaticaParser.InstructionEspecificacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#instructionEspecificacao}.
	 * @param ctx the parse tree
	 */
	void exitInstructionEspecificacao(GramaticaParser.InstructionEspecificacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#instructionValidacao}.
	 * @param ctx the parse tree
	 */
	void enterInstructionValidacao(GramaticaParser.InstructionValidacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#instructionValidacao}.
	 * @param ctx the parse tree
	 */
	void exitInstructionValidacao(GramaticaParser.InstructionValidacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#servico1dataInicioFimEspecificacao}.
	 * @param ctx the parse tree
	 */
	void enterServico1dataInicioFimEspecificacao(GramaticaParser.Servico1dataInicioFimEspecificacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#servico1dataInicioFimEspecificacao}.
	 * @param ctx the parse tree
	 */
	void exitServico1dataInicioFimEspecificacao(GramaticaParser.Servico1dataInicioFimEspecificacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#servico1dataInicioFimValidacao}.
	 * @param ctx the parse tree
	 */
	void enterServico1dataInicioFimValidacao(GramaticaParser.Servico1dataInicioFimValidacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#servico1dataInicioFimValidacao}.
	 * @param ctx the parse tree
	 */
	void exitServico1dataInicioFimValidacao(GramaticaParser.Servico1dataInicioFimValidacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#servico1Justificacao}.
	 * @param ctx the parse tree
	 */
	void enterServico1Justificacao(GramaticaParser.Servico1JustificacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#servico1Justificacao}.
	 * @param ctx the parse tree
	 */
	void exitServico1Justificacao(GramaticaParser.Servico1JustificacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#dataInicio}.
	 * @param ctx the parse tree
	 */
	void enterDataInicio(GramaticaParser.DataInicioContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#dataInicio}.
	 * @param ctx the parse tree
	 */
	void exitDataInicio(GramaticaParser.DataInicioContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#dataFim}.
	 * @param ctx the parse tree
	 */
	void enterDataFim(GramaticaParser.DataFimContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#dataFim}.
	 * @param ctx the parse tree
	 */
	void exitDataFim(GramaticaParser.DataFimContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#justificacao}.
	 * @param ctx the parse tree
	 */
	void enterJustificacao(GramaticaParser.JustificacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#justificacao}.
	 * @param ctx the parse tree
	 */
	void exitJustificacao(GramaticaParser.JustificacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#enviar_email}.
	 * @param ctx the parse tree
	 */
	void enterEnviar_email(GramaticaParser.Enviar_emailContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#enviar_email}.
	 * @param ctx the parse tree
	 */
	void exitEnviar_email(GramaticaParser.Enviar_emailContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#}.
	 * @param ctx the parse tree
	 */
	void enterCorpo_email(GramaticaParser.Corpo_emailContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#}.
	 * @param ctx the parse tree
	 */
	void exitCorpo_email(GramaticaParser.Corpo_emailContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opExprMulDiv}
	 * labeled alternative in {@link GramaticaParser#}.
	 * @param ctx the parse tree
	 */
	void enterOpExprMulDiv(GramaticaParser.OpExprMulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opExprMulDiv}
	 * labeled alternative in {@link GramaticaParser#}.
	 * @param ctx the parse tree
	 */
	void exitOpExprMulDiv(GramaticaParser.OpExprMulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opExprSumDif}
	 * labeled alternative in {@link GramaticaParser#}.
	 * @param ctx the parse tree
	 */
	void enterOpExprSumDif(GramaticaParser.OpExprSumDifContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opExprSumDif}
	 * labeled alternative in {@link GramaticaParser#}.
	 * @param ctx the parse tree
	 */
	void exitOpExprSumDif(GramaticaParser.OpExprSumDifContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link GramaticaParser#}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(GramaticaParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link GramaticaParser#}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(GramaticaParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#date}.
	 * @param ctx the parse tree
	 */
	void enterDate(GramaticaParser.DateContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#date}.
	 * @param ctx the parse tree
	 */
	void exitDate(GramaticaParser.DateContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#month}.
	 * @param ctx the parse tree
	 */
	void enterMonth(GramaticaParser.MonthContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#month}.
	 * @param ctx the parse tree
	 */
	void exitMonth(GramaticaParser.MonthContext ctx);
}