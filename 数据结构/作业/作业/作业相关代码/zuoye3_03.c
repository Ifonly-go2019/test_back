#include <stdio.h>
#include <malloc.h>

//���������㣬��������һ������
typedef struct _node
{
	int data;
	struct _node * next;
} node;

node * create();
void out(node *head);
void reverse(node *head);		//���ô�ͷ��������ת��ԭΪ1,2,3,4�����Ϊ4,3,2,1

int main(void)
{
	node * head;

	head = create();
	out(head);

	reverse(head);
	out(head);		

	return 0;
}

//β�巨��������
node * create()
{
	node * head = (node*)malloc(sizeof(node));	//ͷ���
	node *p, *q;
	int a[11] = {1, 2, 4, 6, 7, 9, 11, 13, 15, 17, 0};	//���ڽ������������ݣ����ÿ�ζ��������룬0��ʾ�������
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

//��������������
void out(node *head)
{
	node * p;
	p = head->next;		//��ͷ���
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
	while (  )		//���
	{
		q = p;
		p = p->next;
		q->next = head->next;
		head->next =   ;		//���
	}
}