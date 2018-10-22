package answers;

public class Question1 {

	public static int bestMergedPortfolio(int[] portfolios) {
			try{
				int n=portfolios.length;
				int r=2;
				int totalWays=factorialRec(n)/(factorialRec(r)*factorialRec(n-r));
				int[] a =new int[totalWays];
				int index=0;
				for(int i=0;i<portfolios.length-1;i++){
					for(int j=i+1;j<portfolios.length;j++){

						a[index++]=convertToDecimal(convertToBinary(portfolios[i]),convertToBinary(portfolios[j]));
					}
				}
				return findMax(a);
			}catch(Exception e){
				if(portfolios.length==1){
					return protfolio[0];
				}else{
					return -1;
				}
			}
	}
	//converting each decimal number to 16-bit binary and return back the binary in form of an array
	public static int[] convertToBinary(int n){
		int[] b = new int[16];
		int i=0;
		while(n > 0){
			b[i++] = n%2;
			n = n/2;
		}
		return b;
	}
	// Merging two binary arrays into one binary in 'String' type and finally convert the merged binary to decimal.
	public static int convertToDecimal(int[] binarya, int[] binaryb){
		String newBinary = "";
		for(int j=0;j<16;j++){
			if(mergingTo1(binarya[j],binaryb[j])){
				newBinary="1"+newBinary;
			}else{
				newBinary="0"+newBinary;
			}
		}
		return Integer.parseInt(newBinary,2);
	}
	//merging by using the given rules
	public static boolean mergingTo1(int a, int b){
		if(a==b){
			return false;
		}
		return true;
	}
	public static int findMax(int[] a){
		if(a.length<=0){
			return -1;
		}
		int max=a[0];
		int index=1;
		while(index<a.length){
			if(max<a[index]){
				max=a[index];
			}
			index++;
		}
		return max;
	}
	//================using recusion to do factorial
	public static int factorialRec(int n){
		if (n<=1){
			return 1;
		}
		int fact = factorialRec(n-1)*n;
		return fact;
	}
}