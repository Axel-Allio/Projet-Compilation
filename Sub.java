public class Sub extends Expression{
    public Expression lhs;
    public Expression rhs;

	public Sub(Expression a, Expression b)
	{
		lhs = a;
		rhs = b;
	}

    public void accept(Visitor v)
    {
        v.visit(this);
    }

}