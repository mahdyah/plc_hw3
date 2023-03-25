# plc_hw3
##2. CFG(BNF) for PEMDAS/BODMAS 
<Expr>  <AS> | <MD> | <E>                                                                 (Leftmost Associative)
<AS>  <AS> + <MD> | <AS> - <MD> | <MD>                                   (Leftmost Associative)
<MD> <MD> * <E> |  <MD> /<E> | <MD> %<E> | <E>                      (Leftmost Associative)
<E>  <P> | <P> ^ <E>                                                                         (Rightmost Associative) 
<P>  (<Expr>) | INT_LIT |ID | FLOAT_LIT | FUNCTIONCALL.          (Leftmost Associative)
##3. 
<AS> | <MD> | <E>    <Expr>                                                               
<AS> + <MD> | <AS> - <MD> | <MD>   <AS>                                  
<MD> * <E> |  <MD> /<E> | <MD> %<E> | <E> <MD>
<P> | <P> ^ <E> <E>                                                                         
 (<Expr>) | INT_LIT |ID | FLOAT_LIT | FUNCTIONCALL  <P>       
##4.  a * 12 / (x - 7.0) 
b) Leftmost Derivation
<expr> => <MD> 
	<MD> / <E>
	<MD> * <E> / <E>
	<E> * <E> / <E>
	<P> * <E> / <E>
	ID * <E> / <E>
	ID * <P> / <E>
	ID * INT_LIT / <E>
	ID * INT_LIT / <P>
	ID * INT_LIT / (<Expr>)
	ID * INT_LIT / (<AS>)
	ID * INT_LIT / (<MD>)
	ID *INT_LIT / (<AS>)
	ID *INT_LIT / (<AS> - <MD>)
	ID *INT_LIT / (<MD> - <MD>)
	ID *INT_LIT / (<E> - <MD>)
	ID *INT_LIT / (<P> - <MD>)
	ID *INT_LIT / (ID- <MD>)
	ID *INT_LIT / (ID- <E>)
	ID *INT_LIT / (ID- <P>)
	ID *INT_LIT / (ID- FLOAT_LIT)


b) Rightmost Derivation
<expr> => <MD> 
	<MD> /<E> 
	<MD> /<P> 
	<MD>/ (<Expr>)
	<MD>/ (<AS>)
	<MD>/ (<AS> - <MD>)
	<MD>/ (<AS> - <E>)
	<MD>/ (<AS> - <P>)
	<MD>/ (<MD> - FLOAT_LIT)
	<MD>/ (<E> - FLOAT_LIT)
	<MD>/ (<P> - FLOAT_LIT)
	<MD>/ (ID - FLOAT_LIT)
	<MD>* <E> / (ID - FLOAT_LIT)
	<MD>*<E> / (ID - FLOAT_LIT)
	<MD>*<P> / (ID - FLOAT_LIT)
	<MD>*INT_LIT / (ID - FLOAT_LIT)
	<E>*INT_LIT / (ID - FLOAT_LIT)
	<P>* INT_LIT /(ID - FLOAT_LIT)
	ID *INT_LIT /(ID - FLOAT_LIT)

##5.
<ForStmt> `for` [ <Condition> | <ForClause> | <RangeClause> ] <Block> 

1.<ForStmt> `for` <Block>
	   `for` {`statmentList `}`
	`for` {`statement `;` `}`
	For {}

2. ForStmt `for` Condition Block
	  `for` Condition  {}
	`for` Expression {}
	`for` UnaryExpr{}
	`for` PrimaryExpr{``}
`for` Operand { }
`for` Literal{}
`for` BasicLit{ }

3. <ForStmt> `for` <ForClause> <Block> 
    `for` <ForClause> {}
    `for` [ InitStmt ] ";" [ Condition ] ";" [ PostStmt ] {}
    `for`  `;``;` {}
4. 
   `for` <ForClause> {}
  `for` InitStmt  `;``;` {}
  `for` SimpleStmt  `;``;` {}
  `for` EmptyStmt`;``;` {}
5. 
    `for` <ForClause> {}
    `for` `;` [ Condition ] `;` {}
  `for` `;`  Condition  `;` {}
                           `for` `;` Expression`;` {}
                           `for` `;` UnaryExpr `;` {}
6.
                          `for` <ForClause> {}
  `for` `;` `;` [ PostStmt ] {}
  `for` `;``;`PostStmt {}`;`
                          `for` `;``;`SimpleStmt {}`;`
7.
<ForStmt> `for` <RangeClause>  <Block>
	   `for` <RangeClause> {}
                  `for` [ ExpressionList `=` | IdentifierList `:=` ] "range" Expression {}
  `for` [ ExpressionList `=` | IdentifierList `:=` ] "range" UnaryExpr  {}
  `for` `range` UnaryExpr  {}
8.
	   `for` <RangeClause> {}
                  `for` [ ExpressionList `=` ] `range` Expression {}
                  `for`  ExpressionList `=`  `range` Expression {}
                  `for`  Expression { "," Expression } `=`  `range`  Expression {}
	  `for`  Expression `=`  `range`  Expression {}
	  `for`  UnaryExpr`=`  `range`  Expression {}
	  `for`  UnaryExpr`=` `range`  UnaryExpr{}
9.
  `for` <RangeClause> {}
                  `for` [ ExpressionList `:=` | IdentifierList `:=` ] `range`  Expression {}
                  `for` [IdentifierList `:=` ] `range` Expression {}
  `for` IdentifierList `:=`  `range`  Expression {}
  `for` identifier { `,` identifier } `:=`  `range`  Expression {}
  `for` identifier `:=`  `range`  Expression {}
  `for`letter { letter | unicode_digit } `:=`  `range`  Expression {}
  `for`letter `:=`  `range`  Expression {}
  `for` unicode_letter | `_`  `:=`  `range`  Expression {}
  `for` `_` `:=`  `range`  Expression {}
  `for` `_` `:=`  `range`  UnaryExpr {}
10. 
  `for` [ ExpressionList `:=` | IdentifierList `:=` ] `range`  Expression {}
   `for` [IdentifierList `:=` ] `range` Expression {}
  `for` IdentifierList `:=`  `range`  Expression {}
  `for` identifier { `,` identifier } `:=`  `range`  Expression {}
  `for` identifier `,` identifier  `:=`  `range`  Expression {}
  `for` letter { letter | unicode_digit } `,` identifier  `:=`  `range` Expression {}
  `for` letter `,` identifier  `:=`  `range` Expression {}
  `for` letter `,` letter { letter | unicode_digit }  `:=`  `range` Expression {}
  `for` letter `,` letter `:=`  `range` Expression {}
  `for` unicode_letter | "_" `,` letter `:=`  `range` Expression {}
  `for` "_" `,` letter `:=`  `range` Expression {}
  `for` "_" `,` unicode_letter | "_" `:=`  `range` Expression {}
  `for` "_" `,` "_" `:=`  `range` Expression {}
  `for` "_" `,` "_" `:=`  `range`  UnaryExpr {}





  












	
















 
  

