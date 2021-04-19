public class Assignment extends Expression
{
    public String aName;
    public Expression aValue;
    public Scope scope;

	public Assignment(String str, Expression e, Scope s)
	{
		aName = str;
        aValue = e;
        scope = s;
	}

    public void accept(Visitor v)
    {
        v.visit(this);
    }
}