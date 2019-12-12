//最简单顺序存储线性表

#include <stdio.h>

typedef struct _seq
{
	int array[10];		//顺序存储的线性表
	int len;			//当前该顺序表中的元素个数
} seq;

void init(seq *sqlist);		//初始化该线性表
void insert_tail(seq *sqlist, int i);	//将i插入到sqlist线性表表尾
int insert(seq *sqlist, int n, int i);	//将i插入到sqlist线性表的第n个位置，返回值为-1表示n位置不合法，返回-2表示线性表已满，返回1表示插入成功
void reverse(seq *sqlist);		//将线性表里的内容就地反转，如原来为1,2,3,4,则变为4,3,2,1
void print(seq sqlist);			//顺序输入该线性表中的值

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

	result = insert(&samplelist, 5, 20);		//将5的值改为0失败，1-8合法，9失败测试代码
	if (result < 0)
	{
		printf("插入失败\n");
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
	//由于存储空间已经分配好了
	(*sqlist).len = 0;		//初始化只需要将该线性表的长度清零
}

void insert_tail(seq *sqlist, int i)
{
	int n = (*sqlist).len;	//获得该线性表的长度
	(*sqlist).array[n] = i;	//将i插入在线性表的表尾
	(*sqlist).len++;		//表长加1
}

int insert(seq *sqlist, int n, int i)
{
	int j,k;

	if ((*sqlist).len == 10)		//表已满
	{
		return -2;		
	}
	if(n>(*sqlist).len||n<1 )				//n值不合法，合法为1至len
	{
		return -1;
	}

    	//在第n个位置（不是下标）插入i值
	
	
	(*sqlist).len++;
	
      k = (*sqlist).len;
	for(j=k;j>=n;j--)
	{
		while(j=n){
		
		 (*sqlist).array[j] =i;  
		}

	   (*sqlist).array[j] =(*sqlist).array[j-1];
		

	}
     
	return 1;
} 

void reverse(seq *sqlist)
{
	int j,c;
     int k = (*sqlist).len;
     for(j=0;j<k;j++)
{
        c=(*sqlist).array[j];
        (*sqlist).array[j]=(*sqlist).array[9-j];
        (*sqlist).array[9-j]=c;
}


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