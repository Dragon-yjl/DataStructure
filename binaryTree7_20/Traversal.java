package binaryTree7_20;



public class Traversal {

    //前序遍历
    public static void preOrder(TreeNode root) {

        if(root != null) {
            System.out.printf("%c",root.v);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //中序遍历
    public static void inOrder(TreeNode root) {

        if(root != null) {
            inOrder(root.left);
            System.out.printf("%c",root.v);
            inOrder(root.right);
        }
    }

    //后序遍历
    public static void postOrder(TreeNode root) {

        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.printf("%c",root.v);
        }
    }


    //前序遍历改进
    public static void preOrder1(TreeNode root) {

        if(root != null) {
            System.out.printf("%c",root.v);
            System.out.print("{");
            preOrder1(root.left);
            System.out.print("} {");
            preOrder1(root.right);
            System.out.print("}");
        }
    }

    public static void main(String[] args) {

        TreeNode a = BuildTree.buildTree1();

        System.out.println("前序遍历");
        preOrder(a);
        System.out.println();

        System.out.println("改进之后的前序遍历");
        preOrder1(a);
        System.out.println();
    }

}
