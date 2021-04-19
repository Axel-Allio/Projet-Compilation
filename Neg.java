public class Neg extends Expression
{
    public Expression exp;

	public Neg(Expression a)
	{
		exp = a;
	}

    public void accept(Visitor v)
    {
        v.visit(this);
    }

}