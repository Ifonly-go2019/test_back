#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 100

typedef struct Node
{
	char info;
	struct Node *llink, *rlink;
} TNODE;

char pred[MAX], inod[MAX];

TNODE *restore(char *ppos, char *ipos, int n);
void postorder(TNODE *ptr);

int main(int argc, char *argv[])
{
	TNODE *root;
	
	if (argc < 3)
	{
		exit(0);
	}
	strcpy(pred, argv[1]);
	strcpy(inod, argv[2]);
	root = restore(pred, inod, strlen(pred));
	postorder(root);
}

TNODE *restore(char *ppos, char *ipos, int n)
{
	TNODE *ptr = (TNODE *)malloc(sizeof(TNODE));
	char *rpos;
	int k;


	if (n <= 0) return NULL;
	ptr->info = ________;
	for (________ ; rpos < ipos + n; rpos++)
	{
		if (*rpos == *ppos)
			break;
	}
	k = ________;
	ptr->llink = restore(ppos+1, ________, k);
	ptr->rlink = restore(________+k, rpos + 1, n - 1 - k);
	return ptr;
}

void postorder(TNODE *ptr)
{
	if (ptr == NULL)
	{
		return;
	}
	postorder(ptr->llink);
	postorder(ptr->rlink);
	printf("%c", ptr->info);
}