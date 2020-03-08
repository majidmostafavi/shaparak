package jpos.service;

import core.dao.TransactionDao;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.jpos.iso.FilteredChannel;
import org.jpos.iso.ISOChannel;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.channel.ASCIIChannel;
import org.jpos.iso.packager.ISO87APackager;
import org.jpos.util.LogSource;
import org.jpos.util.Logger;
import org.jpos.util.SimpleLogListener;
import java.io.IOException;

@Stateless
public class JposService {
    @EJB
    TransactionDao transactionDao;

    public void clien () {
        Logger logger = new Logger();
        logger.addListener(new SimpleLogListener(System.out));
        ISOChannel channel = new ASCIIChannel("localhost",2300,new ISO87APackager());
        ((LogSource) channel).setLogger(logger, "client-logger");
        try {
            channel.connect();
            ISOMsg m = new ISOMsg ();
            m.setMTI ("0800");
            m.set (3, "000000");
            m.set (41, "00000001");
            m.set (70, "301");
            channel.send(m);
            //Get incoming message
            ISOMsg incoming = channel.receive();
            System.out.println(incoming.pack());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ISOException e) {
            e.printStackTrace();
        }
    }
}
