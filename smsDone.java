

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class smsDone
{
public static String retval="";
    
    
    static String bceSunSoftSend(String uid,String pwd,String mobileno,String msg,String sender)
    {
    	//String message="hai WelCome &&&&&&&";
    	//message.replaceAll("&","%26");
    	//sample107,sample@107
    	String url="http://smsc11.com/corp/extendingsms1.jsp?uname="+uid+"&pass="+pwd+"&mobile="+mobileno+"&msg="+msg+"&sender="+sender;
        return exeUrl(url);
    }
    static public String exeUrl(String urloc)
    {
      String finalstr="";
      try
         {
       urloc=urloc.replace("%","%25");  
        urloc=urloc.replace(" ","%20");
        //urloc=urloc.replace(":","%3a");
        urloc=urloc.replace("!","%21");
        urloc=urloc.replace("@","%40");
        urloc=urloc.replace("#","%32");
        urloc=urloc.replace("$","%24");   
    
         URL yahoo = new URL(urloc);
              URLConnection yc = yahoo.openConnection();
              BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
              String inputLine;
              while ((inputLine = in.readLine()) != null) 
              {
               finalstr=finalstr+inputLine;
              }
              System.out.println(finalstr);
              in.close();
       }
       catch (Exception e)
       {
         System.out.println(e.toString());
       }
          return finalstr;
    }
    public static void main(String[] args)
    {        
        //response = SMSSender("forbcestudents", "forbcestudents", "919872246056", "WebSMS", "BCE BTI", "1");        
        //System.out.println(response);
    	bceSunSoftSend("sunsoft123","sunsoft123","9815378734","Verifying d form","SUNSFT");
    }
}
