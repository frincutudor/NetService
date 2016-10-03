package ex.App1;

public class Network implements networkInteface {

    //TODO tudor ,  change this to Set< String>
    // trebuie de refacut pe 3 laiere 
    // view , service, dao
    // view e un fel de entry point in app , fie serviciwii web , controllere http servlete
    // service e layerul de busines logica 
    // dao sunt repositoriile responsabile stocarii obiectelor
    
	private String s1;
	private String s2;
	private String s3;
	
	
	public String getS1() {
		return s1;
	}



	public void setS1(String s1) {
		this.s1 = s1;
	}



	public String getS2() {
		return s2;
	}



	public void setS2(String s2) {
		this.s2 = s2;
	}



	public String getS3() {
		return s3;
	}



	public void setS3(String s3) {
		this.s3 = s3;
	}
	
	
	public void  showNetwork()
	{
		System.out.println("PCs in network : ");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	
	}
	
	
}
