
public class MyThread2Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread th1 = new MyThread();
		MyThread2 r = new MyThread2();
		Thread th2 = new Thread(r);
		th1.start();
		th2.start();
		
		

	}

}
