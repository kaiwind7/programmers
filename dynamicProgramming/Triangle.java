package dynamicProgramming;

import java.util.*;

public class Triangle {
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[][] triangle= {
                    {7},
                   {3, 8},
                  {8, 1, 0},
                 {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        
        int answer;
        answer = new Triangle().solution(triangle);

        System.out.println(answer);
    }

    public int solution(int[][] triangle) {
        int answer = 0;

//        int[][] dp = new int[triangle.length][triangle.length];
//        dp[0][0] = triangle[0][0];
//
//
//
//        for (int i=1; i< triangle.length; i++) {
//
//            dp[i][0] = triangle[i][0] + dp[i - 1][0];
//
//            for (int j=1; j<i+1; j++) {
//                dp[i][j] = triangle[i][j] + Math.max(dp[i -1][j - 1], dp[i -1][j]);
//            }
//        }
//
//        int max = 0;
//        for (int i=0; i<dp[dp.length - 1].length; i++) {
//            max = Math.max(dp[dp.length - 1][i], max);
//        }
//
//
//        answer = max;
//        return answer;



        answer = triangle[0][0];
        sum(triangle, 1, 0, answer);

        answer = Collections.max(list);

        return answer;
    }


    public void sum(int[][] triangle, int startRow, int idx, int sum) {

        int nextRow = startRow+1;
        for(int i = idx; i<=idx+1; i++){
            int num = triangle[startRow][i];

            if(triangle.length-1 == startRow) {
                list.add(sum + num);
            }else{
                sum(triangle, nextRow, i, sum + num);
            }
        }

    }

}

