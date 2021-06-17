// Generated from C:/Users/luism/Desktop/lei20_21_s4_2dl_4/base.core/src/main/java/eapli/base/formulario/gramatica\TarefaAutomatica.g4 by ANTLR 4.9.1
package eapli.base.formulario.gramatica.eapli.base.formulario.gramatica;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TarefaAutomaticaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, MENOR=8, IGUAL=9, 
		MAIOR=10, MENORIGUAL=11, MAIORIGUAL=12, ATRIBUTO=13, ENVIAR_EMAIL=14, 
		COLABORADOR_REQUERENTE=15, NUMERO=16, FICHEIRO=17, XML=18, NAME=19, COMMENT=20, 
		SPACES=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "MENOR", "IGUAL", 
			"MAIOR", "MENORIGUAL", "MAIORIGUAL", "ATRIBUTO", "ENVIAR_EMAIL", "COLABORADOR_REQUERENTE", 
			"NUMERO", "FICHEIRO", "XML", "NAME", "COMMENT", "SPACES"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u00c3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\7\21\u009c\n\21\f\21"+
		"\16\21\u009f\13\21\3\22\7\22\u00a2\n\22\f\22\16\22\u00a5\13\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00b0\n\23\3\24\6\24\u00b3"+
		"\n\24\r\24\16\24\u00b4\3\25\3\25\7\25\u00b9\n\25\f\25\16\25\u00bc\13\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\u00a3\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27\3\2\6\3\2\62;\4\2C\\c|\5\2\f\f\17\17\"\"\4\2\13\13\"\"\2\u00c7\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5\60\3\2\2\2"+
		"\7\66\3\2\2\2\t<\3\2\2\2\13>\3\2\2\2\r@\3\2\2\2\17B\3\2\2\2\21D\3\2\2"+
		"\2\23J\3\2\2\2\25P\3\2\2\2\27V\3\2\2\2\31a\3\2\2\2\33l\3\2\2\2\35u\3\2"+
		"\2\2\37\u0082\3\2\2\2!\u0099\3\2\2\2#\u00a3\3\2\2\2%\u00af\3\2\2\2\'\u00b2"+
		"\3\2\2\2)\u00b6\3\2\2\2+\u00bf\3\2\2\2-.\7U\2\2./\7G\2\2/\4\3\2\2\2\60"+
		"\61\7G\2\2\61\62\7P\2\2\62\63\7V\2\2\63\64\7C\2\2\64\65\7Q\2\2\65\6\3"+
		"\2\2\2\66\67\7U\2\2\678\7G\2\289\7P\2\29:\7C\2\2:;\7Q\2\2;\b\3\2\2\2<"+
		"=\7,\2\2=\n\3\2\2\2>?\7\61\2\2?\f\3\2\2\2@A\7-\2\2A\16\3\2\2\2BC\7/\2"+
		"\2C\20\3\2\2\2DE\7O\2\2EF\7G\2\2FG\7P\2\2GH\7Q\2\2HI\7T\2\2I\22\3\2\2"+
		"\2JK\7K\2\2KL\7I\2\2LM\7W\2\2MN\7C\2\2NO\7N\2\2O\24\3\2\2\2PQ\7O\2\2Q"+
		"R\7C\2\2RS\7K\2\2ST\7Q\2\2TU\7T\2\2U\26\3\2\2\2VW\7O\2\2WX\7G\2\2XY\7"+
		"P\2\2YZ\7Q\2\2Z[\7T\2\2[\\\7K\2\2\\]\7I\2\2]^\7W\2\2^_\7C\2\2_`\7N\2\2"+
		"`\30\3\2\2\2ab\7O\2\2bc\7C\2\2cd\7K\2\2de\7Q\2\2ef\7T\2\2fg\7K\2\2gh\7"+
		"I\2\2hi\7W\2\2ij\7C\2\2jk\7N\2\2k\32\3\2\2\2lm\7C\2\2mn\7V\2\2no\7T\2"+
		"\2op\7K\2\2pq\7D\2\2qr\7W\2\2rs\7V\2\2st\7Q\2\2t\34\3\2\2\2uv\7G\2\2v"+
		"w\7P\2\2wx\7X\2\2xy\7K\2\2yz\7C\2\2z{\7T\2\2{|\7\"\2\2|}\7G\2\2}~\7O\2"+
		"\2~\177\7C\2\2\177\u0080\7K\2\2\u0080\u0081\7N\2\2\u0081\36\3\2\2\2\u0082"+
		"\u0083\7E\2\2\u0083\u0084\7Q\2\2\u0084\u0085\7N\2\2\u0085\u0086\7C\2\2"+
		"\u0086\u0087\7D\2\2\u0087\u0088\7Q\2\2\u0088\u0089\7T\2\2\u0089\u008a"+
		"\7C\2\2\u008a\u008b\7F\2\2\u008b\u008c\7Q\2\2\u008c\u008d\7T\2\2\u008d"+
		"\u008e\7\"\2\2\u008e\u008f\7T\2\2\u008f\u0090\7G\2\2\u0090\u0091\7S\2"+
		"\2\u0091\u0092\7W\2\2\u0092\u0093\7G\2\2\u0093\u0094\7T\2\2\u0094\u0095"+
		"\7G\2\2\u0095\u0096\7P\2\2\u0096\u0097\7V\2\2\u0097\u0098\7G\2\2\u0098"+
		" \3\2\2\2\u0099\u009d\t\2\2\2\u009a\u009c\t\2\2\2\u009b\u009a\3\2\2\2"+
		"\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\"\3"+
		"\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a2\13\2\2\2\u00a1\u00a0\3\2\2\2\u00a2"+
		"\u00a5\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a6\3\2"+
		"\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7\13\2\2\2\u00a7\u00a8\5%\23\2\u00a8"+
		"$\3\2\2\2\u00a9\u00aa\7z\2\2\u00aa\u00ab\7o\2\2\u00ab\u00b0\7n\2\2\u00ac"+
		"\u00ad\7e\2\2\u00ad\u00ae\7u\2\2\u00ae\u00b0\7x\2\2\u00af\u00a9\3\2\2"+
		"\2\u00af\u00ac\3\2\2\2\u00b0&\3\2\2\2\u00b1\u00b3\t\3\2\2\u00b2\u00b1"+
		"\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"(\3\2\2\2\u00b6\u00ba\7%\2\2\u00b7\u00b9\n\4\2\2\u00b8\u00b7\3\2\2\2\u00b9"+
		"\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bd\3\2"+
		"\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\b\25\2\2\u00be*\3\2\2\2\u00bf\u00c0"+
		"\t\5\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\b\26\2\2\u00c2,\3\2\2\2\b\2\u009d"+
		"\u00a3\u00af\u00b4\u00ba\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}