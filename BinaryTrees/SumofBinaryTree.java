class BinaryTree
{
    static int sumBT(Node head){
        //Code
        if(head==null){
            return 0;
        }
        else{
            return head.data+sumBT(head.right)+sumBT(head.left);
        }
    }
}
