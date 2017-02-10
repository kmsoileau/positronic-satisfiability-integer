/**
 * <p>Title: IntegerFixer</p>
 * <p>Description: An IProblem which constrains an IInteger to a particular long value.</p>
 * <p>Copyright (c) 2010</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

package positronic.satisfiability.integer;

import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.exceptions.IntegerFixerException;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;

public class IntegerFixer extends MetaProblem implements IProblem
{
  private static final long serialVersionUID = 927697368604023760L;

  public IntegerFixer(IInteger i2) throws Exception 
	{
	  IProblem problem=new Conjunction(new NaturalNumberFixer(i2.getAbsoluteValue()),
			  new BitFixer(i2.getSign()));
	  this.setClauses(problem.getClauses());
	}

  public IntegerFixer(IInteger b, long n) throws Exception
  {
  	if(b==null)
  		throw new IntegerFixerException("A null IInteger was passed to a constructor.");
  	
  	IProblem problem=null;
  	if(n>=0L)
  		problem=new Conjunction(new NaturalNumberFixer(b.getAbsoluteValue(),n),new BitFixer(b.getSign(),true));
  	if(n<0L)
  		problem=new Conjunction(new NaturalNumberFixer(b.getAbsoluteValue(),-n),new BitFixer(b.getSign(),false));
    
    this.setClauses(problem.getClauses());
  }
}