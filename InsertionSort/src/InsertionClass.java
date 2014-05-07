
public class InsertionClass
{
	
	public void teste()
	{
	int element[] = {33,44,12,68,50,88,102,36,14,104,890,99,456};
	int chave = 0;
	int i = 0;
	
	for(int j = 1; j < element.length; j++)
	{
			chave = element[j];
			i = j - 1;
			
			
			while (i >=0 && element[i] > chave)
			{
				element[i+1] = element[i];
				 i = i-1;
			 }
			
			element[i+1] = chave;
	}
	
	for(int j = 0; j < element.length; j++)
	{
		
		System.out.print(element[j] + ",");
			if (j == element.length-1)
			{
				System.out.print(element[j] + "");
				
			}
				
	}
   }
 }





