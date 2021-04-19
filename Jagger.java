/* Jagger.java */
/* Generated By:JavaCC: Do not edit this line. Jagger.java */
import java.util.ArrayList;
import java.util.HashMap;

public class Jagger implements JaggerConstants {
    public static void main(String args[]) throws ParseException
    {
        Jagger parser = new Jagger(System.in);
        parser.mainloop();
    }

// Main lopp: read expressions on a line until end of file.
//     mainloop → (expression <EOL>)* <EOF>
  static final public void mainloop() throws ParseException {Expression a;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PRINT:
      case IF:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IF:{
        a = ITE();
        jj_consume_token(EOL);
new PrettyPrinter(a); System.out.println(); new Evaluator(a);
        break;
        }
      case PRINT:{
        a = print();
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(0);
  }

//Statement
//statement → print | comparison
  static final public Expression statement() throws ParseException {Token t; Expression a;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case LRB:
    case NUMBER:
    case STRING:
    case 22:
    case 23:{
      a = comparison();
      break;
      }
    case PRINT:{
      a = print();
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return a;}
    throw new Error("Missing return statement in function");
  }

//Print.
// print -> print(comparison())
  static final public Expression print() throws ParseException {Expression a;
    jj_consume_token(PRINT);
    jj_consume_token(LRB);
    a = comparison();
    jj_consume_token(RRB);
{if ("" != null) return new Print(a);}
    throw new Error("Missing return statement in function");
  }

// Comparison operators.
// C -> E ('=='E | '<>'E | '>'E | '<'E | '>='E | '<='E)*
  static final public Expression comparison() throws ParseException {Expression a,b;
    a = expression();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 16:
    case 17:
    case 18:
    case 19:
    case 20:
    case 21:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 16:{
        jj_consume_token(16);
        b = expression();
a = new Equal(a,b);
        break;
        }
      case 17:{
        jj_consume_token(17);
        b = expression();
a = new NonEqual(a,b);
        break;
        }
      case 18:{
        jj_consume_token(18);
        b = expression();
a = new Sup(a,b);
        break;
        }
      case 19:{
        jj_consume_token(19);
        b = expression();
a = new Inf(a,b);
        break;
        }
      case 20:{
        jj_consume_token(20);
        b = expression();
a = new SupEqual(a,b);
        break;
        }
      case 21:{
        jj_consume_token(21);
        b = expression();
a = new InfEqual(a,b);
        break;
        }
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
      }
    default:
      jj_la1[4] = jj_gen;
      ;
    }
{if ("" != null) return a;}
    throw new Error("Missing return statement in function");
  }

// Expression (the axiom).
// E -> T ('+'T | '-'T)*
  static final public Expression expression() throws ParseException {Expression a,b;
    a = term();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 22:
    case 23:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 22:{
        jj_consume_token(22);
        b = term();
a=new Add(a,b);
        break;
        }
      case 23:{
        jj_consume_token(23);
        b = term();
a=new Sub(a,b);
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
      }
    default:
      jj_la1[6] = jj_gen;
      ;
    }
{if ("" != null) return a;}
    throw new Error("Missing return statement in function");
  }

// Term.
// T -> U ('*'U | '/'U)*
  static final public Expression term() throws ParseException {Expression a,b;
    a = unary();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 24:
      case 25:{
        ;
        break;
        }
      default:
        jj_la1[7] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 24:{
        jj_consume_token(24);
        b = term();
a=new Mul(a,b);
        break;
        }
      case 25:{
        jj_consume_token(25);
        b = term();
a=new Div(a,b);
        break;
        }
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
{if ("" != null) return a;}
    throw new Error("Missing return statement in function");
  }

//Unary expression
// U -> "-" F | ("+")?F
  static final public Expression unary() throws ParseException {Expression a;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 23:{
      jj_consume_token(23);
      a = factor();
a=new Neg(a);
      break;
      }
    case LRB:
    case NUMBER:
    case STRING:
    case 22:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 22:{
        jj_consume_token(22);
        break;
        }
      default:
        jj_la1[9] = jj_gen;
        ;
      }
      a = factor();
      break;
      }
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return a;}
    throw new Error("Missing return statement in function");
  }

// Factor of an expression.
// F -> <NUMBER> | "(" E ")"
  static final public Expression factor() throws ParseException {Token t; Expression a;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case NUMBER:{
      t = jj_consume_token(NUMBER);
a = new Num(Double.parseDouble(t.toString()));
      break;
      }
    case STRING:{
      t = jj_consume_token(STRING);
a = new Char(t.toString());
      break;
      }
    case LRB:{
      jj_consume_token(LRB);
      a = comparison();
      jj_consume_token(RRB);
      break;
      }
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return a;}
    throw new Error("Missing return statement in function");
  }

  static final public Expression ITE() throws ParseException {Expression a,b,c;
    label_3:
    while (true) {
      jj_consume_token(IF);
      a = comparison();
      jj_consume_token(THEN);
      b = expression();
      jj_consume_token(ELSE);
      c = expression();
a = new IfThenElse(a,b,c);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IF:{
        ;
        break;
        }
      default:
        jj_la1[12] = jj_gen;
        break label_3;
      }
    }
{if ("" != null) return a;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public JaggerTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[13];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x90,0x90,0xc03030,0x3f0000,0x3f0000,0xc00000,0xc00000,0x3000000,0x3000000,0x400000,0xc03020,0x3020,0x80,};
   }

  /** Constructor with InputStream. */
  public Jagger(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Jagger(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new JaggerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Jagger(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new JaggerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Jagger(JaggerTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(JaggerTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[26];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 13; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 26; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
