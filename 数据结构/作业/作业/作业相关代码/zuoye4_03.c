//循环队列

#include <stdio.h>

typedef struct _queue
{
	int data[10];
	int front;
	int rear;
} Queue;

void create(Queue *qu);
void enqueue(Queue *qu, int n);		//n入队
void dnqueue(Queue *qu, int *n);	//出队，元素存入n
void print(Queue qu);

int main(void)
{
	Queue qu;

	qu.front = qu.rear = 0;	//初始化队列

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
	if (   )		//判断是否循环队列满条件
	{
		printf("队列满\n");
		return;
	}
	(*qu).data[(*qu).rear] = n;
	(*qu).rear = ((*qu).rear + 1) % 10;
}

void dnqueue(Queue *qu, int *n)
{
	if (  )			//判断是否循环队列空条件
	{
		printf("队列空\n");
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