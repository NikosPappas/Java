 Node reverseList(Node head)
    {
        // code here
         Node previous=null;
         Node current=head;
         Node next=null;
         while(current!=null){
             next=current.next;
             current.next=previous;
             previous=current;
             current=next;
         }
         head=previous;
         return head;
    }
