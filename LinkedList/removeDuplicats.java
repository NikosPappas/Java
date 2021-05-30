    Node removeDuplicates(Node head)
    {
	// Your code here
       Node current=head;
       Node temp=null;
       while(current!=null){
           temp=current;
           while(temp!=null && temp.data==current.data){
               temp=temp.next;
           }
           current.next=temp;
           current=current.next;
       }
       current=head;
       return current;
    }
