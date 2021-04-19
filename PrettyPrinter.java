public class PrettyPrinter extends Visitor
{
     private double result;
    private String resultString;

    public PrettyPrinter(Expression e){
        e.accept(this);

    }

    // TYPE
    void visit(Char v){
        System.out.print(v.aValue);
    }
    void visit(Num v){
        System.out.print(v.aValue);
    }

    // CALCUL
    void visit(Neg v){
        System.out.print("(- ");
        v.aValue.accept(this);
        System.out.print(")");
    }
    void visit(Add v){
        System.out.print("(");
        v.lhs.accept(this);
        System.out.print( "+" );
        v.rhs.accept(this);
        System.out.print(")");
    }
    void visit(Sub v){
        System.out.print("(");
        v.lhs.accept(this);
        System.out.print( "-" );
        v.rhs.accept(this);
        System.out.print(")");
    }
    void visit(Mul v){
        System.out.print("(");
        v.lhs.accept(this);
        System.out.print( "*" );
        v.rhs.accept(this);
        System.out.print(")");
    }
    void visit(Div v){
        System.out.print("(");
        v.lhs.accept(this);
        System.out.print( "/" );
        v.rhs.accept(this);
        System.out.print(")");
    }

    // COMPARISON
    void visit(Equal v){
        System.out.print("(");
        v.lhs.accept(this);
        System.out.print("==");
        v.rhs.accept(this);
        System.out.print(")");
    }
    void visit(NonEqual v){
        System.out.print("(");
		v.lhs.accept(this);
		System.out.print(" != ");
		v.rhs.accept(this);
		System.out.print(")");
    }
    void visit(Inf v){
        if(v.lhs instanceof Char && v.rhs instanceof Char) {
			System.out.print("(");
			v.lhs.accept(this);
			System.out.print(".Length < ");
			v.rhs.accept(this);
			System.out.print(".Length)");
		} 
        else if(!(v.lhs instanceof Char) && !(v.rhs instanceof Char)) {
			System.out.print("(");
			v.lhs.accept(this);
			System.out.print(" < ");
			v.rhs.accept(this);
			System.out.print(")");
		} 
        else
		    System.out.println("Incompatible types.");
    }
    void visit(Sup v){
        if(v.lhs instanceof Char && v.rhs instanceof Char) {
			System.out.print("(");
			v.lhs.accept(this);
			System.out.print(".Length < ");
			v.rhs.accept(this);
			System.out.print(".Length)");
		} 
        else if(!(v.lhs instanceof Char) && !(v.rhs instanceof Char)) {
			System.out.print("(");
			v.lhs.accept(this);
			System.out.print(" > ");
			v.rhs.accept(this);
			System.out.print(")");
		} 
        else
		    System.out.println("Incompatible types.");
    }
    void visit(SupEqual v){
        if(v.lhs instanceof Char && v.rhs instanceof Char) {
			System.out.print("(");
			v.lhs.accept(this);
			System.out.print(".Length < ");
			v.rhs.accept(this);
			System.out.print(".Length)");
		} 
        else if(!(v.lhs instanceof Char) && !(v.rhs instanceof Char)) {
			System.out.print("(");
			v.lhs.accept(this);
			System.out.print(" >= ");
			v.rhs.accept(this);
			System.out.print(")");
		} 
        else
		    System.out.println("Incompatible types.");
    }
    void visit(InfEqual v){
        if(v.lhs instanceof Char && v.rhs instanceof Char) {
			System.out.print("(");
			v.lhs.accept(this);
			System.out.print(".Length < ");
			v.rhs.accept(this);
			System.out.print(".Length)");
		} 
        else if(!(v.lhs instanceof Char) && !(v.rhs instanceof Char)) {
			System.out.print("(");
			v.lhs.accept(this);
			System.out.print(" <= ");
			v.rhs.accept(this);
			System.out.print(")");
		} 
        else
		    System.out.println("Incompatible types.");
    }

    void visit(Print v){
        System.out.print("print(");
		v.aValue.accept(this);
		System.out.print(")");
    }
}