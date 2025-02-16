package no.hvl.dat110.messaging;

import java.util.Arrays;

public class MessageUtils {

    public static final int SEGMENTSIZE = 128;

    public static int MESSAGINGPORT = 8080;
    public static String MESSAGINGHOST = "localhost";

    public static byte[] encapsulate(Message message) {
        // Retrieve payload fra medlding
        byte[] data = message.getData();

        //  lage segment av fixa size
        byte[] segment = new byte[SEGMENTSIZE];

        
        segment[0] = (byte) data.length;

        // kopiere paload til posisjon 1
        System.arraycopy(data, 0, segment, 1, data.length);

       
        return segment;
    }

    public static Message decapsulate(byte[] segment) {
        //  lese første byte for å finne lengde
        int length = segment[0];

        //  lage ny array for payload data basert på lengden
        byte[] data = new byte[length];

        // kopiere
        System.arraycopy(segment, 1, data, 0, length);

        //  returne ny melding
        return new Message(data);
    }
}
