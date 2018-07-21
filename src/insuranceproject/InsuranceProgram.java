package insuranceproject;

//import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.logging.Level;
//import java.util.logging.Logger;



public class InsuranceProgram {

	public static void main(String[] args) throws Exception{
		BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
		int numberOfPolicyHolders=0;
		Company company= new Company();
		PolicyHolder[] p=company.getPolicyHolder();
		System.out.println("\t\tINSURANCE MANAGEMENT SYSTEM");
        System.out.println("\n\tEnter password:");
	    Company.Password();
		
		while(true){
			
		System.out.println("Please enter your choice: ");
		System.out.println("1: View policy details ");
		System.out.println("2: Add policy holder ");
		System.out.println("3: Calculate premium");
		System.out.println("4. Provide Fund to policy holder");
		System.out.println("5: Withdraw policy ");
		System.out.println("6: Add bonus ");
		System.out.println("7: Print Receipt");
		System.out.println("8. Exit");
		
	
	     int choice= Integer.parseInt(bufferedReader.readLine());	
    
	    
        switch(choice)
		{
		
		case 1:
			
			Insurance LifeInsurance=new LifeInsurance();  //run time polymorphism
			LifeInsurance.policyDetails();
			break;
			
		case 2:
			System.out.println("Adding policy holder");
			
			System.out.println("please enter your policy number");
	         int no= Integer.parseInt(bufferedReader.readLine());
	      

		    System.out.println("please enter your name");
	            String name= bufferedReader.readLine();
	            
	            System.out.println("please enter your age");
	            int age= Integer.parseInt(bufferedReader.readLine());
	            
	            System.out.println("please enter your beneficiary name");
	            String beneficiary= bufferedReader.readLine();
	            
	         
            System.out.println("please enter your type of life insurance(term/permanent)");
            String type= bufferedReader.readLine();
            
            System.out.println("please enter your insurance amount");
            double amount= Double.parseDouble(bufferedReader.readLine());
            
            System.out.println("please enter your policy duration");
            int duration= Integer.parseInt(bufferedReader.readLine());

            System.out.println("please enter Starting year of policy:");
            int year= Integer.parseInt(bufferedReader.readLine());
            
             Insurance i=new Insurance(amount,no,duration,year);
             LifeInsurance lifeInsurance= new LifeInsurance(type);

            PolicyHolder policyHolder= new PolicyHolder(name,age,beneficiary,i,lifeInsurance);
            p[numberOfPolicyHolders]=policyHolder;
            numberOfPolicyHolders++;
          
			break;
			
		case 3:
			//Calculate obj= new Company();
			System.err.println("Enter policy number");
            no = Integer.parseInt(bufferedReader.readLine());
               if (numberOfPolicyHolders == 0) 
            {
                System.err.println("Policy Number Not Found");
            } 
            else {
                boolean found = false;
                for (int a = 0; a < numberOfPolicyHolders; a++) {
                    Insurance temp = p[a].getInsurance();
                    int accTemp = temp.getPolicyNo();
                    
                    if (accTemp==no) {
                        
                        System.out.println("Calculating amount of premium:");
             company.calculatePremium(p[a]);
                        found = true;
                  }
              }
                
                if (found == false) {
                    System.err.println("Policy Number Not Found");
                }
            }
			
			break;
			
	
			
			
			

		case 4:
			
			System.err.println("Enter policy number");
            no = Integer.parseInt(bufferedReader.readLine());
               if (numberOfPolicyHolders == 0) 
            {
                   System.err.println("Policy Number Not Found");
            } 
            else {
                boolean found = false;
                for (int a = 0; a < numberOfPolicyHolders; a++) {
                    Insurance temp = p[a].getInsurance();
                    int accTemp = temp.getPolicyNo();
                    
                    if (accTemp==no) {
                        
                        System.err.println("Please Enter condition (accident/death): ");
                        String condition = bufferedReader.readLine();
                        
                        System.err.println("Document attached for proof(yes/no): ");
                        String document= bufferedReader.readLine();
                        
                        temp.getFund(condition, document);
                        System.out.println("Beneficiary name is "+p[a].getBeneficiary());
                         found = true;
                  }
              }
                
                if (found == false) {
                    System.err.println("Policy Number Not Found");
                }
            }
			
			break;
			
			
			
			

		case 5:
			
			System.err.println("Enter policy number");
            no = Integer.parseInt(bufferedReader.readLine());
               if (numberOfPolicyHolders == 0) 
            {
                   System.err.println("Policy Number Not Found");
            } 
            else {
                boolean found = false;
                for (int a = 0; a < numberOfPolicyHolders; a++) {
                    Insurance temp = p[a].getInsurance();
                    int accTemp = temp.getPolicyNo();
                    
                    if (accTemp==no) {
                        
                        System.err.println("Do you want to withdraw our policy(yes/no): ");
                        String wish = bufferedReader.readLine();
                   
                        temp.withdrawPolicy(wish);
                         found = true;
                  }
              }
                
                if (found == false) {
                    System.err.println("Policy Number Not Found");
                }
            }
			
			break;
			
			
			

		case 6:
			
			System.err.println("Enter policy number");
            no = Integer.parseInt(bufferedReader.readLine());
               if (numberOfPolicyHolders == 0) 
            {
                   System.err.println("Policy Number Not Found");
            } 
            else {
                boolean found = false;
                for (int a = 0; a < numberOfPolicyHolders; a++) {
                    Insurance temp = p[a].getInsurance();
                    int accTemp = temp.getPolicyNo();
                    
                    if (accTemp==no) {
                        
                        System.err.println("Please Enter your insurance amount: ");
                        double amt = Double.parseDouble(bufferedReader.readLine());
                        System.out.println("Enter current year: ");
                        int cy = Integer.parseInt(bufferedReader.readLine());

                    int sy=temp.getStartYear();
                    int y=cy-sy;
                    if(y>=1)
                     temp.bonus(amt);  
                    else
                    	System.out.println("No bonus");
                     found = true;
                  }
              }
                
                if (found == false) {
                    System.err.println("Policy Number Not Found");
                }
            }
			
			break;
			
		case 7:
			System.err.println("Enter policy number");
            no = Integer.parseInt(bufferedReader.readLine());
               if (numberOfPolicyHolders == 0) 
            {
                   System.err.println("Policy Number Not Found");
            } 
            else {
                boolean found = false;
                for (int a = 0; a < numberOfPolicyHolders; a++) {
                    Insurance temp = p[a].getInsurance();
                    int accTemp = temp.getPolicyNo();
                    
                    if (accTemp==no) {
                    	
                        p[a].display();
                       found = true;
                  }
              }
                
                if (found == false) {
                    System.err.println("Policy Number Not Found");
                }
            }
			
			break;
			
			

		
			
				
		case 8:
			System.exit(0);
			break;
			
		default:
		break;
		
		
}
}

}

	
}


