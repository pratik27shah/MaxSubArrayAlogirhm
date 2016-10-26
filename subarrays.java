/**
 * 
 */
package subarray;

/**
 * @author PRATIK SHAH
 *
 */
public class subarrays {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { -13,-23,25,20,-23,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
subs s1=new subs();
Max m2=s1.maxsub(0, arr.length-1,arr);
System.out.println(m2.startrange);
System.out.println(m2.endrange);
System.out.println(m2.value);

	}

}

class subs {
	
	Max max1=new Max();
	Max max2=new Max();
	Max max3=new Max();
	 Max max=new Max();
Max maxsub(int low,  int high, int[] arr)
{
if(low==high)
{
	max.set(low,high, arr[low]);
return max;	
}
else
{
	
int mid=(low+high)/2;
max1=maxsub(low,mid,arr);
max2=maxsub(mid+1,high,arr);
max3=subarray(low,mid,high,arr);
if(max1.value>max2.value && max1.value> max3.value) return max1;
if(max2.value>max1.value && max2.value>max3.value) return max2;
else return max3;
}


}

Max  subarray(int low, int mid, int high,int[] arr) {
	Max max=new Max();
		int leftsub = -1000;
		int sum = 0, leftval=0, i;
		int rightsub = -1000,rightval=0;
		for (i = mid; i >= low; i--) {
			sum = sum + arr[i];
			if (leftsub < sum) {
				leftsub = sum;
				leftval = i;
			}
		}
		sum=0;
		for (i = mid+1; i <= high; i++) {
			sum = sum + arr[i];
			if (rightsub < sum) {
				rightsub = sum;
				rightval = i;
			}
		}
		max.set(leftval,rightval,rightsub+leftsub);
		return max;
	}
}


class Max
{
	
int startrange;
int endrange;
int value;

void set(int startrange,int endrange,int value)
{
	this.endrange=endrange;
	this.startrange=startrange;
	this.value=value;
	}
int getstartrange()
{
return this.startrange;	
}
int getendrange()
{
return this.endrange;	
}
int value()
{
return this.value;	
}
}