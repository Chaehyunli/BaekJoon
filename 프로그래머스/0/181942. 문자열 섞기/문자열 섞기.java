class Solution {
    public String solution(String str1, String str2) {
//         String answer = "";
        
//         for(int i = 0; i < 2 * str1.length(); i++){
//             if(i % 2 == 0){
//                 answer += str1.charAt(i / 2);
//             }else{
//                 answer += str2.charAt(i / 2);
//             }
//         }
        
//         return answer;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 2 * str1.length(); i++){
            if(i % 2 == 0){
                sb.append(str1.charAt(i / 2));
            }else{
                sb.append(str2.charAt(i / 2));
            }
        }
        
        return sb.toString();
    }
}