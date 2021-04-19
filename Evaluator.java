public class Evaluator
{
    private double result;
    private bool resultBool;
    private String resultString;

    public Evaluator(Expression e){
        e.accept(this);

    }

    // TYPE
    void visit(Chaine v);
    void visit(Num v){
        
    }

    // CALCUL
    void visit(Neg v);
    void visit(Add v);
    void visit(Sub v);
    void visit(Mul v);
    void visit(Div v);

    // COMPARISON
    void visit(Equal n){
        resultBool = n.lhs == n.rhs;
        resultString = resultBool.toString();
    }
    void visit(NonEqual n){
        resultBool = n.lhs != n.rhs
        resultString = resultBool.toString();
    }
    void visit(Inf n){
        resultBool = n.lhs < n.rhs
        resultString = resultBool.toString();
    }
    void visit(Sup n){
        resultBool = n.lhs > n.rhs
        resultString = resultBool.toString();
    }
    void visit(SupEqual n){
        resultBool = n.lhs >= n.rhs
        resultString = resultBool.toString();
    }
    void visit(InfEqual n){
        resultBool = n.lhs <= n.rhs
        resultString = resultBool.toString();
    }

}