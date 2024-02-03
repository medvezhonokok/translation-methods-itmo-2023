// Generated from M:/Mike/ITMO/lab3/src/main/antlr4/JavaGrammar.g4 by ANTLR 4.13.1
package main.antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JavaGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, MODIFIER=17, 
		TYPE=18, OPERATION=19, NUMBER=20, WORD=21, WS=22;
	public static final int
		RULE_start = 0, RULE_package = 1, RULE_imports = 2, RULE_main_class = 3, 
		RULE_class = 4, RULE_class_body = 5, RULE_constructor = 6, RULE_field = 7, 
		RULE_method = 8, RULE_arguments = 9, RULE_statement = 10, RULE_for_cycle = 11, 
		RULE_function_call = 12, RULE_function_arguments = 13, RULE_variable_declaration = 14, 
		RULE_variable_redelcaration = 15, RULE_expression = 16, RULE_term = 17, 
		RULE_f = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "package", "imports", "main_class", "class", "class_body", "constructor", 
			"field", "method", "arguments", "statement", "for_cycle", "function_call", 
			"function_arguments", "variable_declaration", "variable_redelcaration", 
			"expression", "term", "f"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'package'", "'.'", "';'", "'import'", "'class'", "'{'", "'}'", 
			"'='", "'\"'", "'('", "'[]'", "', '", "')'", "'for'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "MODIFIER", "TYPE", "OPERATION", "NUMBER", 
			"WORD", "WS"
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
	public String getGrammarFileName() { return "JavaGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JavaGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public PackageContext package_() {
			return getRuleContext(PackageContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(JavaGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(JavaGrammarParser.WS, i);
		}
		public Main_classContext main_class() {
			return getRuleContext(Main_classContext.class,0);
		}
		public List<ImportsContext> imports() {
			return getRuleContexts(ImportsContext.class);
		}
		public ImportsContext imports(int i) {
			return getRuleContext(ImportsContext.class,i);
		}
		public List<ClassContext> class_() {
			return getRuleContexts(ClassContext.class);
		}
		public ClassContext class_(int i) {
			return getRuleContext(ClassContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			package_();
			setState(39);
			match(WS);
			setState(41); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(40);
				imports();
				}
				}
				setState(43); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
			setState(45);
			main_class();
			setState(46);
			match(WS);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(47);
				class_();
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PackageContext extends ParserRuleContext {
		public TerminalNode WS() { return getToken(JavaGrammarParser.WS, 0); }
		public List<TerminalNode> WORD() { return getTokens(JavaGrammarParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(JavaGrammarParser.WORD, i);
		}
		public PackageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_package; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterPackage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitPackage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitPackage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageContext package_() throws RecognitionException {
		PackageContext _localctx = new PackageContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_package);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__0);
			setState(54);
			match(WS);
			setState(55);
			match(WORD);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(56);
				match(T__1);
				setState(57);
				match(WORD);
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
			match(T__2);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImportsContext extends ParserRuleContext {
		public List<TerminalNode> WS() { return getTokens(JavaGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(JavaGrammarParser.WS, i);
		}
		public List<TerminalNode> WORD() { return getTokens(JavaGrammarParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(JavaGrammarParser.WORD, i);
		}
		public ImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imports; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterImports(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitImports(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitImports(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportsContext imports() throws RecognitionException {
		ImportsContext _localctx = new ImportsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_imports);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(T__3);
			setState(66);
			match(WS);
			setState(67);
			match(WORD);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(68);
				match(T__1);
				setState(69);
				match(WORD);
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
			match(T__2);
			setState(76);
			match(WS);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Main_classContext extends ParserRuleContext {
		public TerminalNode MODIFIER() { return getToken(JavaGrammarParser.MODIFIER, 0); }
		public TerminalNode WS() { return getToken(JavaGrammarParser.WS, 0); }
		public ClassContext class_() {
			return getRuleContext(ClassContext.class,0);
		}
		public Main_classContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_class; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterMain_class(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitMain_class(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitMain_class(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Main_classContext main_class() throws RecognitionException {
		Main_classContext _localctx = new Main_classContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_main_class);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(MODIFIER);
			setState(79);
			match(WS);
			setState(80);
			class_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassContext extends ParserRuleContext {
		public List<TerminalNode> WS() { return getTokens(JavaGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(JavaGrammarParser.WS, i);
		}
		public TerminalNode WORD() { return getToken(JavaGrammarParser.WORD, 0); }
		public Class_bodyContext class_body() {
			return getRuleContext(Class_bodyContext.class,0);
		}
		public ClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassContext class_() throws RecognitionException {
		ClassContext _localctx = new ClassContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_class);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__4);
			setState(83);
			match(WS);
			setState(84);
			match(WORD);
			setState(85);
			match(WS);
			setState(86);
			match(T__5);
			setState(87);
			class_body();
			setState(88);
			match(T__6);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Class_bodyContext extends ParserRuleContext {
		public TerminalNode WS() { return getToken(JavaGrammarParser.WS, 0); }
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public ConstructorContext constructor() {
			return getRuleContext(ConstructorContext.class,0);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public List<ClassContext> class_() {
			return getRuleContexts(ClassContext.class);
		}
		public ClassContext class_(int i) {
			return getRuleContext(ClassContext.class,i);
		}
		public Class_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterClass_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitClass_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitClass_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_bodyContext class_body() throws RecognitionException {
		Class_bodyContext _localctx = new Class_bodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_class_body);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(91); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(90);
					field();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(93); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(95);
			match(WS);
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(96);
				constructor();
				}
				break;
			}
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MODIFIER || _la==WS) {
				{
				{
				setState(99);
				method();
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(105);
				class_();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorContext extends ParserRuleContext {
		public TerminalNode MODIFIER() { return getToken(JavaGrammarParser.MODIFIER, 0); }
		public List<TerminalNode> WS() { return getTokens(JavaGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(JavaGrammarParser.WS, i);
		}
		public TerminalNode WORD() { return getToken(JavaGrammarParser.WORD, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_constructor);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(MODIFIER);
			setState(112);
			match(WS);
			setState(113);
			match(WORD);
			setState(114);
			match(WS);
			setState(115);
			arguments();
			setState(116);
			match(WS);
			setState(117);
			match(T__5);
			setState(118);
			match(WS);
			setState(122);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(119);
					statement();
					}
					} 
				}
				setState(124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(125);
			match(WS);
			setState(126);
			match(T__6);
			setState(127);
			match(WS);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldContext extends ParserRuleContext {
		public List<TerminalNode> WS() { return getTokens(JavaGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(JavaGrammarParser.WS, i);
		}
		public TerminalNode TYPE() { return getToken(JavaGrammarParser.TYPE, 0); }
		public List<TerminalNode> WORD() { return getTokens(JavaGrammarParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(JavaGrammarParser.WORD, i);
		}
		public List<TerminalNode> MODIFIER() { return getTokens(JavaGrammarParser.MODIFIER); }
		public TerminalNode MODIFIER(int i) {
			return getToken(JavaGrammarParser.MODIFIER, i);
		}
		public TerminalNode NUMBER() { return getToken(JavaGrammarParser.NUMBER, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_field);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MODIFIER) {
				{
				setState(129);
				match(MODIFIER);
				}
			}

			setState(136);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(132);
					match(WS);
					setState(133);
					match(MODIFIER);
					}
					} 
				}
				setState(138);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(139);
			match(WS);
			setState(140);
			match(TYPE);
			setState(141);
			match(WS);
			setState(142);
			match(WORD);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(143);
				match(WS);
				}
			}

			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(146);
				match(T__7);
				setState(147);
				match(WS);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(148);
					match(T__8);
					}
				}

				setState(151);
				_la = _input.LA(1);
				if ( !(_la==NUMBER || _la==WORD) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(152);
					match(T__8);
					}
				}

				}
			}

			setState(157);
			match(T__2);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodContext extends ParserRuleContext {
		public List<TerminalNode> WS() { return getTokens(JavaGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(JavaGrammarParser.WS, i);
		}
		public TerminalNode TYPE() { return getToken(JavaGrammarParser.TYPE, 0); }
		public TerminalNode WORD() { return getToken(JavaGrammarParser.WORD, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public List<TerminalNode> MODIFIER() { return getTokens(JavaGrammarParser.MODIFIER); }
		public TerminalNode MODIFIER(int i) {
			return getToken(JavaGrammarParser.MODIFIER, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_method);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MODIFIER) {
				{
				setState(159);
				match(MODIFIER);
				}
			}

			setState(166);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(162);
					match(WS);
					setState(163);
					match(MODIFIER);
					}
					} 
				}
				setState(168);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(169);
			match(WS);
			setState(170);
			match(TYPE);
			setState(171);
			match(WS);
			setState(172);
			match(WORD);
			setState(173);
			match(WS);
			setState(174);
			arguments();
			setState(175);
			match(WS);
			setState(176);
			match(T__5);
			setState(177);
			match(WS);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6553600L) != 0)) {
				{
				{
				setState(178);
				statement();
				}
				}
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(184);
			match(T__6);
			setState(185);
			match(WS);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public List<TerminalNode> TYPE() { return getTokens(JavaGrammarParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(JavaGrammarParser.TYPE, i);
		}
		public List<TerminalNode> WS() { return getTokens(JavaGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(JavaGrammarParser.WS, i);
		}
		public List<TerminalNode> WORD() { return getTokens(JavaGrammarParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(JavaGrammarParser.WORD, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(T__9);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE) {
				{
				setState(188);
				match(TYPE);
				setState(189);
				match(WS);
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(190);
					match(T__10);
					}
					}
					setState(195);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(196);
				match(WORD);
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(197);
					match(T__11);
					setState(198);
					match(TYPE);
					setState(199);
					match(WS);
					setState(203);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(200);
						match(T__10);
						}
						}
						setState(205);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(207);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==WS) {
						{
						setState(206);
						match(WS);
						}
					}

					setState(209);
					match(WORD);
					}
					}
					setState(214);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(217);
			match(T__12);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public TerminalNode WS() { return getToken(JavaGrammarParser.WS, 0); }
		public Variable_declarationContext variable_declaration() {
			return getRuleContext(Variable_declarationContext.class,0);
		}
		public Variable_redelcarationContext variable_redelcaration() {
			return getRuleContext(Variable_redelcarationContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(219);
				variable_declaration();
				}
				break;
			case 2:
				{
				setState(220);
				variable_redelcaration();
				}
				break;
			case 3:
				{
				setState(221);
				function_call();
				}
				break;
			}
			setState(224);
			match(WS);
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

	@SuppressWarnings("CheckReturnValue")
	public static class For_cycleContext extends ParserRuleContext {
		public List<TerminalNode> WS() { return getTokens(JavaGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(JavaGrammarParser.WS, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<Variable_redelcarationContext> variable_redelcaration() {
			return getRuleContexts(Variable_redelcarationContext.class);
		}
		public Variable_redelcarationContext variable_redelcaration(int i) {
			return getRuleContext(Variable_redelcarationContext.class,i);
		}
		public List<Variable_declarationContext> variable_declaration() {
			return getRuleContexts(Variable_declarationContext.class);
		}
		public Variable_declarationContext variable_declaration(int i) {
			return getRuleContext(Variable_declarationContext.class,i);
		}
		public List<Function_callContext> function_call() {
			return getRuleContexts(Function_callContext.class);
		}
		public Function_callContext function_call(int i) {
			return getRuleContext(Function_callContext.class,i);
		}
		public For_cycleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_cycle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterFor_cycle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitFor_cycle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitFor_cycle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_cycleContext for_cycle() throws RecognitionException {
		For_cycleContext _localctx = new For_cycleContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_for_cycle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(T__13);
			setState(227);
			match(WS);
			setState(228);
			match(T__9);
			setState(231);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				{
				setState(229);
				variable_declaration();
				}
				break;
			case WORD:
				{
				setState(230);
				variable_redelcaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(233);
			expression();
			setState(234);
			match(T__2);
			setState(235);
			match(WS);
			setState(236);
			variable_redelcaration();
			setState(237);
			match(T__12);
			setState(238);
			match(T__5);
			setState(246); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(242);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(239);
					variable_declaration();
					}
					break;
				case 2:
					{
					setState(240);
					variable_redelcaration();
					}
					break;
				case 3:
					{
					setState(241);
					function_call();
					}
					break;
				}
				setState(244);
				match(WS);
				}
				}
				setState(248); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 6553600L) != 0) );
			setState(250);
			match(T__6);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(JavaGrammarParser.WORD, 0); }
		public Function_argumentsContext function_arguments() {
			return getRuleContext(Function_argumentsContext.class,0);
		}
		public TerminalNode WS() { return getToken(JavaGrammarParser.WS, 0); }
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitFunction_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(252);
				match(WS);
				}
			}

			setState(255);
			match(WORD);
			setState(256);
			function_arguments();
			setState(257);
			match(T__2);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Function_argumentsContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(JavaGrammarParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(JavaGrammarParser.WORD, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(JavaGrammarParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(JavaGrammarParser.NUMBER, i);
		}
		public Function_argumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterFunction_arguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitFunction_arguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitFunction_arguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_argumentsContext function_arguments() throws RecognitionException {
		Function_argumentsContext _localctx = new Function_argumentsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_function_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(T__9);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3146240L) != 0)) {
				{
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(260);
					match(T__8);
					}
				}

				setState(263);
				_la = _input.LA(1);
				if ( !(_la==NUMBER || _la==WORD) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(264);
					match(T__8);
					}
				}

				}
			}

			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(269);
				match(T__11);
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(270);
					match(T__8);
					}
				}

				setState(273);
				_la = _input.LA(1);
				if ( !(_la==NUMBER || _la==WORD) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(274);
					match(T__8);
					}
				}

				}
				}
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(282);
			match(T__12);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_declarationContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(JavaGrammarParser.TYPE, 0); }
		public TerminalNode WS() { return getToken(JavaGrammarParser.WS, 0); }
		public Variable_redelcarationContext variable_redelcaration() {
			return getRuleContext(Variable_redelcarationContext.class,0);
		}
		public Variable_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterVariable_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitVariable_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitVariable_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_declarationContext variable_declaration() throws RecognitionException {
		Variable_declarationContext _localctx = new Variable_declarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_variable_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(TYPE);
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(285);
				match(T__10);
				}
				}
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(291);
			match(WS);
			setState(292);
			variable_redelcaration();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_redelcarationContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(JavaGrammarParser.WORD, 0); }
		public TerminalNode WS() { return getToken(JavaGrammarParser.WS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Variable_redelcarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_redelcaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterVariable_redelcaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitVariable_redelcaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitVariable_redelcaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_redelcarationContext variable_redelcaration() throws RecognitionException {
		Variable_redelcarationContext _localctx = new Variable_redelcarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_variable_redelcaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(WORD);
			setState(295);
			match(WS);
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(296);
				match(T__7);
				setState(297);
				expression();
				}
			}

			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(300);
				match(T__2);
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			term();
			setState(310);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(308);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__14:
						{
						{
						setState(304);
						match(T__14);
						setState(305);
						term();
						}
						}
						break;
					case T__15:
						{
						{
						setState(306);
						match(T__15);
						setState(307);
						term();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(312);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(JavaGrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(JavaGrammarParser.WS, i);
		}
		public List<TerminalNode> OPERATION() { return getTokens(JavaGrammarParser.OPERATION); }
		public TerminalNode OPERATION(int i) {
			return getToken(JavaGrammarParser.OPERATION, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_term);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(313);
				match(WS);
				}
				break;
			}
			setState(316);
			f();
			setState(318);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				{
				setState(317);
				match(WS);
				}
				break;
			}
			setState(326);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(320);
					match(WS);
					setState(321);
					match(OPERATION);
					setState(322);
					match(WS);
					setState(323);
					f();
					}
					} 
				}
				setState(328);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(JavaGrammarParser.NUMBER, 0); }
		public TerminalNode WORD() { return getToken(JavaGrammarParser.WORD, 0); }
		public FContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).enterF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaGrammarListener ) ((JavaGrammarListener)listener).exitF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JavaGrammarVisitor ) return ((JavaGrammarVisitor<? extends T>)visitor).visitF(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FContext f() throws RecognitionException {
		FContext _localctx = new FContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_f);
		int _la;
		try {
			setState(360);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(330);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__15) {
					{
					setState(329);
					match(T__15);
					}
				}

				{
				setState(332);
				match(T__9);
				setState(333);
				expression();
				setState(334);
				match(T__12);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(337);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(336);
					match(T__15);
					}
					break;
				}
				setState(340);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(339);
					match(T__8);
					}
					break;
				}
				setState(343);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(342);
					match(NUMBER);
					}
					break;
				}
				setState(346);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
				case 1:
					{
					setState(345);
					match(T__8);
					}
					break;
				}
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(349);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(348);
					match(T__15);
					}
					break;
				}
				{
				setState(352);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
				case 1:
					{
					setState(351);
					match(T__8);
					}
					break;
				}
				setState(355);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
				case 1:
					{
					setState(354);
					match(WORD);
					}
					break;
				}
				setState(358);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(357);
					match(T__8);
					}
					break;
				}
				}
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

	public static final String _serializedATN =
		"\u0004\u0001\u0016\u016b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000*\b\u0000\u000b"+
		"\u0000\f\u0000+\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u00001\b\u0000"+
		"\n\u0000\f\u00004\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001;\b\u0001\n\u0001\f\u0001>\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002G\b\u0002\n\u0002\f\u0002J\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0004\u0005\\\b\u0005\u000b\u0005\f\u0005]\u0001"+
		"\u0005\u0001\u0005\u0003\u0005b\b\u0005\u0001\u0005\u0005\u0005e\b\u0005"+
		"\n\u0005\f\u0005h\t\u0005\u0001\u0005\u0005\u0005k\b\u0005\n\u0005\f\u0005"+
		"n\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006y\b\u0006"+
		"\n\u0006\f\u0006|\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0003\u0007\u0083\b\u0007\u0001\u0007\u0001\u0007\u0005\u0007"+
		"\u0087\b\u0007\n\u0007\f\u0007\u008a\t\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0091\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u0096\b\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u009a\b\u0007\u0003\u0007\u009c\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0003\b\u00a1\b\b\u0001\b\u0001\b\u0005\b\u00a5\b\b\n\b\f\b\u00a8"+
		"\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0005\b\u00b4\b\b\n\b\f\b\u00b7\t\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00c0\b\t\n\t\f\t\u00c3\t\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00ca\b\t\n\t\f\t\u00cd\t\t"+
		"\u0001\t\u0003\t\u00d0\b\t\u0001\t\u0005\t\u00d3\b\t\n\t\f\t\u00d6\t\t"+
		"\u0003\t\u00d8\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0003\n\u00df"+
		"\b\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00e8\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00f3\b\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u00f7\b\u000b"+
		"\u000b\u000b\f\u000b\u00f8\u0001\u000b\u0001\u000b\u0001\f\u0003\f\u00fe"+
		"\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0003\r\u0106\b\r"+
		"\u0001\r\u0001\r\u0003\r\u010a\b\r\u0003\r\u010c\b\r\u0001\r\u0001\r\u0003"+
		"\r\u0110\b\r\u0001\r\u0001\r\u0003\r\u0114\b\r\u0005\r\u0116\b\r\n\r\f"+
		"\r\u0119\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0005\u000e\u011f"+
		"\b\u000e\n\u000e\f\u000e\u0122\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u012b\b\u000f"+
		"\u0001\u000f\u0003\u000f\u012e\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u0135\b\u0010\n\u0010\f\u0010\u0138"+
		"\t\u0010\u0001\u0011\u0003\u0011\u013b\b\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u013f\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0005\u0011\u0145\b\u0011\n\u0011\f\u0011\u0148\t\u0011\u0001\u0012\u0003"+
		"\u0012\u014b\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0003\u0012\u0152\b\u0012\u0001\u0012\u0003\u0012\u0155\b\u0012"+
		"\u0001\u0012\u0003\u0012\u0158\b\u0012\u0001\u0012\u0003\u0012\u015b\b"+
		"\u0012\u0001\u0012\u0003\u0012\u015e\b\u0012\u0001\u0012\u0003\u0012\u0161"+
		"\b\u0012\u0001\u0012\u0003\u0012\u0164\b\u0012\u0001\u0012\u0003\u0012"+
		"\u0167\b\u0012\u0003\u0012\u0169\b\u0012\u0001\u0012\u0000\u0000\u0013"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$\u0000\u0001\u0001\u0000\u0014\u0015\u018e\u0000&\u0001"+
		"\u0000\u0000\u0000\u00025\u0001\u0000\u0000\u0000\u0004A\u0001\u0000\u0000"+
		"\u0000\u0006N\u0001\u0000\u0000\u0000\bR\u0001\u0000\u0000\u0000\n[\u0001"+
		"\u0000\u0000\u0000\fo\u0001\u0000\u0000\u0000\u000e\u0082\u0001\u0000"+
		"\u0000\u0000\u0010\u00a0\u0001\u0000\u0000\u0000\u0012\u00bb\u0001\u0000"+
		"\u0000\u0000\u0014\u00de\u0001\u0000\u0000\u0000\u0016\u00e2\u0001\u0000"+
		"\u0000\u0000\u0018\u00fd\u0001\u0000\u0000\u0000\u001a\u0103\u0001\u0000"+
		"\u0000\u0000\u001c\u011c\u0001\u0000\u0000\u0000\u001e\u0126\u0001\u0000"+
		"\u0000\u0000 \u012f\u0001\u0000\u0000\u0000\"\u013a\u0001\u0000\u0000"+
		"\u0000$\u0168\u0001\u0000\u0000\u0000&\'\u0003\u0002\u0001\u0000\')\u0005"+
		"\u0016\u0000\u0000(*\u0003\u0004\u0002\u0000)(\u0001\u0000\u0000\u0000"+
		"*+\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000"+
		"\u0000,-\u0001\u0000\u0000\u0000-.\u0003\u0006\u0003\u0000.2\u0005\u0016"+
		"\u0000\u0000/1\u0003\b\u0004\u00000/\u0001\u0000\u0000\u000014\u0001\u0000"+
		"\u0000\u000020\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u00003\u0001"+
		"\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000056\u0005\u0001\u0000"+
		"\u000067\u0005\u0016\u0000\u00007<\u0005\u0015\u0000\u000089\u0005\u0002"+
		"\u0000\u00009;\u0005\u0015\u0000\u0000:8\u0001\u0000\u0000\u0000;>\u0001"+
		"\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000"+
		"=?\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000?@\u0005\u0003\u0000"+
		"\u0000@\u0003\u0001\u0000\u0000\u0000AB\u0005\u0004\u0000\u0000BC\u0005"+
		"\u0016\u0000\u0000CH\u0005\u0015\u0000\u0000DE\u0005\u0002\u0000\u0000"+
		"EG\u0005\u0015\u0000\u0000FD\u0001\u0000\u0000\u0000GJ\u0001\u0000\u0000"+
		"\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IK\u0001\u0000"+
		"\u0000\u0000JH\u0001\u0000\u0000\u0000KL\u0005\u0003\u0000\u0000LM\u0005"+
		"\u0016\u0000\u0000M\u0005\u0001\u0000\u0000\u0000NO\u0005\u0011\u0000"+
		"\u0000OP\u0005\u0016\u0000\u0000PQ\u0003\b\u0004\u0000Q\u0007\u0001\u0000"+
		"\u0000\u0000RS\u0005\u0005\u0000\u0000ST\u0005\u0016\u0000\u0000TU\u0005"+
		"\u0015\u0000\u0000UV\u0005\u0016\u0000\u0000VW\u0005\u0006\u0000\u0000"+
		"WX\u0003\n\u0005\u0000XY\u0005\u0007\u0000\u0000Y\t\u0001\u0000\u0000"+
		"\u0000Z\\\u0003\u000e\u0007\u0000[Z\u0001\u0000\u0000\u0000\\]\u0001\u0000"+
		"\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0001"+
		"\u0000\u0000\u0000_a\u0005\u0016\u0000\u0000`b\u0003\f\u0006\u0000a`\u0001"+
		"\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bf\u0001\u0000\u0000\u0000"+
		"ce\u0003\u0010\b\u0000dc\u0001\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000"+
		"fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gl\u0001\u0000\u0000"+
		"\u0000hf\u0001\u0000\u0000\u0000ik\u0003\b\u0004\u0000ji\u0001\u0000\u0000"+
		"\u0000kn\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000"+
		"\u0000\u0000m\u000b\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000"+
		"op\u0005\u0011\u0000\u0000pq\u0005\u0016\u0000\u0000qr\u0005\u0015\u0000"+
		"\u0000rs\u0005\u0016\u0000\u0000st\u0003\u0012\t\u0000tu\u0005\u0016\u0000"+
		"\u0000uv\u0005\u0006\u0000\u0000vz\u0005\u0016\u0000\u0000wy\u0003\u0014"+
		"\n\u0000xw\u0001\u0000\u0000\u0000y|\u0001\u0000\u0000\u0000zx\u0001\u0000"+
		"\u0000\u0000z{\u0001\u0000\u0000\u0000{}\u0001\u0000\u0000\u0000|z\u0001"+
		"\u0000\u0000\u0000}~\u0005\u0016\u0000\u0000~\u007f\u0005\u0007\u0000"+
		"\u0000\u007f\u0080\u0005\u0016\u0000\u0000\u0080\r\u0001\u0000\u0000\u0000"+
		"\u0081\u0083\u0005\u0011\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000"+
		"\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0088\u0001\u0000\u0000\u0000"+
		"\u0084\u0085\u0005\u0016\u0000\u0000\u0085\u0087\u0005\u0011\u0000\u0000"+
		"\u0086\u0084\u0001\u0000\u0000\u0000\u0087\u008a\u0001\u0000\u0000\u0000"+
		"\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000"+
		"\u0089\u008b\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000"+
		"\u008b\u008c\u0005\u0016\u0000\u0000\u008c\u008d\u0005\u0012\u0000\u0000"+
		"\u008d\u008e\u0005\u0016\u0000\u0000\u008e\u0090\u0005\u0015\u0000\u0000"+
		"\u008f\u0091\u0005\u0016\u0000\u0000\u0090\u008f\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u009b\u0001\u0000\u0000\u0000"+
		"\u0092\u0093\u0005\b\u0000\u0000\u0093\u0095\u0005\u0016\u0000\u0000\u0094"+
		"\u0096\u0005\t\u0000\u0000\u0095\u0094\u0001\u0000\u0000\u0000\u0095\u0096"+
		"\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0099"+
		"\u0007\u0000\u0000\u0000\u0098\u009a\u0005\t\u0000\u0000\u0099\u0098\u0001"+
		"\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009c\u0001"+
		"\u0000\u0000\u0000\u009b\u0092\u0001\u0000\u0000\u0000\u009b\u009c\u0001"+
		"\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009e\u0005"+
		"\u0003\u0000\u0000\u009e\u000f\u0001\u0000\u0000\u0000\u009f\u00a1\u0005"+
		"\u0011\u0000\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a6\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005"+
		"\u0016\u0000\u0000\u00a3\u00a5\u0005\u0011\u0000\u0000\u00a4\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a8\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a9\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005"+
		"\u0016\u0000\u0000\u00aa\u00ab\u0005\u0012\u0000\u0000\u00ab\u00ac\u0005"+
		"\u0016\u0000\u0000\u00ac\u00ad\u0005\u0015\u0000\u0000\u00ad\u00ae\u0005"+
		"\u0016\u0000\u0000\u00ae\u00af\u0003\u0012\t\u0000\u00af\u00b0\u0005\u0016"+
		"\u0000\u0000\u00b0\u00b1\u0005\u0006\u0000\u0000\u00b1\u00b5\u0005\u0016"+
		"\u0000\u0000\u00b2\u00b4\u0003\u0014\n\u0000\u00b3\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b7\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b8\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005\u0007\u0000"+
		"\u0000\u00b9\u00ba\u0005\u0016\u0000\u0000\u00ba\u0011\u0001\u0000\u0000"+
		"\u0000\u00bb\u00d7\u0005\n\u0000\u0000\u00bc\u00bd\u0005\u0012\u0000\u0000"+
		"\u00bd\u00c1\u0005\u0016\u0000\u0000\u00be\u00c0\u0005\u000b\u0000\u0000"+
		"\u00bf\u00be\u0001\u0000\u0000\u0000\u00c0\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c2\u00c4\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c4\u00d4\u0005\u0015\u0000\u0000\u00c5\u00c6\u0005\f\u0000\u0000\u00c6"+
		"\u00c7\u0005\u0012\u0000\u0000\u00c7\u00cb\u0005\u0016\u0000\u0000\u00c8"+
		"\u00ca\u0005\u000b\u0000\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000\u00ca"+
		"\u00cd\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cb"+
		"\u00cc\u0001\u0000\u0000\u0000\u00cc\u00cf\u0001\u0000\u0000\u0000\u00cd"+
		"\u00cb\u0001\u0000\u0000\u0000\u00ce\u00d0\u0005\u0016\u0000\u0000\u00cf"+
		"\u00ce\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d3\u0005\u0015\u0000\u0000\u00d2"+
		"\u00c5\u0001\u0000\u0000\u0000\u00d3\u00d6\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d8\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d7"+
		"\u00bc\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8"+
		"\u00d9\u0001\u0000\u0000\u0000\u00d9\u00da\u0005\r\u0000\u0000\u00da\u0013"+
		"\u0001\u0000\u0000\u0000\u00db\u00df\u0003\u001c\u000e\u0000\u00dc\u00df"+
		"\u0003\u001e\u000f\u0000\u00dd\u00df\u0003\u0018\f\u0000\u00de\u00db\u0001"+
		"\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00de\u00dd\u0001"+
		"\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005"+
		"\u0016\u0000\u0000\u00e1\u0015\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005"+
		"\u000e\u0000\u0000\u00e3\u00e4\u0005\u0016\u0000\u0000\u00e4\u00e7\u0005"+
		"\n\u0000\u0000\u00e5\u00e8\u0003\u001c\u000e\u0000\u00e6\u00e8\u0003\u001e"+
		"\u000f\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e7\u00e6\u0001\u0000"+
		"\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u00ea\u0003 \u0010"+
		"\u0000\u00ea\u00eb\u0005\u0003\u0000\u0000\u00eb\u00ec\u0005\u0016\u0000"+
		"\u0000\u00ec\u00ed\u0003\u001e\u000f\u0000\u00ed\u00ee\u0005\r\u0000\u0000"+
		"\u00ee\u00f6\u0005\u0006\u0000\u0000\u00ef\u00f3\u0003\u001c\u000e\u0000"+
		"\u00f0\u00f3\u0003\u001e\u000f\u0000\u00f1\u00f3\u0003\u0018\f\u0000\u00f2"+
		"\u00ef\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f2"+
		"\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4"+
		"\u00f5\u0005\u0016\u0000\u0000\u00f5\u00f7\u0001\u0000\u0000\u0000\u00f6"+
		"\u00f2\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8"+
		"\u00f6\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9"+
		"\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fb\u0005\u0007\u0000\u0000\u00fb"+
		"\u0017\u0001\u0000\u0000\u0000\u00fc\u00fe\u0005\u0016\u0000\u0000\u00fd"+
		"\u00fc\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000\u0000\u00fe"+
		"\u00ff\u0001\u0000\u0000\u0000\u00ff\u0100\u0005\u0015\u0000\u0000\u0100"+
		"\u0101\u0003\u001a\r\u0000\u0101\u0102\u0005\u0003\u0000\u0000\u0102\u0019"+
		"\u0001\u0000\u0000\u0000\u0103\u010b\u0005\n\u0000\u0000\u0104\u0106\u0005"+
		"\t\u0000\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000"+
		"\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107\u0109\u0007\u0000"+
		"\u0000\u0000\u0108\u010a\u0005\t\u0000\u0000\u0109\u0108\u0001\u0000\u0000"+
		"\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u010c\u0001\u0000\u0000"+
		"\u0000\u010b\u0105\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000"+
		"\u0000\u010c\u0117\u0001\u0000\u0000\u0000\u010d\u010f\u0005\f\u0000\u0000"+
		"\u010e\u0110\u0005\t\u0000\u0000\u010f\u010e\u0001\u0000\u0000\u0000\u010f"+
		"\u0110\u0001\u0000\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111"+
		"\u0113\u0007\u0000\u0000\u0000\u0112\u0114\u0005\t\u0000\u0000\u0113\u0112"+
		"\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114\u0116"+
		"\u0001\u0000\u0000\u0000\u0115\u010d\u0001\u0000\u0000\u0000\u0116\u0119"+
		"\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0117\u0118"+
		"\u0001\u0000\u0000\u0000\u0118\u011a\u0001\u0000\u0000\u0000\u0119\u0117"+
		"\u0001\u0000\u0000\u0000\u011a\u011b\u0005\r\u0000\u0000\u011b\u001b\u0001"+
		"\u0000\u0000\u0000\u011c\u0120\u0005\u0012\u0000\u0000\u011d\u011f\u0005"+
		"\u000b\u0000\u0000\u011e\u011d\u0001\u0000\u0000\u0000\u011f\u0122\u0001"+
		"\u0000\u0000\u0000\u0120\u011e\u0001\u0000\u0000\u0000\u0120\u0121\u0001"+
		"\u0000\u0000\u0000\u0121\u0123\u0001\u0000\u0000\u0000\u0122\u0120\u0001"+
		"\u0000\u0000\u0000\u0123\u0124\u0005\u0016\u0000\u0000\u0124\u0125\u0003"+
		"\u001e\u000f\u0000\u0125\u001d\u0001\u0000\u0000\u0000\u0126\u0127\u0005"+
		"\u0015\u0000\u0000\u0127\u012a\u0005\u0016\u0000\u0000\u0128\u0129\u0005"+
		"\b\u0000\u0000\u0129\u012b\u0003 \u0010\u0000\u012a\u0128\u0001\u0000"+
		"\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000\u012b\u012d\u0001\u0000"+
		"\u0000\u0000\u012c\u012e\u0005\u0003\u0000\u0000\u012d\u012c\u0001\u0000"+
		"\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e\u001f\u0001\u0000"+
		"\u0000\u0000\u012f\u0136\u0003\"\u0011\u0000\u0130\u0131\u0005\u000f\u0000"+
		"\u0000\u0131\u0135\u0003\"\u0011\u0000\u0132\u0133\u0005\u0010\u0000\u0000"+
		"\u0133\u0135\u0003\"\u0011\u0000\u0134\u0130\u0001\u0000\u0000\u0000\u0134"+
		"\u0132\u0001\u0000\u0000\u0000\u0135\u0138\u0001\u0000\u0000\u0000\u0136"+
		"\u0134\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000\u0000\u0137"+
		"!\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0139\u013b"+
		"\u0005\u0016\u0000\u0000\u013a\u0139\u0001\u0000\u0000\u0000\u013a\u013b"+
		"\u0001\u0000\u0000\u0000\u013b\u013c\u0001\u0000\u0000\u0000\u013c\u013e"+
		"\u0003$\u0012\u0000\u013d\u013f\u0005\u0016\u0000\u0000\u013e\u013d\u0001"+
		"\u0000\u0000\u0000\u013e\u013f\u0001\u0000\u0000\u0000\u013f\u0146\u0001"+
		"\u0000\u0000\u0000\u0140\u0141\u0005\u0016\u0000\u0000\u0141\u0142\u0005"+
		"\u0013\u0000\u0000\u0142\u0143\u0005\u0016\u0000\u0000\u0143\u0145\u0003"+
		"$\u0012\u0000\u0144\u0140\u0001\u0000\u0000\u0000\u0145\u0148\u0001\u0000"+
		"\u0000\u0000\u0146\u0144\u0001\u0000\u0000\u0000\u0146\u0147\u0001\u0000"+
		"\u0000\u0000\u0147#\u0001\u0000\u0000\u0000\u0148\u0146\u0001\u0000\u0000"+
		"\u0000\u0149\u014b\u0005\u0010\u0000\u0000\u014a\u0149\u0001\u0000\u0000"+
		"\u0000\u014a\u014b\u0001\u0000\u0000\u0000\u014b\u014c\u0001\u0000\u0000"+
		"\u0000\u014c\u014d\u0005\n\u0000\u0000\u014d\u014e\u0003 \u0010\u0000"+
		"\u014e\u014f\u0005\r\u0000\u0000\u014f\u0169\u0001\u0000\u0000\u0000\u0150"+
		"\u0152\u0005\u0010\u0000\u0000\u0151\u0150\u0001\u0000\u0000\u0000\u0151"+
		"\u0152\u0001\u0000\u0000\u0000\u0152\u0154\u0001\u0000\u0000\u0000\u0153"+
		"\u0155\u0005\t\u0000\u0000\u0154\u0153\u0001\u0000\u0000\u0000\u0154\u0155"+
		"\u0001\u0000\u0000\u0000\u0155\u0157\u0001\u0000\u0000\u0000\u0156\u0158"+
		"\u0005\u0014\u0000\u0000\u0157\u0156\u0001\u0000\u0000\u0000\u0157\u0158"+
		"\u0001\u0000\u0000\u0000\u0158\u015a\u0001\u0000\u0000\u0000\u0159\u015b"+
		"\u0005\t\u0000\u0000\u015a\u0159\u0001\u0000\u0000\u0000\u015a\u015b\u0001"+
		"\u0000\u0000\u0000\u015b\u0169\u0001\u0000\u0000\u0000\u015c\u015e\u0005"+
		"\u0010\u0000\u0000\u015d\u015c\u0001\u0000\u0000\u0000\u015d\u015e\u0001"+
		"\u0000\u0000\u0000\u015e\u0160\u0001\u0000\u0000\u0000\u015f\u0161\u0005"+
		"\t\u0000\u0000\u0160\u015f\u0001\u0000\u0000\u0000\u0160\u0161\u0001\u0000"+
		"\u0000\u0000\u0161\u0163\u0001\u0000\u0000\u0000\u0162\u0164\u0005\u0015"+
		"\u0000\u0000\u0163\u0162\u0001\u0000\u0000\u0000\u0163\u0164\u0001\u0000"+
		"\u0000\u0000\u0164\u0166\u0001\u0000\u0000\u0000\u0165\u0167\u0005\t\u0000"+
		"\u0000\u0166\u0165\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000"+
		"\u0000\u0167\u0169\u0001\u0000\u0000\u0000\u0168\u014a\u0001\u0000\u0000"+
		"\u0000\u0168\u0151\u0001\u0000\u0000\u0000\u0168\u015d\u0001\u0000\u0000"+
		"\u0000\u0169%\u0001\u0000\u0000\u00004+2<H]aflz\u0082\u0088\u0090\u0095"+
		"\u0099\u009b\u00a0\u00a6\u00b5\u00c1\u00cb\u00cf\u00d4\u00d7\u00de\u00e7"+
		"\u00f2\u00f8\u00fd\u0105\u0109\u010b\u010f\u0113\u0117\u0120\u012a\u012d"+
		"\u0134\u0136\u013a\u013e\u0146\u014a\u0151\u0154\u0157\u015a\u015d\u0160"+
		"\u0163\u0166\u0168";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}