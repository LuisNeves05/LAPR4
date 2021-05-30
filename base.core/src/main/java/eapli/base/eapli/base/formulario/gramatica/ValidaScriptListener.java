// Generated from C:/Users/luism/Desktop/lei20_21_s4_2dl_4/base.core/src/main/java/eapli/base/formulario/gramatica\ValidaScript.g4 by ANTLR 4.9.1
package eapli.base.eapli.base.formulario.gramatica;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ValidaScriptParser}.
 */
public interface ValidaScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ValidaScriptParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ValidaScriptParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidaScriptParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ValidaScriptParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link ValidaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(ValidaScriptParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link ValidaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(ValidaScriptParser.PrintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ValidaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(ValidaScriptParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ValidaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(ValidaScriptParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link ValidaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlank(ValidaScriptParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link ValidaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlank(ValidaScriptParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code defineExpRegular}
	 * labeled alternative in {@link ValidaScriptParser#validaExp}.
	 * @param ctx the parse tree
	 */
	void enterDefineExpRegular(ValidaScriptParser.DefineExpRegularContext ctx);
	/**
	 * Exit a parse tree produced by the {@code defineExpRegular}
	 * labeled alternative in {@link ValidaScriptParser#validaExp}.
	 * @param ctx the parse tree
	 */
	void exitDefineExpRegular(ValidaScriptParser.DefineExpRegularContext ctx);
	/**
	 * Enter a parse tree produced by the {@code validaEntreCampos}
	 * labeled alternative in {@link ValidaScriptParser#validaExp}.
	 * @param ctx the parse tree
	 */
	void enterValidaEntreCampos(ValidaScriptParser.ValidaEntreCamposContext ctx);
	/**
	 * Exit a parse tree produced by the {@code validaEntreCampos}
	 * labeled alternative in {@link ValidaScriptParser#validaExp}.
	 * @param ctx the parse tree
	 */
	void exitValidaEntreCampos(ValidaScriptParser.ValidaEntreCamposContext ctx);
	/**
	 * Enter a parse tree produced by the {@code defineCampoNaoVazio}
	 * labeled alternative in {@link ValidaScriptParser#validaExp}.
	 * @param ctx the parse tree
	 */
	void enterDefineCampoNaoVazio(ValidaScriptParser.DefineCampoNaoVazioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code defineCampoNaoVazio}
	 * labeled alternative in {@link ValidaScriptParser#validaExp}.
	 * @param ctx the parse tree
	 */
	void exitDefineCampoNaoVazio(ValidaScriptParser.DefineCampoNaoVazioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code defineCampoPodeSerVazio}
	 * labeled alternative in {@link ValidaScriptParser#validaExp}.
	 * @param ctx the parse tree
	 */
	void enterDefineCampoPodeSerVazio(ValidaScriptParser.DefineCampoPodeSerVazioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code defineCampoPodeSerVazio}
	 * labeled alternative in {@link ValidaScriptParser#validaExp}.
	 * @param ctx the parse tree
	 */
	void exitDefineCampoPodeSerVazio(ValidaScriptParser.DefineCampoPodeSerVazioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 */
	void enterParens(ValidaScriptParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 */
	void exitParens(ValidaScriptParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 */
	void enterMulDiv(ValidaScriptParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 */
	void exitMulDiv(ValidaScriptParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 */
	void enterAddSub(ValidaScriptParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 */
	void exitAddSub(ValidaScriptParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inte}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 */
	void enterInte(ValidaScriptParser.InteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inte}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 */
	void exitInte(ValidaScriptParser.InteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 */
	void enterId(ValidaScriptParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 */
	void exitId(ValidaScriptParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link ValidaScriptParser#exprExp}.
	 * @param ctx the parse tree
	 */
	void enterInt(ValidaScriptParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link ValidaScriptParser#exprExp}.
	 * @param ctx the parse tree
	 */
	void exitInt(ValidaScriptParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nomeAtributo}
	 * labeled alternative in {@link ValidaScriptParser#exprExp}.
	 * @param ctx the parse tree
	 */
	void enterNomeAtributo(ValidaScriptParser.NomeAtributoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nomeAtributo}
	 * labeled alternative in {@link ValidaScriptParser#exprExp}.
	 * @param ctx the parse tree
	 */
	void exitNomeAtributo(ValidaScriptParser.NomeAtributoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code maior}
	 * labeled alternative in {@link ValidaScriptParser#exprExp}.
	 * @param ctx the parse tree
	 */
	void enterMaior(ValidaScriptParser.MaiorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code maior}
	 * labeled alternative in {@link ValidaScriptParser#exprExp}.
	 * @param ctx the parse tree
	 */
	void exitMaior(ValidaScriptParser.MaiorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code menor}
	 * labeled alternative in {@link ValidaScriptParser#exprExp}.
	 * @param ctx the parse tree
	 */
	void enterMenor(ValidaScriptParser.MenorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code menor}
	 * labeled alternative in {@link ValidaScriptParser#exprExp}.
	 * @param ctx the parse tree
	 */
	void exitMenor(ValidaScriptParser.MenorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code igual}
	 * labeled alternative in {@link ValidaScriptParser#exprExp}.
	 * @param ctx the parse tree
	 */
	void enterIgual(ValidaScriptParser.IgualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code igual}
	 * labeled alternative in {@link ValidaScriptParser#exprExp}.
	 * @param ctx the parse tree
	 */
	void exitIgual(ValidaScriptParser.IgualContext ctx);
}