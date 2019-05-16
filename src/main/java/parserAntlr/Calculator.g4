grammar Calculator;
mainExpr: expr+;
expr
  : expr op=MUL expr        # Mul
  | expr op=DIV expr        # Div
  |	expr op=ADD expr        # Add
  | expr op=SUB expr        # Sub
  |	NUMBER                  # Number
  | SUB expr                # Negation
  |	'(' inside=expr ')'     # Par
  ;

MUL: 'x';
DIV: '/';
ADD: '+';
SUB: '-';
NEWLINE : [ \r\n\t]+ -> skip;
NUMBER    : ('0'..'9')+ ('.' ('0'..'9')+)?;