interface Calculate
{  
	int months=12;
	public double getPremium();
	
}


class Company implements Calculate
{
	static void Password() throws Exception
	{
		BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
       
	
            String word= bufferedReader.readLine();
	        if(word.equals("far"))
	        {
              System.out.println("\tCORRECT PASSWORD");
	        }
	        else
	        {  
	        	 System.err.println("\tINCORRECT PASSWORD ");
	        	  System.out.println("  Please type password again:");
	        	 Company.Password();
	        }
		}
    
	
	

	private PolicyHolder[] policyHolders=new PolicyHolder[1000];
	private double premium;

    
    	public void calculatePremium(PolicyHolder policyHolder){
    		
    		//String s1;
    		String s1=policyHolder.getLifeInsurance().getPolicyType();
    	 
    	    if(s1.equals("term"))
    	    { // a/c to term
            Insurance i=policyHolder.getInsurance();
            double amount=i.getInsuranceAmount();
            double duration=i.getPolicyDuration();
    		//kitna premium per month depends upon insurance amount and time period
        //    premium=amount*duration/months;
            premium=amount/(duration*months);
    		System.out.println("Premium amount="+premium);

    	    }
    	    else
    	    {
    	    	// a/c to permanent
    			
    				//age k hisab se
    		    
    	    	Insurance i=policyHolder.getInsurance();
    		        double amount=i.getInsuranceAmount();
    		        int age=policyHolder.getAge();
    		        
    		       premium=amount/(age*months);
    				System.out.println("Premium amount="+premium);

    	    }
    	    	
    	
}
    
    	
  public double getPremium()
	{
		return premium;
	}
	
	public PolicyHolder[] getPolicyHolder()
	{
		return policyHolders;
	}
	
	


	
	
}





class Insurance
{     //Company company;
   //PolicyHolder policyHolder;
	//private double premium;
	private double insuranceAmount;// as per policyHolder desire
	private int policyNo; //each holder has different policy no
	private int policyDuration;// in years
	//private String accountNumber;
	private double bonus=0;
	private int startYear;

    
	Insurance()
	{
		insuranceAmount=0;
		policyNo=0;
		policyDuration=0;
		startYear=0;
		
	}
	Insurance(double amount, int no, int duration,int year)
	{
		this.insuranceAmount=amount;  
		this.policyNo=no;
		this.policyDuration=duration;
		this.startYear=year;
//		this.accountNumber=acc;
	}
	
