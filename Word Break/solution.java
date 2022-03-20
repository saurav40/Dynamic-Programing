class Solution {
    Map<String,Boolean> mp=new HashMap();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s))
            return true;
        if(mp.containsKey(s))
            return mp.get(s);
        for(int i=1;i<s.length();i++)
        {
            String left=s.substring(0,i);
            if(wordDict.contains(left) && wordBreak(s.substring(i),wordDict))
            {
                mp.put(s,true);
                return true;
            }
        }
        mp.put(s,false);
        return false;
    }
}
