   Node deleteNode(Node head,int x)
    {
	// Your code here
	 Node current=head;
	 Node previous=null;
	 int len=1;
     if(head==null){
         return null;
     }
     //case one
     //x==head.data;
     if(x==1){
         current=current.next;
         current.prev=null;
         head=current;
         return head;
     }
      while(current!=null && len!=x){
          len++;
          previous=current;
          current=current.next;
      }
      if(current==null){
          return null;
      }
      else{
          previous.next=current.next;
          current.prev=previous;
          current=null;
          return head;
      }
    }
