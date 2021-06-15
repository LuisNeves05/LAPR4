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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, COMMENT=6, TIPOAUSENCIA=7, DEFINE=8, 
		SE=9, MENOR=10, MENORIGUAL=11, ENTAO=12, NAOVAZIO=13, VAZIO=14, ENVIAR_EMAIL=15, 
		COLABORADOR_REQUERENTE=16, JAN=17, FEB=18, MAR=19, APR=20, MAY=21, JUN=22, 
		JUL=23, AUG=24, SEP=25, OCT=26, NOV=27, DEC=28, INT4=29, DIGIT=30, NUMERO=31, 
		INT=32, NAME=33, SPACES=34, SEPARATOR=35;
	public static final int
		RULE_parseEspecificao = 0, RULE_parseValidacao = 1, RULE_instructionEspecificacao = 2, 
		RULE_instructionValidacao = 3, RULE_servico1dataInicioFimEspecificacao = 4, 
		RULE_servico1dataInicioFimValidacao = 5, RULE_servico1Justificacao = 6, 
		RULE_dataInicio = 7, RULE_dataFim = 8, RULE_justificacao = 9, RULE_enviar_email = 10, 
		RULE_corpo_email = 11, RULE_calcula = 12, RULE_date = 13, RULE_month = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"parseEspecificao", "parseValidacao", "instructionEspecificacao", "instructionValidacao", 
			"servico1dataInicioFimEspecificacao", "servico1dataInicioFimValidacao", 
			"servico1Justificacao", "dataInicio", "dataFim", "justificacao", "enviar_email", 
			"corpo_email", "calcula", "date", "month"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'JUSTIFICADA'", "'*'", "'/'", "'+'", "'-'", null, null, "'DEFINE'", 
			"'SE'", "'MENOR'", "'MENORIGUAL'", "'ENTAO'", "'NAOVAZIO'", "'VAZIO'", 
			"'ENVIAR EMAIL'", "'COLABORADOR REQUERENTE'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "COMMENT", "TIPOAUSENCIA", "DEFINE", 
			"SE", "MENOR", "MENORIGUAL", "ENTAO", "NAOVAZIO", "VAZIO", "ENVIAR_EMAIL", 
			"COLABORADOR_REQUERENTE", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", 
			"AUG", "SEP", "OCT", "NOV", "DEC", "INT4", "DIGIT", "NUMERO", "INT", 
			"NAME", "SPACES", "SEPARATOR"
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

	public static class ParseEspecificaoContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GramaticaParser.EOF, 0); }
		public List<InstructionEspecificacaoContext> instructionEspecificacao() {
			return getRuleContexts(InstructionEspecificacaoContext.class);
		}
		public InstructionEspecificacaoContext instructionEspecificacao(int i) {
			return getRuleContext(InstructionEspecificacaoContext.class,i);
		}
		public ParseEspecificaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseEspecificao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterParseEspecificao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitParseEspecificao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitParseEspecificao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseEspecificaoContext parseEspecificao() throws RecognitionException {
		ParseEspecificaoContext _localctx = new ParseEspecificaoContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parseEspecificao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SE) | (1L << ENVIAR_EMAIL) | (1L << NAME))) != 0)) {
				{
				{
				setState(30);
				instructionEspecificacao();
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
			match(EOF);
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

	public static class ParseValidacaoContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GramaticaParser.EOF, 0); }
		public List<InstructionValidacaoContext> instructionValidacao() {
			return getRuleContexts(InstructionValidacaoContext.class);
		}
		public InstructionValidacaoContext instructionValidacao(int i) {
			return getRuleContext(InstructionValidacaoContext.class,i);
		}
		public ParseValidacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseValidacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterParseValidacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitParseValidacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitParseValidacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseValidacaoContext parseValidacao() throws RecognitionException {
		ParseValidacaoContext _localctx = new ParseValidacaoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_parseValidacao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(38);
				instructionValidacao();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
			match(EOF);
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

	public static class InstructionEspecificacaoContext extends ParserRuleContext {
		public Enviar_emailContext enviar_email() {
			return getRuleContext(Enviar_emailContext.class,0);
		}
		public Servico1dataInicioFimEspecificacaoContext servico1dataInicioFimEspecificacao() {
			return getRuleContext(Servico1dataInicioFimEspecificacaoContext.class,0);
		}
		public Servico1JustificacaoContext servico1Justificacao() {
			return getRuleContext(Servico1JustificacaoContext.class,0);
		}
		public InstructionEspecificacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructionEspecificacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterInstructionEspecificacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitInstructionEspecificacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitInstructionEspecificacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionEspecificacaoContext instructionEspecificacao() throws RecognitionException {
		InstructionEspecificacaoContext _localctx = new InstructionEspecificacaoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instructionEspecificacao);
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ENVIAR_EMAIL:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				enviar_email();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				servico1dataInicioFimEspecificacao();
				}
				break;
			case SE:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				servico1Justificacao();
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

	public static class InstructionValidacaoContext extends ParserRuleContext {
		public Servico1dataInicioFimValidacaoContext servico1dataInicioFimValidacao() {
			return getRuleContext(Servico1dataInicioFimValidacaoContext.class,0);
		}
		public InstructionValidacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructionValidacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterInstructionValidacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitInstructionValidacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitInstructionValidacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionValidacaoContext instructionValidacao() throws RecognitionException {
		InstructionValidacaoContext _localctx = new InstructionValidacaoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instructionValidacao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			servico1dataInicioFimValidacao();
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

	public static class Servico1dataInicioFimEspecificacaoContext extends ParserRuleContext {
		public DataInicioContext dataInicio() {
			return getRuleContext(DataInicioContext.class,0);
		}
		public TerminalNode MENORIGUAL() { return getToken(GramaticaParser.MENORIGUAL, 0); }
		public DataFimContext dataFim() {
			return getRuleContext(DataFimContext.class,0);
		}
		public Servico1dataInicioFimEspecificacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_servico1dataInicioFimEspecificacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterServico1dataInicioFimEspecificacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitServico1dataInicioFimEspecificacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitServico1dataInicioFimEspecificacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Servico1dataInicioFimEspecificacaoContext servico1dataInicioFimEspecificacao() throws RecognitionException {
		Servico1dataInicioFimEspecificacaoContext _localctx = new Servico1dataInicioFimEspecificacaoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_servico1dataInicioFimEspecificacao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			dataInicio();
			setState(54);
			match(MENORIGUAL);
			setState(55);
			dataFim();
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

	public static class Servico1dataInicioFimValidacaoContext extends ParserRuleContext {
		public DataInicioContext dataInicio() {
			return getRuleContext(DataInicioContext.class,0);
		}
		public DataFimContext dataFim() {
			return getRuleContext(DataFimContext.class,0);
		}
		public Servico1dataInicioFimValidacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_servico1dataInicioFimValidacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterServico1dataInicioFimValidacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitServico1dataInicioFimValidacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitServico1dataInicioFimValidacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Servico1dataInicioFimValidacaoContext servico1dataInicioFimValidacao() throws RecognitionException {
		Servico1dataInicioFimValidacaoContext _localctx = new Servico1dataInicioFimValidacaoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_servico1dataInicioFimValidacao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			dataInicio();
			setState(58);
			dataFim();
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

	public static class Servico1JustificacaoContext extends ParserRuleContext {
		public Token tipoAusencia;
		public TerminalNode SE() { return getToken(GramaticaParser.SE, 0); }
		public TerminalNode ENTAO() { return getToken(GramaticaParser.ENTAO, 0); }
		public JustificacaoContext justificacao() {
			return getRuleContext(JustificacaoContext.class,0);
		}
		public TerminalNode NAOVAZIO() { return getToken(GramaticaParser.NAOVAZIO, 0); }
		public TerminalNode NAME() { return getToken(GramaticaParser.NAME, 0); }
		public Servico1JustificacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_servico1Justificacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterServico1Justificacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitServico1Justificacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitServico1Justificacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Servico1JustificacaoContext servico1Justificacao() throws RecognitionException {
		Servico1JustificacaoContext _localctx = new Servico1JustificacaoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_servico1Justificacao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(SE);
			setState(61);
			((Servico1JustificacaoContext)_localctx).tipoAusencia = match(NAME);
			setState(62);
			match(T__0);
			setState(63);
			match(ENTAO);
			setState(64);
			justificacao();
			setState(65);
			match(NAOVAZIO);
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

	public static class DataInicioContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(GramaticaParser.NAME, 0); }
		public DataInicioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataInicio; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterDataInicio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitDataInicio(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDataInicio(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataInicioContext dataInicio() throws RecognitionException {
		DataInicioContext _localctx = new DataInicioContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dataInicio);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(NAME);
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

	public static class DataFimContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(GramaticaParser.NAME, 0); }
		public DataFimContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataFim; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterDataFim(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitDataFim(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDataFim(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataFimContext dataFim() throws RecognitionException {
		DataFimContext _localctx = new DataFimContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_dataFim);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(NAME);
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

	public static class JustificacaoContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(GramaticaParser.NAME, 0); }
		public JustificacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_justificacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterJustificacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitJustificacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitJustificacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JustificacaoContext justificacao() throws RecognitionException {
		JustificacaoContext _localctx = new JustificacaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_justificacao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(NAME);
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
		public TerminalNode ENVIAR_EMAIL() { return getToken(GramaticaParser.ENVIAR_EMAIL, 0); }
		public TerminalNode COLABORADOR_REQUERENTE() { return getToken(GramaticaParser.COLABORADOR_REQUERENTE, 0); }
		public Corpo_emailContext corpo_email() {
			return getRuleContext(Corpo_emailContext.class,0);
		}
		public Enviar_emailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enviar_email; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterEnviar_email(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitEnviar_email(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitEnviar_email(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Enviar_emailContext enviar_email() throws RecognitionException {
		Enviar_emailContext _localctx = new Enviar_emailContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_enviar_email);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(ENVIAR_EMAIL);
			setState(74);
			match(COLABORADOR_REQUERENTE);
			setState(75);
			corpo_email(0);
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
		public TerminalNode NAME() { return getToken(GramaticaParser.NAME, 0); }
		public CalculaContext calcula() {
			return getRuleContext(CalculaContext.class,0);
		}
		public Corpo_emailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpo_email; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterCorpo_email(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitCorpo_email(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitCorpo_email(this);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_corpo_email, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(84);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(82);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new Corpo_emailContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_corpo_email);
						setState(78);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(79);
						match(NAME);
						}
						break;
					case 2:
						{
						_localctx = new Corpo_emailContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_corpo_email);
						setState(80);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(81);
						calcula(0);
						}
						break;
					}
					} 
				}
				setState(86);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterOpExprMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitOpExprMulDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitOpExprMulDiv(this);
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
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterOpExprSumDif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitOpExprSumDif(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitOpExprSumDif(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomExprContext extends CalculaContext {
		public Token atom;
		public TerminalNode INT() { return getToken(GramaticaParser.INT, 0); }
		public AtomExprContext(CalculaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitAtomExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitAtomExpr(this);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_calcula, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new AtomExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(88);
			((AtomExprContext)_localctx).atom = match(INT);
			}
			_ctx.stop = _input.LT(-1);
			setState(98);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(96);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new OpExprMulDivContext(new CalculaContext(_parentctx, _parentState));
						((OpExprMulDivContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_calcula);
						setState(90);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(91);
						((OpExprMulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__1 || _la==T__2) ) {
							((OpExprMulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(92);
						((OpExprMulDivContext)_localctx).right = calcula(4);
						}
						break;
					case 2:
						{
						_localctx = new OpExprSumDifContext(new CalculaContext(_parentctx, _parentState));
						((OpExprSumDifContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_calcula);
						setState(93);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(94);
						((OpExprSumDifContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__3 || _la==T__4) ) {
							((OpExprSumDifContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(95);
						((OpExprSumDifContext)_localctx).right = calcula(3);
						}
						break;
					}
					} 
				}
				setState(100);
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

	public static class DateContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(GramaticaParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(GramaticaParser.INT, i);
		}
		public List<TerminalNode> SEPARATOR() { return getTokens(GramaticaParser.SEPARATOR); }
		public TerminalNode SEPARATOR(int i) {
			return getToken(GramaticaParser.SEPARATOR, i);
		}
		public MonthContext month() {
			return getRuleContext(MonthContext.class,0);
		}
		public TerminalNode INT4() { return getToken(GramaticaParser.INT4, 0); }
		public DateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateContext date() throws RecognitionException {
		DateContext _localctx = new DateContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_date);
		try {
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(INT);
				setState(102);
				match(SEPARATOR);
				setState(103);
				month();
				setState(104);
				match(SEPARATOR);
				setState(105);
				match(INT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(INT);
				setState(108);
				match(SEPARATOR);
				setState(109);
				month();
				setState(110);
				match(SEPARATOR);
				setState(111);
				match(INT4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				match(INT);
				setState(114);
				match(SEPARATOR);
				setState(115);
				match(INT);
				setState(116);
				match(SEPARATOR);
				setState(117);
				match(INT4);
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

	public static class MonthContext extends ParserRuleContext {
		public TerminalNode JAN() { return getToken(GramaticaParser.JAN, 0); }
		public TerminalNode FEB() { return getToken(GramaticaParser.FEB, 0); }
		public TerminalNode MAR() { return getToken(GramaticaParser.MAR, 0); }
		public TerminalNode APR() { return getToken(GramaticaParser.APR, 0); }
		public TerminalNode MAY() { return getToken(GramaticaParser.MAY, 0); }
		public TerminalNode JUN() { return getToken(GramaticaParser.JUN, 0); }
		public TerminalNode JUL() { return getToken(GramaticaParser.JUL, 0); }
		public TerminalNode AUG() { return getToken(GramaticaParser.AUG, 0); }
		public TerminalNode SEP() { return getToken(GramaticaParser.SEP, 0); }
		public TerminalNode OCT() { return getToken(GramaticaParser.OCT, 0); }
		public TerminalNode NOV() { return getToken(GramaticaParser.NOV, 0); }
		public TerminalNode DEC() { return getToken(GramaticaParser.DEC, 0); }
		public MonthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_month; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).enterMonth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramaticaListener ) ((GramaticaListener)listener).exitMonth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramaticaVisitor ) return ((GramaticaVisitor<? extends T>)visitor).visitMonth(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MonthContext month() throws RecognitionException {
		MonthContext _localctx = new MonthContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_month);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << JAN) | (1L << FEB) | (1L << MAR) | (1L << APR) | (1L << MAY) | (1L << JUN) | (1L << JUL) | (1L << AUG) | (1L << SEP) | (1L << OCT) | (1L << NOV) | (1L << DEC))) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return corpo_email_sempred((Corpo_emailContext)_localctx, predIndex);
		case 12:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%}\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f"+
		"\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\7\2\"\n\2\f\2\16\2%\13"+
		"\2\3\2\3\2\3\3\7\3*\n\3\f\3\16\3-\13\3\3\3\3\3\3\4\3\4\3\4\5\4\64\n\4"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\7\rU\n\r\f\r"+
		"\16\rX\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16c\n\16\f"+
		"\16\16\16f\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17y\n\17\3\20\3\20\3\20\2\4\30\32\21"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\5\3\2\4\5\3\2\6\7\3\2\23\36"+
		"\2w\2#\3\2\2\2\4+\3\2\2\2\6\63\3\2\2\2\b\65\3\2\2\2\n\67\3\2\2\2\f;\3"+
		"\2\2\2\16>\3\2\2\2\20E\3\2\2\2\22G\3\2\2\2\24I\3\2\2\2\26K\3\2\2\2\30"+
		"O\3\2\2\2\32Y\3\2\2\2\34x\3\2\2\2\36z\3\2\2\2 \"\5\6\4\2! \3\2\2\2\"%"+
		"\3\2\2\2#!\3\2\2\2#$\3\2\2\2$&\3\2\2\2%#\3\2\2\2&\'\7\2\2\3\'\3\3\2\2"+
		"\2(*\5\b\5\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2"+
		"\2./\7\2\2\3/\5\3\2\2\2\60\64\5\26\f\2\61\64\5\n\6\2\62\64\5\16\b\2\63"+
		"\60\3\2\2\2\63\61\3\2\2\2\63\62\3\2\2\2\64\7\3\2\2\2\65\66\5\f\7\2\66"+
		"\t\3\2\2\2\678\5\20\t\289\7\r\2\29:\5\22\n\2:\13\3\2\2\2;<\5\20\t\2<="+
		"\5\22\n\2=\r\3\2\2\2>?\7\13\2\2?@\7#\2\2@A\7\3\2\2AB\7\16\2\2BC\5\24\13"+
		"\2CD\7\17\2\2D\17\3\2\2\2EF\7#\2\2F\21\3\2\2\2GH\7#\2\2H\23\3\2\2\2IJ"+
		"\7#\2\2J\25\3\2\2\2KL\7\21\2\2LM\7\22\2\2MN\5\30\r\2N\27\3\2\2\2OV\b\r"+
		"\1\2PQ\f\4\2\2QU\7#\2\2RS\f\3\2\2SU\5\32\16\2TP\3\2\2\2TR\3\2\2\2UX\3"+
		"\2\2\2VT\3\2\2\2VW\3\2\2\2W\31\3\2\2\2XV\3\2\2\2YZ\b\16\1\2Z[\7\"\2\2"+
		"[d\3\2\2\2\\]\f\5\2\2]^\t\2\2\2^c\5\32\16\6_`\f\4\2\2`a\t\3\2\2ac\5\32"+
		"\16\5b\\\3\2\2\2b_\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2e\33\3\2\2\2f"+
		"d\3\2\2\2gh\7\"\2\2hi\7%\2\2ij\5\36\20\2jk\7%\2\2kl\7\"\2\2ly\3\2\2\2"+
		"mn\7\"\2\2no\7%\2\2op\5\36\20\2pq\7%\2\2qr\7\37\2\2ry\3\2\2\2st\7\"\2"+
		"\2tu\7%\2\2uv\7\"\2\2vw\7%\2\2wy\7\37\2\2xg\3\2\2\2xm\3\2\2\2xs\3\2\2"+
		"\2y\35\3\2\2\2z{\t\4\2\2{\37\3\2\2\2\n#+\63TVbdx";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}