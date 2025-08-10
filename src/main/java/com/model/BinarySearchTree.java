package com.model;

public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }

        if (value < node.getValue()) {
            node.setLeft(insertRecursive(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insertRecursive(node.getRight(), value));
        }
        return node;
    }

    public TreeNode getRoot() {
        return root;
    }

    // Converts the tree to a JSON string //
    public String toJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(root);
        } catch (JsonProcessingException e) {
            return "{}";
        }
    }

    // List to hold in-order traversal results //
    public List<Integer> inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        inOrderTraversalRecursive(root, result);
        return result;
    }

    // Recursive method for in-order traversal //
    private void inOrderTraversalRecursive(TreeNode node, List<Integer> result) {
        if (node != null) {
            inOrderTraversalRecursive(node.getLeft(), result);
            result.add(node.getValue());
            inOrderTraversalRecursive(node.getRight(), result);
        }
    }

}