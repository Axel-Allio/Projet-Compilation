public class Inf extends Expression
{
    public Expression lhs;
    public Expression rhs;

	public Inf(Expression a, Expression b)
	{
		lhs = a;
		rhs = b;
	}

    public void accept(Visitor v)
    {
        v.visit(this);
    }

}