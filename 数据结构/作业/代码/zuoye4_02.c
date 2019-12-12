//简单顺序栈
//top为栈顶指示，为0表示栈空，为20表示栈满

#include <stdio.h>

typedef struct _stack
{
	char data[20];
	int top;
} Stack;

void push(Stack *st, char ch);
void pop(Stack *st, char *ch);

int main(void)
{
	int i;
	char ch;
	char str[20] = "!ssSuecc";
	Stack st;

	st.top = 0;	//初始化栈

	for (i = 0; i < 8; i++)
	{
		push(&st, str[i]);

		if (i == 3 || i == 4 || i == 6)
		{
			pop(&st, &ch);
			putchar(ch);
		}
	}
	for (i = 0; i < 5; i++)
	{
		pop(&st, &ch);
		putchar(ch);
	}
	putchar('\n');
	return 0;
}

void push(Stack *st, char ch)
{
	if (st->top == 20)
	{
		printf("栈已满，不能入栈\n");
		return;
	}

	//入栈
	
}

void pop(Stack *st, char *ch)
{
	if (st->top == 0)
	{
		printf("栈空，不能出栈\n");
		return;
	}

	//出栈
	
}
