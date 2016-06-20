import java.io.File;

public class McPatterns {
	
    public static void main(String[] args){
    	try { 
        McPatternsGUI gui = new McPatternsGUI(new McPatternsPresenter(new File(args[0])));
    	} catch(Exception e) {
    		System.out.println("No File in current directory");
    	}
     }
 }