// Generated from C:/Users/luism/Desktop/lei20_21_s4_2dl_4/base.core/src/main/java/eapli/base/formulario/gramatica\ValidaScript.g4 by ANTLR 4.9.1
package eapli.base.eapli.base.formulario.gramatica;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ValidaScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, NEWLINE=2, INT=3, ID=4, MUL=5, DIV=6, ADD=7, SUB=8, ATR=9, LPR=10, 
		RPR=11, DEFINE=12, SE=13, ENTAO=14, NAOVAZIO=15, VAZIO=16, MAIOR=17, MENOR=18, 
		NOMEATRIBUTO=19, ESPACO=20, EXPREGULAR=21;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_validaExp = 2, RULE_expr = 3, RULE_exprExp = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stat", "validaExp", "expr", "exprExp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' '", null, null, null, "'*'", "'/'", "'+'", "'-'", "'='", "'('", 
			"')'", "'DEFINE'", "'SE'", "'ENTAO'", "'NAOVAZIO'", "'VAZIO'", "'>'", 
			"'<'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "NEWLINE", "INT", "ID", "MUL", "DIV", "ADD", "SUB", "ATR", 
			"LPR", "RPR", "DEFINE", "SE", "ENTAO", "NAOVAZIO", "VAZIO", "MAIOR", 
			"MENOR", "NOMEATRIBUTO", "ESPACO", "EXPREGULAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ValidaScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ValidaScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public List<ValidaExpContext> validaExp() {
			return getRuleContexts(ValidaExpContext.class);
		}
		public ValidaExpContext validaExp(int i) {
			return getRuleContext(ValidaExpContext.class,i);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			setState(17);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case DEFINE:
			case SE:
				enterOuterAlt(_localctx, 1);
				{
				setState(13);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DEFINE || _la==SE) {
					{
					{
					setState(10);
					validaExp();
					}
					}
					setState(15);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case NEWLINE:
			case INT:
			case ID:
			case LPR:
				enterOuterAlt(_localctx, 2);
				{
				setState(16);
				stat();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BlankContext extends StatContext {
		public TerminalNode NEWLINE() { return getToken(ValidaScriptParser.NEWLINE, 0); }
		public BlankContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterBlank(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitBlank(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitBlank(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintExprContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ValidaScriptParser.NEWLINE, 0); }
		public PrintExprContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterPrintExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitPrintExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitPrintExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends StatContext {
		public TerminalNode ID() { return getToken(ValidaScriptParser.ID, 0); }
		public TerminalNode ATR() { return getToken(ValidaScriptParser.ATR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ValidaScriptParser.NEWLINE, 0); }
		public AssignContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(28);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new PrintExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(19);
				expr(0);
				setState(20);
				match(NEWLINE);
				}
				break;
			case 2:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(22);
				match(ID);
				setState(23);
				match(ATR);
				setState(24);
				expr(0);
				setState(25);
				match(NEWLINE);
				}
				break;
			case 3:
				_localctx = new BlankContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(27);
				match(NEWLINE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValidaExpContext extends ParserRuleContext {
		public ValidaExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_validaExp; }
	 
		public ValidaExpContext() { }
		public void copyFrom(ValidaExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DefineCampoPodeSerVazioContext extends ValidaExpContext {
		public TerminalNode DEFINE() { return getToken(ValidaScriptParser.DEFINE, 0); }
		public ExprExpContext exprExp() {
			return getRuleContext(ExprExpContext.class,0);
		}
		public TerminalNode VAZIO() { return getToken(ValidaScriptParser.VAZIO, 0); }
		public DefineCampoPodeSerVazioContext(ValidaExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterDefineCampoPodeSerVazio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitDefineCampoPodeSerVazio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitDefineCampoPodeSerVazio(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefineCampoNaoVazioContext extends ValidaExpContext {
		public TerminalNode DEFINE() { return getToken(ValidaScriptParser.DEFINE, 0); }
		public ExprExpContext exprExp() {
			return getRuleContext(ExprExpContext.class,0);
		}
		public TerminalNode NAOVAZIO() { return getToken(ValidaScriptParser.NAOVAZIO, 0); }
		public DefineCampoNaoVazioContext(ValidaExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterDefineCampoNaoVazio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitDefineCampoNaoVazio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitDefineCampoNaoVazio(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValidaEntreCamposContext extends ValidaExpContext {
		public TerminalNode SE() { return getToken(ValidaScriptParser.SE, 0); }
		public List<ExprExpContext> exprExp() {
			return getRuleContexts(ExprExpContext.class);
		}
		public ExprExpContext exprExp(int i) {
			return getRuleContext(ExprExpContext.class,i);
		}
		public TerminalNode VAZIO() { return getToken(ValidaScriptParser.VAZIO, 0); }
		public TerminalNode ENTAO() { return getToken(ValidaScriptParser.ENTAO, 0); }
		public TerminalNode NAOVAZIO() { return getToken(ValidaScriptParser.NAOVAZIO, 0); }
		public TerminalNode MAIOR() { return getToken(ValidaScriptParser.MAIOR, 0); }
		public TerminalNode MENOR() { return getToken(ValidaScriptParser.MENOR, 0); }
		public TerminalNode ATR() { return getToken(ValidaScriptParser.ATR, 0); }
		public ValidaEntreCamposContext(ValidaExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterValidaEntreCampos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitValidaEntreCampos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitValidaEntreCampos(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefineExpRegularContext extends ValidaExpContext {
		public TerminalNode DEFINE() { return getToken(ValidaScriptParser.DEFINE, 0); }
		public ExprExpContext exprExp() {
			return getRuleContext(ExprExpContext.class,0);
		}
		public TerminalNode EXPREGULAR() { return getToken(ValidaScriptParser.EXPREGULAR, 0); }
		public DefineExpRegularContext(ValidaExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterDefineExpRegular(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitDefineExpRegular(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitDefineExpRegular(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValidaExpContext validaExp() throws RecognitionException {
		ValidaExpContext _localctx = new ValidaExpContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_validaExp);
		try {
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new DefineExpRegularContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				match(DEFINE);
				setState(31);
				exprExp();
				setState(32);
				match(EXPREGULAR);
				}
				break;
			case 2:
				_localctx = new ValidaEntreCamposContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				match(SE);
				setState(35);
				exprExp();
				setState(36);
				match(T__0);
				setState(37);
				match(VAZIO);
				setState(38);
				match(ENTAO);
				setState(39);
				exprExp();
				setState(40);
				match(NAOVAZIO);
				}
				break;
			case 3:
				_localctx = new ValidaEntreCamposContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				match(SE);
				setState(43);
				exprExp();
				setState(44);
				match(NAOVAZIO);
				setState(45);
				match(ENTAO);
				setState(46);
				exprExp();
				setState(47);
				match(VAZIO);
				}
				break;
			case 4:
				_localctx = new ValidaEntreCamposContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				match(SE);
				setState(50);
				exprExp();
				setState(51);
				match(MAIOR);
				setState(52);
				exprExp();
				setState(53);
				match(ENTAO);
				setState(54);
				exprExp();
				setState(55);
				match(VAZIO);
				}
				break;
			case 5:
				_localctx = new ValidaEntreCamposContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(57);
				match(SE);
				setState(58);
				exprExp();
				setState(59);
				match(MAIOR);
				setState(60);
				exprExp();
				setState(61);
				match(ENTAO);
				setState(62);
				exprExp();
				setState(63);
				match(NAOVAZIO);
				}
				break;
			case 6:
				_localctx = new ValidaEntreCamposContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(65);
				match(SE);
				setState(66);
				exprExp();
				setState(67);
				match(MENOR);
				setState(68);
				exprExp();
				setState(69);
				match(ENTAO);
				setState(70);
				exprExp();
				setState(71);
				match(NAOVAZIO);
				}
				break;
			case 7:
				_localctx = new ValidaEntreCamposContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(73);
				match(SE);
				setState(74);
				exprExp();
				setState(75);
				match(ATR);
				setState(76);
				exprExp();
				setState(77);
				match(ENTAO);
				setState(78);
				exprExp();
				setState(79);
				match(NAOVAZIO);
				}
				break;
			case 8:
				_localctx = new DefineCampoNaoVazioContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(81);
				match(DEFINE);
				setState(82);
				exprExp();
				setState(83);
				match(NAOVAZIO);
				}
				break;
			case 9:
				_localctx = new DefineCampoPodeSerVazioContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(85);
				match(DEFINE);
				setState(86);
				exprExp();
				setState(87);
				match(VAZIO);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParensContext extends ExprContext {
		public TerminalNode LPR() { return getToken(ValidaScriptParser.LPR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPR() { return getToken(ValidaScriptParser.RPR, 0); }
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(ValidaScriptParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(ValidaScriptParser.DIV, 0); }
		public MulDivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitMulDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(ValidaScriptParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(ValidaScriptParser.SUB, 0); }
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InteContext extends ExprContext {
		public TerminalNode INT() { return getToken(ValidaScriptParser.INT, 0); }
		public InteContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterInte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitInte(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitInte(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdContext extends ExprContext {
		public TerminalNode ID() { return getToken(ValidaScriptParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				_localctx = new InteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(92);
				match(INT);
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(93);
				match(ID);
				}
				break;
			case LPR:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94);
				match(LPR);
				setState(95);
				expr(0);
				setState(96);
				match(RPR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(106);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(100);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(101);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(102);
						expr(6);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(103);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(104);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(105);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExprExpContext extends ParserRuleContext {
		public ExprExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprExp; }
	 
		public ExprExpContext() { }
		public void copyFrom(ExprExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NomeAtributoContext extends ExprExpContext {
		public TerminalNode NOMEATRIBUTO() { return getToken(ValidaScriptParser.NOMEATRIBUTO, 0); }
		public NomeAtributoContext(ExprExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterNomeAtributo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitNomeAtributo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitNomeAtributo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MaiorContext extends ExprExpContext {
		public TerminalNode MAIOR() { return getToken(ValidaScriptParser.MAIOR, 0); }
		public MaiorContext(ExprExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterMaior(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitMaior(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitMaior(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MenorContext extends ExprExpContext {
		public TerminalNode MENOR() { return getToken(ValidaScriptParser.MENOR, 0); }
		public MenorContext(ExprExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterMenor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitMenor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitMenor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IgualContext extends ExprExpContext {
		public TerminalNode ATR() { return getToken(ValidaScriptParser.ATR, 0); }
		public IgualContext(ExprExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterIgual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitIgual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitIgual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends ExprExpContext {
		public TerminalNode INT() { return getToken(ValidaScriptParser.INT, 0); }
		public IntContext(ExprExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValidaScriptListener ) ((ValidaScriptListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValidaScriptVisitor ) return ((ValidaScriptVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprExpContext exprExp() throws RecognitionException {
		ExprExpContext _localctx = new ExprExpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_exprExp);
		try {
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				match(INT);
				}
				break;
			case NOMEATRIBUTO:
				_localctx = new NomeAtributoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				match(NOMEATRIBUTO);
				}
				break;
			case MAIOR:
				_localctx = new MaiorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				match(MAIOR);
				}
				break;
			case MENOR:
				_localctx = new MenorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(114);
				match(MENOR);
				}
				break;
			case ATR:
				_localctx = new IgualContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(115);
				match(ATR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27y\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\7\2\16\n\2\f\2\16\2\21\13\2\3\2\5\2\24"+
		"\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\37\n\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4\\\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5e\n\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\7\5m\n\5\f\5\16\5p\13\5\3\6\3\6\3\6\3\6\3\6\5\6w\n\6\3\6\2"+
		"\3\b\7\2\4\6\b\n\2\4\3\2\7\b\3\2\t\n\2\u0087\2\23\3\2\2\2\4\36\3\2\2\2"+
		"\6[\3\2\2\2\bd\3\2\2\2\nv\3\2\2\2\f\16\5\6\4\2\r\f\3\2\2\2\16\21\3\2\2"+
		"\2\17\r\3\2\2\2\17\20\3\2\2\2\20\24\3\2\2\2\21\17\3\2\2\2\22\24\5\4\3"+
		"\2\23\17\3\2\2\2\23\22\3\2\2\2\24\3\3\2\2\2\25\26\5\b\5\2\26\27\7\4\2"+
		"\2\27\37\3\2\2\2\30\31\7\6\2\2\31\32\7\13\2\2\32\33\5\b\5\2\33\34\7\4"+
		"\2\2\34\37\3\2\2\2\35\37\7\4\2\2\36\25\3\2\2\2\36\30\3\2\2\2\36\35\3\2"+
		"\2\2\37\5\3\2\2\2 !\7\16\2\2!\"\5\n\6\2\"#\7\27\2\2#\\\3\2\2\2$%\7\17"+
		"\2\2%&\5\n\6\2&\'\7\3\2\2\'(\7\22\2\2()\7\20\2\2)*\5\n\6\2*+\7\21\2\2"+
		"+\\\3\2\2\2,-\7\17\2\2-.\5\n\6\2./\7\21\2\2/\60\7\20\2\2\60\61\5\n\6\2"+
		"\61\62\7\22\2\2\62\\\3\2\2\2\63\64\7\17\2\2\64\65\5\n\6\2\65\66\7\23\2"+
		"\2\66\67\5\n\6\2\678\7\20\2\289\5\n\6\29:\7\22\2\2:\\\3\2\2\2;<\7\17\2"+
		"\2<=\5\n\6\2=>\7\23\2\2>?\5\n\6\2?@\7\20\2\2@A\5\n\6\2AB\7\21\2\2B\\\3"+
		"\2\2\2CD\7\17\2\2DE\5\n\6\2EF\7\24\2\2FG\5\n\6\2GH\7\20\2\2HI\5\n\6\2"+
		"IJ\7\21\2\2J\\\3\2\2\2KL\7\17\2\2LM\5\n\6\2MN\7\13\2\2NO\5\n\6\2OP\7\20"+
		"\2\2PQ\5\n\6\2QR\7\21\2\2R\\\3\2\2\2ST\7\16\2\2TU\5\n\6\2UV\7\21\2\2V"+
		"\\\3\2\2\2WX\7\16\2\2XY\5\n\6\2YZ\7\22\2\2Z\\\3\2\2\2[ \3\2\2\2[$\3\2"+
		"\2\2[,\3\2\2\2[\63\3\2\2\2[;\3\2\2\2[C\3\2\2\2[K\3\2\2\2[S\3\2\2\2[W\3"+
		"\2\2\2\\\7\3\2\2\2]^\b\5\1\2^e\7\5\2\2_e\7\6\2\2`a\7\f\2\2ab\5\b\5\2b"+
		"c\7\r\2\2ce\3\2\2\2d]\3\2\2\2d_\3\2\2\2d`\3\2\2\2en\3\2\2\2fg\f\7\2\2"+
		"gh\t\2\2\2hm\5\b\5\bij\f\6\2\2jk\t\3\2\2km\5\b\5\7lf\3\2\2\2li\3\2\2\2"+
		"mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\t\3\2\2\2pn\3\2\2\2qw\7\5\2\2rw\7\25\2"+
		"\2sw\7\23\2\2tw\7\24\2\2uw\7\13\2\2vq\3\2\2\2vr\3\2\2\2vs\3\2\2\2vt\3"+
		"\2\2\2vu\3\2\2\2w\13\3\2\2\2\n\17\23\36[dlnv";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}