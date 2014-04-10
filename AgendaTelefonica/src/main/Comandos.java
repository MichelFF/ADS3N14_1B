
package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

import Estrutura.ListaOrdenada;
import Estrutura.Nodo;
import Estrutura.Pessoa;


public class Comandos {
	
    private BufferedReader br;
    public static Scanner sc;
    private ListaOrdenada novaLista;

    public void showMenu()
    {
	System.out.println("\n"
			+ "============= Menu =============  \n "
			+ "1-  Inserir contato na agenda   |\n "
			+ "2 - Listar contatos da agenda   |\n "
			+ "3 - Pesquisar Letra             |\n "
			+ "4 - Navegar                     |\n "
			+ "5 - Pesquisa binaria            |\n "
			+ "6 - Encerrar                    |\n"
			+ "================================  \n");
    }
    
    public void readAction(Integer cmd) throws IOException{
	if(cmd.equals(1)){
	    add();
	}
	
	if(cmd.equals(2)){
	    showList();
	}
	
	if(cmd.equals(3))
	{
		System.out.println("Digite a primeira letra para pesquisar o contato:");
	    String Pesquisa= sc.next();
	    char teste = Pesquisa.charAt(0);
	    PesquisaChar(teste);
	}
	
	if(cmd.equals(4)){
	    surfIntoList();
	}
	
	if(cmd.equals(5)){
		binarySearch();
	   
	}
	
	if(cmd.equals(6)){
		 System.out.println("Encerrando sistema");
		 System.exit(0);
	}
	
	
     }
    

    public void binarySearch() throws IOException{
    	
      Pessoa ps = new Pessoa();
  	
   	 novaLista = new ListaOrdenada<String>();
  	
  	 Reader fileReader = new FileReader("Lista_telefonica.txt");
  	 br = new BufferedReader(fileReader);
  	
        
    String line = null;

  	
  	 while ((line = br.readLine()) != null)
  	 {
  		
  	     String[] breakLine = line.split(";");
  	     
  	    		
  			 String nomePessoa = breakLine[0];//nome
  			 String telefonePessoa = breakLine[1];//telefone
  			 
  			 ps.setNome(nomePessoa.toLowerCase());
  			 ps.setTelefone(telefonePessoa);
  			 
  			 novaLista.insert(new Nodo<String>("Contato: "+ps.getNome().toUpperCase()+" "+"| Telefone: "+ps.getTelefone()));
  		
  			
  	     }// fim do while
  		Nodo<?> novo  = novaLista.getHead();
  		
  	 	ArrayList<String> myArray = new ArrayList();
  	 
  	 	  	 	
  	 	while (novo != null)
  	 	{
  	 		
  	 		String temp = novo.getData().toString();
  	 		novo = novo.getNext();
  	 		myArray.add(temp);
  	 			 		
  	 	}
  	 	
  	 	System.out.println("Digite o numero do contato para a pesquisa binaria");
  	 	
  	 	Scanner leitor = new Scanner(System.in);
  	 	int x = leitor.nextInt();
  	 	
  	 	int esquerda, direita, meio, count = 0;
  	 	
  	 	
  	 	esquerda = 0 ; 	 	
  	 	direita = myArray.size();
  	 	meio  = (direita / 2); 
  	 		  	
  	 	
  	 	
  	 	while (esquerda <= direita)		
  	 	{	
  	 		if (meio == x)
  	 		{
  	 				System.out.println("Contato numero "+x+" da lista: "+ myArray.get(meio-1));
  	 				System.out.println("numero de comparações : " +count);
  	 				break;
  	 		}
  	 		if (x > meio)
  	 		{
  	 			esquerda = meio + 1;
  	 			meio = (esquerda + direita) / 2;
  	 			count++;
  	 		}
  	 		
  	 		if (x < meio)
  	 		{
  	 			direita = meio - 1;
  	 			meio = (esquerda + direita) / 2;
  	 			count++;
  	 		}
  	 		
  	 	}
  	 	
        
      }// fim do metodo

    
    
        
    
