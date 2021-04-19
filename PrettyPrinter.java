public class PrettyPrinter extends Visitor
{
     private double result;
    private bool resultBool;
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
        System.out.println("-" + v.exp.accept(this));
    }
    void visit(Add v){
        System.out.println(v.lhs.accept(this) + "+" + v.rhs.accept(this));
        resultString = result.toString;
    }
    void visit(Sub v){
        System.out.println(v.lhs.accept(this) + "-" + v.rhs.accept(this));
        resultString = result.toString;
    }
    void visit(Mul v){
        System.out.println(v.lhs.accept(this) + "*" + v.rhs.accept(this));
        resultString = result.toString;
    }
    void visit(Div v){
        System.out.println(v.lhs.accept(this) + "/" + v.rhs.accept(this));
        resultString = result.toString;
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
        if(v.lhs instanceof Chaine && v.rhs instanceof Chaine) {
			System.out.print("(");
			v.lhs.accept(this);
			System.out.print(".Length < ");
			v.rhs.accept(this);
			System.out.print(".Length)");
		} else if(!(v.lhs instanceof Chaine) && !(v.rhs instanceof Chaine)) {
			System.out.print("(");
			v.lhs.accept(this);
			System.out.print(" < ");
			v.rhs.accept(this);
			System.out.print(")");
		} else
		System.out.println("Incompatible types.");
    }
    void visit(Sup v){
        resultBool = v.lhs > v.rhs
        if(v.lhs instanceof Chaine && v.rhs instanceof Chaine) {
			System.out.print("(");
			v.lhs.accept(this);
			System.out.print(".Length < ");
			v.rhs.accept(this);
			System.out.print(".Length)");
		} else if(!(v.lhs instanceof Chaine) && !(v.rhs instanceof Chaine)) {
			System.out.print("(");
			v.lhs.accept(this);
			System.out.print(" > ");
			v.rhs.accept(this);
			System.out.print(")");
		} else
		System.out.println("Incompatible types.");
    }
    void visit(SupEqual v){
        if(v.lhs instanceof Chaine && v.rhs instanceof Chaine) {
			System.out.print("(");
			v.lhs.accept(this);
			System.out.print(".Length < ");
			v.rhs.accept(this);
			System.out.print(".Length)");
		} else if(!(v.lhs instanceof Chaine) && !(v.rhs instanceof Chaine)) {
			System.out.print("(");
			v.lhs.accept(this);
			System.out.print(" >= ");
			v.rhs.accept(this);
			System.out.print(")");
		} else
		System.out.println("Incompatible types.");
    }
    void visit(InfEqual v){
        if(v.lhs instanceof Chaine && v.rhs instanceof Chaine) {
			System.out.print("(");
			v.lhs.accept(this);
			System.out.print(".Length < ");
			v.rhs.accept(this);
			System.out.print(".Length)");
		} else if(!(v.lhs instanceof Chaine) && !(v.rhs instanceof Chaine)) {
			System.out.print("(");
			v.lhs.accept(this);
			System.out.print(" <= ");
			v.rhs.accept(this);
			System.out.print(")");
		} else
		System.out.println("Incompatible types.");
    }

}
}