package Page_Object;

public class reverse_string {
	public static void main(String[] args) {
		
	
		String str = "Java";
		String rev = new StringBuilder(str).reverse().toString();

		System.out.println(rev);
	}}