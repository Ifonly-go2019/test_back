//ѭ������

#include <stdio.h>

typedef struct _queue
{
	int data[10];
	int front;
	int rear;
} Queue;

void create(Queue *qu);
void enqueue(Queue *qu, int n);		//n���
void dnqueue(Queue *qu, int *n);	//���ӣ�Ԫ�ش���n
void print(Queue qu);

int main(void)
{
	Queue qu;

	qu.front = qu.rear = 0;	//��ʼ������

	create(&qu);
	print(qu);
	return 0;
}

void create(Queue *qu)
{
	int i;
	int a[5] = {2, 8, 5, 3, 1};

	for (i = 0; i < 5; i++)
	{
		enqueue(qu, a[i]);
	}
}

void enqueue(Queue *qu, int n)
{
	if (   )		//�ж��Ƿ�ѭ������������
	{
		printf("������\n");
		return;
	}
	(*qu).data[(*qu).rear] = n;
	(*qu).rear = ((*qu).rear + 1) % 10;
}

void dnqueue(Queue *qu, int *n)
{
	if (  )			//�ж��Ƿ�ѭ�����п�����
	{
		printf("���п�\n");
		return;
	}
	*n = (*qu).data[(*qu).front];
	(*qu).front = ((*qu).front + 1) % 10;
}

void print(Queue qu)
{
	while( qu.front != qu.rear)
	{
		printf("%d,", qu.data[qu.front]);
		qu.front = (qu.front + 1) % 10;
	}
}