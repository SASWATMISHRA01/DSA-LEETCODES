class Solution {
    public int strStr(String A, String B) {
        if(A.equals(B)) 
            return 0;

        for(int i = 0; i + B.length() <= A.length(); ++i) {
            Boolean f = true;
            int inx = 0;

            for(int j = i; j < i + B.length(); ++j) {
               if(A.charAt(j) != B.charAt(inx)) {
                    f = false;
                    break;
               }

               inx++;
            }

            if(f) 
              return i;
        }

        return -1;        
    }
}