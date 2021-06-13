public class Carpet {
    public static void main(String[] args){

    }

    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = brown + yellow;
        
        for(int i=3 ; i<=sum; i++) {
            if(sum % i == 0){
                int col = sum / i;
                int row = sum / col;
                
                int a = col - 2;
                int b = row - 2;
                if(a*b == yellow && col>=row){                    
                    return new int[]{col, row};
                }
            }
        }
        return answer;
    }

}