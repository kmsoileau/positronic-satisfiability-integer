package positronic.satisfiability.integer;

/** 
 * The IProblem constructed by new IntegerOrderer(X,Y) is satisfied if and 
 * only if X<=Y.
 * 
 */

import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.naturalnumber.NaturalNumberOrderer;

public class IntegerOrderer extends MetaProblem implements IProblem
{
	private static final long serialVersionUID = 9062586739519931425L;

	public IntegerOrderer(IInteger X, IInteger Y) throws Exception
	{
		IProblem p1=new Conjunction(
				new BitFixer(X.getSign(),false),
				new BitFixer(Y.getSign(),false),
				new NaturalNumberOrderer(Y.getAbsoluteValue(),X.getAbsoluteValue()));
		IProblem p2=new Conjunction(
				new BitFixer(X.getSign(),false),
				new BitFixer(Y.getSign(),true));
		IProblem p3=new Conjunction(
				new BitFixer(X.getSign(),true),
				new BitFixer(Y.getSign(),true),
				new NaturalNumberOrderer(X.getAbsoluteValue(),Y.getAbsoluteValue()));
		this.setClauses(new Disjunction(p1,p2,p3).getClauses());
	}
}
