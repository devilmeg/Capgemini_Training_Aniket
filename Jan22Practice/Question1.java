package Jan22Practice;

class Male{
	boolean loyal;
	double income;
	
}

class Female{
	boolean beautiful;
	double salary;
	
	Male m = new Male();
	
	{
		m.loyal = true;
		m.income = 30.87;
		System.out.println(m.loyal+ "  "+ m.income);
	}

	
}
public class Question1 {

	public static void main(String[] args) {
		
//		Male m = new Male(true, 20.0);
//		
//		System.out.println(m.loyal);
		
		Female f = new Female();

	}

}
