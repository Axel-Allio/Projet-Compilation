public class Evaluator
{
    private double result;
    private bool resultBool;
    private String resultString;

    public Evaluator(Expression e){
        e.accept(this);

    }

    // TYPE
    void visit(Chaine v){
        
    }
    void visit(Num v){
        resultString = v.aValue.ToString();
    }

    // CALCUL
    void visit(Neg v);
    void visit(Add v);
    void visit(Sub v);
    void visit(Mul v);
    void visit(Div v);

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