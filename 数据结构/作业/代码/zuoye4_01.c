#include <stdio.h>
#include <stdlib.h>

//双向链表，next指后继，prior指前驱
typedef struct _node
{
	int data;
	struct _node * next;
	struct _node * prior;
} node, *pnode;			//可以用pnode来定义指向node类型的指针变量，相当于node *   

void create(pnode head);	//创建双向链表
void print(pnode head);		//从前往后，从后往前，输出双向链表
void insert(pnode head, int n);		//在双向链表中插入一个元素n，使双向链表依然有序
void del(pnode head, int n);		//将双向链表中值为n的元素删除

int main(void)
{
	pnode head;			//头结点，相当于代码  node * head;
	
	//初始化该双向链表，无元素
	head = (pnode)malloc(sizeof(node));
	//head->data = -222;
	head->next = NULL;
	head->prior = NULL;

	create(head);
	print(head);

	insert(head, 12);
	print(head);

	del(head, 23);
	print(head);
	return 0;
}

void create(pnode head)
{
	int i;
	int a[11] = {1, 3, 6, 9, 13, 18, 23, 25, 0};
	pnode s;
	pnode p = head;
	
	for (i = 0; a[i] != 0; i++)
	{
		s = (pnode)malloc(sizeof(node));
		s->data = a[i];
		s->next = p->next;
		s->prior = p;
		p->next = s;
		p = s;
	}
}

void print(pnode head)
{
	pnode p = head;
	printf("从前往后是：\n");
	while (p->next != NULL)
	{
		printf("%d,", p->next->data);
		p = p->next;
	}
	printf("\n从后往前是：\n");
	while (p->prior != NULL)
	{
		printf("%d,", p->data);
		p = p->prior;
	}
	printf("\n");
}

//在双向链表中插入一个元素n，使双向链表依然有序
void insert(pnode head, int n)
{
	pnode p = head;
	pnode s = (pnode)malloc(sizeof(node));

	s->data = n;
	//找到插入位置之前的结点，让p指向前一个结点
	while(p->next->data < n && p->next != NULL)
	{
		p = p->next;
	}

	//为双向链表在p结点之后插入s结点
	
}

//将双向链表中值为n的元素删除
void del(pnode head, int n)
{
	//定义需要的指针变量，参考insert函数，并赋值


	//找到需要删除的元素，不考虑未找到情况（健壮性），既该元素肯定存在
	

	//删除该结点，设删除p所指结点
	/*
	p->next->prior = p->prior;	//修改p结点后继结点的前驱指针
	p->prior->next = p->next;	//修改p前驱结点的后继指针
	free(p);
	*/
}