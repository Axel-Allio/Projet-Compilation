public class Evaluator
{
    private double result;
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
    void visit(Equal v);
    void visit(NonEqual v);
    void visit(Inf v);
    void visit(Sup v); 
    void visit(SupEqual v);
    void visit(InfEqual v);

}