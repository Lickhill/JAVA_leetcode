class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
        {
            return false;
        }

        Map<Character,Character> mp=new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (!mp.containsKey(s.charAt(i))) {
                    for (var ele : mp.keySet()) {
                        if (mp.get(ele) == t.charAt(i)) {
                            return false;
                        }
                    }
                    mp.put(s.charAt(i), t.charAt(i));
                } else {
                    if (mp.get(s.charAt(i)) != t.charAt(i)) {
                        return false;
                    }
                }
            }
            System.out.println(mp);
            return true;
    }
}
