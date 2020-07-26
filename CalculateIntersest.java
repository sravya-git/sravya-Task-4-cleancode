package cleancode;
import java.util.*;

import java.io.*;
interface Interest
{
	public double getInterest(double principal,double time,double rate_of_interest);
}
class SimpleInterest implements Interest
{
	double simple_interest;
	public double getInterest(double principal,double time,double rate_of_interest)
	{
		simple_interest=(principal*time*rate_of_interest)/100;
		return simple_interest;
	}
}
class CompoundInterest implements Interest
{
	double compound_interest,amount;
	
	public double getInterest(double principal,double time,double rate_of_interest)
	{
		amount=principal*Math.pow((1.0+rate_of_interest/100),time);
		compound_interest=amount-principal;
		return compound_interest;
	}
}
class GetData
{
	Scanner sc=new Scanner(System.in);
	
    PrintStream ps=new PrintStream(System.out);
    public double getPricipal()
    {
      ps.print("enter the principal");
      double principal=sc.nextDouble();
      return principal;
    }
    public double getPeriod()
    {
      ps.print("enter the period");
      double time=sc.nextDouble();
      return time;
    }public double getRateOfInterest()
    {
        ps.print("enter the Rate of Interest");
        double rate_of_interest=sc.nextDouble();
        return rate_of_interest;
    }
      
}
class CalculateInterest extends GetData
{

    public static void main(String args[])
    {
    	CalculateInterest interest=new CalculateInterest();
    	double principal=interest.getPricipal();
    	double period=interest.getPeriod();
    	double rate_of_interest=interest.getRateOfInterest();
    	SimpleInterest si=new SimpleInterest();
    	CompoundInterest ci=new CompoundInterest();
    	double simple_interest=si.getInterest(principal, period, rate_of_interest);
    	double compound_interest=ci.getInterest(principal,period, rate_of_interest);
    	
    	 PrintStream ps=new PrintStream(System.out);
    	 ps.print("Simple Interest="+simple_interest);
    	 ps.print("Compound Interest="+compound_interest);
 
    }

}
