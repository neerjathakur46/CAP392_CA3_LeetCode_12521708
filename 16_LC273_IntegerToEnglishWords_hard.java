class Solution {
private:
    vector<string> belowTwenty = {
        "", "One", "Two", "Three", "Four", "Five", "Six",
        "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
        "Thirteen", "Fourteen", "Fifteen", "Sixteen",
        "Seventeen", "Eighteen", "Nineteen"
    };

    vector<string> tens = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty",
        "Sixty", "Seventy", "Eighty", "Ninety"
    };

    vector<string> thousands = {
        "", "Thousand", "Million", "Billion"
    };

    string convert(int num) {
        if (num == 0)
            return "";

        if (num < 20)
            return belowTwenty[num];

        if (num < 100) {
            return tens[num / 10] +
                (num % 10 == 0 ? "" : " " + belowTwenty[num % 10]);
        }

        return belowTwenty[num / 100] + " Hundred" +
            (num % 100 == 0 ? "" : " " + convert(num % 100));
    }

public:
    string numberToWords(int num) {
        if (num == 0)
            return "Zero";

        int group = 0;
        string result = "";

        while (num > 0) {
            int part = num % 1000;

            if (part != 0) {
                string words = convert(part);

                result = words +
                    (thousands[group].empty() ? "" : " " + thousands[group]) +
                    (result.empty() ? "" : " " + result);
            }

            num /= 1000;
            group++;
        }

        return result;
    }
};