    public void add() throws IOException{
	
		 Reader fileReader = new FileReader("Lista_telefonica.txt");
		
		 br = new BufferedReader(fileReader);
		
		 String nome = null;
		 String telefone;
		
		
		 sc = new Scanner(System.in);
		
		 Writer fileWriter = new FileWriter("Lista_telefonica.txt", true);
	
		
		 System.out.println("Nome: ");

		 nome = sc.nextLine()+";".toLowerCase();
		
		
	    
	System.out.println("Telefone: ");
	telefone = sc.nextLine();
	
	boolean insertion = false;

	while (insertion!=true) {
	    
	    	fileWriter.write(nome+" "+telefone);
		fileWriter.append("\n");
		insertion = true;
	}
	
	fileWriter.close();
	
    }
    
  public void showList() throws IOException{
	
      Pessoa ps = new Pessoa();
	
 	 ListaOrdenada<String> lista = new ListaOrdenada<String>();
	
	 Reader fileReader = new FileReader("Lista_telefonica.txt");
	 br = new BufferedReader(fileReader);
	
      
      String line = null;

	
	 while ((line = br.readLine()) != null) {
		
	     String[] breakLine = line.split(";");
	     
	     System.out.println(line);
		
			 String nomePessoa = breakLine[0];//nome
			 String telefonePessoa = breakLine[1];//telefone
			 
			 ps.setNome(nomePessoa.toLowerCase());
			 ps.setTelefone(telefonePessoa);
			 
			 lista.insert(new Nodo<String>("Contato: "+ps.getNome().toUpperCase()+" "+"| Telefone: "+ps.getTelefone()));
		
			 
			
	 }
		System.out.println("\n ============================ Forma ordenada ============================\n");
		lista.print();
      
    }
   
  

  
  	public void PesquisaChar(char c) throws IOException{
  	  
  	  Pessoa ps = new Pessoa();
  	
  	 ListaOrdenada<String> lista = new ListaOrdenada<String>();
 	
 	 Reader fileReader = new FileReader("Lista_telefonica.txt");
 	 br = new BufferedReader(fileReader);
 	
       
       String line = null;

 	
 	 while ((line = br.readLine()) != null) {
 		
 	     String[] breakLine = line.split(";");
 	     
 
 			 String nomePessoa = breakLine[0];//nome
 			 String telefonePessoa = breakLine[1];//telefone
 			 
 			 					 
 			 ps.setNome(nomePessoa.toLowerCase());
 			 ps.setTelefone(telefonePessoa);
 			 
 			lista.insert(new Nodo<String>(ps.getNome().toLowerCase()+" "+ps.getTelefone()));
 			
 			
 	 }
 		System.out.println("_____________________");
 		lista.printUniqueChar(c);
  }

  	
  	
  	
  	
  	
  	
  	
  	public void surfIntoList() throws IOException{

  	     Pessoa ps = new Pessoa();
  		
  	 	 ListaOrdenada<String> lista = new ListaOrdenada<String>();
  		
  		 Reader fileReader = new FileReader("Lista_telefonica.txt");
  		 br = new BufferedReader(fileReader);
  		
  	      
  	      String line = null;

  		
  		 while ((line = br.readLine()) != null) {
  			
  		     String[] breakLine = line.split(";");
  		     
  		     //	System.out.println(line);
  			
  				 String nomePessoa = breakLine[0];//nome
  				 String telefonePessoa = breakLine[1];//telefone
  				 
  	 				 
  				 ps.setNome(nomePessoa.toLowerCase());
  				 ps.setTelefone(telefonePessoa);
  				 
  				lista.insert(new Nodo<String>("Contato: "+ps.getNome().toUpperCase()+" "+"| Telefone: "+ps.getTelefone()));
  			
  				
  		 }
  			
  		System.out.println("----------------------------------------------------------------");
		
  		
		do{
		    
		    try{
		    	
			String s = sc.nextLine();
		
		    		    
		    if(s.toLowerCase().equals("a")){
		   lista.upDown++;
		    lista.printAgain();
		 
		}if(s.toLowerCase().equals("v")){
		    lista.upDown--;
		    lista.printAgain();
		 
		}
		if(s.equals("s")){
		    break;
		 
		}
		
		System.out.println("\n Menu:(a) proximo>>>>> (v) <<<<< anterior (s) Voltar ao menu \n"); 
		
		    }catch(Exception e){
		    System.out.println("Inconsistente");
		}
		}while(true);
  	}
  	
  	
}
