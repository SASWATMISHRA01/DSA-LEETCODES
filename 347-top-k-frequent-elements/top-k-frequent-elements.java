class Solution {
    class Pair {
        Integer first , second;

        Pair(Integer first , Integer second) {
            this.first = first;
            this.second = second;
        }
    }
    
    class MyComp implements Comparator<Pair> {
        @Override
        public int compare(Pair L , Pair R) {
            if(R.second.compareTo(L.second) == 0) 
                return R.first.compareTo(L.first); 

            return R.second.compareTo(L.second);
        }
    }

    public int[] topKFrequent(int[] A, int k) {
        HashMap<Integer , Integer> freq = new HashMap<>();

        int n = A.length;

        for(int i = 0; i < n; ++i) 
            if(freq.containsKey(A[i])) 
                freq.put(A[i] , freq.get(A[i]) + 1);
            else 
                freq.put(A[i] , 1);  

        ArrayList<Pair> T = new ArrayList<>();        
        
        for(Map.Entry<Integer , Integer> C : freq.entrySet()) 
            T.add(new Pair(C.getKey() , C.getValue()));
        
        Collections.sort(T , new MyComp());

        int [] ans = new int [k];

        for(int i = 0; i < k; ++i) 
           ans[i] = T.get(i).first;

        return ans;      
    }
}