import java.net.*;
public class EchoUDPServer {
	public static void main( String[] args ) {
		DatagramSocket	socket = null;
		DatagramPacket	sendPacket = null;
		byte	sendBuf[];
		DatagramPacket	receivePacket = null;
		byte	receiveBuf[] = new byte[256];
		try{
			socket = new DatagramSocket( 9000 );
			receivePacket = new DatagramPacket( receiveBuf, receiveBuf.length );

			socket.receive( receivePacket );
			InetAddress addr = receivePacket.getAddress();
			int port = receivePacket.getPort();
			System.out.println( "IPアドレス:" + addr );
    			System.out.println( "Port番号:" + port );
			String msg = new String( receivePacket.getData(), 0, receivePacket.getLength() );
			System.out.println( "Receive: " + msg );

			sendBuf = msg.getBytes();
			sendPacket = new DatagramPacket( sendBuf, sendBuf.length, addr, port );
			socket.send( sendPacket );
		}catch( Exception e ) {
			e.printStackTrace();
		}
	}
}
