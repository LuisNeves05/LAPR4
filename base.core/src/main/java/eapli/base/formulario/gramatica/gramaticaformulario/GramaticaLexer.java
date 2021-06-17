// Generated from C:/Users/luism/Desktop/lei20_21_s4_2dl_4/base.core/src/main/java/eapli/base/formulario/gramatica\Gramatica.g4 by ANTLR 4.9.1
package eapli.base.formulario.gramatica.gramaticaformulario;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramaticaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, ATRIBUTO=2, DEFINE=3, SE=4, MENOR=5, IGUAL=6, MAIOR=7, MENORIGUAL=8, 
		MAIORIGUAL=9, ENTAO=10, NAOVAZIO=11, VAZIO=12, NUMERO=13, NAME=14, NEWLINE=15, 
		SPACES=16, SEPARATOR=17, EXPREGULAR=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMMENT", "ATRIBUTO", "DEFINE", "SE", "MENOR", "IGUAL", "MAIOR", "MENORIGUAL", 
			"MAIORIGUAL", "ENTAO", "NAOVAZIO", "VAZIO", "NUMERO", "NAME", "NEWLINE", 
			"SPACES", "SEPARATOR", "EXPREGULAR"
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


	public GramaticaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Gramatica.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u009c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\7\2*\n\2\f\2\16\2-\13\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\7\16\u0083\n\16\f\16\16\16"+
		"\u0086\13\16\3\17\6\17\u0089\n\17\r\17\16\17\u008a\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\6\23\u0097\n\23\r\23\16\23\u0098\3\23\3"+
		"\23\3\u0098\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\3\2\7\4\2\f\f\17\17\3\2\62;\4\2C\\c"+
		"|\4\2\13\13\"\"\5\2//\61\61^^\2\u009f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5\60"+
		"\3\2\2\2\79\3\2\2\2\t@\3\2\2\2\13C\3\2\2\2\rI\3\2\2\2\17O\3\2\2\2\21U"+
		"\3\2\2\2\23`\3\2\2\2\25k\3\2\2\2\27q\3\2\2\2\31z\3\2\2\2\33\u0080\3\2"+
		"\2\2\35\u0088\3\2\2\2\37\u008c\3\2\2\2!\u008e\3\2\2\2#\u0092\3\2\2\2%"+
		"\u0094\3\2\2\2\'+\7%\2\2(*\n\2\2\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2"+
		"\2\2,.\3\2\2\2-+\3\2\2\2./\b\2\2\2/\4\3\2\2\2\60\61\7C\2\2\61\62\7V\2"+
		"\2\62\63\7T\2\2\63\64\7K\2\2\64\65\7D\2\2\65\66\7W\2\2\66\67\7V\2\2\67"+
		"8\7Q\2\28\6\3\2\2\29:\7F\2\2:;\7G\2\2;<\7H\2\2<=\7K\2\2=>\7P\2\2>?\7G"+
		"\2\2?\b\3\2\2\2@A\7U\2\2AB\7G\2\2B\n\3\2\2\2CD\7O\2\2DE\7G\2\2EF\7P\2"+
		"\2FG\7Q\2\2GH\7T\2\2H\f\3\2\2\2IJ\7K\2\2JK\7I\2\2KL\7W\2\2LM\7C\2\2MN"+
		"\7N\2\2N\16\3\2\2\2OP\7O\2\2PQ\7C\2\2QR\7K\2\2RS\7Q\2\2ST\7T\2\2T\20\3"+
		"\2\2\2UV\7O\2\2VW\7G\2\2WX\7P\2\2XY\7Q\2\2YZ\7T\2\2Z[\7K\2\2[\\\7I\2\2"+
		"\\]\7W\2\2]^\7C\2\2^_\7N\2\2_\22\3\2\2\2`a\7O\2\2ab\7C\2\2bc\7K\2\2cd"+
		"\7Q\2\2de\7T\2\2ef\7K\2\2fg\7I\2\2gh\7W\2\2hi\7C\2\2ij\7N\2\2j\24\3\2"+
		"\2\2kl\7G\2\2lm\7P\2\2mn\7V\2\2no\7C\2\2op\7Q\2\2p\26\3\2\2\2qr\7P\2\2"+
		"rs\7C\2\2st\7Q\2\2tu\7X\2\2uv\7C\2\2vw\7\\\2\2wx\7K\2\2xy\7Q\2\2y\30\3"+
		"\2\2\2z{\7X\2\2{|\7C\2\2|}\7\\\2\2}~\7K\2\2~\177\7Q\2\2\177\32\3\2\2\2"+
		"\u0080\u0084\t\3\2\2\u0081\u0083\t\3\2\2\u0082\u0081\3\2\2\2\u0083\u0086"+
		"\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\34\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0087\u0089\t\4\2\2\u0088\u0087\3\2\2\2\u0089\u008a\3\2"+
		"\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\36\3\2\2\2\u008c\u008d"+
		"\t\2\2\2\u008d \3\2\2\2\u008e\u008f\t\5\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u0091\b\21\2\2\u0091\"\3\2\2\2\u0092\u0093\t\6\2\2\u0093$\3\2\2\2\u0094"+
		"\u0096\7B\2\2\u0095\u0097\13\2\2\2\u0096\u0095\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u009b\7B\2\2\u009b&\3\2\2\2\7\2+\u0084\u008a\u0098\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}