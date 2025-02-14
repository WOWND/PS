#include <stdio.h>
#include <stdlib.h>

//노드로 구현한 이진트리
typedef struct Tree {
    char value;
    struct Tree *right, *left;
}Tree;


Tree *init(char value) {
    Tree *tree = (Tree *) malloc(sizeof(Tree));
    tree->value = value;
    tree->left = NULL;
    tree->right = NULL;
    return tree;
}

void preorder(Tree *tree) {//전위순회 V->L->R
    if (tree == NULL) {
        return;
    }
    printf("%c", tree->value);
    preorder(tree->left);
    preorder(tree->right);
}

void inorder(Tree *tree) { //중위순회 L->V->R
    if (tree == NULL) {
        return;
    }
    inorder(tree->left);
    printf("%c", tree->value);
    inorder(tree->right);
}

void postorder(Tree *tree) { //후위순회 L->R->V
    if (tree == NULL) {
        return;
    }
    postorder(tree->left);
    postorder(tree->right);
    printf("%c", tree->value);
}
Tree* search(Tree* tree,char value) {
    if (tree == NULL) {
        return NULL;
    }
    if (tree-> value == value) {
        return tree;
    }
    Tree* returnVal = search(tree->left,value);
    if  (returnVal != NULL) {
        return returnVal;
    }
    return search(tree->right,value);
}

int main() {
    Tree *root;

    int N;
    scanf("%d",&N);

    for (int i=0;i<N;++i) {
        char parent,left,right;
        scanf(" %c %c %c", &parent, &left, &right);
        Tree* parentNode; //부모노드

        if (i == 0) { //A는 항상 루트노드
            parentNode = init(parent);
            root = parentNode;
        } else {
            parentNode = search(root,parent);
        }

        if (left != '.') {
            parentNode->left = init(left);
        }
        if (right != '.') {
            parentNode->right = init(right);
        }
    }

    preorder(root);
    printf("\n");

    inorder(root);
    printf("\n");

    postorder(root);
    printf("\n");

    free(root);
}