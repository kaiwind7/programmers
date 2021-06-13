import java.util.Set;
import java.util.HashSet;

class Solution {
    public static Set<Integer> setPermutn = new HashSet<>();
    
    public static void main(String[] args) {
        int result = new Solution().solution("011");

        System.out.println(":::::::::: "+result);
    }

    public int solution(String numbers) {
        int answer = 0;
        int[] array = new int[numbers.length()];
        for(int i=0; i<numbers.length(); i++){
            array[i] = Integer.valueOf(numbers.substring(i, i+1));
        }

		int length = array.length;
		String[] output = new String[length];
		boolean[] isVisit = new boolean[length];
		
		for(int cnt=1; cnt<=length; cnt++) {
			permutation(array, output, isVisit, 0, length, cnt);
		}


        for(int tmp : setPermutn){
            if(isPrime(tmp)){
                System.out.println(tmp);
                answer++;
            }        
        }

        return answer;
    }

    public static void permutation(int[] array, String[] output, boolean[] isVisit, int depth, int length, int count) {
		if(count==0) {	
            String temp = "";
            for(int i = 0; i<output.length; i++){
                temp += (output[i] == null) ? "":output[i];
            }
            setPermutn.add(Integer.valueOf(temp));
			return;
		}  
		for(int i=0; i<length; i++) {
			if(isVisit[i]!=true) {
				isVisit[i] = true;
				output[depth] = String.valueOf(array[i]) ;
				permutation(array, output, isVisit, depth+1, length, count-1);
				isVisit[i] = false;
			}
		}
	}
    
    public static boolean isPrime(int num) {
        boolean result = true;
        
        if(num == 1 || num == 0){
            result = false;
        }
        for(int i = 2; i <= (int)Math.sqrt(num); i++) {
            if( num%i == 0) {
                result = false;
                break; 
            } else {
                result = true;
            }
        }        
        return result;        
    }
}

 

