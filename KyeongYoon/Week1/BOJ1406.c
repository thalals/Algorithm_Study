#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct node{
  char data;
  struct node* next;
  struct node* prev;
}node;

void print(node* n){
  node* temp = n;
  temp=temp->next;
  while(temp){
    printf("%c",temp->data);
    temp=temp->next;
  }
  printf("\n");
}

int main(){
  node* head = (node*)malloc(sizeof(node));
  head->data='!';
  head->prev=head->next=NULL;
  node* cur = head;
  char t;
  while((t=getchar())!='\n'){
    node* newnode = (node*)malloc(sizeof(node));
    newnode->data=t;
    newnode->prev=cur;
    newnode->next=NULL;
    cur->next=newnode;
    cur=newnode;
  }
  int n;
  scanf("%d",&n);
  for(int i=0;i<n;i++){
    //print(head);
    char c;
    scanf(" %c",&c);
    switch(c){
      case 'L':{
        if(cur->prev) cur=cur->prev;
        break;
      }case 'D':{
        if(cur->next) cur=cur->next;
        break;
      }case 'B':{
        if(cur->prev==NULL) continue;
        node* del = (node*)malloc(sizeof(node));
        del=cur;
        cur=del->prev;
        if(del->next) {
          cur->next=del->next;
          del->next->prev=cur;
          del->prev=NULL;}
        else{cur->next=NULL;}
        free(del);
        break;
      }case 'P':{
        char tmp;
        scanf(" %c",&tmp);
        node* newnode = (node*)malloc(sizeof(node));
        newnode->data=tmp;
        newnode->prev=cur;
        if(cur->next){
          newnode->next=cur->next;
          cur->next->prev=newnode;
        }else{
          newnode->next=NULL;
        }
        cur->next=newnode;
        cur=cur->next;
        break;
      }
    }
  }
  head=head->next;
  while(head){
    printf("%c",head->data);
    head=head->next;
  }
}