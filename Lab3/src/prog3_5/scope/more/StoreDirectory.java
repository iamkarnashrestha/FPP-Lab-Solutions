package prog3_5.scope.more;

public class StoreDirectory {
	Bookstore bookstore;
	Market market;
	public StoreDirectory(String custId){
		bookstore = new Bookstore(custId);
		market = new Market();
	}
	
	
	
	//books
	public int getNumberOfBooks() {
		return bookstore.getNumBooks();
	}
	
	public int getNumberOfBookstoreEmployees() {
		return bookstore.getNumEmployees();
	}
	
	public boolean addNewEmployee(String employeeId){
		return bookstore.addNewEmployee(employeeId); 
	}
	
	public boolean bookIsInStock(String bookId){
		return bookstore.bookIsInStock(bookId);
	}
	public int getNumCDsInBookstore(){
		//implement 
		return bookstore.getNumCds();
	}
	
	public boolean addNewCD(int cdId){
		//re-implement 
		return bookstore.addCd(cdId);
	}
	public boolean addNewBook(String bookId){
		//re-implement
		return bookstore.addNewBook(bookId);
	}
	
	
	//market
	public boolean marketCarriesFoodItem(String foodItem){
		//re-implement 
		return market.carriesFoodItem(foodItem);
	}

}
