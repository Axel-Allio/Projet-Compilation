public class Assignment extends Expression
{
    public String aName;
    public Exp aValue;
    public Scope scope;

	public Assignment(String str, Exp e, Scope s)
	{
		aName = str;
        aValue = v;
        scope = s;
	}

    public void accept(Visitor v)
    {
        v.visit(this);
    }
}