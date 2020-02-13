import java_cup.runtime.*; // defines the Symbol class
import java.util.*;
// The generated scanner will return a Symbol for each token that it finds.
// A Symbol contains an Object field named value; that field will be of type
// TokenVal, defined below.
//
// A TokenVal object contains the line number on which the token occurs as
// well as the number of the character on that line that starts the token.
// Some tokens (literals and IDs) also include the value of the token.
class TokenVal {
  // fields
    int linenum;
    int charnum;
  // constructor
    TokenVal(int line, int ch) {
        linenum = line;
        charnum = ch;
    }
}
class IntLitTokenVal extends TokenVal {
  // new field: the value of the integer literal
    int intVal;
  // constructor
    IntLitTokenVal(int line, int ch, int val) {
        super(line, ch);
        intVal = val;
    }
}
class IdTokenVal extends TokenVal {
  // new field: the value of the identifier
    String idVal;
  // constructor
    IdTokenVal(int line, int ch, String val) {
        super(line, ch);
    idVal = val;
    }
}
class StrLitTokenVal extends TokenVal {
  // new field: the value of the string literal
    String strVal;
  // constructor
    StrLitTokenVal(int line, int ch, String val) {
        super(line, ch);
        strVal = val;
    }
}
// The following class is used to keep track of the character number at which
// the current token starts on its line.
class CharNum {
    static int num=1;
}
class temp{
    static HashMap<String, Integer> reserve_map = new HashMap<>(){{
      put("bool",sym.BOOL);
      put("int",sym.INT);
      put("void",sym.VOID);
      put("true",sym.TRUE);
      put("false",sym.FALSE);
      put("struct",sym.STRUCT);
      put("cin",sym.CIN);
      put("cout",sym.COUT);
      put("if",sym.IF);
      put("else",sym.ELSE);
      put("while",sym.WHILE);
      put("return",sym.RETURN);
      put("(",sym.LPAREN);
      put(")",sym.RPAREN);
      put("{",sym.LCURLY);
      put("}",sym.RCURLY);
      put(";",sym.SEMICOLON);
      put(",",sym.COMMA);
      put(".",sym.DOT);
      put("<<",sym.WRITE);
      put(">>",sym.READ);
      put("++",sym.PLUSPLUS);
      put("--",sym.MINUSMINUS);
      put("+",sym.PLUS);
      put("-",sym.MINUS);
      put("*",sym.TIMES);
      put("/",sym.DIVIDE);
      put("!",sym.NOT);
      put("&&",sym.AND);
      put("||",sym.OR);
      put("==",sym.EQUALS);
      put("!=",sym.NOTEQUALS);
      put("<",sym.LESS);
      put(">",sym.GREATER);
      put("<=",sym.LESSEQ);
      put(">=",sym.GREATEREQ);
      put("=",sym.ASSIGN);
    }};
}


