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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, MENOR=8, IGUAL=9, 
		MAIOR=10, MENORIGUAL=11, MAIORIGUAL=12, ATRIBUTO=13, ENVIAR_EMAIL=14, 
		COLABORADOR_REQUERENTE=15, NUMERO=16, FICHEIRO=17, XML=18, NAME=19, COMMENT=20, 
		SPACES=21;
	public static final int
		RULE_prog = 0, RULE_executa = 1, RULE_enviar_email = 2, RULE_corpo_email = 3, 
		RULE_pesquisa_xml = 4, RULE_desconto = 5, RULE_desconto_aplica = 6, RULE_compara = 7, 
		RULE_numero = 8, RULE_nome_ficheiro = 9, RULE_calcula = 10, RULE_atributo = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "executa", "enviar_email", "corpo_email", "pesquisa_xml", "desconto", 
			"desconto_aplica", "compara", "numero", "nome_ficheiro", "calcula", "atributo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'SE'", "'ENTAO'", "'SENAO'", "'*'", "'/'", "'+'", "'-'", "'MENOR'", 
			"'IGUAL'", "'MAIOR'", "'MENORIGUAL'", "'MAIORIGUAL'", "'ATRIBUTO'", "'ENVIAR EMAIL'", 
			"'COLABORADOR REQUERENTE'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "MENOR", "IGUAL", "MAIOR", 
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
		public Enviar_emailContext enviar_email() {
			return getRuleContext(Enviar_emailContext.class,0);
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
			setState(28);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FICHEIRO:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				pesquisa_xml();
				}
				break;
			case EOF:
			case ENVIAR_EMAIL:
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
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
		enterRule(_localctx, 4, RULE_enviar_email);
		try {
			setState(34);
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
				setState(31);
				match(ENVIAR_EMAIL);
				setState(32);
				match(COLABORADOR_REQUERENTE);
				setState(33);
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_corpo_email, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(41);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new Corpo_emailContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_corpo_email);
						setState(37);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(38);
						match(NAME);
						}
						break;
					case 2:
						{
						_localctx = new Corpo_emailContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_corpo_email);
						setState(39);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(40);
						calcula(0);
						}
						break;
					}
					} 
				}
				setState(45);
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

	public static class Pesquisa_xmlContext extends ParserRuleContext {
		public AtributoContext id_a_pesquisar;
		public Nome_ficheiroContext nome_ficheiro() {
			return getRuleContext(Nome_ficheiroContext.class,0);
		}
		public Enviar_emailContext enviar_email() {
			return getRuleContext(Enviar_emailContext.class,0);
		}
		public AtributoContext atributo() {
			return getRuleContext(AtributoContext.class,0);
		}
		public List<DescontoContext> desconto() {
			return getRuleContexts(DescontoContext.class);
		}
		public DescontoContext desconto(int i) {
			return getRuleContext(DescontoContext.class,i);
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
		enterRule(_localctx, 8, RULE_pesquisa_xml);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			nome_ficheiro();
			setState(47);
			((Pesquisa_xmlContext)_localctx).id_a_pesquisar = atributo();
			setState(49); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(48);
				desconto();
				}
				}
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 || _la==T__2 );
			setState(53);
			enviar_email();
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

	public static class DescontoContext extends ParserRuleContext {
		public NumeroContext limite;
		public AtributoContext atributo() {
			return getRuleContext(AtributoContext.class,0);
		}
		public ComparaContext compara() {
			return getRuleContext(ComparaContext.class,0);
		}
		public Desconto_aplicaContext desconto_aplica() {
			return getRuleContext(Desconto_aplicaContext.class,0);
		}
		public NumeroContext numero() {
			return getRuleContext(NumeroContext.class,0);
		}
		public DescontoContext desconto() {
			return getRuleContext(DescontoContext.class,0);
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
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				match(T__0);
				setState(56);
				atributo();
				setState(57);
				compara();
				setState(58);
				((DescontoContext)_localctx).limite = numero();
				setState(59);
				match(T__1);
				setState(60);
				desconto_aplica();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				match(T__2);
				setState(63);
				desconto();
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
			setState(66);
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
		enterRule(_localctx, 14, RULE_compara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
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
		enterRule(_localctx, 16, RULE_numero);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
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

	public static class Nome_ficheiroContext extends ParserRuleContext {
		public TerminalNode FICHEIRO() { return getToken(TarefaAutomaticaParser.FICHEIRO, 0); }
		public Nome_ficheiroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nome_ficheiro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).enterNome_ficheiro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TarefaAutomaticaListener ) ((TarefaAutomaticaListener)listener).exitNome_ficheiro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TarefaAutomaticaVisitor ) return ((TarefaAutomaticaVisitor<? extends T>)visitor).visitNome_ficheiro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nome_ficheiroContext nome_ficheiro() throws RecognitionException {
		Nome_ficheiroContext _localctx = new Nome_ficheiroContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_nome_ficheiro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(FICHEIRO);
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

			setState(75);
			((AtomExprContext)_localctx).atom = match(NUMERO);
			}
			_ctx.stop = _input.LT(-1);
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(83);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new OpExprMulDivContext(new CalculaContext(_parentctx, _parentState));
						((OpExprMulDivContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_calcula);
						setState(77);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(78);
						((OpExprMulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__3 || _la==T__4) ) {
							((OpExprMulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(79);
						((OpExprMulDivContext)_localctx).right = calcula(4);
						}
						break;
					case 2:
						{
						_localctx = new OpExprSumDifContext(new CalculaContext(_parentctx, _parentState));
						((OpExprSumDifContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_calcula);
						setState(80);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(81);
						((OpExprSumDifContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==T__6) ) {
							((OpExprSumDifContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(82);
						((OpExprSumDifContext)_localctx).right = calcula(3);
						}
						break;
					}
					} 
				}
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
			setState(88);
			match(ATRIBUTO);
			setState(89);
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
		case 3:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27^\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\5\3\37\n\3\3\4\3\4\3\4\3\4\5\4%\n\4\3\5"+
		"\3\5\3\5\3\5\3\5\7\5,\n\5\f\5\16\5/\13\5\3\6\3\6\3\6\6\6\64\n\6\r\6\16"+
		"\6\65\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7C\n\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\fV\n\f\f"+
		"\f\16\fY\13\f\3\r\3\r\3\r\3\r\2\4\b\26\16\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\2\5\3\2\n\16\3\2\6\7\3\2\b\t\2Y\2\32\3\2\2\2\4\36\3\2\2\2\6$\3\2\2\2"+
		"\b&\3\2\2\2\n\60\3\2\2\2\fB\3\2\2\2\16D\3\2\2\2\20F\3\2\2\2\22H\3\2\2"+
		"\2\24J\3\2\2\2\26L\3\2\2\2\30Z\3\2\2\2\32\33\5\4\3\2\33\3\3\2\2\2\34\37"+
		"\5\n\6\2\35\37\5\6\4\2\36\34\3\2\2\2\36\35\3\2\2\2\37\5\3\2\2\2 %\3\2"+
		"\2\2!\"\7\20\2\2\"#\7\21\2\2#%\5\b\5\2$ \3\2\2\2$!\3\2\2\2%\7\3\2\2\2"+
		"&-\b\5\1\2\'(\f\4\2\2(,\7\25\2\2)*\f\3\2\2*,\5\26\f\2+\'\3\2\2\2+)\3\2"+
		"\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\t\3\2\2\2/-\3\2\2\2\60\61\5\24\13"+
		"\2\61\63\5\30\r\2\62\64\5\f\7\2\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2"+
		"\2\2\65\66\3\2\2\2\66\67\3\2\2\2\678\5\6\4\28\13\3\2\2\29:\7\3\2\2:;\5"+
		"\30\r\2;<\5\20\t\2<=\5\22\n\2=>\7\4\2\2>?\5\16\b\2?C\3\2\2\2@A\7\5\2\2"+
		"AC\5\f\7\2B9\3\2\2\2B@\3\2\2\2C\r\3\2\2\2DE\7\22\2\2E\17\3\2\2\2FG\t\2"+
		"\2\2G\21\3\2\2\2HI\7\22\2\2I\23\3\2\2\2JK\7\23\2\2K\25\3\2\2\2LM\b\f\1"+
		"\2MN\7\22\2\2NW\3\2\2\2OP\f\5\2\2PQ\t\3\2\2QV\5\26\f\6RS\f\4\2\2ST\t\4"+
		"\2\2TV\5\26\f\5UO\3\2\2\2UR\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\27"+
		"\3\2\2\2YW\3\2\2\2Z[\7\17\2\2[\\\7\22\2\2\\\31\3\2\2\2\n\36$+-\65BUW";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}