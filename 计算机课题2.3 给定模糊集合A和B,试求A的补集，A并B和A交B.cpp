#include"stdio.h"
#include"malloc.h"

double max(double a,double b)
{
	if(a<b)
		a=b;
	return(a);
}

double min(double a,double b)
{
	if(a>b)
		a=b;
	return(a);
}

int main()    /*计算机课题2.3 给定模糊集合A和B,试求A的补集，A并B和A交B*/
{
	int i,n,*p=NULL;
	double *a=NULL,*b=NULL;
	printf("please input the number of the elements of U\n");
	scanf("%d",&n);
	p=(int *)malloc(sizeof(int)*n);
	a=(double *)malloc(sizeof(double)*n);
	b=(double *)malloc(sizeof(double)*n);
	printf("please input the elements of U\n");
	for(i=0;i<n;i++)
		scanf("%d",&p[i]);
	printf("please input the probality of the element belonging to A\n");
    for(i=0;i<n;i++)
		scanf("%lf",&a[i]);
	printf("please input the probality of the element belonging to B\n");
    for(i=0;i<n;i++)
		scanf("%lf",&b[i]);
	printf("the complement of A is showed below\n");
	for(i=0;i<n;i++)
		printf("%d %lf\n",p[i],1-a[i]);
	printf("the union of A and B is showed below\n");
    for(i=0;i<n;i++)
		printf("%d %lf\n",p[i],max(a[i],b[i]));
	printf("the intersection of A and B is showed below\n");
	for(i=0;i<n;i++)
		printf("%d %lf\n",p[i],min(a[i],b[i]));
	return(0);
}

	