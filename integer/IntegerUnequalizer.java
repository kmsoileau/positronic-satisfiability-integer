package positronic.satisfiability.integer;

/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2010</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */
import positronic.satisfiability.elements.BitUnequalizer;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.naturalnumber.NaturalNumberEqualizer;
import positronic.satisfiability.naturalnumber.NaturalNumberUnequalizer;

public class IntegerUnequalizer extends MetaProblem implements IProblem
{
	private static final long serialVersionUID = 1459266420251069591L;

	public IntegerUnequalizer(IInteger X, IInteger Y) throws Exception
	{
		//|X|<>|Y|
		IProblem p1=new NaturalNumberUnequalizer(
				X.getAbsoluteValue(),
				Y.getAbsoluteValue());
		//X=-Y
		IProblem p2=new Conjunction(
				new NaturalNumberEqualizer(X.getAbsoluteValue(),Y.getAbsoluteValue()),
				new BitUnequalizer(X.getSign(),Y.getSign()));
		this.setClauses(new Disjunction(p1,p2).getClauses());
	  }
}