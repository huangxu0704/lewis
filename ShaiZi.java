import java.text.DecimalFormat;

public class ShaiZi {
	public static void main(String[] args) {
		printProbability(10);
	}
	
	public static int max=6;
	
	public static void printProbability(int number) {  
		if(number<1)
			return;
		
		int[][] arrs=new int[2][number*max+1];
		
		int flag=0;
		
		for(int i=1;i<=max;i++) {
			arrs[flag][i]=1;
		}
		
		for(int j=2;j<=number;j++) {
			flag=1-flag;
			
			for(int i=0;i<number;i++) {
				arrs[flag][i]=0;
			}
			
			for(int i=number;i<=j*max;i++) {
				int count=1;
				while(i-count>0 && count<=6) {
					arrs[flag][i]+=arrs[1-flag][i-count];
					count++;
				}
			}
		}
		
		double totalCount=Math.pow(max, number);
		DecimalFormat df=new DecimalFormat("0.000");
		for(int i=number;i<=number*max;i++) {
			System.out.println(i+":"+df.format(arrs[flag][i]/totalCount));
		}
	}
}
