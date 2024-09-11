
public class SumOfArray {
public static void main(String[] args) {
	
	int A[]= {3,4,5,6,64,3,3};
	
	int sum=0;
	//for loop
//	for(int i = 0; i<A.length;i++) {
//		sum=sum +A[i];
//	}
	
	
	
	//for each loop
	for (int x: A) {
		
		sum=sum +x;
	}
	System.out.println("sum of "+ sum);
}
}
