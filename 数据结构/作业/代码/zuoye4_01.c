#include <stdio.h>
#include <stdlib.h>

//˫������nextָ��̣�priorָǰ��
typedef struct _node
{
	int data;
	struct _node * next;
	struct _node * prior;
} node, *pnode;			//������pnode������ָ��node���͵�ָ��������൱��node *   

void create(pnode head);	//����˫������
void print(pnode head);		//��ǰ���󣬴Ӻ���ǰ�����˫������
void insert(pnode head, int n);		//��˫�������в���һ��Ԫ��n��ʹ˫��������Ȼ����
void del(pnode head, int n);		//��˫��������ֵΪn��Ԫ��ɾ��

int main(void)
{
	pnode head;			//ͷ��㣬�൱�ڴ���  node * head;
	
	//��ʼ����˫��������Ԫ��
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
	printf("��ǰ�����ǣ�\n");
	while (p->next != NULL)
	{
		printf("%d,", p->next->data);
		p = p->next;
	}
	printf("\n�Ӻ���ǰ�ǣ�\n");
	while (p->prior != NULL)
	{
		printf("%d,", p->data);
		p = p->prior;
	}
	printf("\n");
}

//��˫�������в���һ��Ԫ��n��ʹ˫��������Ȼ����
void insert(pnode head, int n)
{
	pnode p = head;
	pnode s = (pnode)malloc(sizeof(node));

	s->data = n;
	//�ҵ�����λ��֮ǰ�Ľ�㣬��pָ��ǰһ�����
	while(p->next->data < n && p->next != NULL)
	{
		p = p->next;
	}

	//Ϊ˫��������p���֮�����s���
	
}

//��˫��������ֵΪn��Ԫ��ɾ��
void del(pnode head, int n)
{
	//������Ҫ��ָ��������ο�insert����������ֵ


	//�ҵ���Ҫɾ����Ԫ�أ�������δ�ҵ��������׳�ԣ����ȸ�Ԫ�ؿ϶�����
	

	//ɾ���ý�㣬��ɾ��p��ָ���
	/*
	p->next->prior = p->prior;	//�޸�p����̽���ǰ��ָ��
	p->prior->next = p->next;	//�޸�pǰ�����ĺ��ָ��
	free(p);
	*/
}