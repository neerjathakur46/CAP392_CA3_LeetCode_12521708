class Solution {
 private final String[] belowTwenty = {
 "", "One", "Two", "Three", "Four", "Five", "Six",
 "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
 "Thirteen", "Fourteen", "Fifteen", "Sixteen",
 "Seventeen", "Eighteen", "Nineteen"
 };
 private final String[] tens = {
 "", "", "Twenty", "Thirty", "Forty", "Fifty",
 "Sixty", "Seventy", "Eighty", "Ninety"
 };
 private final String[] thousands = {
 "", "Thousand", "Million", "Billion"
 };
 public String numberToWords(int num) {
 if (num == 0) {
 return "Zero";
 }
 int group = 0;
 String result = "";
 while (num > 0) {
     int part = num % 1000;
 if (part != 0) {
 String words = convert(part);
 result = words + (thousands[group].isEmpty()
 ? "" : " " + thousands[group])
 + (result.isEmpty() ? "" : " " + result);
 }
 num /= 1000;
 group++;
 }
 return result;
 }
 private String convert(int num) {
 if (num == 0) return "";
 if (num < 20) return belowTwenty[num];
 if (num < 100) {
 return tens[num / 10]
 + (num % 10 == 0 ? "" : " " + belowTwenty[num % 10]);
 }
 return belowTwenty[num / 100] + " Hundred"
 + (num % 100 == 0 ? "" : " " + convert(num % 100));
 }
}
