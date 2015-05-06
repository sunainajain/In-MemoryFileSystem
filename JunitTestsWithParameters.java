import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
 


import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)

 public class JunitTestsWithParameters {
	 	private MemoryFileSystem MemoryFileSystem1;
	 	static	String operation;
		static	String folderpath;
		static	String filename;
		static	String filecontent;
		static	String targetfile;
		static	String filesearch;
		static String expectedresult;
	 
	 
	 
	 @Before
	public void initialize() {
	   MemoryFileSystem1 = new MemoryFileSystem();}

	 public JunitTestsWithParameters(String operation,String folderpath,String filename, String filecontent, 
			  String targetfile, String filesearch, String expectedresult)
	        {

		  		this.operation=operation;
		  		this.folderpath=folderpath;
	        	this.filename=filename;
	        	this.filecontent=filecontent;
	        	this.targetfile=targetfile;
	        	this.filesearch=filesearch;
	        	this.expectedresult=expectedresult;
	        }	
	        
	  
		
		@Parameterized.Parameters()
		
		
		
		
		public static Object Iterabledata() {
		        
					return Arrays.asList(new Object[][] { 
		        			        		
		 			{"CREATE_NEW_FOLDER","c:/users/owner/sunaina","","","","","success"},	
					{"WRITE_ON_FILE","c:/users/owner/sunaina","sunaina.txt","hello1","","","success"},	
		        	{"WRITE_ON_FILE","c:/users/owner/sunaina","sunaina","hello1","","","success"},	
		       		{"COPY_FILE & Display","c:/users/owner/sunaina","sunaina.txt","","jain.txt","","success"},	
		        	{"COPY_FILE & Display","c:/users/owner/sunaina","sunaina_1.txt","","jain.txt","","file not found"},	//Invalid Source File
		        	{"LIST_FOLDER_CONTENTS","c:/users/owner/sunaina","sunaina.txt","Test","jain.txt","","success"},	//Right Folder Name
		        	{"LIST_FOLDER_CONTENTS","c:/users/owner/sunina","sunaina.txt","Test","jain.txt","","folder not found"},	//Wrong Folder Name
		      		{"SEARCH_FILE","c:/users/owner/sunaina","","","","Wrong.txt","file not found"},	//Wrong File Name
		      		{"SEARCH_FILE","c:/users/owner/sunaina","","","","sunaina.txt","success"}	//Right File Name
		        	 });
		}
		
				
	  
	        
	@Test
	public   void testFileSystem() throws IOException
	{
		String result;
		MemoryFileSystem a =new MemoryFileSystem();
		result=a.init(operation,folderpath,filename,filecontent,targetfile,filesearch);
		assertEquals(result,expectedresult);
		
	
	}        
}
