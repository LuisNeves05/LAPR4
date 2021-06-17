// Generated from C:/Users/luism/Desktop/lei20_21_s4_2dl_4/base.core/src/main/java/eapli/base/formulario/gramatica\Gramatica.g4 by ANTLR 4.9.1
package eapli.base.formulario.gramatica;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramaticaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, ATRIBUTO=2, DEFINE=3, SE=4, MENOR=5, IGUAL=6, MAIOR=7, MENORIGUAL=8, 
		MAIORIGUAL=9, ENTAO=10, NAOVAZIO=11, VAZIO=12, NUMERO=13, NAME=14, NEWLINE=15, 
		SPACES=16, SEPARATOR=17, EXPREGULAR=18;
	public static final int
		RULE_prog = 0, RULE_valida = 1, RULE_compara = 2, RULE_decisao = 3, RULE_atributo = 4, 
		RULE_nomes = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "valida", "compara", "decisao", "atributo", "nomes"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'ATRIBUTO'", "'DEFINE'", "'SE'", "'MENOR'", "'IGUAL'", "'MAIOR'", 
			"'MENORIGUAL'", "'MAIORIGUAL'", "'ENTAO'", "'NAOVAZIO'", "'VAZIO'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "ATRIBUTO", "DEFINE", "SE", "MENOR", "IGUAL", "MAIOR", 
			"MENORIGUAL", "MAIORIGUAL", "ENTAO", "NAOVAZIO", "VAZIO", "NUMERO", "NAME", 
			"NEWLINE", "SPACES", "SEPARATOR", "EXPREGULAR"
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
	public String getGrammarFileName() { return "Gramatica.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GramaticaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public ValidaContext valida() {
			return getRuleContext(ValidaContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			valida();
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

	public static class ValidaContext extends ParserRuleContext {
		public ValidaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valida; }
	 
		public ValidaContext() { }
		public void copyFrom(ValidaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LimitaNomeAtributoContext extends ValidaContext {
		public AtributoContext atributo() {
			return getRuleContext(AtributoContext.class,0);
		}
		public NomesContext nomes() {
			return getRuleContext(NomesContext.class,0);
		}
		public LimitaNomeAtributoContext(ValidaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterLimitaNomeAtributo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitLimitaNomeAtributo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitLimitaNomeAtributo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtributoExpRegularContext extends ValidaContext {
		public AtributoContext atributo() {
			return getRuleContext(AtributoContext.class,0);
		}
		public TerminalNode EXPREGULAR() { return getToken(GramaticaParser.EXPREGULAR, 0); }
		public AtributoExpRegularContext(ValidaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterAtributoExpRegular(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitAtributoExpRegular(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAtributoExpRegular(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefineNaoVazioContext extends ValidaContext {
		public AtributoContext atributo() {
			return getRuleContext(AtributoContext.class,0);
		}
		public TerminalNode NAOVAZIO() { return getToken(GramaticaParser.NAOVAZIO, 0); }
		public DefineNaoVazioContext(ValidaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterDefineNaoVazio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitDefineNaoVazio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDefineNaoVazio(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparaAtributosContext extends ValidaContext {
		public AtributoContext left;
		public AtributoContext right;
		public ComparaContext compara() {
			return getRuleContext(ComparaContext.class,0);
		}
		public DecisaoContext decisao() {
			return getRuleContext(DecisaoContext.class,0);
		}
		public List<AtributoContext> atributo() {
			return getRuleContexts(AtributoContext.class);
		}
		public AtributoContext atributo(int i) {
			return getRuleContext(AtributoContext.class,i);
		}
		public ComparaAtributosContext(ValidaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterComparaAtributos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitComparaAtributos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitComparaAtributos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValidaContext valida() throws RecognitionException {
		ValidaContext _localctx = new ValidaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_valida);
		try {
			setState(28);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new DefineNaoVazioContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				atributo();
				setState(15);
				match(NAOVAZIO);
				}
				break;
			case 2:
				_localctx = new ComparaAtributosContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(17);
				((ComparaAtributosContext)_localctx).left = atributo();
				setState(18);
				compara();
				setState(19);
				((ComparaAtributosContext)_localctx).right = atributo();
				setState(20);
				decisao();
				}
				break;
			case 3:
				_localctx = new LimitaNomeAtributoContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(22);
				atributo();
				setState(23);
				nomes(0);
				}
				break;
			case 4:
				_localctx = new AtributoExpRegularContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(25);
				atributo();
				setState(26);
				match(EXPREGULAR);
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

	public static class ComparaContext extends ParserRuleContext {
		public TerminalNode NAOVAZIO() { return getToken(GramaticaParser.NAOVAZIO, 0); }
		public TerminalNode VAZIO() { return getToken(GramaticaParser.VAZIO, 0); }
		public TerminalNode NAME() { return getToken(GramaticaParser.NAME, 0); }
		public TerminalNode MENOR() { return getToken(GramaticaParser.MENOR, 0); }
		public TerminalNode MENORIGUAL() { return getToken(GramaticaParser.MENORIGUAL, 0); }
		public TerminalNode MAIOR() { return getToken(GramaticaParser.MAIOR, 0); }
		public TerminalNode MAIORIGUAL() { return getToken(GramaticaParser.MAIORIGUAL, 0); }
		public TerminalNode IGUAL() { return getToken(GramaticaParser.IGUAL, 0); }
		public ComparaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterCompara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitCompara(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitCompara(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparaContext compara() throws RecognitionException {
		ComparaContext _localctx = new ComparaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_compara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MENOR) | (1L << IGUAL) | (1L << MAIOR) | (1L << MENORIGUAL) | (1L << MAIORIGUAL) | (1L << NAOVAZIO) | (1L << VAZIO) | (1L << NAME))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class DecisaoContext extends ParserRuleContext {
		public TerminalNode NAOVAZIO() { return getToken(GramaticaParser.NAOVAZIO, 0); }
		public TerminalNode VAZIO() { return getToken(GramaticaParser.VAZIO, 0); }
		public DecisaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decisao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterDecisao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitDecisao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDecisao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecisaoContext decisao() throws RecognitionException {
		DecisaoContext _localctx = new DecisaoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decisao);
		try {
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case NAOVAZIO:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				match(NAOVAZIO);
				}
				break;
			case VAZIO:
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				match(VAZIO);
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

	public static class AtributoContext extends ParserRuleContext {
		public TerminalNode ATRIBUTO() { return getToken(GramaticaParser.ATRIBUTO, 0); }
		public TerminalNode NUMERO() { return getToken(GramaticaParser.NUMERO, 0); }
		public AtributoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atributo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterAtributo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitAtributo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAtributo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtributoContext atributo() throws RecognitionException {
		AtributoContext _localctx = new AtributoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_atributo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(ATRIBUTO);
			setState(38);
			match(NUMERO);
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

	public static class NomesContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(GramaticaParser.NAME, 0); }
		public NomesContext nomes() {
			return getRuleContext(NomesContext.class,0);
		}
		public NomesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nomes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterNomes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitNomes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitNomes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NomesContext nomes() throws RecognitionException {
		return nomes(0);
	}

	private NomesContext nomes(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NomesContext _localctx = new NomesContext(_ctx, _parentState);
		NomesContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_nomes, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(41);
			match(NAME);
			}
			_ctx.stop = _input.LT(-1);
			setState(47);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NomesContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_nomes);
					setState(43);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(44);
					match(NAME);
					}
					} 
				}
				setState(49);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return nomes_sempred((NomesContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean nomes_sempred(NomesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24\65\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\37\n\3\3\4\3\4\3\5\3\5\3\5\5\5&\n\5"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7\60\n\7\f\7\16\7\63\13\7\3\7\2\3\f"+
		"\b\2\4\6\b\n\f\2\3\5\2\7\13\r\16\20\20\2\64\2\16\3\2\2\2\4\36\3\2\2\2"+
		"\6 \3\2\2\2\b%\3\2\2\2\n\'\3\2\2\2\f*\3\2\2\2\16\17\5\4\3\2\17\3\3\2\2"+
		"\2\20\21\5\n\6\2\21\22\7\r\2\2\22\37\3\2\2\2\23\24\5\n\6\2\24\25\5\6\4"+
		"\2\25\26\5\n\6\2\26\27\5\b\5\2\27\37\3\2\2\2\30\31\5\n\6\2\31\32\5\f\7"+
		"\2\32\37\3\2\2\2\33\34\5\n\6\2\34\35\7\24\2\2\35\37\3\2\2\2\36\20\3\2"+
		"\2\2\36\23\3\2\2\2\36\30\3\2\2\2\36\33\3\2\2\2\37\5\3\2\2\2 !\t\2\2\2"+
		"!\7\3\2\2\2\"&\3\2\2\2#&\7\r\2\2$&\7\16\2\2%\"\3\2\2\2%#\3\2\2\2%$\3\2"+
		"\2\2&\t\3\2\2\2\'(\7\4\2\2()\7\17\2\2)\13\3\2\2\2*+\b\7\1\2+,\7\20\2\2"+
		",\61\3\2\2\2-.\f\4\2\2.\60\7\20\2\2/-\3\2\2\2\60\63\3\2\2\2\61/\3\2\2"+
		"\2\61\62\3\2\2\2\62\r\3\2\2\2\63\61\3\2\2\2\5\36%\61";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}