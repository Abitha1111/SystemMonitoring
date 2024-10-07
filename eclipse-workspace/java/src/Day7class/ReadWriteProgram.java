package Day7class;

import java.util.HashSet;

//public class examples {
//	public static void main(String[] args) {



//import java.util.Scanner;
//
//public class ArmstrongNumber {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter a number: ");
//        int number = scanner.nextInt();
//
//        if (isArmstrong(number)) {
//            System.out.println(number + " is an Armstrong number.");
//        } else {
//            System.out.println(number + " is not an Armstrong number.");
//        }
//
//        scanner.close();
//    }
//
//    // Function to check if a number is an Armstrong number
//    public static boolean isArmstrong(int num) {
//        int originalNumber, remainder, result = 0, n = 0;
//
//        originalNumber = num;
//
//        // Count number of digits
//        for (originalNumber = num; originalNumber != 0; originalNumber /= 10, ++n);
//
//        originalNumber = num;
//
//        // Calculate sum of nth power of individual digits
//        while (originalNumber != 0) {
//            remainder = originalNumber % 10;
//            result += Math.pow(remainder, n);
//            originalNumber /= 10;
//        }
//
//        // Check if number is equal to the sum of nth power of its digits
//        return result == num;
//    }
//}





//import java.util.Scanner;
//
//public class ReverseFibonacci {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        
//        System.out.print("Enter the value of n: ");
//        int n = scanner.nextInt();
//        
//        if (n <= 0) {
//            System.out.println("Please enter a positive integer greater than zero.");
//        } else {
//            int[] fibonacci = new int[n];
//            fibonacci[0] = 0;
//            fibonacci[1] = 1;
//            
//            // Generating Fibonacci series
//            for (int i = 2; i < n; i++) {
//                fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
//            }
//            
//            // Displaying the reverse Fibonacci series
//            System.out.println("Reverse Fibonacci series up to " + n + ":");
//            for (int i = n - 1; i >= 0; i--) {
//                System.out.print(fibonacci[i] + " ");
//            }
//        }
//        scanner.close();
//    }
//}




//		boolean b=true;
//		int r=15,i=10;
//		do {
//		      i--;
//		      if(i==8) b=false;
//			r-=2;
//		    }while(b);
//		System.out.println(r);

//	}
//}
//		int m=9,n=1,x=0;
//		while(m>n) {
//				m--;
//				n+=2;
//				x+=m+n;
//		}
//		System.out.println(x);

//		int s=0;
//		for(int i=1;i<=2;i++)
//		   for(int j=1;j<=2;j++)
//			s+=i+j;
//		System.out.println(s);	
//		

//		int s=0;
//		for(int i=1;i<=2;i++)
//		  for(int j=1;j<=2;j++)
//		     {
//			if(i==j)
//			   continue;
//			s+=i+j;
//		     }
//		System.out.println(s);

//		int s=0;
//		for(int i=1;i<=2;i++)
//			for(int j=1;j<=2;j++)
//			{
//				if(i==j)
//					break;
//				s+=i+j;
//			}
//		System.out.println(s);

//		int s=0;
//		 outer: for(int i=1;i<=2;i++)
//		 inner: for(int j=1;j<=2;j++)
//					{
//						if(i==j)
//						   break outer;
//						s+=i+j;
//					}
//		System.out.println(s);

//		int s=0;
//		outer: for(int i=1;i<=2;i++)
//		 inner: for(int j=1;j<=2;j++)
//					{
//						if(i==j)
//							break inner;
//						s+=i+j;
//					}
//				System.out.println(s);

//		
//		int s=0;
//		for(int i=0;i<10;i++)
//		{
//			if(i%2==0)
//				continue;
//				s+=i;
//		}
//			System.out.println(s);

//		
//		int i=0;
//		while(i++<10)
//			if(i==5)
//				break;
//		System.out.println(i);

