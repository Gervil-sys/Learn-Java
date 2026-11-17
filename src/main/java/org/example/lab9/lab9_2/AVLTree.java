package org.example.lab9.lab9_2;

public class AVLTree {

    private static class Node {
        int key;
        int height;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
            this.height = 1;
        }
    }

    private Node root;
    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int balanceFactor(Node node) {
        return height(node.left) - height(node.right);
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node t2 = x.right;
        x.right = y;
        y.left = t2;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node t2 = y.left;
        y.left = x;
        x.right = t2;
        updateHeight(x);
        updateHeight(y);
        return y;
    }

    private Node balance(Node node) {
        updateHeight(node);
        int bf = balanceFactor(node);

        if (bf > 1) {
            if (balanceFactor(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }

        if (bf < -1) {
            if (balanceFactor(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }

        return node;
    }

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
        } else {
            return node;
        }

        return balance(node);
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

        return balance(node);
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