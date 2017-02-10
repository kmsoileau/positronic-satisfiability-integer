package positronic.satisfiability.integer;

import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberAdder;
 /**
 * An extension of the Problem class which implements an adder of two
 * Integers.
 *
 * In one way to use this class, one passes IInteger X, IInteger Y, and IInteger Z to the
 * appropriate constructor. The IntegerAdder object produced is a Problem, and one may 
 * manipulate it using any of the methods provided by the Problem class.
 *
 * For example, when the Problem instance p defined by
 *
 * <p><tt>Problem p = new IntegerAdder(X,Y,Z);</tt></p>
 *
 * is satisfied, the following truth equation will be satisfied:
 *
 * <p><tt>Z == X + Y</tt></p>
 *
 * @author  Kerry Michael Soileau
 * <blockquote><pre>
 * ksoileau@yahoo.com
 * http://kerrysoileau.com/index.html
 * </pre></blockquote>
 * @version 1.1, 10/09/01
 * @see Conjunction
 * @see Disjunction
 * @see IBooleanVariable
 * @see IClause
 * @see IProblem
 * @see MetaProblem
 * @see INaturalNumber
 * @see NaturalNumber
 * @see NaturalNumberAdder
 */

public class IntegerAdder extends MetaProblem implements IProblem
{
	private static final long serialVersionUID = -421899574837020135L;

	public IntegerAdder(IInteger X, IInteger Y, IInteger Z) throws Exception
	{
		IProblem p1=new Conjunction(
				new BitFixer(X.getSign(),false),
				new BitFixer(Y.getSign(),false),
  				new NaturalNumberAdder(
  						X.getAbsoluteValue(),
  						Y.getAbsoluteValue(),
  						Z.getAbsoluteValue()),
  				new BitFixer(Z.getSign(),false));
		IProblem p2=new Conjunction(
				new BitFixer(X.getSign(),false),
				new BitFixer(Y.getSign(),true),
  				new NaturalNumberAdder(
  						X.getAbsoluteValue(),
  						Z.getAbsoluteValue(),
  						Y.getAbsoluteValue()),
  				new BitFixer(Z.getSign(),true));
		IProblem p3=new Conjunction(
				new BitFixer(X.getSign(),false),
				new BitFixer(Y.getSign(),true),
  				new NaturalNumberAdder(
  						Y.getAbsoluteValue(),
  						Z.getAbsoluteValue(),
  						X.getAbsoluteValue()),
  				new BitFixer(Z.getSign(),false));
		IProblem p4=new Conjunction(
				new BitFixer(Y.getSign(),false),
				new BitFixer(X.getSign(),true),
  				new NaturalNumberAdder(
  						Y.getAbsoluteValue(),
  						Z.getAbsoluteValue(),
  						X.getAbsoluteValue()),
  				new BitFixer(Z.getSign(),true));
		IProblem p5=new Conjunction(
				new BitFixer(Y.getSign(),false),
				new BitFixer(X.getSign(),true),
  				new NaturalNumberAdder(
  						X.getAbsoluteValue(),
  						Z.getAbsoluteValue(),
  						Y.getAbsoluteValue()),
  				new BitFixer(Z.getSign(),false));
		IProblem p6=new Conjunction(
				new BitFixer(X.getSign(),true),
				new BitFixer(Y.getSign(),true),
  				new NaturalNumberAdder(
  						X.getAbsoluteValue(),
  						Y.getAbsoluteValue(),
  						Z.getAbsoluteValue()),
  				new BitFixer(Z.getSign(),true));
		
		IProblem problem=new Disjunction(new IProblem[]{p1,p2,p3,p4,p5,p6});
	
		this.setClauses(problem.getClauses());
	}
}