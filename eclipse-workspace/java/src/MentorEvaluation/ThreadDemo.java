package MentorEvaluation;

//class MyThread extends Thread
//{
//	public void run() {
//		System.out.print(Thread.currentThread().getName());
//	}
//}
//public class ThreadDemo {
//	public static void main(String[] args) {
//		MyThread t1=new MyThread();
//		t1.setName("First");
//		t1.start();
//		MyThread t2=new MyThread();
//		t2.setName("Second");
//		t2.start();
//	}
//}



public class ThreadDemo{
	public static void main(String[]args) {
		ChildThread c=new ChildThread();
		c.run();
		
	}
}