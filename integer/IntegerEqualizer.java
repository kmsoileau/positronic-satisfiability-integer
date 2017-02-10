package positronic.satisfiability.integer;

import positronic.satisfiability.elements.BitEqualizer;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.naturalnumber.NaturalNumberEqualizer;

public class IntegerEqualizer extends MetaProblem implements IProblem
{
	private static final long serialVersionUID = -8868664246999231837L;

	public IntegerEqualizer(IInteger X, IInteger Y) throws Exception
	{
		this.setClauses(new Conjunction(
    		new NaturalNumberEqualizer(X.getAbsoluteValue(),Y.getAbsoluteValue()),
  			new BitEqualizer(X.getSign(),Y.getSign())).getClauses());
	}
}
