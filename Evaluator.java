import java.util.ArrayList;

public class Evaluator extends Visitor
{
    private double result;
    private String resultString;
    private ArrayList<String> toPrint = new ArrayList<String>();
    private Scope scope;

    public Evaluator(Expression e){
        e.accept(this);
        for(String s:toPrint)
			System.out.println(s);
		System.out.println();
    }

    public Evaluator(Scope s)
	{
		scope = s;
	}

    /////// Type ///////
    void visit(Char v){
        resultString = v.aValue;
    }
    void visit(Num v){
        result = v.aValue;
        resultString = Double.toString(result);
    }

    void visit(Variable v){
        scope.getInScope(v.name).accept(this);
        resultString = Double.toString(result);
    }

    /////// Calcul ///////
    void visit(Neg v){
        v.aValue.accept(this);
        result = -result;
        resultString = Double.toString(result);
    }
    void visit(Add v){
        if(v.lhs instanceof Char && v.rhs instanceof Char) {
    	    v.lhs.accept(this);
            String temp = resultString.replace("\"","");
            v.rhs.accept(this);
            resultString = "\""+temp + resultString.replace("\"", "") + "\"";
    	} 
        else if(!(v.lhs instanceof Char) && !(v.rhs instanceof Char)) {
            v.lhs.accept(this) ;
            Double temp = result;
            v.rhs.accept(this);
            result += temp;
            resultString = Double.toString(result);
        } else
		    System.out.println("Incompatible types");
        
    }
    void visit(Sub v){
        if(!(v.lhs instanceof Char) && !(v.rhs instanceof Char)) {
            v.lhs.accept(this) ;
            Double temp = result;
            v.rhs.accept(this);
            result = temp - result;
            resultString = Double.toString(result);   
        }
        else {
			result = 0;
			System.out.println("Incompatible types");
		}
    }
    void visit(Mul v){
        if(!(v.lhs instanceof Char) && !(v.rhs instanceof Char)) {
            v.lhs.accept(this) ;
            Double temp = result;
            v.rhs.accept(this);
            result = result * temp;
            resultString = Double.toString(result);
        }
        else {
			result = 0;
			System.out.println("Incompatible types");
		}
    }
    void visit(Div v){
        if(!(v.lhs instanceof Char) && !(v.rhs instanceof Char)) {
            v.lhs.accept(this) ;
            Double temp = result;
            v.rhs.accept(this);
            result = result / temp;
            resultString = Double.toString(result);
        }
        else {
			result = 0;
			System.out.println("Incompatible types");
		}
    }

    /////// Comparison ///////
    void visit(Equal v){
        if(v.lhs instanceof Char && v.rhs instanceof Char) {
			v.lhs.accept(this);
			double temp = resultString.length();
			v.rhs.accept(this);
			if(temp == resultString.length())
				resultString = "1";
			else
				resultString = "0";
		} 
        else if(!(v.lhs instanceof Char) && !(v.rhs instanceof Char)) {
            v.lhs.accept(this) ;
            Double temp = result;
            v.rhs.accept(this);
            if (temp == result)
                result = 1;
            else
            result = 0;
            resultString = Double.toString(result);
        }
        else
            System.out.println("Incompatible types");
    }
    void visit(NonEqual v){
        if(v.lhs instanceof Char && v.rhs instanceof Char) {
			v.lhs.accept(this);
			double temp = resultString.length();
			v.rhs.accept(this);
			if(temp != resultString.length())
				resultString = "1";
			else
				resultString = "0";
		} 
        else if(!(v.lhs instanceof Char) && !(v.rhs instanceof Char)) {
            v.lhs.accept(this) ;
            Double temp = result;
            v.rhs.accept(this);
            if (temp != result)
                result = 1;
            else
                result = 0;
            resultString = Double.toString(result);  
        }
        else
            System.out.println("Incompatible types");
    }

    void visit(Inf v){
        if(v.lhs instanceof Char && v.rhs instanceof Char) {
			v.lhs.accept(this);
			double temp = resultString.length();
			v.rhs.accept(this);
			if(temp < resultString.length())
				resultString = "1";
			else
				resultString = "0";
		} 
        else if(!(v.lhs instanceof Char) && !(v.rhs instanceof Char)) {
            v.lhs.accept(this) ;
            Double temp = result;
            v.rhs.accept(this);
            if (temp < result)
                result = 1;
            else
                result = 0;
            resultString = Double.toString(result);   
        }
        else
            System.out.println("Incompatible types");
    }

    void visit(Sup v){
        if(v.lhs instanceof Char && v.rhs instanceof Char) {
			v.lhs.accept(this);
			double temp = resultString.length();
			v.rhs.accept(this);
			if(temp > resultString.length())
				resultString = "1";
			else
				resultString = "0";
		} 
        else if(!(v.lhs instanceof Char) && !(v.rhs instanceof Char)) {
            v.lhs.accept(this) ;
            Double temp = result;
            v.rhs.accept(this);
            if (temp > result)
                result = 1;
            else
                result = 0;
            resultString = Double.toString(result);
        }
        else
            System.out.println("Incompatible types");
    }
    void visit(SupEqual v){
        if(v.lhs instanceof Char && v.rhs instanceof Char) {
			v.lhs.accept(this);
			double temp = resultString.length();
			v.rhs.accept(this);
			if(temp >= resultString.length())
				resultString = "1";
			else
				resultString = "0";
		} 
        else if(!(v.lhs instanceof Char) && !(v.rhs instanceof Char)) {
            v.lhs.accept(this); 
            Double temp = result;
            v.rhs.accept(this);
            if (temp >= result)
                result = 1;
            else
            result = 0;
            resultString = Double.toString(result);  
        }
        else
            System.out.println("Incompatible types");

    }
    void visit(InfEqual v){
        if(v.lhs instanceof Char && v.rhs instanceof Char) {
			v.lhs.accept(this);
			double temp = resultString.length();
			v.rhs.accept(this);
			if(temp <= resultString.length())
				resultString = "1";
			else
				resultString = "0";
		} 
        else if(!(v.lhs instanceof Char) && !(v.rhs instanceof Char)) {
            v.lhs.accept(this) ;
            Double temp = result;
            v.rhs.accept(this);
            if (temp <= result)
                result = 1;
            else
                result = 0;
            resultString = Double.toString(result);
        }
        else
            System.out.println("Incompatible types");
    }

    /////// KeyWord ///////
    void visit(Print v)
	{
		v.aValue.accept(this);
		toPrint.add(resultString);
	}

    void visit(IfThenElse v){
        v.aCondition.accept(this);
        if(result==1){
            v.aThen.accept(this);
        }
        else{
            v.aElse.accept(this);
        }
    }

    public void visit(Scope s)
    {
    	scope = s;
        for (Expression a : s.getInstructions()) {
            a.accept(this);
        }
        scope = s.parent;
    }

    public void visit(Assignment v)
	{
		v.scope.changeValue(v.aName, v.aValue);
	}

    /////// Usefull Function ///////
    public double getResult(){
        return this.result;
    }


}