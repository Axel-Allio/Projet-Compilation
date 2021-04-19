public class IfThenElse extends Expression
{
	Expression aCondition, aThen, aElse;

    public IfThenElse(Expression pCondition, Expression pThen, Expression pElse)
    {
        aCondition=pCondition;
		aThen=pThen;
		aElse=pElse;
	}
    
    public void accept(Visitor v)
    {
        v.visit(this);
    }
}