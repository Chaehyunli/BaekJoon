import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> result = new ArrayList<>();
        
        HashMap<String, Integer> typeMap = new HashMap<>();
        
        // HashMap에 값 넣기
        for(int i = 0; i < terms.length; i++){
            String[] temp = terms[i].split(" "); 
            String type = temp[0];
            int term = Integer.parseInt(temp[1]); 
    
            typeMap.put(type, term);
        }
        
        // 오늘 날짜 변환
        String[] todayParts = today.split("\\.");
        int todayTotal = Integer.parseInt(todayParts[0]) * 12 * 28 + 
                         Integer.parseInt(todayParts[1]) * 28 + 
                         Integer.parseInt(todayParts[2]);
        
        // privacies 날짜 변환
        for(int i = 0; i < privacies.length; i++){
            String[] p = privacies[i].split(" ");
            String[] dateParts = p[0].split("\\.");
            int pTotal = Integer.parseInt(dateParts[0]) * 12 * 28 + 
                         Integer.parseInt(dateParts[1]) * 28 + 
                         Integer.parseInt(dateParts[2]);
            
            // 파기 시점 = 수집일 + (약관 개월 * 28)
            int expireDate = pTotal + (typeMap.get(p[1]) * 28);
            
            if(expireDate <= todayTotal) {
                result.add(i + 1);
            }
        }
        
        // 5. ArrayList를 int[]로 변환
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}