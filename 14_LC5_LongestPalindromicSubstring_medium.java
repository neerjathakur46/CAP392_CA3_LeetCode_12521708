class Solution {
 private int left;
 private int bestLength;
 public String longestPalindrome(String s) {
 if (s == null || s.length() < 2) {
 return s;
 }
 for (int i = 0; i < s.length(); i++) {
 expand(s, i, i); 
 expand(s, i, i + 1); 
 }
 return s.substring(left, left + bestLength);
 }
 private void expand(String s, int start, int end) {
 while (start >= 0 && end < s.length()
 && s.charAt(start) == s.charAt(end)) {
 start--;
 end++;
 }
 int length = end - start - 1;
     if (length > bestLength) {
 bestLength = length;
 left = start + 1;
 }
 }
}
