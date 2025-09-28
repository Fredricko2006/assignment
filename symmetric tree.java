//Symmetric tree
class TreeNode 
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution 
{
    public boolean isSymmetric(TreeNode root) 
    {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) 
    {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }

    public static void main(String[] args) 
    {
        Solution sol = new Solution();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root1.right = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        System.out.println(sol.isSymmetric(root1)); // true

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2, null, new TreeNode(3));
        root2.right = new TreeNode(2, null, new TreeNode(3));
        System.out.println(sol.isSymmetric(root2)); // false
    }
}
