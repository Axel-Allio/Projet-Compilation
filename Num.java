public class Num extends Expression
{
    public double aValue;

    public Num(double pValue)
    {
        aValue = pValue;
    }
    
    public void accept(Visitor v)
    {
        v.visit(this);
    }
}