import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

class Client{
    public void run() throws UnknownHostException,IOException{
        int port=8010; //mention port on which it should connect
        InetAddress address=InetAddress.getByName("localhost");
        Socket socket=new Socket(address,port);

        //to write to server
        PrintWriter toSocket=new PrintWriter(socket.getOutputStream());

        //to read from server
        BufferedReader fromSocket=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        toSocket.println("Hello from Client");
        String response=fromSocket.readLine();
        System.out.println("Response from socket is "+response);

        toSocket.close();
        fromSocket.close();
        socket.close();
    }

    public static void main(String args[]){
        try{
            Client client=new Client();
            client.run();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}