class Yylex implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 128;
	private final int YY_EOF = 129;
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NOT_ACCEPT,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NOT_ACCEPT,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"2:9,35,34,2:2,33,2:18,35,25,30,1,2:2,26,32,20:3,23,20,24,20,1,29:10,2,20,21" +
",27,22,32,2,28:26,2,31,2:2,28,2,15,3,17,10,13,14,28,19,6,28:2,5,28,7,4,28:2" +
",11,16,8,12,9,18,28:3,20,1,20,2:2,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,53,
"0,1,2,1,3,1,4,1,5,6,1,7,1,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24," +
"25,26,27,28,29,30,31,32,33,34,35,36,37,38,23,39,40,41,42,31,43,44,45")[0];

	private int yy_nxt[][] = unpackFromString(46,36,
"1,2,3,4,44:2,15,44,46,47,44,48,44,49,50,44,51,29,52,44,5,16,20,22,24,26,14," +
"26,44,6,18,3:2,-1,7,8,-1:37,2:32,-1:2,2,-1:3,44,30,44:15,-1:8,44,31,-1:35,6" +
",-1:41,8,-1,9:29,10,13,9:2,-1,9,-1,11:29,12,17,11:2,-1,11,-1,11:6,9:2,11:21" +
",9:3,-1,11:2,-1:26,5,-1:12,44:4,19,44:6,28,44:5,-1:8,44,31,-1:27,5,-1:5,5,-" +
"1:9,11:32,-1,11:2,-1,9:29,-1,13,9:2,-1,9,-1:3,44:5,28,44:11,-1:8,44,31,-1:2" +
"8,5,-1:4,5,-1:11,44:4,28,44:12,-1:8,44,31,-1:29,5,-1:15,44:2,28,44:14,-1:8," +
"44,31,-1:30,5,-1:14,44:10,28,44:6,-1:8,44,31,-1:33,5,-1:11,44:7,28,44:9,-1:" +
"8,44,31,-1:9,44:17,-1:8,44,31,-1:9,44,38,44,21,44:13,-1:8,44,31,-1:9,44,23," +
"44:15,-1:8,44,31,-1:9,31:17,-1:8,31:2,-1:9,44:9,25,44:7,-1:8,44,31,-1:9,44:" +
"3,27,44:13,-1:8,44,31,-1:9,44:5,40,44:11,-1:8,44,31,-1:9,44:13,25,44:3,-1:8" +
",44,31,-1:9,44:2,35,44:14,-1:8,44,31,-1:9,44:8,45,44:8,-1:8,44,31,-1:9,44:9" +
",19,44:7,-1:8,44,31,-1:9,44:3,41,44:13,-1:8,44,31,-1:9,44:9,42,44:7,-1:8,44" +
",31,-1:9,44:2,25,44:14,-1:8,44,31,-1:9,44:8,21,44:8,-1:8,44,31,-1:9,44:14,1" +
"9,44:2,-1:8,44,31,-1:9,44:9,43,44:7,-1:8,44,31,-1:9,44:8,32,44:8,-1:8,44,31" +
",-1:9,44,33,44:15,-1:8,44,31,-1:9,44:10,34,44:6,-1:8,44,31,-1:9,44:12,36,44" +
":4,-1:8,44,31,-1:9,44:5,37,44:11,-1:8,44,31,-1:9,44:16,39,-1:8,44,31,-1:6");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {

return new Symbol(sym.EOF);
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{
}
					case -3:
						break;
					case 3:
						{ ErrMsg.fatal(yyline+1, CharNum.num,
                         "ignoring illegal character: " + yytext());
            CharNum.num++;
          }
					case -4:
						break;
					case 4:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -5:
						break;
					case 5:
						{ 
            Symbol s = new Symbol(temp.reserve_map.get(yytext()),
                              new TokenVal(yyline+1, CharNum.num));
            CharNum.num++;
            return s;
          }
					case -6:
						break;
					case 6:
						{ 
            Symbol s;
            try{
              int val = Integer.parseInt(yytext());
              s = new Symbol(sym.INTLITERAL,
                              new IntLitTokenVal(yyline+1, CharNum.num, val));
              }catch(NumberFormatException e){
                ErrMsg.warn(yyline+1, CharNum.num,
                         "integer literal too large; using max value");
                s = new Symbol(sym.INTLITERAL,
                                new IntLitTokenVal(yyline+1, CharNum.num, Integer.MAX_VALUE));
              }
            CharNum.num += yytext().length();
            return s;
          }
					case -7:
						break;
					case 7:
						{ CharNum.num = 1; }
					case -8:
						break;
					case 8:
						{ CharNum.num += yytext().length(); }
					case -9:
						break;
					case 9:
						{//unterminated string literal
            ErrMsg.fatal(yyline+1, CharNum.num,
                         "unterminated string literal ignored: " + yytext());
            CharNum.num += yytext().length();
          }
					case -10:
						break;
					case 10:
						{//normal string literal
            Symbol s = new Symbol(sym.STRINGLITERAL,
                             new StrLitTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -11:
						break;
					case 11:
						{//untemrinated bad string literal
            ErrMsg.fatal(yyline+1, CharNum.num,
                         "unterminated string literal with bad escaped" +
                         " character ignored: " + yytext());
            CharNum.num += yytext().length();
          }
					case -12:
						break;
					case 12:
						{//temrinated bad string literal
            ErrMsg.fatal(yyline+1, CharNum.num,
                         "string literal with bad escaped character" +
                         " ignored: " + yytext());
            CharNum.num += yytext().length();
          }
					case -13:
						break;
					case 14:
						{ ErrMsg.fatal(yyline+1, CharNum.num,
                         "ignoring illegal character: " + yytext());
            CharNum.num++;
          }
					case -14:
						break;
					case 15:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -15:
						break;
					case 16:
						{ 
            Symbol s = new Symbol(temp.reserve_map.get(yytext()),
                              new TokenVal(yyline+1, CharNum.num));
            CharNum.num++;
            return s;
          }
					case -16:
						break;
					case 18:
						{ ErrMsg.fatal(yyline+1, CharNum.num,
                         "ignoring illegal character: " + yytext());
            CharNum.num++;
          }
					case -17:
						break;
					case 19:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -18:
						break;
					case 20:
						{ 
            Symbol s = new Symbol(temp.reserve_map.get(yytext()),
                              new TokenVal(yyline+1, CharNum.num));
            CharNum.num++;
            return s;
          }
					case -19:
						break;
					case 21:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -20:
						break;
					case 22:
						{ 
            Symbol s = new Symbol(temp.reserve_map.get(yytext()),
                              new TokenVal(yyline+1, CharNum.num));
            CharNum.num++;
            return s;
          }
					case -21:
						break;
					case 23:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -22:
						break;
					case 24:
						{ 
            Symbol s = new Symbol(temp.reserve_map.get(yytext()),
                              new TokenVal(yyline+1, CharNum.num));
            CharNum.num++;
            return s;
          }
					case -23:
						break;
					case 25:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -24:
						break;
					case 26:
						{ 
            Symbol s = new Symbol(temp.reserve_map.get(yytext()),
                              new TokenVal(yyline+1, CharNum.num));
            CharNum.num++;
            return s;
          }
					case -25:
						break;
					case 27:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -26:
						break;
					case 28:
						{ 
            Symbol s = new Symbol(temp.reserve_map.get(yytext()),
                              new TokenVal(yyline+1, CharNum.num));
            CharNum.num++;
            return s;
          }
					case -27:
						break;
					case 29:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -28:
						break;
					case 30:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -29:
						break;
					case 31:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -30:
						break;
					case 32:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -31:
						break;
					case 33:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -32:
						break;
					case 34:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -33:
						break;
					case 35:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -34:
						break;
					case 36:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -35:
						break;
					case 37:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -36:
						break;
					case 38:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -37:
						break;
					case 39:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -38:
						break;
					case 40:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -39:
						break;
					case 41:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -40:
						break;
					case 42:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -41:
						break;
					case 43:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -42:
						break;
					case 44:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -43:
						break;
					case 45:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -44:
						break;
					case 46:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -45:
						break;
					case 47:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -46:
						break;
					case 48:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -47:
						break;
					case 49:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -48:
						break;
					case 50:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -49:
						break;
					case 51:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -50:
						break;
					case 52:
						{
            Symbol s = new Symbol(sym.ID,
                             new IdTokenVal(yyline+1, CharNum.num, yytext()));
            CharNum.num += yytext().length();
            return s;
          }
					case -51:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
