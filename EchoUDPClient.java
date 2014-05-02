import java.net.*;
public class EchoUDPClient {
	public static void main( String[] args ) {
		DatagramSocket	socket = null;
		DatagramPacket	sendPacket = null;
		byte	sendBuf[];
		DatagramPacket	receivePacket = null;
		byte	receiveBuf[] = new byte[256];
		try{
			sendBuf = "メッセージ送信テスト".getBytes();
			socket = new DatagramSocket();
			sendPacket = new DatagramPacket( sendBuf,
    		 sendBuf.length, InetAddress.getByName( "localhost" ), 9000 );
			socket.send( sendPacket );
			System.out.println( "\"" + new String( sendBuf ) + "\"を送信しました" );

			receivePacket = new DatagramPacket( receiveBuf, receiveBuf.length );
			socket.receive( receivePacket );
			String msg = new String( receivePacket.getData(), 0, receivePacket.getLength() );
			System.out.println( "Receive: " + msg );
			socket.close();
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
}
