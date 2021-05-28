// Generated from C:/Users/FaustoPC/Desktop/LAPR/base.core/src/main/java/eapli/base/formulario/gramatica\ValidaScript.g4 by ANTLR 4.9.1
package eapli.base.formulario.gramatica;
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
		NEWLINE=1, INT=2, ID=3, MUL=4, DIV=5, ADD=6, SUB=7, ATR=8, LPR=9, RPR=10, 
		DEFINE=11, SE=12, ENTAO=13, NAOVAZIO=14, VAZIO=15, MAIOR=16, MENOR=17, 
		NOMEATRIBUTO=18, ESPACO=19, EXPREGULAR=20;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_expr = 2, RULE_validaExp = 3, RULE_exprExp = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stat", "expr", "validaExp", "exprExp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'*'", "'/'", "'+'", "'-'", "'='", "'('", "')'", 
			"'DEFINE'", "'SE'", "'ENTAO'", "'NAOVAZIO'", "'VAZIO'", "'>'", "'<'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NEWLINE", "INT", "ID", "MUL", "DIV", "ADD", "SUB", "ATR", "LPR", 
			"RPR", "DEFINE", "SE", "ENTAO", "NAOVAZIO", "VAZIO", "MAIOR", "MENOR", 
			"NOMEATRIBUTO", "ESPACO", "EXPREGULAR"
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
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<ValidaExpContext> validaExp() {
			return getRuleContexts(ValidaExpContext.class);
		}
		public ValidaExpContext validaExp(int i) {
			return getRuleContext(ValidaExpContext.class,i);
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
			setState(22);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(13);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEWLINE) | (1L << INT) | (1L << ID) | (1L << LPR))) != 0)) {
					{
					{
					setState(10);
					stat();
					}
					}
					setState(15);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DEFINE || _la==SE) {
					{
					{
					setState(16);
					validaExp(0);
					}
					}
					setState(21);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
			setState(33);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new PrintExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				expr(0);
				setState(25);
				match(NEWLINE);
				}
				break;
			case 2:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				match(ID);
				setState(28);
				match(ATR);
				setState(29);
				expr(0);
				setState(30);
				match(NEWLINE);
				}
				break;
			case 3:
				_localctx = new BlankContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				_localctx = new InteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(36);
				match(INT);
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(37);
				match(ID);
				}
				break;
			case LPR:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(38);
				match(LPR);
				setState(39);
				expr(0);
				setState(40);
				match(RPR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(50);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(44);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(45);
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
						setState(46);
						expr(6);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(47);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(48);
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
						setState(49);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(54);
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
		public ValidaExpContext validaExp() {
			return getRuleContext(ValidaExpContext.class,0);
		}
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
		return validaExp(0);
	}

	private ValidaExpContext validaExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValidaExpContext _localctx = new ValidaExpContext(_ctx, _parentState);
		ValidaExpContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_validaExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new ValidaEntreCamposContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(56);
				match(SE);
				setState(57);
				exprExp();
				setState(58);
				match(VAZIO);
				setState(59);
				match(ENTAO);
				setState(60);
				exprExp();
				setState(61);
				match(NAOVAZIO);
				}
				break;
			case 2:
				{
				_localctx = new ValidaEntreCamposContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63);
				match(SE);
				setState(64);
				exprExp();
				setState(65);
				match(NAOVAZIO);
				setState(66);
				match(ENTAO);
				setState(67);
				exprExp();
				setState(68);
				match(VAZIO);
				}
				break;
			case 3:
				{
				_localctx = new ValidaEntreCamposContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70);
				match(SE);
				setState(71);
				exprExp();
				setState(72);
				match(MAIOR);
				setState(73);
				exprExp();
				setState(74);
				match(ENTAO);
				setState(75);
				exprExp();
				setState(76);
				match(VAZIO);
				}
				break;
			case 4:
				{
				_localctx = new ValidaEntreCamposContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				match(SE);
				setState(79);
				exprExp();
				setState(80);
				match(MAIOR);
				setState(81);
				exprExp();
				setState(82);
				match(ENTAO);
				setState(83);
				exprExp();
				setState(84);
				match(NAOVAZIO);
				}
				break;
			case 5:
				{
				_localctx = new ValidaEntreCamposContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				match(SE);
				setState(87);
				exprExp();
				setState(88);
				match(MENOR);
				setState(89);
				exprExp();
				setState(90);
				match(ENTAO);
				setState(91);
				exprExp();
				setState(92);
				match(NAOVAZIO);
				}
				break;
			case 6:
				{
				_localctx = new ValidaEntreCamposContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94);
				match(SE);
				setState(95);
				exprExp();
				setState(96);
				match(ATR);
				setState(97);
				exprExp();
				setState(98);
				match(ENTAO);
				setState(99);
				exprExp();
				setState(100);
				match(NAOVAZIO);
				}
				break;
			case 7:
				{
				_localctx = new DefineCampoNaoVazioContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102);
				match(DEFINE);
				setState(103);
				exprExp();
				setState(104);
				match(NAOVAZIO);
				}
				break;
			case 8:
				{
				_localctx = new DefineCampoPodeSerVazioContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(106);
				match(DEFINE);
				setState(107);
				exprExp();
				setState(108);
				match(VAZIO);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DefineExpRegularContext(new ValidaExpContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_validaExp);
					setState(112);
					if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
					setState(113);
					match(DEFINE);
					setState(114);
					exprExp();
					setState(115);
					match(EXPREGULAR);
					}
					} 
				}
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
			setState(127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				match(INT);
				}
				break;
			case NOMEATRIBUTO:
				_localctx = new NomeAtributoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				match(NOMEATRIBUTO);
				}
				break;
			case MAIOR:
				_localctx = new MaiorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				match(MAIOR);
				}
				break;
			case MENOR:
				_localctx = new MenorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(125);
				match(MENOR);
				}
				break;
			case ATR:
				_localctx = new IgualContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(126);
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
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 3:
			return validaExp_sempred((ValidaExpContext)_localctx, predIndex);
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
	private boolean validaExp_sempred(ValidaExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u0084\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\7\2\16\n\2\f\2\16\2\21\13\2\3\2\7"+
		"\2\24\n\2\f\2\16\2\27\13\2\5\2\31\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\5\3$\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4-\n\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\7\4\65\n\4\f\4\16\48\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5q\n\5\3\5\3\5\3\5\3\5\3\5"+
		"\7\5x\n\5\f\5\16\5{\13\5\3\6\3\6\3\6\3\6\3\6\5\6\u0082\n\6\3\6\2\4\6\b"+
		"\7\2\4\6\b\n\2\4\3\2\6\7\3\2\b\t\2\u0093\2\30\3\2\2\2\4#\3\2\2\2\6,\3"+
		"\2\2\2\bp\3\2\2\2\n\u0081\3\2\2\2\f\16\5\4\3\2\r\f\3\2\2\2\16\21\3\2\2"+
		"\2\17\r\3\2\2\2\17\20\3\2\2\2\20\31\3\2\2\2\21\17\3\2\2\2\22\24\5\b\5"+
		"\2\23\22\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\31\3\2\2"+
		"\2\27\25\3\2\2\2\30\17\3\2\2\2\30\25\3\2\2\2\31\3\3\2\2\2\32\33\5\6\4"+
		"\2\33\34\7\3\2\2\34$\3\2\2\2\35\36\7\5\2\2\36\37\7\n\2\2\37 \5\6\4\2 "+
		"!\7\3\2\2!$\3\2\2\2\"$\7\3\2\2#\32\3\2\2\2#\35\3\2\2\2#\"\3\2\2\2$\5\3"+
		"\2\2\2%&\b\4\1\2&-\7\4\2\2\'-\7\5\2\2()\7\13\2\2)*\5\6\4\2*+\7\f\2\2+"+
		"-\3\2\2\2,%\3\2\2\2,\'\3\2\2\2,(\3\2\2\2-\66\3\2\2\2./\f\7\2\2/\60\t\2"+
		"\2\2\60\65\5\6\4\b\61\62\f\6\2\2\62\63\t\3\2\2\63\65\5\6\4\7\64.\3\2\2"+
		"\2\64\61\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\7\3\2\2\2"+
		"8\66\3\2\2\29:\b\5\1\2:;\7\16\2\2;<\5\n\6\2<=\7\21\2\2=>\7\17\2\2>?\5"+
		"\n\6\2?@\7\20\2\2@q\3\2\2\2AB\7\16\2\2BC\5\n\6\2CD\7\20\2\2DE\7\17\2\2"+
		"EF\5\n\6\2FG\7\21\2\2Gq\3\2\2\2HI\7\16\2\2IJ\5\n\6\2JK\7\22\2\2KL\5\n"+
		"\6\2LM\7\17\2\2MN\5\n\6\2NO\7\21\2\2Oq\3\2\2\2PQ\7\16\2\2QR\5\n\6\2RS"+
		"\7\22\2\2ST\5\n\6\2TU\7\17\2\2UV\5\n\6\2VW\7\20\2\2Wq\3\2\2\2XY\7\16\2"+
		"\2YZ\5\n\6\2Z[\7\23\2\2[\\\5\n\6\2\\]\7\17\2\2]^\5\n\6\2^_\7\20\2\2_q"+
		"\3\2\2\2`a\7\16\2\2ab\5\n\6\2bc\7\n\2\2cd\5\n\6\2de\7\17\2\2ef\5\n\6\2"+
		"fg\7\20\2\2gq\3\2\2\2hi\7\r\2\2ij\5\n\6\2jk\7\20\2\2kq\3\2\2\2lm\7\r\2"+
		"\2mn\5\n\6\2no\7\21\2\2oq\3\2\2\2p9\3\2\2\2pA\3\2\2\2pH\3\2\2\2pP\3\2"+
		"\2\2pX\3\2\2\2p`\3\2\2\2ph\3\2\2\2pl\3\2\2\2qy\3\2\2\2rs\f\13\2\2st\7"+
		"\r\2\2tu\5\n\6\2uv\7\26\2\2vx\3\2\2\2wr\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz"+
		"\3\2\2\2z\t\3\2\2\2{y\3\2\2\2|\u0082\7\4\2\2}\u0082\7\24\2\2~\u0082\7"+
		"\22\2\2\177\u0082\7\23\2\2\u0080\u0082\7\n\2\2\u0081|\3\2\2\2\u0081}\3"+
		"\2\2\2\u0081~\3\2\2\2\u0081\177\3\2\2\2\u0081\u0080\3\2\2\2\u0082\13\3"+
		"\2\2\2\f\17\25\30#,\64\66py\u0081";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}