//		int count=0;
//		l1: for(int r=1;r<=3;r++)
//			 for(int c=1;c<=2;c++) {
//				 if(r*c%2==0) continue l1;
//		         count++;
//			 }
//		System.out.println(count);

//		int x=1,i;
//		out:
//		for(i=0;i<10;i++)
//		{
//		   while(x++<50)
//		     if(i*x==400)
//			break out;
//		}
//		System.out.println(i + x);
//	}
//}

//class First {
//	 int a;
//	public static void main(String[] args) {
//		
//		System.out.println(a);	
//		}
//		}

//		class First {
//			 int a;
//			public static void main(String[] args) {
//				First f;
//				System.out.println(f.a);	
//			}
//		}	

//	int i;float fl;double d;long l;char c; boolean b;examples ft; 
//public static void main(String[] args) {
//	examples f=new examples();
// System.out.println(f.i +""+f.fl+ ""+f.d+""+f.l+""+f.c+""+f.b+""+f.ft );	
//	}
//}

//class First {
//	int a;
//	public static void main(String[] args) {
//		int a=2;
//		System.out.println(a);	
//	}
//}

//class First {
//	int a;
//	public static void main(String[] args) {
//		int a;
//		First f=new First();
//		System.out.println(f.a);	
//	}
//}
//

//class First {
//	public static void main(String[] args) {
//		int a;
//		First f=new First();
//		a=3;
//		f.go();
//		System.out.print(a);	
//	}
//	void go() {
//		int x=a;
//		System.out.print(x);	
//	}
//}
//

//class First {
//	int a;
//	public static void main(String[] args) {
//		int a;
//		First f=new First();
//		a=3;
//		f.go();
//		System.out.print(a);	
//	}
//	void go() {
//		int x=a;
//		System.out.print(x);	

//class First {
//	System.out.println("12" + 23);

//int value=null;
//System.out.println(value);

//		abstract class Tiger{
//			String eat() {
//			     return "eat";
//			}
//		}
//		public class InterfaceDemo extends Tiger {
//			public static void main(String[] args) {
//		          new Tiger().eat();
//			}
//		}

//abstract class Tiger{
//	String eat() {
//	     return "eat";
//	}
//}
//public class InterfaceDemo extends Tiger {
//	public static void main(String[] args) {
//          new InterfaceDemo().eat();
//	}
//}

//interface Tigerable{
//	protected void eat();
//}
//public class Cub implements Tigerable  {
//	public void eat() {
//		System.out.println("eat");
//	}
//	public static void main(String[] args) {
//		Tigerable t = new Cub();
//		t.eat();
//	}
//}

//interface Tigerable{
//	final default void eat() {
//		System.out.println("eating");
//	}
//}
//public class Cub implements Tigerable  {
//	public void eat() {
//		System.out.println("eat");
//	}
//	public static void main(String[] args) {
//		Tigerable t = new Cub();
//		t.eat();
//	}
//}

//interface Tigerable{
//	default void eat() {
//		System.out.println("eating");
//	}
//}
//public class Cub implements Tigerable  {
//	public void eat() {
//		System.out.println("eat");
//	}
//	public static void main(String[] args) {
//		Tigerable t = new Cub();
//		t.eat();
//	}
//}

//interface Tigerable{
//	int x=5;
//}
//public class Cub implements Tigerable  {
//	void display()
//	{
//		x=3;
//		System.out.println(x);
//	}
//	public static void main(String[] args) {
//		Cub c=new Cub();
//		c.display();
//	}
//}

//interface Tigerable{
//	int x=5;
//}
//public class Cub implements Tigerable  {
//	int x;
//	void display()
//	{
//		x=3;
//		System.out.println(x);
//	}
//	public static void main(String[] args) {
//		Cub c=new Cub();
//		c.display();
//	}
//}

