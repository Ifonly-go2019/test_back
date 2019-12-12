#include <stdio.h>
#include <malloc.h>

typedef struct _linklist
{
	int data;
	struct _linklist *next;
} linklist;

void subp(linklist *s, linklist *q)
{
	linklist *p;
	p = s;
	while (p->next != q)
	{
		p = p->next;
	}
	p->next = s;
}

void Mp(linklist *pa, linklist *pb)
{
	subp(pa, pb);
	subp(pb, pa);
}

void print(linklist *h)
{
	linklist *p;

	p = h;

	while (p->next != h)
	{
		printf("%d, ", p->data);
		p = p->next;
	}
	printf("%d\n", p->data);
}

int main(void)
{
	int i;
	linklist *h1, *p1, *q1;
	linklist *ha, *hb;

	h1 = q1 = p1 = (linklist *)malloc(sizeof(linklist));
	h1->data = 1;
	h1->next = h1;
	for (i = 1; i <= 10; i++)
	{
		p1 = (linklist *)malloc(sizeof(linklist));
		p1->data = i * 2;
		p1->next = q1->next;
		q1->next=p1;
		q1 = p1;
	}
	print(h1);

	p1 = h1;
	for (i = 1; i <= 8; i++, p1 = p1->next)
	{
		if (i == 3)
		{
			ha = p1;
		}
		if (i == 7)
		{
			hb = p1;
		}
	}

	Mp(ha, hb);
	print(ha);
	print(hb);
	return 0;
}
