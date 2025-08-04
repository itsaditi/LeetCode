// Last updated: 8/4/2025, 4:50:05 PM
class Solution {
    public String compressedString(String word) {
        
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i = 1; i < word.length() ; i++){
            if(word.charAt(i) == word.charAt(i-1) && count != 9){
                count++;
            } else {
                sb.append(count).append(word.charAt(i- 1));
                count = 1;
            }           
        }
         sb.append(count).append(word.charAt(word.length() - 1));
         return sb.toString();
    }
}