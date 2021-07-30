public static int sumOfLeafNodes(Node root)
    {
        // code here 
        if(root==null){
            return 0;
        }
        else if(root.left==null & root.right==null){
             return root.data;
        }
        else{
            return sumOfLeafNodes(root.left)+sumOfLeafNodes(root.right);
        }
    }
