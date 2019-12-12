#include <stdio.h>
#include <malloc.h>

typedef struct _list
{
	int data;
	struct _list *next;
} list;

void mergelink(list *p, list *q)
{
	list *h, *r;

	h = (list *)malloc(sizeof(list));
	h->next = NULL;
	r = h;
	while (p != NULL && q != NULL)
	{
		if (p->data <= q->data)
		{
			________;
			r = p;
			p = p->next;
		}
		else
		{
			_________;
			r = q;
			q = q->next;
		}
	}
	if (p == NULL)
	{
		r->next = q;
	}
	else
	{
		________;
	}
	p = h->next;
	free(h);
}

void print(list *h)
{
	list *p;

	p = h;
	while (p != NULL)
	{
		printf("%d, ", p->data);
		p = p->next;
	}
	printf("\n");
}

int main(void)
{
	int i;
	list *h1, *h2;
	list *p1, *q1, *p2, *q2;

	h1 = q1 = p1 = (list *)malloc(sizeof(list));
	h2 = q2 = p2 = (list *)malloc(sizeof(list));
	h1->data = 1;
	h2->data = 1;
	h1->next = NULL;
	h2->next = NULL;
	for (i = 1; i <= 10; i++)
	{
		p1 = (list *)malloc(sizeof(list));
		p2 = (list *)malloc(sizeof(list));
		
		p1->data = i * 2;
		p2->data = i * 3;
		
		p1->next = q1->next;
		q1->next=p1;
		q1 = p1;
		p2->next = q2->next;
		q2->next=p2;
		q2 = p2;
	}
	print(h1);
	print(h2);

	mergelink(h1, h2);

	print(h1);
	return 0;
}