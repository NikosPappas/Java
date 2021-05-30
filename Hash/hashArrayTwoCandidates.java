    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // code here
         HashSet<Integer> s = new HashSet<Integer>();
         for(int i=0;i<arr.length;i++){
             int temp=x-arr[i];
             if(s.contains(temp)){
                 return true;
             }
             s.add(arr[i]);
         }
         return false;
    }
