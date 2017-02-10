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
import positronic.satisfiability.naturalnumber.NaturalNumberPositiver;

public class IntegerSignChanger extends MetaProblem implements IProblem
{
	private static final long serialVersionUID = -8008265590401945230L;

	public IntegerSignChanger(IInteger X, IInteger Y) throws Exception
	{
		//X=0 && Y=0
		IProblem p1=new Conjunction(
				new IntegerFixer(X,0L),
				new IntegerFixer(Y,0L));
		//X<>0
		IProblem p2=new Conjunction(
				new NaturalNumberPositiver(X.getAbsoluteValue()),
				new BitUnequalizer(X.getSign(),Y.getSign()),
				new NaturalNumberEqualizer(
						X.getAbsoluteValue(),
						Y.getAbsoluteValue()));
		this.setClauses(new Disjunction(p1,p2).getClauses());
	  }
}