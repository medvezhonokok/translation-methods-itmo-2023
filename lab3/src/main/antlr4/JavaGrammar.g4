grammar JavaGrammar;

start : package WS imports+ main_class WS class*;

package : 'package' WS WORD ('.' WORD)* ';';
imports : 'import' WS WORD ('.' WORD)* ';' WS;

main_class : MODIFIER WS class;

class : 'class' WS WORD WS '{' class_body '}';
class_body : field+ WS constructor? method* class*;

constructor: MODIFIER WS WORD WS arguments WS '{' WS statement* WS '}' WS;
field : MODIFIER? (WS MODIFIER)* WS TYPE WS WORD WS? ('=' WS ('"')? (NUMBER | WORD) ('"')?)? ';';
method : MODIFIER? (WS MODIFIER)* WS TYPE WS WORD WS arguments WS '{' WS statement* '}' WS;

arguments : '(' (TYPE WS ('[]')*  WORD (', ' TYPE WS ('[]')* WS? WORD)*)? ')';
statement : (variable_declaration | variable_redelcaration | function_call ) WS;

for_cycle : 'for' WS '(' (variable_declaration | variable_redelcaration) expression ';' WS variable_redelcaration ')' '{'  ((variable_declaration | variable_redelcaration | function_call) WS)+ '}';

function_call : WS? WORD function_arguments ';';
function_arguments : '(' (('"')?(WORD | NUMBER) ('"')? )?  (', ' ('"')? (WORD | NUMBER) ('"')? )* ')' ;

variable_declaration : TYPE ('[]')* WS variable_redelcaration;
variable_redelcaration : WORD WS ('=' expression)? ';'?;

expression: term (('+' term)| ('-' term ))*;

term: WS? f WS? (WS OPERATION WS f )*;

f: (('-')? ( '(' expression ')')) | (('-')? ('"')? NUMBER? ('"')?) | (('-')? (('"')? WORD? ('"')?));

MODIFIER : 'private' | 'static' | 'final' | 'synchronized ' | 'public' | 'protected';
TYPE : 'int' | 'long' | 'double' | 'String' | 'void' | 'var' | 'boolean' | 'float';

OPERATION : '*' | '/' | '&&' | '||' | '>' | '<' | '!=';

NUMBER : ([0-9]+) | ([0-9]+ '.' [0-9]+);
WORD : [a-zA-Z_][a-zA-Z0-9_]*;

WS : [ \r\t\n]+;