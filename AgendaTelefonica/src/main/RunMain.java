
package main;



import java.io.IOException;
import java.util.Scanner;

     public class RunMain {

	

	public static void main(String [] args) throws IOException{

	  
	    
	    while(true){
		  
	        Comandos prompt = new Comandos();
	    
	             prompt.showMenu();
	    
	                 Integer Entrada;
	                 
	                 
	                 
	                 
	      Comandos.sc = new Scanner(System.in);
	    
	             Entrada = Comandos.sc.nextInt();
	    

	                   prompt.readAction(Entrada);
	    
	}   
		
	
	
	}

}
