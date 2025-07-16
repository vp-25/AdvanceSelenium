
public class practicedriver {

	public static void main(String[] args) {
		//String original="vishnu";//this is for one word
		/*String sentence="java is fun";
		//String reversed="";
		String [] words=sentence.split(" ");		
		for(int i=words.length-1;i>=0;i--) {
			//reversed+=original.charAt(i);
			  System.out.print(words[i] + " ");
		}
		//System.out.println("reversed string "+ reversed);
	}*/
		String name = "malayalam";
		String orginal = name;
		String reversed = "";
		for(int i=orginal.length()-1;i>=0;i--) {
			reversed+=orginal.charAt(i);
		}
		if(orginal.equals(reversed)) {
			System.out.println(orginal + " is a palindrome");
		}
		else {
			System.out.println(orginal + " is not a palindrome ");
		}
	}

}
