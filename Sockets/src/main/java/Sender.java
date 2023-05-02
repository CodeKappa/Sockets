import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sender extends Thread
{
    Integer port = null;
    List<String> destinations = null;
    private List<ReentrantLock> locks;
    public Sender(Integer port, List<String> destinations)
    {
        this.port = port;
        this.destinations = destinations;
    }

    @Override
    public void run()
    {
        int size = destinations.size();
        locks = new ArrayList<>();
        for(int i = 0; i < size; i++)
        {
            locks.add(new ReentrantLock());
        }
        Random r = new Random();
        try
        {
            for(int i = 1; i <= 100; i++)
            {
                int destination = r.nextInt(size);
                locks.get(destination).lock();
                String message = destinations.get(destination) + " " + i;
                System.out.println("Sending message: " + message);

                Socket socket = new Socket(destinations.get(destination), port);
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
                writer.writeBytes(message + "\n");
                writer.flush();
                writer.close();
                socket.close();
                locks.get(destination).unlock();
                //sleep(10);
                //System.out.println();
            }

            Socket socket = new Socket(destinations.get(0), port);
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
            writer.writeBytes(destinations.get(size-1) + " " + -1 + "\n");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
