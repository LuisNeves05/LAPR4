// Generated from C:/Users/luism/Desktop/lei20_21_s4_2dl_4/base.core/src/main/java/eapli/base/formulario/gramatica\ValidaScript.g4 by ANTLR 4.9.1
package eapli.base.eapli.base.formulario.gramatica;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ValidaScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ValidaScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ValidaScriptParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ValidaScriptParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link ValidaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpr(ValidaScriptParser.PrintExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link ValidaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(ValidaScriptParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link ValidaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlank(ValidaScriptParser.BlankContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defineExpRegular}
	 * labeled alternative in {@link ValidaScriptParser#validaExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineExpRegular(ValidaScriptParser.DefineExpRegularContext ctx);
	/**
	 * Visit a parse tree produced by the {@code validaEntreCampos}
	 * labeled alternative in {@link ValidaScriptParser#validaExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidaEntreCampos(ValidaScriptParser.ValidaEntreCamposContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defineCampoNaoVazio}
	 * labeled alternative in {@link ValidaScriptParser#validaExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineCampoNaoVazio(ValidaScriptParser.DefineCampoNaoVazioContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defineCampoPodeSerVazio}
	 * labeled alternative in {@link ValidaScriptParser#validaExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineCampoPodeSerVazio(ValidaScriptParser.DefineCampoPodeSerVazioContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(ValidaScriptParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(ValidaScriptParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(ValidaScriptParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inte}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInte(ValidaScriptParser.InteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in .
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(ValidaScriptParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link ValidaScriptParser#exprExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(ValidaScriptParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nomeAtributo}
	 * labeled alternative in {@link ValidaScriptParser#exprExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNomeAtributo(ValidaScriptParser.NomeAtributoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code maior}
	 * labeled alternative in {@link ValidaScriptParser#exprExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaior(ValidaScriptParser.MaiorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code menor}
	 * labeled alternative in {@link ValidaScriptParser#exprExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMenor(ValidaScriptParser.MenorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code igual}
	 * labeled alternative in {@link ValidaScriptParser#exprExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgual(ValidaScriptParser.IgualContext ctx);
}