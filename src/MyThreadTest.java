
public class MyThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread t1 = new MyThread();
//		t1.start();
		t1.run();//û�������̣߳�ֻ�ǵ����˷���
		for(int i =0 ;i<100;i++)
		{
			System.out.println(Thread.currentThread().getName()+":"+i);
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
