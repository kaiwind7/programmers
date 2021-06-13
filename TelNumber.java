import java.util.HashMap;
import java.util.Map;

public class TelNumber { 
    public static void main(String[] args) {
        TelNumber telNumber = new TelNumber();
        String[] phone_book = {"12","123","1235","567","88", "8898"};
        boolean answer = telNumber.solution(phone_book);
        System.out.println(answer);
    }
    
    public boolean solution(String[] phone_book) {
        boolean answer = true;       

        Map<String, Object> hashMap = new HashMap<>();

        for(String temp : phone_book){
            hashMap.put(temp, null);
        }

        for(String key : hashMap.keySet()){
            for (int j = 1; j <= key.length() - 1; j++)
                if (hashMap.containsKey(key.substring(0, j))) return false;
        }
        
        return answer;
    }
}


// 실패
// public boolean solution(String[] phone_book) {
//     boolean answer = true;

//     Arrays.sort(phone_book);

//     for(int i = 0; i < phone_book.length; i++){
//         for(int j=i+1 ; j< phone_book.length; j++){
//             if(phone_book[j].startsWith(phone_book[i])){
//                 return false;
//             }
//         }
//     }
    
//     return answer;
// }