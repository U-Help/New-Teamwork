#include"stdio.h"

int main()   /*���������1.4 ����ģ���߼�������P��Q��ֵ����P��Q��ȡ�ͺ�ȡ����ֵ*/
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
