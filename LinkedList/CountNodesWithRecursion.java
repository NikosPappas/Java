    public static int getCount(Node head)
    {
        
        //Code here
       if(head==null){
           return 0;
       }
       else{
           return 1+getCount(head.next);
       }
    }
