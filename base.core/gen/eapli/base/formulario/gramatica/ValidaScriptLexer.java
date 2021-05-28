// Generated from C:/Users/FaustoPC/Desktop/LAPR/base.core/src/main/java/eapli/base/formulario/gramatica\ValidaScript.g4 by ANTLR 4.9.1
package eapli.base.formulario.gramatica;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ValidaScriptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, INT=2, ID=3, MUL=4, DIV=5, ADD=6, SUB=7, ATR=8, LPR=9, RPR=10, 
		DEFINE=11, SE=12, ENTAO=13, NAOVAZIO=14, VAZIO=15, MAIOR=16, MENOR=17, 
		NOMEATRIBUTO=18, ESPACO=19, EXPREGULAR=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NEWLINE", "INT", "ID", "MUL", "DIV", "ADD", "SUB", "ATR", "LPR", "RPR", 
			"DEFINE", "SE", "ENTAO", "NAOVAZIO", "VAZIO", "MAIOR", "MENOR", "NOMEATRIBUTO", 
			"ESPACO", "EXPREGULAR"
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


	public ValidaScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ValidaScript.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26|\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\6\2-\n\2\r\2\16\2.\3\3\6\3\62\n\3\r"+
		"\3\16\3\63\3\4\6\4\67\n\4\r\4\16\48\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\6\23m\n\23\r\23"+
		"\16\23n\3\24\3\24\3\24\3\24\3\25\3\25\6\25w\n\25\r\25\16\25x\3\25\3\25"+
		"\3x\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26\3\2\7\4\2\f\f\17\17\3\2\62;\3\2c|\4"+
		"\2C\\c|\3\2\"\"\2\u0080\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3,\3\2\2"+
		"\2\5\61\3\2\2\2\7\66\3\2\2\2\t:\3\2\2\2\13<\3\2\2\2\r>\3\2\2\2\17@\3\2"+
		"\2\2\21B\3\2\2\2\23D\3\2\2\2\25F\3\2\2\2\27H\3\2\2\2\31O\3\2\2\2\33R\3"+
		"\2\2\2\35X\3\2\2\2\37a\3\2\2\2!g\3\2\2\2#i\3\2\2\2%l\3\2\2\2\'p\3\2\2"+
		"\2)t\3\2\2\2+-\t\2\2\2,+\3\2\2\2-.\3\2\2\2.,\3\2\2\2./\3\2\2\2/\4\3\2"+
		"\2\2\60\62\t\3\2\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2"+
		"\2\2\64\6\3\2\2\2\65\67\t\4\2\2\66\65\3\2\2\2\678\3\2\2\28\66\3\2\2\2"+
		"89\3\2\2\29\b\3\2\2\2:;\7,\2\2;\n\3\2\2\2<=\7\61\2\2=\f\3\2\2\2>?\7-\2"+
		"\2?\16\3\2\2\2@A\7/\2\2A\20\3\2\2\2BC\7?\2\2C\22\3\2\2\2DE\7*\2\2E\24"+
		"\3\2\2\2FG\7+\2\2G\26\3\2\2\2HI\7F\2\2IJ\7G\2\2JK\7H\2\2KL\7K\2\2LM\7"+
		"P\2\2MN\7G\2\2N\30\3\2\2\2OP\7U\2\2PQ\7G\2\2Q\32\3\2\2\2RS\7G\2\2ST\7"+
		"P\2\2TU\7V\2\2UV\7C\2\2VW\7Q\2\2W\34\3\2\2\2XY\7P\2\2YZ\7C\2\2Z[\7Q\2"+
		"\2[\\\7X\2\2\\]\7C\2\2]^\7\\\2\2^_\7K\2\2_`\7Q\2\2`\36\3\2\2\2ab\7X\2"+
		"\2bc\7C\2\2cd\7\\\2\2de\7K\2\2ef\7Q\2\2f \3\2\2\2gh\7@\2\2h\"\3\2\2\2"+
		"ij\7>\2\2j$\3\2\2\2km\t\5\2\2lk\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2"+
		"o&\3\2\2\2pq\t\6\2\2qr\3\2\2\2rs\b\24\2\2s(\3\2\2\2tv\7B\2\2uw\13\2\2"+
		"\2vu\3\2\2\2wx\3\2\2\2xy\3\2\2\2xv\3\2\2\2yz\3\2\2\2z{\7B\2\2{*\3\2\2"+
		"\2\b\2.\638nx\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}