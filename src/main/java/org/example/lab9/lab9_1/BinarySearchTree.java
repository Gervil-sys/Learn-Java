package org.example.lab9.lab9_1;

public class BinarySearchTree {
    private static class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }

    private Node root;

    public void insert(int x) {
        root = insert(root, x);
    }

    private Node insert(Node node, int x) {
        if (node == null) {
            return new Node(x);
        }
        if (x < node.key) {
            node.left = insert(node.left, x);
        } else if (x > node.key) {
            node.right = insert(node.right, x);
        }
        return node;
    }

    public boolean has(int x) {
        Node current = root;
        while (current != null) {
            if (x == current.key) return true;
            current = x < current.key ? current.left : current.right;
        }
        return false;
    }

    public void delete(int x) {
        root = delete(root, x);
    }

    private Node delete(Node node, int x) {
        if (node == null) return null;

        if (x < node.key) {
            node.left = delete(node.left, x);
        } else if (x > node.key) {
            node.right = delete(node.right, x);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node min = node.right;
            while (min.left != null) {
                min = min.left;
            }
            node.key = min.key;
            node.right = delete(node.right, min.key);
        }
        return node;
    }

    public Integer next(int x) {
        Node current = root;
        Integer result = null;
        while (current != null) {
            if (current.key > x) {
                result = current.key;
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return result;
    }

    public Integer prev(int x) {
        Node current = root;
        Integer result = null;
        while (current != null) {
            if (current.key < x) {
                result = current.key;
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return result;
    }
}