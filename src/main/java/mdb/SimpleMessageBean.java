//package MDB;
//
//import javax.ejb.ActivationConfigProperty;
//import javax.ejb.MessageDriven;
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.MessageListener;
//import javax.jms.TextMessage;
//
//@MessageDriven(mappedName="jms/Queue", activationConfig =  {
//        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
//        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")})
//public class SimpleMessageBean implements MessageListener {
//
//    @Override
//    public void onMessage(Message msg) {
//        try {
//            TextMessage message = (TextMessage) msg;
//            System.out.println("FROM MDB - " + message.getText());
//        } catch (JMSException ex) {
//            ex.printStackTrace();
//        }
//    }
//}
