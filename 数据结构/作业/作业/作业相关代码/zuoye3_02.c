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
		printf("ɾ��ʧ�ܣ�û�и�������...\n");
	}
	out(head);		//����ʧ����񣬶��������

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

node * insert(node * head, int n)
{
	node * p = head->next;
	node * s = (node *)malloc(sizeof(node));
	
	s->data = n;
	
	//��ɴ��룬��nֵ������������֤�����������򣩣��绹��Ҫ�������������ǰ�����


	



	return head;
}

node * del(node *head, int n, int * res)
{
	node * p;
	node * q;

	p = q =  head->next;		//�������ͷ���
	*res = 1;					//��ʾ����ҵ�����res��ָ�洢�ռ���1�����ظ�����������ɾ���Ƿ�����
	
	//��ɴ��룬����Ϊn�Ľ��ɾ�����绹��Ҫ�������������ǰ�����
	//���û���ҵ�������  *res = 0;



	return head;
}