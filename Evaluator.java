public class Evaluator
{
    private double result;
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
    void visit(Equal n);
    void visit(NonEqual n);
    void visit(Inf n);
    void visit(Sup n);
    void visit(SupEqual n);
    void visit(InfEqual n);

}