public class Char extends Expression
{
    public String aValue;

    public Char(String pValue)
    {
        aValue = pValue;
    }
    
    public void accept(Visitor v)
    {
        v.visit(this);
    }
}