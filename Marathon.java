import java.util.Arrays;




public class Marathon {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        	
        Marathon test = new Marathon();
        System.out.println(test.solution(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {       
        int i;
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for (i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        
        return participant[i];
    }

}