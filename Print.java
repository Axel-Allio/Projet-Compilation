public class Print extends Expression
{
    public Expression exp;

	public Print(Expression a)
	{
		exp = a;;
	}

    public void accept(Visitor v)
    {
        v.visit(this);
    }

}