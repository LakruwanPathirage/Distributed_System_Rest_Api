import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RMI_Client extends UnicastRemoteObject implements sensorListener {
	
	
	
	static ServerInt obj;
	
	public RMI_Client() throws Exception {
		super();
		System.setProperty("java.security.policy", "file:allowall.policy");
		this.obj=(ServerInt)Naming.lookup("server");
		obj.serverCheck();
		
		
		
		
	}
		
			public void add(String id,int floor,int roomNumber,int smokelevel,int co2level) {
				try {

					fireAlarm fm1=new fireAlarm(id, floor, roomNumber, smokelevel, co2level);
					
					ArrayList<fireAlarm> myResponse =obj.addItem(fm1);
					
					System.out.println(myResponse.get(0).id);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	public void read(String id) {
		try {
			
			ArrayList<fireAlarm> myResponse =obj.getItem(id);
			
			System.out.println(myResponse.get(0));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<fireAlarm> readAll() {
		ArrayList<fireAlarm> myResponse=null;
		try {
			
			myResponse =obj.getItems();
				//System.out.println(myResponse);
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		return myResponse;
	}
	
	public void update(fireAlarm item) {
		try {
			
			ArrayList<fireAlarm> myResponse =obj.updateItem(item);
			
			System.out.println(myResponse.get(0).id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delete(String id) {
		
		System.out.println(id);
		try {
		
			ArrayList<fireAlarm> myResponse =obj.deleteItem(id);
			
			System.out.println(myResponse.get(0).id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	@Override
	public ArrayList<fireAlarm> sensorStatusChanged() throws RemoteException {
		//System.out.println("inside sensor");
		ArrayList<fireAlarm> array = null;
		try {
			array=this.readAll();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		Frame1.updateArrayList(array);
		userDisplay.updateArrayList(array);
		return array;
	}
	public static void main(String[] args)throws Exception {
		
		
		
		
		RMI_Client client=new RMI_Client();
		
		obj.addSensorListener(client);
		
		login n1 = new login();
		n1.main(null);
		//obj.addSensorListener(client);
		 //check the server by uncommenting following
		/*
		 * ServerInt obj=(ServerInt)Naming.lookup("server"); obj.serverCheck();
		 * 
		 
		 * 
		 * obj.addSensorListener(cli);
		 */
		
		//cli.add();
		//cli.read();
		//client.readAll();
		//cli.update();
		//cli.delete();
		
		
		
	}



	

}


//import java.rmi.Naming;
//import java.rmi.Remote;
//import java.rmi.RemoteException;
//import java.rmi.server.UnicastRemoteObject;
//import java.util.ArrayList;
//
//import javax.swing.table.DefaultTableModel;
//
//import com.sun.tools.javac.util.Name.Table;
//
//public class rmi extends UnicastRemoteObject {
//
//	protected rmi() throws RemoteException {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public void add(String id,int floor,int roomNumber,int smokelevel,int co2level) {
//		try {
//			ServerInt obj=(ServerInt)Naming.lookup("ADD");
//			
//		
//			fireAlarm fm1=new fireAlarm(id, floor, roomNumber, smokelevel, co2level);
//			
//			ArrayList<fireAlarm> myResponse =obj.addItem(fm1);
//			
//			System.out.println(myResponse.get(0).id);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	public void read() {
//		try {
//			ServerInt obj=(ServerInt)Naming.lookup("ADD");
//			
//			//Id of the row that needs to be read
//			int id=100;
//			
//			ArrayList<fireAlarm> myResponse =obj.getItem(id);
//			
//			System.out.println(myResponse.get(0).id);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	public ArrayList<fireAlarm> readAll() {
//		ArrayList<fireAlarm> myResponse=null;
//		try {
//			ServerInt obj=(ServerInt)Naming.lookup("ADD");
//			
//			myResponse =obj.getItems();
//			
//			System.out.println(myResponse);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return myResponse;
//	}
//	
//	public void update(fireAlarm fa) {
//
//		try {
//			ServerInt obj=(ServerInt)Naming.lookup("ADD");
//			
//		
//			ArrayList<fireAlarm> myResponse =obj.updateItem(fa);
//			
//			System.out.println(myResponse.get(0).id);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	public void delete(int id) {
//		System.out.println(id);
//		try {
//			ServerInt obj=(ServerInt)Naming.lookup("ADD");
//			
//			ArrayList<fireAlarm> myResponse =obj.deleteItem(id);
//			
//			System.out.println(myResponse.get(0).id);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}	
//	}
//	
//	public static void main(String[] args)throws Exception {
//		
//		System.setProperty("java.security.policy", "file:allowall.policy");
//		
//		 //check the server by uncomenting following
//		//ServerInt obj=(ServerInt)Naming.lookup("ADD");
//		//obj.serverCheck();
//		
//		rmi cli=new rmi();
//		
//	
//		//cli.add(0, 0, 0, 0, 0);
//		//cli.read();
//		//cli.readAll();
//		//cli.update(0, 0, 0, 0, 0);
////		cli.delete();
//	}
//
//}
