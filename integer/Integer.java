 package positronic.satisfiability.integer;
 
 /*
 * Integer.java	1.1 10/09/01
 *
 * Copyright 2010 Positronic Software.
 *
 *
 */
 /**
 * A wrapper class surrounding an INaturalNumber object and an IBooleanVariable object.
 * The INaturalNumber object gives the absolute value of the integer and the 
 * IBooleanVariable object gives its sign.
 *
 * @author  Kerry Michael Soileau
 * <blockquote><pre>
 * ksoileau@yahoo.com
 * http://kerrysoileau.com/index.html
 * </pre></blockquote>
 * @version 1.0, 10/09/01
 * @see INaturalNumber
 * @see NaturalNumber
 */

import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.exceptions.IntegerException;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;

public class Integer implements IInteger
{
  private static long nICount;
  private static int bits=IInteger.DEFAULTLENGTH;
  private static boolean hasBeenSet=false;
  
  public static int getLength() 
  {
	  if(!hasBeenSet)
	  {
		  bits=IInteger.DEFAULTLENGTH;
		  hasBeenSet=true;
	  }
	  return bits;	  
  }
  
  public static void setLength(int size) throws IntegerException
  {
		if(!hasBeenSet)
		{
			bits=size;
			hasBeenSet=true;
		}
		else
			throw(new IntegerException("Attempted to change a previously set bit length for the class Integer."));
  }
  
  private String name;
  private INaturalNumber absValue;
  private IBooleanVariable sign;

  public Integer() throws Exception
  {
    this(0L);
  }
  
  public Integer(INaturalNumber n) throws Exception
  {
    this();
    this.setAbsoluteValue(n);
  }
  
  public Integer(long n) throws Exception
  {
    this("NaturalNumber$"+ nICount++,n);
  }
  
  public Integer(String name) throws Exception
  {
    this(name,0L);
  }

  public Integer(String name, long n) throws Exception
  {
    if(n<0)
    {
    	this.setAbsoluteValue(new NaturalNumber(name,-n));
    	this.setSign(BooleanVariable.getBooleanVariable(name,false));
    }
    else
    {
    	this.setAbsoluteValue(new NaturalNumber(name,n));
    	this.setSign(BooleanVariable.getBooleanVariable(name,true));
    }
  }

  @Override
public boolean equals(Object o)
  {
  	if(o==null)
  		return false; //this is never equal to null.
    if(!(o instanceof Integer))
      return false;
    else
      return (this.getName().compareTo(((Integer)o).getName()))==0;
  }

  @Override
public INaturalNumber getAbsoluteValue()
  {
		return this.absValue;
  }

  @Override
public String getName()
  {
  	return this.name;
  }
  
  @Override
public IBooleanVariable getSign()
  {
		return this.sign;
  }
  
  @Override
public void setAbsoluteValue(INaturalNumber naturalNumber) 
  {
	this.absValue=naturalNumber;
  }
  
  @Override
public void setName(String s)
  {
  	this.name=s;
  }

  @Override
public void setSign(IBooleanVariable booleanVariable) 
  {
	this.sign=booleanVariable;
  }

  @Override
public String toString()
  {
	  String ret="";
	  if(!this.getSign().getValue())
		  ret+="$";
	  return ret+this.getAbsoluteValue();
  }
}