#include"stdio.h"
#include"malloc.h"
#include"math.h"

int main()    /*计算和探索2.2 给定一个有限集，试列出其幂集中的所有元素*/
{
	int *p=NULL,*q=NULL,i,j,k,n;
	printf("please input the cardinality of the contain\n");
	scanf("%d",&n);
	p=(int *)malloc(sizeof(int)*n);
	q=(int *)malloc(sizeof(int)*n);
	printf("please input the elements of the contain\n");
	for(i=0;i<n;q[i]=0,i++)
		scanf("%d",&p[i]);
	printf("the son contains is showed below:\n");
	printf("[/]\n");
	for(i=0,j=1;j<int(pow(2,n));j++,i=0)
	{
loop:	if(q[i]+1>1)
		{
			q[i]=0;
			i++;
			goto loop;
		}
        else
			q[i]=1;
		printf("(");
		for(k=0;k<n;k++)
		{
			if(q[k]==1)
				printf("%d",p[k]);
			if(k<n-1)
				printf(",");
		}
		printf(")\n");
	}
	return(0);
}


