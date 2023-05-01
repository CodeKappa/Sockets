import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Destination extends Thread
{
    String address = null;
    Integer source = null;
    String destination = null;
    Integer destinationPort = null;

    public Destination(String address, Integer source, String destination, Integer destinationPort)
    {
        this.address = address;
        this.source = source;
        this.destination = destination;
        this.destinationPort = destinationPort;
    }

    @Override
    public void run()
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(source);
            System.out.println("Relay node started on port " + source);

            while (true)
            {
                Socket clientSocket = serverSocket.accept();

                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String message = reader.readLine();
                String target = message.split(" ")[0];
                Integer value = Integer.parseInt(message.split(" ")[1]);

                if (address.equals(target) && value != -1)
                {
                    System.out.println(address + ": Received value: " + value);
                }
                else if(destination != null)
                {
                    Socket destinationSocket = new Socket(destination, destinationPort);
                    DataOutputStream destinationWriter = new DataOutputStream(destinationSocket.getOutputStream());
                    destinationWriter.writeBytes(message + "\n");
                    destinationWriter.flush();
                    destinationWriter.close();
                    destinationSocket.close();
                }

                reader.close();
                clientSocket.close();
                if(value == -1) break;
            }

            serverSocket.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
