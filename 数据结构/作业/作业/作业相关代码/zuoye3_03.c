#include <stdio.h>
#include <malloc.h>

//声明链表结点，数据域是一个整型
typedef struct _node
{
	int data;
	struct _node * next;
} node;

node * create();
void out(node *head);
void reverse(node *head);		//将该带头结点的链表反转，原为1,2,3,4，则变为4,3,2,1

int main(void)
{
	node * head;

	head = create();
	out(head);

	reverse(head);
	out(head);		

	return 0;
}

//尾插法建立链表
node * create()
{
	node * head = (node*)malloc(sizeof(node));	//头结点
	node *p, *q;
	int a[11] = {1, 2, 4, 6, 7, 9, 11, 13, 15, 17, 0};	//用于建立链表用数据，免得每次都键盘输入，0表示输入结束
	int i = 0;

	head->next = NULL;
	q=head;
	while (a[i] != 0)
	{
		p = (node *)malloc(sizeof(node));
		p->data = a[i];
		p->next = q->next;
		q->next = p;
		q = q->next;
		i++;
	}
	return head;
}

//输出链表的数据域
void out(node *head)
{
	node * p;
	p = head->next;		//带头结点
	while (p!=NULL)
	{
		printf("%d,", p->data);
		p = p->next;
	}
	printf("\n");
}

void reverse(node *head)
{
	node *p, *q;
	p = head->next;
	head->next = NULL;
	while (  )		//填空
	{
		q = p;
		p = p->next;
		q->next = head->next;
		head->next =   ;		//填空
	}
}