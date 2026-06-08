class Solution {
    public String minWindow(String s, String t) {

        if (s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i),
                    mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int required = mapT.size();
        int formed = 0;

        int left = 0;
        int right = 0;

        int[] ans = {-1, 0, 0};

        Map<Character, Integer> windowMap = new HashMap<>();

        while (right < s.length()) {

            char c = s.charAt(right);

            windowMap.put(
                c,
                windowMap.getOrDefault(c, 0) + 1
            );

            if (mapT.containsKey(c) &&
                windowMap.get(c).intValue() == mapT.get(c).intValue()) {

                formed++;
            }

            while (left <= right && formed == required) {

                if (ans[0] == -1 ||
                    right - left + 1 < ans[0]) {

                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                char ch = s.charAt(left);

                windowMap.put(ch, windowMap.get(ch) - 1);

                if (mapT.containsKey(ch) &&
                    windowMap.get(ch).intValue() < mapT.get(ch).intValue()) {

                    formed--;
                }

                left++;
            }

            right++;
        }

        return ans[0] == -1
                ? ""
                : s.substring(ans[1], ans[2] + 1);
    }
}
