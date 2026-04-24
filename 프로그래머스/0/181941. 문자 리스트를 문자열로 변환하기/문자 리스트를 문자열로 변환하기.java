class Solution {
    public String solution(String[] arr) {
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < arr.length; i++){
            answer.append(arr[i]);
        }
        
        return answer.toString();
    }
}