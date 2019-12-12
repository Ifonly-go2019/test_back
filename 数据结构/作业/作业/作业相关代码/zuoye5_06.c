#include <stdio.h>
#include <malloc.h>

typedef struct _list
{
	int data;
	struct _list *next;
} list;

void exam(list *pa, list *pb)
{
	list *p, *p1, *p2;
	int s1, s2;

	p1 = pa->next;
	p2 = pb->next;
	pa->next = NULL;
	s1 = 0;
	s2 = 0;
	while (p1 != NULL && p2 != NULL)
	{
		if (p1->data < p2->data)
		{
			p = p1;
			p1 = p1->next;
			s2++;
			free(p);
		}
		else if (p1->data > p2->data)
		{
			p2 = p2->next;
		}
		else
		{
			p = p1;
			p1 = p1->next;
			p->next = pa->next;
			pa->next = p;
			p2 = p2->next;
			s1++;
		}
	}
	while (p1 != NULL)
	{
		p = p1;
		p1 = p1->next;
		free(p);
		s2++;
	}
	printf("s1=%d,s2=%d\n", s1, s2);
}

void print(list *h)
{
	list *p;
	p = h->next;

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

	q1 = h1 = (list *)malloc(sizeof(list));
	q2 = h2 = (list *)malloc(sizeof(list));
	h1->next = NULL;
	h2->next = NULL;
	for (i = 1; i <= 10; i++)
	{
		p1 = (list *)malloc(sizeof(list));
		p2 = (list *)malloc(sizeof(list));
		
		p1->data = i * 2;
		p2->data = i * 3;
		
		p1->next = q1->next;
		q1->next = p1;
		q1 = p1;
		p2->next = q2->next;
		q2->next = p2;
		q2 = p2;
	}
	print(h1);
	print(h2);

	exam(h1, h2);
	print(h1);
	print(h2);
	return 0;
}