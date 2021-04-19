import java.util.ArrayList;

public class Evaluator extends Visitor
{
    private double result;
    private String resultString;
    private ArrayList<String> toPrint = new ArrayList<String>();

    public Evaluator(Expression e){
        e.accept(this);
        for(String s:toPrint)
			System.out.println(s);
		System.out.println();
    }

    // TYPE
    void visit(Char v){
        resultString = v.aValue;
    }
    void visit(Num v){
        result = v.aValue;
        resultString = Double.toString(result);
    }

    // CALCUL
    void visit(Neg v){
        v.aValue.accept(this);
        result = -result;
        resultString = Double.toString(result);
    }
    void visit(Add v){
        if(v.lhs instanceof Char && v.rhs instanceof Char) {
    	    v.lhs.accept(this);
    	    //String temp = sRes.replace("\"", "");
            String temp = resultString;
    	    v.rhs.accept(this);
    	    resultString = temp + resultString;
    	} 
        else if(!(v.lhs instanceof Char) && !(v.rhs instanceof Char)) {
            v.lhs.accept(this) ;
            Double temp = result;
            v.rhs.accept(this);
            result += temp;
            }
        resultString = Double.toString(result);
    }
    void visit(Sub v){
        v.lhs.accept(this) ;
        Double temp = result;
        v.rhs.accept(this);
        result = result - temp;
        resultString = Double.toString(result);    
    }
    void visit(Mul v){
        v.lhs.accept(this) ;
        Double temp = result;
        v.rhs.accept(this);
        result = result * temp;
        resultString = Double.toString(result);
    }
    void visit(Div v){
        v.lhs.accept(this) ;
        Double temp = result;
        v.rhs.accept(this);
        result = result / temp;
        resultString = Double.toString(result);
    }

    // COMPARISON
    void visit(Equal v){
        v.lhs.accept(this) ;
        Double temp = result;
        v.rhs.accept(this);
        if (temp == result)
            result = 1;
        else
            result = 0;
        resultString = Double.toString(result);
    }
    void visit(NonEqual v){
        v.lhs.accept(this) ;
        Double temp = result;
        v.rhs.accept(this);
        if (temp != result)
            result = 1;
        else
            result = 0;
        resultString = Double.toString(result);  
    }
    void visit(Inf v){
        v.lhs.accept(this) ;
        Double temp = result;
        v.rhs.accept(this);
        if (temp < result)
            result = 1;
        else
            result = 0;
        resultString = Double.toString(result);    
    }
    void visit(Sup v){
        v.lhs.accept(this) ;
        Double temp = result;
        v.rhs.accept(this);
        if (temp > result)
            result = 1;
        else
            result = 0;
        resultString = Double.toString(result);
    }
    void visit(SupEqual v){
        v.lhs.accept(this); 
        Double temp = result;
        v.rhs.accept(this);
        if (temp >= result)
            result = 1;
        else
            result = 0;
        resultString = Double.toString(result);    
    }
    void visit(InfEqual v){
        v.lhs.accept(this) ;
        Double temp = result;
        v.rhs.accept(this);
        if (temp <= result)
            result = 1;
        else
            result = 0;
        resultString = Double.toString(result);
    }

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

}