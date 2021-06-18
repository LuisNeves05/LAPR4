// Generated from C:/Users/luism/Desktop/lei20_21_s4_2dl_4/base.core/src/main/java/eapli/base/formulario/gramatica\TarefaAutomatica.g4 by ANTLR 4.9.1
package eapli.base.formulario.gramatica.eapli.base.formulario.gramatica;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TarefaAutomaticaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, MENOR=7, IGUAL=8, MAIOR=9, 
		MENORIGUAL=10, MAIORIGUAL=11, ATRIBUTO=12, ENVIAR_EMAIL=13, COLABORADOR_REQUERENTE=14, 
		NUMERO=15, FICHEIRO=16, XML=17, NAME=18, COMMENT=19, SPACES=20;
	public static final int
		RULE_prog = 0, RULE_executa = 1, RULE_pesquisa_xml = 2, RULE_enviar_email = 3, 
		RULE_corpo_email = 4, RULE_desconto = 5, RULE_desconto_aplica = 6, RULE_se_categoria = 7, 
		RULE_compara = 8, RULE_numero = 9, RULE_calcula = 10, RULE_atributo = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "executa", "pesquisa_xml", "enviar_email", "corpo_email", "desconto", 
			"desconto_aplica", "se_categoria", "compara", "numero", "calcula", "atributo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'SE'", "'ENTAO'", "'*'", "'/'", "'+'", "'-'", "'MENOR'", "'IGUAL'", 
			"'MAIOR'", "'MENORIGUAL'", "'MAIORIGUAL'", "'ATRIBUTO'", "'ENVIAR EMAIL'", 
			"'COLABORADOR REQUERENTE'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "MENOR", "IGUAL", "MAIOR", 
			"MENORIGUAL", "MAIORIGUAL", "ATRIBUTO", "ENVIAR_EMAIL", "COLABORADOR_REQUERENTE", 
			"NUMERO", "FICHEIRO", "XML", "NAME", "COMMENT", "SPACES"
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
	public String getGrammarFileName() { return "TarefaAutomatica.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TarefaAutomaticaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public ExecutaContext executa() {
			return getRuleContext(ExecutaContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TarefaAutomaticaVisitor ) return ((TarefaAutomaticaVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			executa();
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

	public static class ExecutaContext extends ParserRuleContext {
		public Pesquisa_xmlContext pesquisa_xml() {
			return getRuleContext(Pesquisa_xmlContext.class,0);
		}
		public ExecutaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_executa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).enterExecuta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).exitExecuta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TarefaAutomaticaVisitor ) return ((TarefaAutomaticaVisitor<? extends T>)visitor).visitExecuta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExecutaContext executa() throws RecognitionException {
		ExecutaContext _localctx = new ExecutaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_executa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			pesquisa_xml();
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

	public static class Pesquisa_xmlContext extends ParserRuleContext {
		public AtributoContext nome_ficheiro;
		public AtributoContext id_a_pesquisar;
		public DescontoContext desconto() {
			return getRuleContext(DescontoContext.class,0);
		}
		public Enviar_emailContext enviar_email() {
			return getRuleContext(Enviar_emailContext.class,0);
		}
		public List<AtributoContext> atributo() {
			return getRuleContexts(AtributoContext.class);
		}
		public AtributoContext atributo(int i) {
			return getRuleContext(AtributoContext.class,i);
		}
		public Pesquisa_xmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pesquisa_xml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).enterPesquisa_xml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).exitPesquisa_xml(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TarefaAutomaticaVisitor ) return ((TarefaAutomaticaVisitor<? extends T>)visitor).visitPesquisa_xml(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pesquisa_xmlContext pesquisa_xml() throws RecognitionException {
		Pesquisa_xmlContext _localctx = new Pesquisa_xmlContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pesquisa_xml);
		try {
			setState(34);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATRIBUTO:
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				((Pesquisa_xmlContext)_localctx).nome_ficheiro = atributo();
				setState(29);
				((Pesquisa_xmlContext)_localctx).id_a_pesquisar = atributo();
				setState(30);
				desconto();
				setState(31);
				enviar_email();
				}
				break;
			case EOF:
			case ENVIAR_EMAIL:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				enviar_email();
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

	public static class Enviar_emailContext extends ParserRuleContext {
		public TerminalNode ENVIAR_EMAIL() { return getToken(TarefaAutomaticaParser.ENVIAR_EMAIL, 0); }
		public TerminalNode COLABORADOR_REQUERENTE() { return getToken(TarefaAutomaticaParser.COLABORADOR_REQUERENTE, 0); }
		public Corpo_emailContext corpo_email() {
			return getRuleContext(Corpo_emailContext.class,0);
		}
		public Enviar_emailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enviar_email; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).enterEnviar_email(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).exitEnviar_email(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TarefaAutomaticaVisitor ) return ((TarefaAutomaticaVisitor<? extends T>)visitor).visitEnviar_email(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Enviar_emailContext enviar_email() throws RecognitionException {
		Enviar_emailContext _localctx = new Enviar_emailContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_enviar_email);
		try {
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case ENVIAR_EMAIL:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				match(ENVIAR_EMAIL);
				setState(38);
				match(COLABORADOR_REQUERENTE);
				setState(39);
				corpo_email(0);
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

	public static class Corpo_emailContext extends ParserRuleContext {
		public Corpo_emailContext corpo_email() {
			return getRuleContext(Corpo_emailContext.class,0);
		}
		public TerminalNode NAME() { return getToken(TarefaAutomaticaParser.NAME, 0); }
		public CalculaContext calcula() {
			return getRuleContext(CalculaContext.class,0);
		}
		public Corpo_emailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpo_email; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).enterCorpo_email(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).exitCorpo_email(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TarefaAutomaticaVisitor ) return ((TarefaAutomaticaVisitor<? extends T>)visitor).visitCorpo_email(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Corpo_emailContext corpo_email() throws RecognitionException {
		return corpo_email(0);
	}

	private Corpo_emailContext corpo_email(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Corpo_emailContext _localctx = new Corpo_emailContext(_ctx, _parentState);
		Corpo_emailContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_corpo_email, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(49);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(47);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new Corpo_emailContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_corpo_email);
						setState(43);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(44);
						match(NAME);
						}
						break;
					case 2:
						{
						_localctx = new Corpo_emailContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_corpo_email);
						setState(45);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(46);
						calcula(0);
						}
						break;
					}
					} 
				}
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class DescontoContext extends ParserRuleContext {
		public AtributoContext atribquanti;
		public NumeroContext limite;
		public ComparaContext compara() {
			return getRuleContext(ComparaContext.class,0);
		}
		public Desconto_aplicaContext desconto_aplica() {
			return getRuleContext(Desconto_aplicaContext.class,0);
		}
		public Se_categoriaContext se_categoria() {
			return getRuleContext(Se_categoriaContext.class,0);
		}
		public AtributoContext atributo() {
			return getRuleContext(AtributoContext.class,0);
		}
		public NumeroContext numero() {
			return getRuleContext(NumeroContext.class,0);
		}
		public DescontoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_desconto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).enterDesconto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).exitDesconto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TarefaAutomaticaVisitor ) return ((TarefaAutomaticaVisitor<? extends T>)visitor).visitDesconto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescontoContext desconto() throws RecognitionException {
		DescontoContext _localctx = new DescontoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_desconto);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(T__0);
			setState(53);
			((DescontoContext)_localctx).atribquanti = atributo();
			setState(54);
			compara();
			setState(55);
			((DescontoContext)_localctx).limite = numero();
			setState(56);
			match(T__1);
			setState(57);
			desconto_aplica();
			setState(58);
			se_categoria();
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

	public static class Desconto_aplicaContext extends ParserRuleContext {
		public TerminalNode NUMERO() { return getToken(TarefaAutomaticaParser.NUMERO, 0); }
		public Desconto_aplicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_desconto_aplica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).enterDesconto_aplica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).exitDesconto_aplica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TarefaAutomaticaVisitor ) return ((TarefaAutomaticaVisitor<? extends T>)visitor).visitDesconto_aplica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Desconto_aplicaContext desconto_aplica() throws RecognitionException {
		Desconto_aplicaContext _localctx = new Desconto_aplicaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_desconto_aplica);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
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

	public static class Se_categoriaContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(TarefaAutomaticaParser.NAME, 0); }
		public Desconto_aplicaContext desconto_aplica() {
			return getRuleContext(Desconto_aplicaContext.class,0);
		}
		public Se_categoriaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_se_categoria; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).enterSe_categoria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).exitSe_categoria(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TarefaAutomaticaVisitor ) return ((TarefaAutomaticaVisitor<? extends T>)visitor).visitSe_categoria(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Se_categoriaContext se_categoria() throws RecognitionException {
		Se_categoriaContext _localctx = new Se_categoriaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_se_categoria);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__0);
			setState(63);
			match(NAME);
			setState(64);
			match(T__1);
			setState(65);
			desconto_aplica();
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
		public TerminalNode MENOR() { return getToken(TarefaAutomaticaParser.MENOR, 0); }
		public TerminalNode MENORIGUAL() { return getToken(TarefaAutomaticaParser.MENORIGUAL, 0); }
		public TerminalNode MAIOR() { return getToken(TarefaAutomaticaParser.MAIOR, 0); }
		public TerminalNode MAIORIGUAL() { return getToken(TarefaAutomaticaParser.MAIORIGUAL, 0); }
		public TerminalNode IGUAL() { return getToken(TarefaAutomaticaParser.IGUAL, 0); }
		public ComparaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).enterCompara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).exitCompara(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TarefaAutomaticaVisitor ) return ((TarefaAutomaticaVisitor<? extends T>)visitor).visitCompara(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparaContext compara() throws RecognitionException {
		ComparaContext _localctx = new ComparaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_compara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MENOR) | (1L << IGUAL) | (1L << MAIOR) | (1L << MENORIGUAL) | (1L << MAIORIGUAL))) != 0)) ) {
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

	public static class NumeroContext extends ParserRuleContext {
		public TerminalNode NUMERO() { return getToken(TarefaAutomaticaParser.NUMERO, 0); }
		public NumeroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numero; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).enterNumero(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).exitNumero(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TarefaAutomaticaVisitor ) return ((TarefaAutomaticaVisitor<? extends T>)visitor).visitNumero(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumeroContext numero() throws RecognitionException {
		NumeroContext _localctx = new NumeroContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_numero);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
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

	public static class CalculaContext extends ParserRuleContext {
		public CalculaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcula; }
	 
		public CalculaContext() { }
		public void copyFrom(CalculaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OpExprMulDivContext extends CalculaContext {
		public CalculaContext left;
		public Token op;
		public CalculaContext right;
		public List<CalculaContext> calcula() {
			return getRuleContexts(CalculaContext.class);
		}
		public CalculaContext calcula(int i) {
			return getRuleContext(CalculaContext.class,i);
		}
		public OpExprMulDivContext(CalculaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).enterOpExprMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).exitOpExprMulDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TarefaAutomaticaVisitor ) return ((TarefaAutomaticaVisitor<? extends T>)visitor).visitOpExprMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpExprSumDifContext extends CalculaContext {
		public CalculaContext left;
		public Token op;
		public CalculaContext right;
		public List<CalculaContext> calcula() {
			return getRuleContexts(CalculaContext.class);
		}
		public CalculaContext calcula(int i) {
			return getRuleContext(CalculaContext.class,i);
		}
		public OpExprSumDifContext(CalculaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).enterOpExprSumDif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).exitOpExprSumDif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TarefaAutomaticaVisitor ) return ((TarefaAutomaticaVisitor<? extends T>)visitor).visitOpExprSumDif(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomExprContext extends CalculaContext {
		public Token atom;
		public TerminalNode NUMERO() { return getToken(TarefaAutomaticaParser.NUMERO, 0); }
		public AtomExprContext(CalculaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).enterAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).exitAtomExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TarefaAutomaticaVisitor ) return ((TarefaAutomaticaVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalculaContext calcula() throws RecognitionException {
		return calcula(0);
	}

	private CalculaContext calcula(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CalculaContext _localctx = new CalculaContext(_ctx, _parentState);
		CalculaContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_calcula, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new AtomExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(72);
			((AtomExprContext)_localctx).atom = match(NUMERO);
			}
			_ctx.stop = _input.LT(-1);
			setState(82);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(80);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new OpExprMulDivContext(new CalculaContext(_parentctx, _parentState));
						((OpExprMulDivContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_calcula);
						setState(74);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(75);
						((OpExprMulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__2 || _la==T__3) ) {
							((OpExprMulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(76);
						((OpExprMulDivContext)_localctx).right = calcula(4);
						}
						break;
					case 2:
						{
						_localctx = new OpExprSumDifContext(new CalculaContext(_parentctx, _parentState));
						((OpExprSumDifContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_calcula);
						setState(77);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(78);
						((OpExprSumDifContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5) ) {
							((OpExprSumDifContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(79);
						((OpExprSumDifContext)_localctx).right = calcula(3);
						}
						break;
					}
					} 
				}
				setState(84);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class AtributoContext extends ParserRuleContext {
		public TerminalNode ATRIBUTO() { return getToken(TarefaAutomaticaParser.ATRIBUTO, 0); }
		public TerminalNode NUMERO() { return getToken(TarefaAutomaticaParser.NUMERO, 0); }
		public AtributoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atributo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).enterAtributo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).exitAtributo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TarefaAutomaticaVisitor ) return ((TarefaAutomaticaVisitor<? extends T>)visitor).visitAtributo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtributoContext atributo() throws RecognitionException {
		AtributoContext _localctx = new AtributoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_atributo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(ATRIBUTO);
			setState(86);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return corpo_email_sempred((Corpo_emailContext)_localctx, predIndex);
		case 10:
			return calcula_sempred((CalculaContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean corpo_email_sempred(Corpo_emailContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean calcula_sempred(CalculaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26[\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4%\n\4\3\5\3"+
		"\5\3\5\3\5\5\5+\n\5\3\6\3\6\3\6\3\6\3\6\7\6\62\n\6\f\6\16\6\65\13\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\fS\n\f\f\f\16\fV\13\f\3\r"+
		"\3\r\3\r\3\r\2\4\n\26\16\2\4\6\b\n\f\16\20\22\24\26\30\2\5\3\2\t\r\3\2"+
		"\5\6\3\2\7\b\2T\2\32\3\2\2\2\4\34\3\2\2\2\6$\3\2\2\2\b*\3\2\2\2\n,\3\2"+
		"\2\2\f\66\3\2\2\2\16>\3\2\2\2\20@\3\2\2\2\22E\3\2\2\2\24G\3\2\2\2\26I"+
		"\3\2\2\2\30W\3\2\2\2\32\33\5\4\3\2\33\3\3\2\2\2\34\35\5\6\4\2\35\5\3\2"+
		"\2\2\36\37\5\30\r\2\37 \5\30\r\2 !\5\f\7\2!\"\5\b\5\2\"%\3\2\2\2#%\5\b"+
		"\5\2$\36\3\2\2\2$#\3\2\2\2%\7\3\2\2\2&+\3\2\2\2\'(\7\17\2\2()\7\20\2\2"+
		")+\5\n\6\2*&\3\2\2\2*\'\3\2\2\2+\t\3\2\2\2,\63\b\6\1\2-.\f\4\2\2.\62\7"+
		"\24\2\2/\60\f\3\2\2\60\62\5\26\f\2\61-\3\2\2\2\61/\3\2\2\2\62\65\3\2\2"+
		"\2\63\61\3\2\2\2\63\64\3\2\2\2\64\13\3\2\2\2\65\63\3\2\2\2\66\67\7\3\2"+
		"\2\678\5\30\r\289\5\22\n\29:\5\24\13\2:;\7\4\2\2;<\5\16\b\2<=\5\20\t\2"+
		"=\r\3\2\2\2>?\7\21\2\2?\17\3\2\2\2@A\7\3\2\2AB\7\24\2\2BC\7\4\2\2CD\5"+
		"\16\b\2D\21\3\2\2\2EF\t\2\2\2F\23\3\2\2\2GH\7\21\2\2H\25\3\2\2\2IJ\b\f"+
		"\1\2JK\7\21\2\2KT\3\2\2\2LM\f\5\2\2MN\t\3\2\2NS\5\26\f\6OP\f\4\2\2PQ\t"+
		"\4\2\2QS\5\26\f\5RL\3\2\2\2RO\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2U\27"+
		"\3\2\2\2VT\3\2\2\2WX\7\16\2\2XY\7\21\2\2Y\31\3\2\2\2\b$*\61\63RT";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}