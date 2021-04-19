public class Sup extends Expression
{
    public Expression lhs;
    public Expression rhs;

	public Sup(Expression a, Expression b)
	{
		lhs = a;
		rhs = b;
	}

    public void accept(Visitor v)
    {
        v.visit(this);
    }

}