//interface Tigerable{
//	int x=5;
//}
//public class Cub implements Tigerable  {
//	int x;
//	void display()
//	{
//		x=3;
//		System.out.println(x+super.x);
//	}
//	public static void main(String[] args) {
//		Cub c=new Cub();
//		c.display();
//	}
//}

//int[] a;
//a[0]=3;
//System.out.println(a[0]);

//		
//		int[] a=new int[3];
//		 for (int x: a)
//		  System.out.println(x);

//		int[] n=new int[] {1,2,3,4,5};
//		System.out.println(n.length);

//		
//		int[] n=new int[5] {1,2,3,4,5};
//		System.out.println(n.length);
//		

//		int[] n=new int[5] ;
//		n[2]=3;
//		System.out.println(n[4]);

//		int[] n=new int[] {1,2,3,4,5} ;
//		int total=0;
//		for (int i=0;i<=n.length;i++)
//		   total=total+n[i];
//System.out.println(total);

//		public class ArrayDemo {
//			static int takeArray(int[] a) {
//				int total=0;
//				for(int x:a)
//					total+=x;
//				return total;
//			}
//			public static void main(String[] args) {
//				System.out.println(takeArray(new int[3] {10,20,30}));

//int j[][]=new int[4][];
//j[0]=new int[]{0,1,3};
//j[1]=new int[]{6,4};
//j[2]=new int[]{1,7,6,8,9};
//j[3]=new int[]{5};
//System.out.println(j[2][2]==j[1][0]);	

//		
//		int arr[]= {10,20,30};
//		int cloneArr[]=arr.clone();
//		System.out.print(arr==cloneArr);
//		arr[1]=200;
//		System.out.print(arr[1]==cloneArr[1]);
//

//		
//		int arr[][]= {{1,2,3,4},{5,6}};
//		int cloneArr[][]=arr.clone();
//		System.out.print(arr[1]==cloneArr[1]);
//		arr[1][1]=200;
//		System.out.print(arr[1][1]==cloneArr[1][1]);

//		public class examples {
//			float a;
//			public static void main(String[] args) {
//			   System.out.println("a=" + a);

//public class examples {
//	static int objCount;
//	examples()
//	{
//		objCount+=1;
//	}
//	public static void main(String[] args) {
//		new examples();
//		new examples();
//		new examples();
//		System.out.println("Number of objects=" + objCount);
//		

//		public class examples {
//			int objCount;
//			examples()
//			{
//				objCount+=1;
//			}
//			public static void main(String[] args) {
//				new examples();
//				new examples();
//				new examples();
//				System.out.println("Number of objects=" + objCount);

//class Tiger{
//	static void eat() {
//		System.out.println("Tiger eats!");
//	}
//}
//public class examples extends Tiger {
//	static void eat() {
//		System.out.println("Cub eats!");
//	}
//	public static void main(String[] args) {
//		Tiger t=new examples();
//                t.eat();

//class Tiger{
//	String eat() {
//		static String food="boar ";
//		return food;
//	}
//}
//public class examples extends Tiger {
//	public static void main(String[] args) {
//        new Tiger().eat();
//	System.out.println(new Tiger(). eat());

//final class Tiger {
//	String eat() {
//		return "eat";
//	}
//}
//
//public class Cub extends Tiger {
//	public static void main(String[] args) {
//		System.out.println(new Tiger().eat());

//abstract final class Tiger{
//	String eat() {
//	     return "eat";
//	}
//}
//public class examples extends Tiger {
//	public static void main(String[] args) {
//          Tiger t;
//	}
//}

//interface Tigerable{
//	protected void eat();
//}
//public class examples implements Tigerable  {
//	public void eat() {
//		System.out.println("eat");
//	}
//	public static void main(String[] args) {
//		Tigerable t = new examples();
//		t.eat();

//interface Tigerable{
//	final default void eat() {
//		System.out.println("eating");
//	}
//}
//public class examples implements Tigerable  {
//	public void eat() {
//		System.out.println("eat");
//	}
//	public static void main(String[] args) {
//		Tigerable t = new examples();
//		t.eat();
//	}
//}

