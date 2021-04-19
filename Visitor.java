public abstract class Visitor
{
    ///////TYPES///////
    abstract void visit(Char v);
    abstract void visit(Num v);

    ///////CALCULS///////
    //unary
    abstract void visit(Neg v);
    //binary
    abstract void visit(Add v);
    abstract void visit(Sub v);
    abstract void visit(Mul v);
    abstract void visit(Div v);

    ///////COMPARISONS///////
    abstract void visit(Equal v);
    abstract void visit(NonEqual v);
    abstract void visit(Inf v);
    abstract void visit(Sup v);
    abstract void visit(SupEqual v);
    abstract void visit(InfEqual v);

    ///////KEYWORDS///////
    abstract void visit(Print v);
    abstract void visit(IfThenElse v);
    abstract void visit(Variable v);
    abstract void visit(Scope v);
    //abstract void visit(Assignment v);
    //abstract void visit(Function v);
}