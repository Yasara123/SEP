/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic;

/**
 *
 * @author Nandula
 */
import java.io.IOException;
import org.smslib.GatewayException;
import org.smslib.OutboundMessage;
import org.smslib.SMSLibException;
import org.smslib.Service;
import org.smslib.TimeoutException;
import org.smslib.modem.SerialModemGateway;

public class SMS {
    
    public static void sendMessage(String number, String message) throws GatewayException, SMSLibException, TimeoutException, IOException, InterruptedException {
        SerialModemGateway gateway = new SerialModemGateway("modem.com3", "COM11", 9600, "", "");
        gateway.setInbound(true);
        gateway.setOutbound(true);
        Service.getInstance().addGateway(gateway);
        Service.getInstance().startService();
        OutboundMessage msg = new OutboundMessage(number, message);
        Service.getInstance().sendMessage(msg);
        Service.getInstance().stopService();
    }
}
