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
node * insert(node * head, int n);
node * del(node *head, int n, int *res);

int main(void)
{
	int res;
	node * head;

	head = create();
	out(head);

	head = insert(head, 5);
	out(head);

	head = del(head, 13, &res);
	if (res == 0)
	{
		printf("删除失败，没有该数据项...\n");
	}
	out(head);		//不管失败与否，都输出链表

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

node * insert(node * head, int n)
{
	node * p = head->next;
	node * s = (node *)malloc(sizeof(node));
	
	s->data = n;
	
	//完成代码，将n值插入链表，并保证链表有序（升序），如还需要定义变量，可在前面添加


	



	return head;
}

node * del(node *head, int n, int * res)
{
	node * p;
	node * q;

	p = q =  head->next;		//该链表带头结点
	*res = 1;					//表示如果找到，给res所指存储空间存放1，返回给主调函数，删除是否正常
	
	//完成代码，将数为n的结点删除，如还需要定义变量，可在前面添加
	//如果没有找到，运行  *res = 0;



	return head;
}