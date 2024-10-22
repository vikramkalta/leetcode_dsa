import java.util.HashMap;

public class LongestRepeatingReplacement {
    public static void main(String[] args) {
        // String s = "AAAA";
        // String s = "ABAA";
        // String s = "AAAB";
        // System.out.println(characterReplacement(s, 0));
        // String s
        // ="IMNJJTRMJEGMSOLSCCQICIHLQIOGBJAEHQOCRAJQMBIBATGLJDTBNCPIFRDLRIJHRABBJGQAOLIKRLHDRIGERENNMJSDSSMESSTR";
        String s = "JSDSSMESSTR";
        System.out.println(characterReplacement(s, 2));
        // String s = "ABABAC";
        // System.out.println(characterReplacement(s, 2));
        // String s = "AABABBA";
        // System.out.println(characterReplacement(s, 1));
    }

    public static int characterReplacement(String s, int k) {
        // ABABAC
        HashMap<Character, Integer> chrMap = new HashMap<>();
        int len = s.length();
        int maxCount = 0;
        int l = 0;
        int r = 0;
        int ans = 0;
        while (l < len && r < len) {
            char curr = s.charAt(r);
            int x = chrMap.getOrDefault(curr, 0);
            chrMap.put(curr, x + 1);
            maxCount = Math.max(maxCount, x + 1);

            int subStrLen = r - l + 1;
            if (subStrLen - maxCount > k) {
                while (r - l + 1 - maxCount > k) {
                    chrMap.put(s.charAt(l), chrMap.get(s.charAt(l)) - 1);
                    // Reset maxCount and recalculate
                    maxCount = 0;
                    for (char key: chrMap.keySet()) {
                        maxCount = Math.max(maxCount, chrMap.get(key));
                    }
                    l++;

                }
            } else {
                ans = Math.max(ans, subStrLen);
            }
            r++;
        }

        return ans;
    }

    public static int characterReplacement1(String s, int k) {
        // char[] charArr = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
        // 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
        // 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        char[] charArr = { 'S' };
        int len = s.length();
        int l = 0;
        int r = 0;
        int tempK = k;
        int max = 0;
        for (int i = 0; i < charArr.length; i++) {
            char currReplacement = charArr[i];
            l = 0;
            r = 0;
            if (k == 0) {
                int j = 0;
                while (j < len) {
                    if (currReplacement == s.charAt(j)) {
                        r++;
                        max = Math.max(max, r - l);
                    } else {
                        r++;
                        l = r;
                    }
                    j++;
                }
            } else {

                while (l < len && r < len) {
                    char curr = s.charAt(r);
                    if (currReplacement != curr) {
                        if (tempK == 0) {
                            max = Math.max(max, r - l);
                            do {
                                l++;
                            } while (s.charAt(l) != currReplacement);
                            tempK++;
                        } else {
                            tempK--;
                            r++;
                        }
                    } else {
                        r++;
                    }
                }
                max = Math.max(max, r - l);
            }
        }
        return max;
    }
}
