   public Node removeDuplicates(Node head) 
    {
         // Your code here
         Node current= null, previous = null, dup = null; 
        if(head==null){
            return null;
         }
         current = head; 
  
        /* Pick elements one by one */
        while (current != null && current.next != null) { 
            previous = current; 
  
            /* Compare the picked element with rest 
                of the elements */
            while (previous.next != null) { 
  
                /* If duplicate then delete it */
                if (current.data == previous.next.data) { 
  
                    /* sequence of steps is important here */
                    dup = previous.next; 
                    previous.next = previous.next.next; 
                    System.gc();
                } else /* This is tricky */ { 
                    previous = previous.next; 
                } 
            } 
            current = current.next; 
         }   
         return head;
    }
