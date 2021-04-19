public abstract class Visitor
{
    ///////Type///////
    abstract void visit(Char v);
    abstract void visit(Num v);
    abstract void visit(Variable v);

    ///////Calculs///////
    abstract void visit(Neg v);

    abstract void visit(Add v);
    abstract void visit(Sub v);
    abstract void visit(Mul v);
    abstract void visit(Div v);

    ///////Comparisons///////
    abstract void visit(Equal v);
    abstract void visit(NonEqual v);
    abstract void visit(Inf v);
    abstract void visit(Sup v);
    abstract void visit(SupEqual v);
    abstract void visit(InfEqual v);

    ///////Keywords///////
    abstract void visit(Print v);
    abstract void visit(IfThenElse v);
    abstract void visit(Scope v);
    abstract void visit(Assignment v);
}