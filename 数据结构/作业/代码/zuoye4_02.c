//��˳��ջ
//topΪջ��ָʾ��Ϊ0��ʾջ�գ�Ϊ20��ʾջ��

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

	st.top = 0;	//��ʼ��ջ

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
		printf("ջ������������ջ\n");
		return;
	}

	//��ջ
	
}

void pop(Stack *st, char *ch)
{
	if (st->top == 0)
	{
		printf("ջ�գ����ܳ�ջ\n");
		return;
	}

	//��ջ
	
}
