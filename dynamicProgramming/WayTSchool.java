package dynamicProgramming;

public class WayTSchool {
    public static void main(String[] args) {
        WayTSchool wayTSchool = new WayTSchool();
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        wayTSchool.solution(m, n, puddles);
    }

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] street = new int[n][m];

        // 웅덩이는 -1
        for (int[] puddle : puddles)
            street[puddle[1] - 1][puddle[0] - 1] = -1;

        street[0][0] = 1;

        for (int i = 0; i < n; i++) { // 시작점은 1로 저장
            for (int j = 0; j < m; j++) {

                if(street[i][j] == -1) { // 웅덩이면 0으로 바꾸고 continue
                    street[i][j] = 0;
                    continue;
                }

                if(i != 0)
                    street[i][j] += street[i - 1][j] % 1000000007; // 숫자가 이 값을 초과할 수 있기 때문에 계산 과정에서 나머지 구하기

                if(j != 0)
                    street[i][j] += street[i][j - 1] % 1000000007; // 왼쪽
            }
        }

        return street[n - 1][m - 1] % 1000000007;
    }

}