//int  f(int n) {
//    if (n==1)
//        return 1;
//    else
//         {
//          System.out.print(n + "");
//          return f(n-1);
//         }

//		
//		public class RecursionDemo {
//			public static void main(String[] args) {
//				RecursionDemo r=new RecursionDemo();
//				System.out.println(r.f(3));
//			}
//			
//			int  f(int n) {
//			    if (n==1)
//			        return 1;
//			    else
//			          return 2+ f(n-1);
//			    }

//		int f(int n) 
//		{ 
//			if(n==1)
//				return 1;
//			else
//				return 1+f(n-1);
//		}
//		}

//
//		public class examples {
//			int f(int n) 
//			{ 
//				if(n==1)
//					return 1;
//				else
//					return n+f(n-1);
//			}
//				public static void main(String[]args) {
//		       examples s=new examples();
//		       System.out.println(s.f(4));
//				}
//		}


//HashSet<Integer> h= new HashSet<>();
//h.add(12);
//h.add(23);
//h.add(12);
//System.out.println(h.size());
		
		
		
		
//		
//		class MyThread extends Thread
//		{
//		public void run() {
//				System.out.println(Thread.currentThread().getName());
//			} 
//		}
//		public class ThreadDemo {
//			public static void main(String[] args) {
//				MyThread t1=new MyThread();
//				t1.start();
//			}
//		}
//	



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



//class MyThread extends Thread
//{
//	public void run() {
//		System.out.println(Thread.currentThread().getName());
//	}
//}
//public class ThreadDemo {
//	public static void main(String[] args) {
//		MyThread t1=new MyThread();
//		t1.setName("First");
//		t1.start();
//		t1.start();		
//	}
//}





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
//		MyThread t2=new MyThread();
//		t2.setName("Second");
//		t1.run();
//		t2.run();
//	}
//}




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










//class MyThread implements Runnable
//{
//	int x;
//	public void run() {
//		System.out.println(++x);
//	}
//}
//public class ThreadDemo {
//	public static void main(String[] args) {
//		MyThread t=new MyThread();
//		Thread t1=new Thread(t);
//		t1.start();
//		Thread t2=new Thread(t);
//		t2.start();
//		Thread t3=new Thread(t);
//		t3.start();
//		thread.
//	}
//}











//class MyThread implements Runnable
//{
//	public void run() {
//		System.out.println(Thread.currentThread().getPriority());
//	}
//}
//public class ThreadDemo {
//	public static void main(String[] args) {
//		MyThread t=new MyThread();
//		Thread t1=new Thread(t);
//		t1.start();
//	}
//}






//class SharedResource{
//	private int x;
//	public int useResource() {
//		x=x+1;
//		return x;
//	}
//}
//class NewThread extends Thread{
//	SharedResource sr;
//	NewThread(SharedResource sr){
//		this.sr=sr;
//	}
//	public void run() {
//		   System.out.print( Thread.currentThread().getName()+sr.useResource());
//		   try {
//		   Thread.sleep(1000);
//		   }catch(InterruptedException ie) {
//			   System.out.println("Interrupted Exception");
//		   }
//	}
//}
//public class SynchronizationDemo {
//	public static void main(String[] args) {
//		SharedResource s=new SharedResource();
//		NewThread t1=new NewThread(s);
//		NewThread t2=new NewThread(s);
//		t1.setName("First");
//		t1.start();
//		t2.setName("Second");
//		t2.start();
//	}
//}




import java.util.Scanner;

public class ReadWriteProgram {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the keyboard
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter some input
        System.out.print("Enter something: ");

        // Read input from the keyboard
        String userInput = scanner.nextLine();

        // Close the scanner to avoid resource leaks
        scanner.close();

        // Display the input on the monitor (console)
        System.out.println("You entered: " + userInput);
    }
}







