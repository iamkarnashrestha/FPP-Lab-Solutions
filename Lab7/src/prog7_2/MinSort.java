package prog7_2;

public class MinSort {

	String str;
	public String sort(String s){
		if(s == null || s.length() ==0)
			return "";
		char[] strArr = s.toCharArray();
		int minPos=0;
		char minchar=strArr[0];
		for(int i=1;i<strArr.length;++i)
		{
			if(strArr[i]<minchar)
			{
				minPos=i;
				minchar=strArr[i];
			}		
		}
		
		strArr[minPos]=strArr[0];
		strArr[0]=minchar;
		s=new String(strArr);
		return minchar+sort(s.substring(1));

		
	}
	
	
	
	public static void main(String[] args)
	{
		MinSort ms = new MinSort();
		String result = ms.sort("zwxuabfkafutbbbb");
		
		System.out.println(result);

	}
	
	
}
