// Generated from C:/Users/luism/Desktop/lei20_21_s4_2dl_4/base.core/src/main/java/eapli/base/formulario/gramatica\TarefaAutomatica.g4 by ANTLR 4.9.1
package eapli.base.formulario.gramatica.eapli.base.formulario.gramatica;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TarefaAutomaticaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, MENOR=7, IGUAL=8, MAIOR=9, 
		MENORIGUAL=10, MAIORIGUAL=11, ATRIBUTO=12, ENVIAR_EMAIL=13, COLABORADOR_REQUERENTE=14, 
		NUMERO=15, FICHEIRO=16, XML=17, NAME=18, COMMENT=19, SPACES=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "MENOR", "IGUAL", "MAIOR", 
			"MENORIGUAL", "MAIORIGUAL", "ATRIBUTO", "ENVIAR_EMAIL", "COLABORADOR_REQUERENTE", 
			"NUMERO", "FICHEIRO", "XML", "NAME", "COMMENT", "SPACES"
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


	public TarefaAutomaticaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TarefaAutomatica.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u00bb\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\7\20\u0094\n\20\f\20\16\20\u0097\13\20\3\21\7\21\u009a\n\21"+
		"\f\21\16\21\u009d\13\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\5"+
		"\22\u00a8\n\22\3\23\6\23\u00ab\n\23\r\23\16\23\u00ac\3\24\3\24\7\24\u00b1"+
		"\n\24\f\24\16\24\u00b4\13\24\3\24\3\24\3\25\3\25\3\25\3\25\3\u009b\2\26"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26\3\2\6\3\2\62;\4\2C\\c|\5\2\f\f\17\17\"\"\4"+
		"\2\13\13\"\"\2\u00bf\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2"+
		"\5.\3\2\2\2\7\64\3\2\2\2\t\66\3\2\2\2\138\3\2\2\2\r:\3\2\2\2\17<\3\2\2"+
		"\2\21B\3\2\2\2\23H\3\2\2\2\25N\3\2\2\2\27Y\3\2\2\2\31d\3\2\2\2\33m\3\2"+
		"\2\2\35z\3\2\2\2\37\u0091\3\2\2\2!\u009b\3\2\2\2#\u00a7\3\2\2\2%\u00aa"+
		"\3\2\2\2\'\u00ae\3\2\2\2)\u00b7\3\2\2\2+,\7U\2\2,-\7G\2\2-\4\3\2\2\2."+
		"/\7G\2\2/\60\7P\2\2\60\61\7V\2\2\61\62\7C\2\2\62\63\7Q\2\2\63\6\3\2\2"+
		"\2\64\65\7,\2\2\65\b\3\2\2\2\66\67\7\61\2\2\67\n\3\2\2\289\7-\2\29\f\3"+
		"\2\2\2:;\7/\2\2;\16\3\2\2\2<=\7O\2\2=>\7G\2\2>?\7P\2\2?@\7Q\2\2@A\7T\2"+
		"\2A\20\3\2\2\2BC\7K\2\2CD\7I\2\2DE\7W\2\2EF\7C\2\2FG\7N\2\2G\22\3\2\2"+
		"\2HI\7O\2\2IJ\7C\2\2JK\7K\2\2KL\7Q\2\2LM\7T\2\2M\24\3\2\2\2NO\7O\2\2O"+
		"P\7G\2\2PQ\7P\2\2QR\7Q\2\2RS\7T\2\2ST\7K\2\2TU\7I\2\2UV\7W\2\2VW\7C\2"+
		"\2WX\7N\2\2X\26\3\2\2\2YZ\7O\2\2Z[\7C\2\2[\\\7K\2\2\\]\7Q\2\2]^\7T\2\2"+
		"^_\7K\2\2_`\7I\2\2`a\7W\2\2ab\7C\2\2bc\7N\2\2c\30\3\2\2\2de\7C\2\2ef\7"+
		"V\2\2fg\7T\2\2gh\7K\2\2hi\7D\2\2ij\7W\2\2jk\7V\2\2kl\7Q\2\2l\32\3\2\2"+
		"\2mn\7G\2\2no\7P\2\2op\7X\2\2pq\7K\2\2qr\7C\2\2rs\7T\2\2st\7\"\2\2tu\7"+
		"G\2\2uv\7O\2\2vw\7C\2\2wx\7K\2\2xy\7N\2\2y\34\3\2\2\2z{\7E\2\2{|\7Q\2"+
		"\2|}\7N\2\2}~\7C\2\2~\177\7D\2\2\177\u0080\7Q\2\2\u0080\u0081\7T\2\2\u0081"+
		"\u0082\7C\2\2\u0082\u0083\7F\2\2\u0083\u0084\7Q\2\2\u0084\u0085\7T\2\2"+
		"\u0085\u0086\7\"\2\2\u0086\u0087\7T\2\2\u0087\u0088\7G\2\2\u0088\u0089"+
		"\7S\2\2\u0089\u008a\7W\2\2\u008a\u008b\7G\2\2\u008b\u008c\7T\2\2\u008c"+
		"\u008d\7G\2\2\u008d\u008e\7P\2\2\u008e\u008f\7V\2\2\u008f\u0090\7G\2\2"+
		"\u0090\36\3\2\2\2\u0091\u0095\t\2\2\2\u0092\u0094\t\2\2\2\u0093\u0092"+
		"\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		" \3\2\2\2\u0097\u0095\3\2\2\2\u0098\u009a\13\2\2\2\u0099\u0098\3\2\2\2"+
		"\u009a\u009d\3\2\2\2\u009b\u009c\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009e"+
		"\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u009f\13\2\2\2\u009f\u00a0\5#\22\2"+
		"\u00a0\"\3\2\2\2\u00a1\u00a2\7z\2\2\u00a2\u00a3\7o\2\2\u00a3\u00a8\7n"+
		"\2\2\u00a4\u00a5\7e\2\2\u00a5\u00a6\7u\2\2\u00a6\u00a8\7x\2\2\u00a7\u00a1"+
		"\3\2\2\2\u00a7\u00a4\3\2\2\2\u00a8$\3\2\2\2\u00a9\u00ab\t\3\2\2\u00aa"+
		"\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad&\3\2\2\2\u00ae\u00b2\7%\2\2\u00af\u00b1\n\4\2\2\u00b0\u00af"+
		"\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b5\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\b\24\2\2\u00b6(\3\2\2\2"+
		"\u00b7\u00b8\t\5\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\b\25\2\2\u00ba*\3"+
		"\2\2\2\b\2\u0095\u009b\u00a7\u00ac\u00b2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}