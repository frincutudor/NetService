package ex.App1;

public class networkController {
	
	networkInteface obj;

	public void setObj(networkInteface obj) {
		this.obj = obj;
	}
	
	
	void printNetwork()
	{
		
		obj.showNetwork();
		
	}
	
	

}
