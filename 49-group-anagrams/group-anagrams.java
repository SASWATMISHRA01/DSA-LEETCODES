class Solution {
    public List<List<String>> groupAnagrams(String[] S) {
        HashMap<String , ArrayList<String>> mp = new HashMap<>();
        
        int sz = S.length;

        for(int i = 0; i < sz; ++i) {
            int n = S[i].length();
            char [] C = new char[n];

            for(int j = 0; j < n; ++j) 
                C[j] = S[i].charAt(j);

            Arrays.sort(C);

            String X = new String(C);  

            if(mp.containsKey(X)) {
                ArrayList<String> T = mp.get(X);
                T.add(S[i]);
            }  else {
                ArrayList<String> T = new ArrayList<>();
                T.add(S[i]);
                mp.put(X , T);
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<String , ArrayList<String>> C : mp.entrySet()) {
            ans.add(C.getValue());
        }

        return ans;
    }
}