//���˳��洢���Ա�

#include <stdio.h>

typedef struct _seq
{
	int array[10];		//˳��洢�����Ա�
	int len;			//��ǰ��˳����е�Ԫ�ظ���
} seq;

void init(seq *sqlist);		//��ʼ�������Ա�
void insert_tail(seq *sqlist, int i);	//��i���뵽sqlist���Ա��β
int insert(seq *sqlist, int n, int i);	//��i���뵽sqlist���Ա�ĵ�n��λ�ã�����ֵΪ-1��ʾnλ�ò��Ϸ�������-2��ʾ���Ա�����������1��ʾ����ɹ�
void reverse(seq *sqlist);		//�����Ա�������ݾ͵ط�ת����ԭ��Ϊ1,2,3,4,���Ϊ4,3,2,1
void print(seq sqlist);			//˳����������Ա��е�ֵ

int main(void)
{
	int i, result;
	seq samplelist;

	init(&samplelist);
	for (i = 1; i < 20; i += 3)
	{
		insert_tail(&samplelist, i);		
	}
	print(samplelist);	

	result = insert(&sqmplelist, 5, 20);		//��5��ֵ��Ϊ0ʧ�ܣ�1-8�Ϸ���9ʧ�ܲ��Դ���
	if (result < 0)
	{
		printf("����ʧ��\n");
	}
	else
	{
		print(samplelist);
	}

	reverse(&samplelist);
	print(samplelist);
	return 0;
}

void init(seq *sqlist)
{
	//���ڴ洢�ռ��Ѿ��������
	(*sqlist).len = 0;		//��ʼ��ֻ��Ҫ�������Ա�ĳ�������
}

void insert_tail(seq *sqlist, int i)
{
	int n = (*sqlist).len;	//��ø����Ա�ĳ���
	(*sqlist).array[n] = i;	//��i���������Ա�ı�β
	(*sqlist).len++;		//����1
}

int insert(seq *sqlist, int n, int i)
{
	int j;

	if ((*sqlist).len == 10)		//������
	{
		return -2;		
	}
	if(  )				//nֵ���Ϸ����Ϸ�Ϊ1��len
	{
		return -1;
	}

	//�ڵ�n��λ�ã������±꣩����iֵ


	return 1;
}

void reverse(seq *sqlist)
{

}

void print(seq sqlist)
{
	int i;
	for (i = 0; i < sqlist.len; i++)
	{
		printf("%d,", sqlist.array[i]);
	}
	printf("\n");
}