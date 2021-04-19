public class Evaluator
{
    private double result;
    private bool resultBool;
    private String resultString;

    public Evaluator(Expression e){
        e.accept(this);

    }

    // TYPE
    void visit(Chaine n);
    void visit(Num n){
        
    }

    // CALCUL
    void visit(Neg n);
    void visit(Add n);
    void visit(Sub n);
    void visit(Mul n);
    void visit(Div n);

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