class Solution {
public:
    string reverseWords(string s) {
        stringstream ss(s);
        string word;
        string answer = "";

        while (ss >> word) {
            if (answer.empty()) {
                answer = word;
            } 
            else {
                answer = word + " " + answer;
            }
        }

        return answer;
    }
};
