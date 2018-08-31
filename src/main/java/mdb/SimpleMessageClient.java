//package MDB;
//
//import javax.annotation.Resource;
//import javax.jms.*;
//
//public class SimpleMessageClient {
//
//    @Resource(mappedName="jms/ConnectionFactory")
//    private static ConnectionFactory connectionFactory;
//
//    @Resource(mappedName="jms/Queue")
//    private static Queue queue;
//
//    public void sendMessages() {
//        try {
//            Connection connection = connectionFactory.createConnection();
//            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
//            MessageProducer producer = session.createProducer(queue);
//            TextMessage message = session.createTextMessage();
//            for (int i = 0; i < 5; i++) {
//                message.setText("This is message " + (i + 1));
//                System.out.println("Sending message: " + message.getText());
//                producer.send(message);
//            }
//            session.close();
//            connection.close();
//
//        } catch (JMSException ex) {
//            System.err.println("Sending message error");
//            ex.printStackTrace();
//
//        }
//    }
//
//}
