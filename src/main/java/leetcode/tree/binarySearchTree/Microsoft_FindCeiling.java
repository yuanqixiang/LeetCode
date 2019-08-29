package leetcode.tree.binarySearchTree;

import leetcode.dataStructures.TreeNode;

/*
 * 在二叉搜索树中查找大于等于某个key值的最小节点
 */
public class Microsoft_FindCeiling {
    // 迭代实现
     private static TreeNode findCeiling(TreeNode root, int target) {
        TreeNode ceiling = null, current = root;
        while(current != null) {
            if(current.val < target)
                current = current.right;
            else if(current.val >= target) {
                ceiling = current;
                current = current.left;
            }
        }
        return ceiling;
    }

    /*
     * 在二叉搜索树中查找大于某个key值的最小节点
     */
    private static TreeNode findCeilingExcept(TreeNode root, int target) {
        TreeNode ceiling = null, current = root;
        while(current != null) {
            if(current.val <= target)
                current = current.right;
            else if(current.val > target) {
                ceiling = current;
                current = current.left;
            }
        }
        return ceiling;
    }

    private TreeNode findCeilingUsingRecursion(TreeNode root, int target)
    {
        if(root == null) return null;
        if(root.val < target)
            return findCeilingUsingRecursion(root.right, target);
        else if(root.val > target) {
            TreeNode ceiling = findCeilingUsingRecursion(root.left, target);
            return ceiling != null ? ceiling : root;
        } else return root;
    }

    public static void main(String[] args) {
         /*
          *            50
          *           /  \
          *         30    70
          *        /  \
          *      25    48
          *           /  \
          *         40    49
          *           \
          *            46
          */
        TreeNode root = new TreeNode(50);
        TreeNode left = new TreeNode(30);
        TreeNode right = new TreeNode(70);
        root.left = left;
        root.right = right;
        TreeNode node1 = new TreeNode(25);
        TreeNode node2 = new TreeNode(48);
        left.left = node1;
        left.right = node2;
        TreeNode node3 = new TreeNode(40);
        TreeNode node4 = new TreeNode(49);
        node2.left = node3;
        node2.right = node4;
        TreeNode node5 = new TreeNode(46);
        node3.right = node5;

        System.out.println(findCeiling(root,25).val);
        System.out.println(findCeilingExcept(root,25).val);
    }
}
