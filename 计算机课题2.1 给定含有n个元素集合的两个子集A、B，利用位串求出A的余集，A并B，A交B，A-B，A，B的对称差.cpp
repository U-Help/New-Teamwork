#include"stdio.h"
#include"malloc.h"

int main()    /*计算机课题2.1 给定含有n个元素集合的两个子集A、B，利用位串求出A的余集，A并B，A交B，A-B，A，B的对称差*/
{
	int n,*q[2],i;double *p=NULL;
	printf("please input the cardinality of universal contain\n");
	scanf("%d",&n);
	printf("please input the elements of contain U\n");
	p=(double *)malloc(sizeof(double)*n);	
	for(i=0;i<n;i++)
		scanf("%lf",&p[i]);
	q[0]=(int *)malloc(sizeof(int)*n);
	q[1]=(int *)malloc(sizeof(int)*n);
	printf("please input the elements of contain A,use 1 for in and 0 for out\n");
	for(i=0;i<n;i++)
		scanf("%d",q[0]+i);
	printf("please input the elements of contain B,use 1 for in and 0 for out\n");
	for(i=0;i<n;i++)
		scanf("%d",q[1]+i);

	printf("A的余集: ");
	for(i=0;i<n;i++)   /*输出A的余集*/
		if(*(q[0]+i)==0)
			printf("%lf ",p[i]);
	printf("\n");

	printf("A和B的并: ");
	for(i=0;i<n;i++)   /*输出A和B的并*/
		if(*(q[0]+i)==1||*(q[1]+i)==1)
			printf("%lf ",p[i]);
	printf("\n");

	printf("A和B的交: ");
    for(i=0;i<n;i++)   /*输出A和B的交*/
		if(*(q[0]+i)==1&&(*(q[1]+i))==1)
			printf("%lf ",p[i]);
	printf("\n");

    printf("A-B: ");
	for(i=0;i<n;i++)   /*输出A-B*/
		if(*(q[0]+i)==1&&(*(q[1]+i))==0)
			printf("%lf ",p[i]);
	printf("\n");

	printf("A和B的对称差: ");
	for(i=0;i<n;i++)   /*输出A和B的对称差*/
		if(*(q[0]+i)+*(q[1]+i)==1&&(*(q[0]+i)* *(q[1]+i)==0))
			printf("%lf ",p[i]);
	printf("\n");
	return(0);
}


		
	