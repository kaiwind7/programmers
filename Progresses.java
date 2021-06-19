import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;


/**
 * Progresses
 */
public class Progresses {

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        Progresses prog = new Progresses();
        prog.solution(progresses, speeds);
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
       
        Queue<int[]> queue = new LinkedList<>();
        
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0 ; i < progresses.length; i++) {            
            //queue.add(new int[]{progresses[i], speeds[i]});

            int p = progresses[i];
            int s= speeds[i];
            int remain = 100 - p;
            int finish = remain / s;
            int mod = remain % s;

            if(mod > 0) {
                finish++;
            }

            //System.out.println(finish);

            if(queue.isEmpty()) {
                queue.add(new int[]{finish, 1});
            }else{
                if(queue.peek()[0] >= finish) {
                    queue.peek()[1] += 1;
                }else{
                    queue.add(new int[]{finish, 1});
                    list.add(queue.poll()[1]);                    
                }
            }
        }

        if(!queue.isEmpty()) {
            list.add(queue.poll()[1]);
        }

        answer = new int[list.size()];

        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
            //System.out.println(list.get(i));
        }
        

        return answer;
    }
}