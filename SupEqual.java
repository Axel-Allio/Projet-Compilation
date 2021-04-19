public class SupEqual extends Expression
{
    public Expression lhs;
    public Expression rhs;

	public SupEqual(Expression a, Expression b)
	{
		lhs = a;
		rhs = b;
	}

    public void accept(Visitor v)
    {
        v.visit(this);
    }

}