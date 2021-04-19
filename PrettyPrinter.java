public class PrettyPrinter extends Visitor
{
    private Scope scope;
    private int nbOfScope;

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

    void visit(IfThenElse v){
        System.out.print("if ");
	    v.aCondition.accept(this);
		System.out.print(" then\n");
		v.aThen.accept(this);
		System.out.print("\nelse\n");
		v.aElse.accept(this);
		System.out.print("\n");
    }

    public void visit(Scope s)
	{
		scope = s;
		nbOfScope++;
		System.out.println("let");
		//variables
		if(!s.data.isEmpty())
			for (String entry : scope.data.keySet()) {
				indentScope(nbOfScope); System.out.print("var "+ entry + " := ");
				scope.getInScope(entry).accept(this);
				System.out.println();
			}
        }
        ArrayList<Expression> instruction = scope.getInstructions();
		indentScope(nbOfScope-1); System.out.println("in");
		for (Expression a : ins) {
			indentScope(nbOfScope); a.accept(this);
			System.out.println();
		}
		indentScope(nbOfScope-1); System.out.println("end");
		nbOfScope--;
		scope = s.parent;
	}
}