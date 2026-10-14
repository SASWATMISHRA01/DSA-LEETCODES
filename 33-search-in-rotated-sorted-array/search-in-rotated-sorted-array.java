class Solution {
    public int search(int[] A, int T) {
        int n = A.length;

        if(n == 1) {
            if(A[0] == T) 
                return 0;

            return -1;    
         }

        if (A[n - 1] > A[0]) {
            // zero rotation
            int lo = 0, hi = n - 1;

            while (lo <= hi) {
                int mid = (lo + hi) / 2;

                if (A[mid] > T)
                    hi = mid - 1;

                if (A[mid] < T)
                    lo = mid + 1;

                if (A[mid] == T)
                    return mid;
            }

            return -1;
        } else {
            if (A[n - 1] < A[n - 2]) {
                if (A[n - 1] == T)
                    return n - 1;

                int lo = 0, hi = n - 1;

                while (lo <= hi) {
                    int mid = (lo + hi) / 2;

                    if (A[mid] > T)
                        hi = mid - 1;

                    if (A[mid] < T)
                        lo = mid + 1;

                    if (A[mid] == T)
                        return mid;
                }

                return -1;
            } else {
                int lo = 0, hi = n - 2;
                int pivot = 0;

                while (lo <= hi) {
                    int mid = (lo + hi) / 2;

                    if (A[mid] > A[n - 1]) {
                        lo = mid + 1;
                    }

                    if (A[mid] < A[n - 1]) {
                        pivot = mid;
                        hi = mid - 1;
                    }
                }

                if (T == A[n - 1])
                    return n - 1;

                if (T < A[n - 1]) {
                    lo = pivot;
                    hi = n - 2;

                    while (lo <= hi) {
                        int mid = (lo + hi) / 2;

                        if (A[mid] > T)
                            hi = mid - 1;

                        if (A[mid] < T)
                            lo = mid + 1;

                        if (A[mid] == T)
                            return mid;
                    }

                    return -1;

                } else {
                    lo = 0;
                    hi = pivot - 1;
                    
                    while (lo <= hi) {
                        int mid = (lo + hi) / 2;

                        if (A[mid] > T)
                            hi = mid - 1;

                        if (A[mid] < T)
                            lo = mid + 1;

                        if (A[mid] == T)
                            return mid;
                    }

                    return -1;
                }
            }
        }
    }
}