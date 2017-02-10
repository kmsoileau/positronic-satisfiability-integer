package positronic.satisfiability.integer;

/**
 * <p>Title: IntegerMultiplier</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2010</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.1
 */
import positronic.satisfiability.elements.BitEqualityIndicator;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.naturalnumber.NaturalNumberMultiplier;

public class IntegerMultiplier extends MetaProblem implements IProblem
{
	private static final long serialVersionUID = -5109945551398192123L;

	public IntegerMultiplier(IInteger X, IInteger Y, IInteger Z) throws Exception
	{
	  	IProblem p1=new Conjunction(new NaturalNumberMultiplier(
	  			X.getAbsoluteValue(),
	  			Y.getAbsoluteValue(),
	  			Z.getAbsoluteValue()),
	  			new BitEqualityIndicator(X.getSign(),Y.getSign(),Z.getSign()));
	  	
	  	
	  	this.setClauses(p1.getClauses());
	}
}