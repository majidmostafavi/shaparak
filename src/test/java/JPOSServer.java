

import org.jpos.iso.*;
import org.jpos.iso.channel.ASCIIChannel;
import org.jpos.iso.packager.ISO87APackager;
import org.jpos.util.LogSource;
import org.jpos.util.Logger;
import org.jpos.util.SimpleLogListener;
import java.io.IOException;

public class JPOSServer implements ISORequestListener {

    public static void main(String[] args){
        Logger logger = new Logger();
        logger.addListener(new SimpleLogListener(System.out));
        ServerChannel sChannel = new ASCIIChannel("localhost",2300,new ISO87APackager());
        ((LogSource)sChannel).setLogger(logger,"server-channel-logger");
        ISOServer isoServer = new ISOServer(2300,sChannel,null);
        isoServer.setLogger(logger,"server-logger");
        //Asign ISOListener Process
        isoServer.addISORequestListener(new JPOSServer());
        new Thread(isoServer).start();


    }

    @Override
    public boolean process(ISOSource isoSource, ISOMsg isoMsg) {

        ISOMsg m = (ISOMsg) isoMsg.clone();
        try {
            m.setMTI("0801");
            m.set(999,"INCOMING FROM SERVER");
            isoSource.send(m);
        } catch (ISOException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
