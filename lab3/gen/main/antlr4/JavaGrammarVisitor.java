// Generated from M:/Mike/ITMO/lab3/src/main/antlr4/JavaGrammar.g4 by ANTLR 4.13.1
package main.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JavaGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JavaGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(JavaGrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#package}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackage(JavaGrammarParser.PackageContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#imports}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImports(JavaGrammarParser.ImportsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#main_class}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain_class(JavaGrammarParser.Main_classContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#class}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass(JavaGrammarParser.ClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#class_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_body(JavaGrammarParser.Class_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor(JavaGrammarParser.ConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(JavaGrammarParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(JavaGrammarParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(JavaGrammarParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(JavaGrammarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#for_cycle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_cycle(JavaGrammarParser.For_cycleContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(JavaGrammarParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#function_arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_arguments(JavaGrammarParser.Function_argumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#variable_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_declaration(JavaGrammarParser.Variable_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#variable_redelcaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_redelcaration(JavaGrammarParser.Variable_redelcarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(JavaGrammarParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(JavaGrammarParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF(JavaGrammarParser.FContext ctx);
}