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
        resultString = v.aValue;
    }
    void visit(Num v){
        resultString = v.aValue.toString();
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
        resultBool = v.lhs == v.rhs;
        resultString = resultBool.toString();
    }
    void visit(NonEqual v){
        resultBool = v.lhs != v.rhs
        resultString = resultBool.toString();
    }
    void visit(Inf v){
        resultBool = v.lhs < v.rhs
        resultString = resultBool.toString();
    }
    void visit(Sup v){
        resultBool = v.lhs > v.rhs
        resultString = resultBool.toString();
    }
    void visit(SupEqual v){
        resultBool = v.lhs >= v.rhs
        resultString = resultBool.toString();
    }
    void visit(InfEqual v){
        resultBool = v.lhs <= v.rhs
        resultString = resultBool.toString();
    }

}
}