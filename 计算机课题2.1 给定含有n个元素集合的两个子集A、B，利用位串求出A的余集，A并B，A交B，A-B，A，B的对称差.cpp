#include"stdio.h"
#include"malloc.h"

int main()    /*���������2.1 ��������n��Ԫ�ؼ��ϵ������Ӽ�A��B������λ�����A���༯��A��B��A��B��A-B��A��B�ĶԳƲ�*/
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

	printf("A���༯: ");
	for(i=0;i<n;i++)   /*���A���༯*/
		if(*(q[0]+i)==0)
			printf("%lf ",p[i]);
	printf("\n");

	printf("A��B�Ĳ�: ");
	for(i=0;i<n;i++)   /*���A��B�Ĳ�*/
		if(*(q[0]+i)==1||*(q[1]+i)==1)
			printf("%lf ",p[i]);
	printf("\n");

	printf("A��B�Ľ�: ");
    for(i=0;i<n;i++)   /*���A��B�Ľ�*/
		if(*(q[0]+i)==1&&(*(q[1]+i))==1)
			printf("%lf ",p[i]);
	printf("\n");

    printf("A-B: ");
	for(i=0;i<n;i++)   /*���A-B*/
		if(*(q[0]+i)==1&&(*(q[1]+i))==0)
			printf("%lf ",p[i]);
	printf("\n");

	printf("A��B�ĶԳƲ�: ");
	for(i=0;i<n;i++)   /*���A��B�ĶԳƲ�*/
		if(*(q[0]+i)+*(q[1]+i)==1&&(*(q[0]+i)* *(q[1]+i)==0))
			printf("%lf ",p[i]);
	printf("\n");
	return(0);
}


		
	