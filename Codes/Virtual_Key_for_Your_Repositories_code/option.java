package project;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class option {
	public static void main(String[] args){
	/*System.out.println("Hello World!");*/
    System.out.println("\n**************************************\n");
    System.out.println("\tWelcome to TheDesk \n");
    System.out.println("**************************************");
    optionsSelection();

}
private static void optionsSelection(){
	Scanner sc = new Scanner(System.in);
	File ff = new File("C:/Users/User/Desktop/MyRepository/Project/Files");
	ff.mkdirs();
    
    while(true) {
    	System.out.println("**********Prototype of the Application LockedMe.com**********  \n");
        System.out.println("*****The following functions are :- *******   \n");
        System.out.println("1. To display the files in ascending order\n");
        System.out.println("2. Here are some User Enabled Operations  \n");
        System.out.println("3. Terminate Program");
        
        System.out.println("Enter your choice \n");
        int choice = sc.nextInt();
        switch(choice) {
        case 1:
        	File arr2[] = ff.listFiles();
        	Arrays.sort(arr2);
        	for(int i=0;i<arr2.length;i++) {
                System.out.println(arr2[i]);
        	}
        	System.out.println();
        	break;
        
        
        case 2 :
        	while(true) {
        	String[] arr = {"1. You want to create a file",
                "2. You want to delete a file",
                "3. You want to search a file",
                "4. You want to go back on previous menu",
        		};
        	int[] arr1 = {1,2,3,4};
        	int  slen = arr1.length;
        	for(int i=0; i<slen;i++){
        		System.out.println(arr[i]);
        	}
        
        	System.out.println("\nEnter your choice:\t");
        	int  options =  sc.nextInt();
            switch (options){
                case 1:
                    System.out.println("Enter the file name that name you want \n");
                    String fle_name = sc.next();
                                        
                    if(new File(ff,fle_name).exists()) {
                    	System.out.println("File already exists \n");
                    	}
                    else {
                    	File folder1 = new File(ff,fle_name);
                    	folder1.mkdir();
                    	if(new File(ff,fle_name).exists()) {
                    		System.out.println("Your file added successfully \n");
                    		}
                    	}
                    
                    break;
                case 2:
                    System.out.println("Enter filename that you want to delete \n");
                    String name = sc.next();
                    
                    if(new File(ff,name).exists()) {
                    	File folder2 = new File(ff,name);
                    	folder2.delete();
                    	System.out.println("Your file deleted successfully \n");
                    	}
                    else {
                    	System.out.println("File Not Found \n");
                    	}

                    break;
                case 3:
                    System.out.println("Enter filename that you want to search \n");
                    String search = sc.next();
                    
                    if(new File(ff,search).exists()) {
                    	//File folder3 = new File(ff,search);
                    	System.out.println("File exist");
                    	System.out.println("It's path is " + ff.getPath() + "\n");
                    }
                    else {
                    	System.out.println("File Not Found \n");
                    }
                    //optionsSelection();
                    break;
                case 4:
                	System.out.println("You want to go back on previous menu");
                	optionsSelection();
                    break;
                default:
                    System.out.println("You have made an invalid choice!");
                    break;
            			}
        			}
        	//break;
    
        case 3:
        	System.out.println("------------You exit Successfully--------------");
        	System.exit(0);
        	break;
        
        default:
        	System.out.println("You have made an invalid choice!");
        	break;
        
        	}
    		
    	}

	}


}
