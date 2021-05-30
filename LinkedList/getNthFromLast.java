int getNthFromLast(Node head, int n)
    {
    	// Your code here
    	int len=0;
    	Node temp=head;
    	while(temp!=null){
    	    len++;
    	    temp=temp.next;
    	}
    	if(n>len){
    	    return -1;
    	}
    	temp=head;
    	for(int i=0;i<len-n;i++){
    	    temp=temp.next;
    	}
    	return temp.data;
    }
