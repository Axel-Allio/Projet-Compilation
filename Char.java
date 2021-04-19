public class Char extends Expression
{
    public String aVal;

    public Char(String pVal)
    {
        aVal = pVal;
    }
    
    public void accept(Visitor v)
    {
        v.visit(this);
    }
}