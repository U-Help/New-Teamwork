#include"stdio.h"

int main()   /*计算机课题1.4 给定模糊逻辑中命题P和Q的值，求P和Q析取和合取的真值*/
{
	double p,q,temp;
	printf("please input the true values of p and q\n");
	scanf("%lf%lf",&p,&q);
    if(p<=q)
	{
		temp=p;
		p=q;
		q=temp;
	}
	printf("the true value of the conjunction of p and q is %lf\n",p);
	printf("the true value of the exclusive of p and q is %lf\n",q);
	return(0);
}
