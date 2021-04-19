import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Scope extends Expression
{
    public Scope parent;
    public HashMap<String, Expression> data;
	public ArrayList<Expression> instructions;
    public HashMap<String, Function> functions;
    public Function bindedFunction;

    //constructor
    public Scope(Scope s)
    {
        parent = s;
        data = new HashMap<String, Expression>();
        instructions = new ArrayList<Expression>();
        functions = new HashMap<String, Function>();
    }

    //data
    public void addDeclaration(String s, Expression e)
    {
        Evaluator ev = new Evaluator(this);
        e.accept(ev);
        Num value = new Num(ev.getResult());
        if(!data.containsKey(s))
            data.put(s, value);
        else
            System.out.println("The variable " + s + " is already defined in the scope.");
    }

    public void changeValue(String s, Expression e){
        Evaluator ev = new Evaluator(e);
        e.accept(ev);
        Num value = new Num(ev.getResult());
        if(data.containsKey(s)){
            data.remove(s);
            data.put(s, value);
        }
        else
            System.out.println("The variable " + s + " does not exist in the scope.");
    }

    public Expression getInScope(String s){
        if(data.containsKey(s))
            return data.get(s);
        else if(parent != null)            
            return parent.getInScope(s);
        else{
            System.out.println("The variable " + s + " does not exist in the scope");
            return null;
        }
    }
    //instruction
    public ArrayList<Expression> getInstructions()
    {
        return instructions;
    }
    public void addInstruction(Expression e)
    {
        instructions.add(e);
    }
 
    //visitor
    public void accept(Visitor v)
    {
        v.visit(this);
    }
}