	public void policyDetails()
	{

		
		System.out.println("\tLIFE INSURANCE POLICY DETAILS: ");
		System.out.println("Our Insurance policies offers several benefits while providing life insurance protection. ");
		System.out.println("1.You have the choice to withdraw your policy at any time,\n but we will deduct 20% from your amount if you withdraw it.");
		System.out.println("2.We will also give you bonus depending upon your insurance amount annually.");
		System.out.println("3.After you will choose your insurance amount, we will calculate the amount of premium you have to pay monthly.");
		

	}
	
	
	
	
	/*public void showPremium()
	{
		//monthly premium pay krni h
		System.out.println("You have to pay premium of "+company.getPremium()+" per month.");
			
	}*/
    public void getFund(String condition, String document)
    {    //according to certain policy conditions money milti hai agar policyHolder ko kch hojata hai tou

    	if(condition.equals("accident")&&document.equals("yes"))
    	{
    		double temp=insuranceAmount*25/100;
    		double fund=temp;
    		System.out.println("We are providing you the fund of amount  "+fund+" at this time.");
    	}

        if(condition.equals("death")&&document.equals("yes"))
        {
    		double temp=insuranceAmount*7/100;
    		double fund=temp;
    		System.out.println("The fund of amount "+fund+" will be given to the beneificicary per month.");	
    		
        }
      
        if(document.equals("no"))
        {
        System.err.println("Your document is required for proof");	
        }
        	
    
    	
    	
    }
    
    
    
    
    
    public void withdrawPolicy(String wish)
    {
    	/* jitni policyHolder ki paid premium hoti h a/c to certain conditons wapis mil jata
    	ya kch deduction hokr milti hai wapis */
    	
    	if(wish.equals("yes"))
    	{
    		double deduction=insuranceAmount*20/100;
    		System.out.println("As you withdraw your policy, according to our terms and conditions,\n we are going to deduct "+deduction+"from your amount.\nThankyou");
    	}
    	else
    	{
    		System.out.println("Thankyou for not withdrawing your policy.");
    	}
    	
	}
    	
    	
    	
    
    public void bonus(double amount) //company gives policyHolder bonus per year according to their InsuranceAmount
    {    double temp=amount*5/100;
         this.bonus+=temp;
    	System.out.println("CONGRATULATIONS! You are awarded a bonus of "+bonus);	
    }
    
	
	///*public double getPremium()
//	{
//		return premium;
//	}*/
	
	public double getInsuranceAmount()
	{
		return insuranceAmount;
	}
	public int getPolicyNo()
	{
		return policyNo;
	}
	
	public int getStartYear()
	{
		return startYear;
	}
	
	
	public int getPolicyDuration()
	{
		return policyDuration;
	}
	
	
	
	
	
	
	
	///*public String getAccountNumber()
	//{
	//	return accountNumber;
	//}*/
	
	public double getBonus()
	{
		return bonus;
	}
	
	
}



class LifeInsurance extends Insurance{
	private String policyType;
	 
	LifeInsurance()
	{super();
	policyType=null;}
	
	LifeInsurance(String type)// type=term or type=permanent
	{ 
	this.policyType=type;	
	}
	public void policyDetails()
	{    
		super.policyDetails();
		
		System.out.println("4.We have two types of life insurance policy:\na)term/limited duration \nb)permanent/whole life ");
		System.out.println("5.In term life insurance policy you have to choose your insurance amount\n for a certain number of years as per your desire. ");
		System.out.println("6.In whole life insurance policy we will cover risks in your life\n and provide benefits to your family after your death.");
		System.out.println("7.For any query, you can visit our website 'www.abc.com'\n\tTHANKYOU. ");
	}
	
	
   public String getPolicyType()
   {
	   return policyType;
   }
	
}









abstract class Person{
	
abstract public void display();

}

class PolicyHolder
{
	 private String name;
	 private int age;
	 private String beneficiary;
	 private Insurance insurance;
	 private LifeInsurance lifeInsurance;
	 
	 PolicyHolder(String n, int a,String b,Insurance i,LifeInsurance l)
	 {   
		 name=n;
		 age=a;
		 beneficiary=b;
		 insurance=i;
		 lifeInsurance=l;}
	 
	 
     public void display()
     {
    	 System.out.println("Generating receipt of policy holder:");
        System.out.println("Policy No: "+insurance.getPolicyNo());
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Beneficiary Name: "+beneficiary);
		System.out.println("Policy Type: "+lifeInsurance.getPolicyType());
		System.out.println("Policy year: "+insurance.getStartYear());
		System.out.println("Duration of policy: "+insurance.getPolicyDuration());
		System.out.println("Insurance Amount: "+insurance.getInsuranceAmount());
		
     }
     
     public void display(String n)
     {
    	 System.out.println("Name: "+n);
     }
     
     
     
     
     public String getName()
     {
    	 return name;
     }
     
     public int getAge()
     {
    	 return age;
     }
     
     
     public String getBeneficiary()
     {
    	 return beneficiary;
     }
     
     public Insurance getInsurance()
     {
    	 return insurance;
     }
	public LifeInsurance getLifeInsurance()
	{
		return lifeInsurance;
	}
}













