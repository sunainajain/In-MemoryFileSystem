import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;


public class MemoryFileSystem {

static String error;
	
/*Method Name: init
Description: performs create folder, create file, copy file, display contents from file, search file by name,list folder contents, 
 Parameters: Operation-> type of activity to be performed
	            folderpath-> path of folder
				filename-> name of file
				filecontent-> content to be written to file
				targetfile-> destination file to be copied
				filesearch->filename to be searched*/
	public String init(String operation, String folderpath, String filename, String filecontent, String targetfile, String filesearch) throws IOException 
	{
		
	try
	{
		//Creating the new folder
			
		File f = new File(folderpath);
		int found=0;
	
	if(operation=="CREATE_NEW_FOLDER")
	{
	if(!f.exists())
	{error="success";
	f.mkdirs();	}
	else
		{error="folder already exists";
	}
	}
		
	 //Create a new file    
    if (operation=="WRITE_ON_FILE")
	 {
    	 File file = new File(folderpath+ "/"+filename);
    	   
    	   if (!file.exists())  
    	   file.createNewFile();    
    	   
    	    
    		
    		// Add content to file
    		
    		 FileWriter fw = new FileWriter(file.getAbsoluteFile());
    		
     BufferedWriter bw = new BufferedWriter(fw);
     bw.write(filecontent);
     bw.close();
	 }
     
	 //COPY the file and display contents	 
	 if (operation=="COPY_FILE & Display")
	 {
		// System.out.println("in copy file");
		 File file = new File(folderpath+ "/"+filename);
  	   
  	   if (!file.exists())
  		   {error="file not found";
			}
  	   else
  	 error="success";
 
		 FileReader fr = new FileReader(folderpath+ "/"+filename);
	     BufferedReader br = new BufferedReader(fr);
	    // System.out.println("in copy file_1");
	     LinkedList<String> ll = new LinkedList<String>();
	     String sline;
	     while((sline=br.readLine())!=null)
	     {
	//    	 System.out.println("in copy file_2");
	       ll.add(sline);
	     System.out.println("Contents of the file: "+ ll.getFirst());
	     }
	     FileOutputStream fout = new FileOutputStream(folderpath+ "/"+targetfile);
	     BufferedWriter brout = new BufferedWriter(new OutputStreamWriter(fout));
	     int i;
	     int len = ll.size();
	     for(i=0;i<=len-1;i++){
	    	 
	    //	 System.out.println(ll.get(i));
	         
	         brout.write(ll.get(i));
	         brout.newLine();
	       
	     }
	     brout.close();
	    br.close();}
	 if (operation=="LIST_FOLDER_CONTENTS")
	 {
			File f1 = new File(folderpath);
			if (!f1.exists())
		  		   error="folder not found";
			else error="success";
		 File[] files = f1.listFiles();
		 System.out.println("The List Of Files are following:");
	        for (File file : files) {
	            if (file.isDirectory()) {
	                System.out.print("It is directory");
	            } else {
	                System.out.print("     file:");
	            }
	            System.out.println(file.getCanonicalPath());
	        }
	 }
	 
	 
	
	
	//SEARCH FILE CODE
	if (operation=="SEARCH_FILE")
	{
		String[] fileNames = f.list();
		if (fileNames == null)
		{
	         System.out.println("does not exist or is not a directory");
	    }
		else
		{
			 
			for (int i = 0; i < fileNames.length; i++) {
	            String fileName = fileNames[i];
	            
	           
	            if (fileName.equals(filesearch))
	            {
	            	found=1;
	            	
	            //	System.out.println(filename);
	            }
	            
	            	
	    }
			if (found==1){
				System.out.println(filesearch +" Is Found");
			System.out.println("The file is found in " +folderpath);
			error="success";
			}
			else
				error="file not found";
		}
	}
		
	
	
	 
	}catch(Exception e){
		//System.out.println("exception");
	}
	return error;
	}
	
	
	
	
	
	
	
	
	
	
	/*public static void main(String args[]) 
	{
		//System.out.println("hello");
		
		//Call to write on the file
		try
		{
		abc a1=new abc();
		//a1.init("WRITE_ON_FILE","c:/users/owner/sunaina","sunaina.txt","hello1");
		//a1.init("COPY_FILE","c:/users/owner/sunaina","sunaina.txt","Test","jain.txt");
		//a1.init("LIST_FOLDER_CONTENTS","c:/users/owner/sunaina","sunaina.txt","Test","jain.txt");
		a1.init("SEARCH_FILE","c:/users/owner/sunaina","","","","jain.txt");
	}
		catch(Exception e)
		{e.printStackTrace();}
		
		
		
		//Call to Copy the file
}*/
	
}