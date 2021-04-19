public class Evaluator extends Visitor
{
    private double result;
    private bool resultBool;
    private String resultString;

    public Evaluator(Expression e){
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
        result = -v.exp;
        resultString = result.toString;
    }
    void visit(Add v){
        result = v.lhs + v.rhs;
        resultString = result.toString;
    }
    void visit(Sub v){
        result = v.lhs - v.rhs;
        resultString = result.toString;
    }
    void visit(Mul v){
        result = v.lhs * v.rhs;
        resultString = result.toString;
    }
    void visit(Div v){
        result = v.lhs / v.rhs;
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