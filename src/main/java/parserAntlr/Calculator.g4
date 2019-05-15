grammar Calculator;
mainExpr: expr+;
expr
  : expr op=MUL expr        # Mul
  | expr op=DIV expr        # Div
  |	expr op=ADD expr        # Add
  | expr op=SUB expr        # Sub
  |	NUMBER                  # Number
  |	'(' inside=expr ')'     # Par
  ;

MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
NEWLINE : [ \r\n\t]+ -> skip;
NUMBER    : [0-9]+ ;