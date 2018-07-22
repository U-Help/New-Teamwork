#include"stdio.h"
#include"malloc.h"

int main()    /*计算机课题2.6 给定一个从自然数到其自身的双射函数f，求f的反函数*/
{
	int *p=NULL,*q=NULL,n,i;
	printf("please input the domain of function\n");
	scanf("%d",&n);
	p=(int *)malloc(sizeof(int)*n);
	q=(int *)malloc(sizeof(int)*n);
	printf("please input the function\n");
	printf("x:");
	for(i=0;i<n;i++)
		printf("%d ",i);
	printf("\ny:");
	for(i=0;i<n;i++)
		scanf("%d",&q[i]);
	printf("the inverse of function is showed below:\n");
	printf("x:");
	for(i=0;i<n;i++)
		printf("%d ",q[i]);
	printf("\ny:");
	for(i=0;i<n;i++)
		printf("%d ",i);
	printf("\n");
	free(p);free(q);
	return(0);
}