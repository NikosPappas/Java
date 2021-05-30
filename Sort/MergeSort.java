    void merge(int arr[], int l, int m, int r)
    {
         // Your code here
         int n1 = m - l + 1;
         int n2 = r - m;
         int L[] = new int[n1];
         int R[] = new int[n2];
          for (int i = 0; i < n1;i++)
            L[i] = arr[l + i];
         for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];
         int i = 0, j = 0;
         int k=l;
         while(i<n1 && j<n2){
             if(L[i] <= R[j]){
                 arr[k++]=L[i++];
             }
             else{
                 arr[k++]=R[j++];
             }
         }
         while(i<n1){
             arr[k++]=L[i++];
         }
         while(j<n2){
             arr[k++]=R[j++];
         }
    }
    void mergeSort(int arr[], int l, int r)
    {
        //code here
        if(l<r){
            int median=l+(r-l)/2;
            mergeSort(arr,l,median);
            mergeSort(arr,median+1,r);
            //merge(arr,l,median,r);
            if (arr[median] > arr[median + 1])
             merge(arr, l, median,r) ;
        }
    }
