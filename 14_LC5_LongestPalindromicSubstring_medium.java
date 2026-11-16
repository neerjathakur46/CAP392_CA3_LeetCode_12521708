class Solution {
private:
    int left = 0;
    int bestLength = 0;

    void expand(string& s, int start, int end) {
        while (start >= 0 && end < s.size() &&
               s[start] == s[end]) {
            start--;
            end++;
        }

        int length = end - start - 1;

        if (length > bestLength) {
            bestLength = length;
            left = start + 1;
        }
    }

public:
    string longestPalindrome(string s) {
        if (s.size() < 2) {
            return s;
        }

        left = 0;
        bestLength = 0;

        for (int i = 0; i < s.size(); i++) {
            expand(s, i, i);       
            expand(s, i, i + 1);   
        }

        return s.substr(left, bestLength);
    }
};
