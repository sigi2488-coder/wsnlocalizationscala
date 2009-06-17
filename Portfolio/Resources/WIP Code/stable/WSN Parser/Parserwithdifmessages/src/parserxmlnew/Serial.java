/* Philippe Belet, graduate student Artesis, Applied Engineering: Electronics-ICT
 * ICT 7: WSN & DB
 * Project: TelosB WSN module
 */

package parserxmlnew;

import java.io.*;
import java.util.*;
import java.net.*;
import net.tinyos.message.*;

/**
 *
 * @author philippe
 */
public class Serial implements Runnable, MessageListener {
    private MoteIF gateway;
    private Socket requestSocket;
    private OutputStreamWriter wr;
    private int port;
    private String host;

    public Serial(MoteIF gateway) {
        this.gateway = gateway;
        //this.host = "192.168.1.100";
        this.host = connectiondetails.IP;
        //this.port = 3800;
        //this.port = Integer.getInteger(connectiondetails.Sendport);
        //this.port = Integer.parseInt(connectiondetails.Sendport);
        this.port = connectiondetails.Sendport;

    }
    
    public void run() {
        this.gateway.registerListener(new BN_CollMsg(), this);
        while (true) {}
    }
    
    private double convertTemperature(int temp) {
        //double ap = (((temp/4096*1.2) - 0.986)/0.00355)+273.15;
        double ap = 0.0098 * temp + 234.75;
        return ap;
    }
    
    private double convertHumidity(int hum) {
        double ap = -0.0000028*hum*hum + 0.0405*hum-4;
        return ap;
    }
    
    private double convertLight(int light) {
        //double ap = 0.625 * 1000000 * 1000 * (light/100000);
        return (double)light;
    }
    
    private int convertButton(byte but) {
        return (int)but;
    }
    
    private void createClient() throws UnknownHostException, IOException {
	System.out.println("Created socket on port " + connectiondetails.Sendport);
        this.requestSocket = new Socket(this.host, this.port);
        this.wr = new OutputStreamWriter(this.requestSocket.getOutputStream());
    }
    
    // when serial interface receives a message
    public void messageReceived(int dest_addr, Message message) {
        // if it's a datapacket
        if (message instanceof BN_CollMsg)
        {
            BN_CollMsg CollectedMsg = (BN_CollMsg)message;
            
            // generate timestamp
            Date date = new Date();
            
            // xmlstring
            String xmlString = "";
            String xmlString2 = "";
            String xmlString3 = "";
            
            System.out.println("received collection message");
            System.out.println("Mote id: " + CollectedMsg.get_moteid());
            System.out.println("Temperature: " + convertTemperature(CollectedMsg.get_tempreading()));
            System.out.println("Humidity: " + convertHumidity(CollectedMsg.get_humidityreading()));
            System.out.println("Light: " + convertLight(CollectedMsg.get_lightreading()));
            System.out.println("Button pressed: " + convertButton(CollectedMsg.get_button()));
            
            // detect corrupt measurements (with dummyvalue humidity is negative)
            if (convertHumidity(CollectedMsg.get_humidityreading()) < 0)
                System.out.println("corrupt message");
            // when not corrupt, forward
            else {
            
                // fill up xml1
                xml1 xmlParser1 = new xml1();
                xmlParser1.set_moteID(CollectedMsg.get_moteid());
                xmlParser1.set_temperature(convertTemperature(CollectedMsg.get_tempreading()));
                xmlParser1.set_humidity(convertHumidity(CollectedMsg.get_humidityreading()));
                xmlParser1.set_light(convertLight(CollectedMsg.get_lightreading()));
                xmlParser1.set_button(convertButton(CollectedMsg.get_button()));
                xmlParser1.set_date(date);
                xmlParser1.parse();
                xmlString = xmlParser1.get_message();

                // fill up xml2
                xml2 xmlParser2 = new xml2();
                xmlParser2.set_date(date);
                xmlParser2.parse();
                xmlString2 = xmlParser2.get_message();

                // fill up xml2
                xml3 xmlParser3 = new xml3();
                xmlParser3.set_date(date);
                xmlParser3.parse();
                xmlString3 = xmlParser3.get_message();

                // send to controller
                try {
                    createClient();
                    wr.write(xmlString);
                    wr.flush();
                    System.out.println("message 1 send to controller");
                    wr.write(xmlString2);
                    wr.flush();
                    System.out.println("message 2 send to controller");
                    wr.write(xmlString3);
                    wr.flush();
                    System.out.println("message 3 send to controller");
                } catch (IOException e) { e.printStackTrace(); }     
            }
        }
    }
}

