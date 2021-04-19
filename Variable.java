public class Variable extends Expression
{
    public String name;

    public Variable(String pVal)
    {
        name = pVal;
    }
    
    public void accept(Visitor v)
    {
        v.visit(this);
    }
}