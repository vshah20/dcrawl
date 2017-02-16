package gui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client_UI {

	static String hostName;
	static int portNumber;
	PrintWriter out = null;
	BufferedReader in = null;
	Socket cliSocket = null;

	public Client_UI() {
		// TODO Auto-generated constructor stub
	}

	public void init(String hstName,int port)
	{
		try 		
		{
			hostName = hstName;
			portNumber = port;
			
			cliSocket = new Socket(hostName, portNumber);
		    out = new PrintWriter(cliSocket.getOutputStream(), true);
		    InputStreamReader is = new InputStreamReader(cliSocket.getInputStream());
		    in = new BufferedReader(is);
		    
		}
		catch (Exception  e){
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	public String Search(String query)
	{
		String ret = "No Responce from Server!";
		try{
		    String fromServer = "";
		    if((fromServer = in.readLine()) != null)
		    {
		    	if (fromServer.equals("Exit."))
		        {
		        	//close the socket and return
		        	cliSocket.close();
		        }
		    	if (fromServer.equals("Please Enter Query String:"))
		        {
		    		out.println(query);
		        }
		    	if(fromServer.equals("Enter valid Query:"))
		    	{
		    		return "Invalid Query!";
		    	}
		    	if((fromServer = in.readLine()) != null)
		    		return fromServer;
		    }
		}
		catch (Exception  e){
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		return ret;
	}
	public String NextList()
	{
		String ret = "No Responce from Server!!!";
		try{
		    String fromServer = "";
		    out.println("Yes");
		    if((fromServer = in.readLine()) != null)
		    {
		    	if (fromServer.equals("Exit."))
		        {
		        	//close the socket and return
		        	cliSocket.close();
		        	return "No more results found!";
		        }
		    	if (fromServer.equals("No more results found!"))
		        {
		        	//close the socket and return
		        	cliSocket.close();
		        	return fromServer;
		        }
		    	return fromServer;
		    }
		}
		catch (Exception  e){
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		return ret;
	}
}
