package cleancode;
import java.util.*;
import java.io.PrintWriter;
interface HouseCost
{
	public double calculateHouseCost(double area);
		
		
}
class ChooseMaterial
{
	Scanner sc=new Scanner(System.in);
	//method that takes the type of material to build house from the user
	public int getMaterial(PrintWriter pw)
	{
	pw.write("choose the type of the Material....\n ");
	pw.write("1.enter 1 if you want materials of  Standard quality\n");
	pw.write("2.enter 2 if you want materaials of above Standard qaulity\n");
	pw.write("3.enter 3 if you want materials of high standard quality\n");
	int quality=sc.nextInt();
	return quality;
	
	}
}
class HouseArea
{
	Scanner sc=new Scanner(System.in);
	//method that takes the input area of the house from the user
	public double getHouseArea(PrintWriter pw)
	{
		pw.write("Enter the Area.....\n");
		double area=sc.nextDouble();
		return area;
	}
}
class StandardMaterial implements HouseCost
{
	public final int cost_per_sqr=1200;
	//method that calculates the cost of the house builded using standard materials
	public double calculateHouseCost(double area)
	{
		double cost_of_house=(double)cost_per_sqr*area;
		return cost_of_house;
	}
}
class HighStandardMaterial implements HouseCost
{
	//method that calculates the cost of the house builded using high standard materials
	public final int cost_per_sqr=1800;
	public double calculateHouseCost(double area)
	{
		double cost_of_house=(double)cost_per_sqr*area;
		return cost_of_house;
	}
}
class AutomatedHome implements HouseCost
{ //method that calculates the cost of the house builded using high standard materials and automated
	public final int cost_per_sqr=2500;
	public double calculateHouseCost(double area)
	{
		double cost_of_house=(double)cost_per_sqr*area;
		return cost_of_house;
	}
}
class AboveStandardMaterial implements HouseCost
{  //method that calculates the cost of the house builded using above standard materials
	public final int cost_per_sqr=1500;
	public double calculateHouseCost(double area)
	{
		double cost_of_house=(double)cost_per_sqr*area;
		return cost_of_house;
	}
}
public class House extends ChooseMaterial{

	public static void main(String[] args) 
	{
		House h=new House();
		HouseArea ha=new HouseArea();
		PrintWriter pw=new PrintWriter(System.out);
		int quality=h.getMaterial(pw);
		double area=ha.getHouseArea(pw);
		double house_cost=0;
		try
		{
		switch(quality)
		{
		case 1:StandardMaterial sm=new StandardMaterial();
		       house_cost=sm.calculateHouseCost(area);
		        break;
		case 2:AboveStandardMaterial asm=new AboveStandardMaterial();
		       house_cost=asm.calculateHouseCost(area);
		       break;
		case 3:pw.write("Enter yes if house should be automated");
		       Scanner sc=new Scanner(System.in);
		       String choice=sc.next();
		       if(choice.toLowerCase()=="yes")
		       {
		    	   AutomatedHome ah=new AutomatedHome();
		    	   house_cost=ah.calculateHouseCost(area);
		       }
		       else
		       {
		    	   HighStandardMaterial hsm=new HighStandardMaterial();
		    	   house_cost=hsm.calculateHouseCost(area);
		       }
		       break;
		default: throw new Exception(" Choose the materials from available qualities only!!!!");
		
		}
		
		// TODO Auto-generated method stub

	}
		catch(Exception e)
		{
			
		}
		finally
		{
			pw.write(";Choose the materials from available qualities only!!!!");
		}
		pw.print("cost of the house= "+house_cost);
		
	}

}
