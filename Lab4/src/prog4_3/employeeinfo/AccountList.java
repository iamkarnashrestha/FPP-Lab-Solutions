package prog4_3.employeeinfo;


public class AccountList {
	private final int INITIAL_LENGTH = 2;
	private Account[] accountList; 
	private int size;
	
	public AccountList() {
		accountList = new Account[INITIAL_LENGTH];
		size = 0;
	}
	
	public void add(Account s){
		//implement
		if(size>=accountList.length)
		{
			resize();
		}
		accountList[size]=s;
		size++;
	}
	
	public Account get(int i){
		//implement
		return accountList[i];
	}
	
	public boolean find(AccountType s){
		for(int i=0;i<accountList.length;i++)
		{
			if(accountList[i].getAcctType().equals(s))
				return true;
		}
		return false;
	}
	
	public void insert(String s, int pos){
		//implement
		
	}
	
	public boolean remove(AccountType s){
		//implement
		if(find(s))
		{	 size--;
			
			for(int i=0;i<accountList.length;i++)
			{	 
				if(s.equals(accountList[i].getAcctType()))
				{	
					System.arraycopy(accountList,i+1, accountList, i, accountList.length-i-1);
					break;
					
				}	
			}
			return true;
		}
		else
			return false;
	}
	
	
	private void resize(){
		System.out.println("Resizing....");
		Account[]temp=new Account[size*2];
		System.arraycopy(accountList, 0, temp, 0, size());
		accountList=temp;
	}
	
	
	public String toString(){

		
		String myString="[";
		for(int i=0;i<size;i++)
		{	
				if(i==size-1)
				{
					myString+=accountList[i];
					
				}
				else
					myString+=accountList[i];

		}
		return myString+"]";
	}
	public int size() {
		return size;
	}

	

}
