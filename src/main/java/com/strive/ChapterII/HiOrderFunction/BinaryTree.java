package com.strive.ChapterII.HiOrderFunction;

import java.util.LinkedList;
import java.util.function.Consumer;

//优化二叉树的前序遍历、中序遍历、后序遍历
public class BinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,null,null),
                        null
                ),
                new TreeNode(3,
                        new TreeNode(5,null,null),
                        new TreeNode(6,null,null)
                        )
        );

        //非递归遍历
        traversal(root,Type.PRE,System.out::print);
        System.out.println();
        traversal(root,Type.In,System.out::print);
        System.out.println();
        traversal(root,Type.POST,System.out::print);
        System.out.println();

        //递归遍历
        new_traversal(root,Type.PRE,System.out::print);
        System.out.println();
        new_traversal(root,Type.In,System.out::print);
        System.out.println();
        new_traversal(root,Type.POST,System.out::print);
        System.out.println();
    }

    public record TreeNode(int value,TreeNode left, TreeNode right) {
        @Override
        public String toString() {
            return "%d ".formatted(value);
        }
    }

    enum Type {
        PRE, In, POST
    }

    public static void new_traversal(TreeNode root,Type type,Consumer<TreeNode> consumer) {
        if(root == null) {
            return;
        }
        //前序遍历处理值
        if(type == Type.PRE) {
            consumer.accept(root);
        }
        traversal(root.left,type,consumer);
        //中序遍历处理值
        if(type == Type.In) {
            consumer.accept(root);
        }
        traversal(root.right,type,consumer);
        //后序遍历处理值
        if(type == Type.POST) {
            consumer.accept(root);
        }
    }

    //二叉树中序遍历
    public static void traversal(TreeNode root, Type type, Consumer<TreeNode> consumer) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        TreeNode last = null;
        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                //处理前序遍历的值
                if(type == Type.PRE) {
                    consumer.accept(curr);
                }
                curr = curr.left;
            }else {
                TreeNode peek = stack.peek();
                if(peek.right == null) {
                    //处理中序遍历、后序遍历的值
                    if(type == Type.In || type == Type.POST) {
                        consumer.accept(peek);
                    }
                    last = stack.pop();
                } else if(peek.right == last) {
                    //处理后序遍历的值
                    if(type == Type.POST) {
                        consumer.accept(peek);
                    }
                    last = stack.pop();
                } else {
                    //处理中序遍历的值
                    if(type == Type.In) {
                        consumer.accept(peek);
                    }
                    curr = peek.right;
                }
            }
        }
    }
}
