public class Neg extends Expression
{
    public Expression aValue;

	public Neg(Expression a)
	{
		aValue = a;
	}

    public void accept(Visitor v)
    {
        v.visit(this);
    }

}