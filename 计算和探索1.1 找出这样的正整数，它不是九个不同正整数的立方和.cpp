#include"stdio.h"

#define N 3000

int except(int *a,int n)
{
	int i,sum=0;
	for(i=0;i<10;i++)
	{
		if(i==n)
			continue;
		else
			sum=sum+a[i]*a[i]*a[i];
	}
	return(sum);
}

int main()    /*�����̽��1.1 �ҳ��������������������ǾŸ���ͬ��������������*/
{
	int i,sum,a[10]={1,2,3,4,5,6,7,8,9,10},num[N+1]={0};
	for(i=0;i<10;i++)
	{
		sum=except(a,i);
		num[sum]=1;
	}
	for(i=1;i<N+1;i++)
	{
		if(num[i]==0)
			printf(" %d ",i);
		else
			printf("      ");
		if(i%10==0)
			printf("\n");
	}
	return(0);
}
