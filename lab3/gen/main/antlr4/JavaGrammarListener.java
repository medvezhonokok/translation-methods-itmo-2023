// Generated from M:/Mike/ITMO/lab3/src/main/antlr4/JavaGrammar.g4 by ANTLR 4.13.1
package main.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JavaGrammarParser}.
 */
public interface JavaGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(JavaGrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(JavaGrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#package}.
	 * @param ctx the parse tree
	 */
	void enterPackage(JavaGrammarParser.PackageContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#package}.
	 * @param ctx the parse tree
	 */
	void exitPackage(JavaGrammarParser.PackageContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#imports}.
	 * @param ctx the parse tree
	 */
	void enterImports(JavaGrammarParser.ImportsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#imports}.
	 * @param ctx the parse tree
	 */
	void exitImports(JavaGrammarParser.ImportsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#main_class}.
	 * @param ctx the parse tree
	 */
	void enterMain_class(JavaGrammarParser.Main_classContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#main_class}.
	 * @param ctx the parse tree
	 */
	void exitMain_class(JavaGrammarParser.Main_classContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#class}.
	 * @param ctx the parse tree
	 */
	void enterClass(JavaGrammarParser.ClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#class}.
	 * @param ctx the parse tree
	 */
	void exitClass(JavaGrammarParser.ClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#class_body}.
	 * @param ctx the parse tree
	 */
	void enterClass_body(JavaGrammarParser.Class_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#class_body}.
	 * @param ctx the parse tree
	 */
	void exitClass_body(JavaGrammarParser.Class_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterConstructor(JavaGrammarParser.ConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitConstructor(JavaGrammarParser.ConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(JavaGrammarParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(JavaGrammarParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(JavaGrammarParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(JavaGrammarParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(JavaGrammarParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(JavaGrammarParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(JavaGrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(JavaGrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#for_cycle}.
	 * @param ctx the parse tree
	 */
	void enterFor_cycle(JavaGrammarParser.For_cycleContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#for_cycle}.
	 * @param ctx the parse tree
	 */
	void exitFor_cycle(JavaGrammarParser.For_cycleContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(JavaGrammarParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(JavaGrammarParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#function_arguments}.
	 * @param ctx the parse tree
	 */
	void enterFunction_arguments(JavaGrammarParser.Function_argumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#function_arguments}.
	 * @param ctx the parse tree
	 */
	void exitFunction_arguments(JavaGrammarParser.Function_argumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVariable_declaration(JavaGrammarParser.Variable_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVariable_declaration(JavaGrammarParser.Variable_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#variable_redelcaration}.
	 * @param ctx the parse tree
	 */
	void enterVariable_redelcaration(JavaGrammarParser.Variable_redelcarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#variable_redelcaration}.
	 * @param ctx the parse tree
	 */
	void exitVariable_redelcaration(JavaGrammarParser.Variable_redelcarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(JavaGrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(JavaGrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(JavaGrammarParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(JavaGrammarParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterF(JavaGrammarParser.FContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitF(JavaGrammarParser.FContext ctx);
}