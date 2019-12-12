#include <stdio.h>
 
void change_49(int a,int m,int n);
void change_49(int a,int m,int n)
{
    int  a1, m1, n1, a2, m2, n2;
    int i, j, cnt_49, quotient_49, tmp_49, s1 = 1, s2 = 1;
    int mm[20];
    a1 = a2 = a;
    m1 = m2 = m;
    n1 = n2 = n;
    quotient_49 = m1;
    for (i = 0; quotient_49 != 0; i++)
    {
        mm[i] = quotient_49 % 2;
        quotient_49 = quotient_49 / 2;
    }
    j = i;
 
	printf("模重复平方根算法：\n");
    for (i = 0; i < j; i++)
    {
        if (mm[i] == 1)
        {
            s1 = (s1 * a1) % n1;
        }
        a1 = (a1 * a1) % n1;
        printf("i = %d, s = %d, a = %d\n", mm[i], s1, a1);
    }
    printf("最终结果为：s = %d\n\n\n", s1);
	
	
    for (i = 0; i < j / 2 ; i++)
    {
        tmp_49 = mm[i];
        mm[i] = mm[j-i-1];
        mm[j-i-1] = tmp_49;
    }
    cnt_49 = j;	
	printf("平方乘算法：\n");
	for (i = 0; i < j; i++)
    {
        s2 = (s2 * s2) % n2;
        printf("%d, ",s2);
        if (mm[i] == 1)
        {
            s2 = (s2 * a) % n2;
        }
        printf("i = %d, b%d = %d, s = %d\n", cnt_49-1, cnt_49-1, mm[i], s2);
        cnt_49--;
    }
    printf("最终结果为：s = %d\n", s2);
}






int main()
{
    int a, m, n;
    printf("请输入数字(a, m, n):");
    scanf("%d%d%d", &a, &m, &n);
    change_49(a,m,n);
	getchar();
    return 0;
}

