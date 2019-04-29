package leetcode.tree;

import leetcode.dataStructures.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string
 * and this string can be deserialized to the original tree structure.
 */
public class _0297_SerializeAndDeserializeBinaryTree {
    private static final String spliter = ",";
    private static final String NULL = "X";

    public String serializeUsingRecursion(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildTree(root, sb);
        return sb.toString();
    }

    private void buildTree(TreeNode root, StringBuilder sb) {
        if(root == null)
            sb.append(NULL).append(spliter);
        else {
            sb.append(root.val).append(spliter);
            buildTree(root.left, sb);
            buildTree(root.right, sb);
        }
    }

    public TreeNode deserializeUsingRecursion(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals(NULL)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    public String serializeUsingIteration(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("n ");
                continue;
            }
            sb.append(node.val).append(" ");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return sb.toString();
    }

    public TreeNode deserializeUsingIteration(String data) {
        if (data.equals("")) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.offer(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.offer(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        _0297_SerializeAndDeserializeBinaryTree codec = new _0297_SerializeAndDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        System.out.println(codec.serializeUsingIteration(root));
        System.out.println(codec.serializeUsingRecursion(root));
    }
}
