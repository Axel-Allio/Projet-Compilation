public class Print extends Expression
{
    public Expression aValue;

	public Print(Expression a)
	{
		aValue = a;
	}

    public void accept(Visitor v)
    {
        v.visit(this);
    }

}