   int MissingNumber(int array[], int n) {
        // Your Code Here
        int total;
        total=(n+2)*(n+1)/2;
        for(int i=0;i<array.length;i++){
            total=total-array[i];
        }
        return total-n-1;
    }
}
