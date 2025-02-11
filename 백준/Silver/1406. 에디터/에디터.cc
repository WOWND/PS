#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef char element;

typedef struct Node{ //노드
    struct Node *next; //다음 노드를 가리킴
    struct Node *prev; //직전 노드를 가리킴
    element data; //데이터
}Node;


typedef struct { //연결 리스트
    Node *head;
}LinkedList;

LinkedList* init() {  //초기화
    LinkedList *list = (LinkedList *) malloc(sizeof(LinkedList));
    list->head = NULL;
    return list;
}

Node* delete_node(LinkedList *list,Node* node){ //특정 노드를 제거
    Node *nextNode = node->next; //다음 노드
    Node *prevNode = node->prev; //이전 노드


    prevNode->next = nextNode;
    if (nextNode != NULL) {
        nextNode->prev = prevNode;
    }

    free(node);

    return prevNode;
}

Node *insert_node(LinkedList *list, Node *cursor,char value) {
    Node *newNode = (Node *) malloc(sizeof(Node));
    newNode->data = value;

    //커서 -> 새로운 노드  -> 원래 커서 다음

    Node *nextNode = cursor->next; //원래 커서 다음

    if (nextNode != NULL) { //다음 커서가 있을때만
        nextNode->prev = newNode;
    }
    cursor->next = newNode;
    newNode->prev = cursor;
    newNode->next = nextNode;



    return newNode;
}

void print_list(LinkedList *list) { //출력
    Node *now = list->head->next;
    while (now != NULL) {
        printf("%c",now->data);
        now = now->next;
    }
}

int main() {
    char str[100000]; //문자들
    scanf("%s",str);
    int len = strlen(str);


    LinkedList* list = init();
    Node * cursor; //커서 노드
    //int location = len-1;

    Node *head = (Node *) malloc(sizeof(Node));
    head->data = '\0';
    head->prev = NULL;
    head->next = NULL;
    list->head = head;

    cursor = head;

    for (int i = 0; i < len; ++i) {
        Node *newNode = (Node *) malloc(sizeof(Node));
        newNode ->data = str[i];
        cursor->next = newNode;
        newNode->prev = cursor;
        cursor = newNode;
    }

    int cmdLen; //명령어 줄 수
    scanf("%d", &cmdLen);
    //삭제 = 커서 노드를 삭제하고 직전 노드에 붙는다
    //추가 = 커서 노드 직전노드에 붙는다
    //직전 노드가 없다 = 커서가 맨 앞이다

    for (int i=0; i<cmdLen; ++i) {
        char cmd;
        scanf(" %c", &cmd);

        if (cmd == 'L') { //커서 왼쪽으로
            if (cursor == head) { //이미 왼쪽 끝
                continue;
            }
            cursor = cursor->prev;
        }else if (cmd == 'D') { //커서 오른쪽으로
            if (cursor->next == NULL) { //이미 오른쪽끝
                continue;
            }
            cursor = cursor ->next;
        }else if (cmd == 'B') { //커서 왼쪽 삭제
            if (cursor == head) { //이미 왼쪽 끝
                continue;
            }
            cursor = delete_node(list,cursor); //커서는 앞에 노드로 이동
        }else {
            char c;
            scanf(" %c",&c);
            cursor = insert_node(list,cursor,c);  //커서는 새로 추가한 노드로 이동
        }
    }

    print_list(list);
}