package positronic.satisfiability.integer;

import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.naturalnumber.INaturalNumber;

public interface IInteger
{
	final int DEFAULTLENGTH=12;

	@Override
	boolean equals(Object o);
	INaturalNumber getAbsoluteValue();
	String getName();
	IBooleanVariable getSign();
	void setAbsoluteValue(INaturalNumber naturalNumber) ;
	void setName(String s);
	void setSign(IBooleanVariable booleanVariable) ;
	@Override
	String toString();
}
