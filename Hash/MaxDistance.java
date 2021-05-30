 int maxDistance(int arr[], int n)
    {
	// Your code here
        HashMap<Integer, Integer> hm= new HashMap<>();
        int max_dist = 0;
        for (int i = 0; i < n; i++)
        {
            if (!hm.containsKey(arr[i]))
                hm.put(arr[i], i);
            else
                max_dist = Math.max(max_dist, i - hm.get(arr[i]));
        }
 
        return max_dist;
    }
