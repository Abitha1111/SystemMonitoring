package examplesums;

//class Catt {
//	public static void main(String[] args) {
//}
//}


//		Will the compiler insert a default constructor in the following case?  
//		class A {
//			A(int x) {
//				System.out.print("A");
//			}
//		}
//		


//		

//class A{
//			A(int x){
//				System. out.println("Inside A");
//			}
//		}
//		public class JavaDemo {
//			public static void main(String[] args) {
//			A a=new A();
//			}
//		}
//		


//		

//class A{
//		     void A(int x){
//			  System.out.println("Inside A");
//			}
//		}
//		public class JavaDemo {
//			public static void main(String[] args) {
//			A a=new A();
//			}
//		}





//		class A{
//			A(){
//				A(5);
//				System.out.print("N");
//			}
//			A(int x){
//				System.out.print("P");
//			}
//		}
//
//		public class JavaDemo {
//			public static void main(String[] args) {
//			A a=new A();
//			}
//		}





//class A {
//	A(int x) {
//		System.out.print(x);
//		A();
//	}
//
//	void A() {
//		System.out.print("A");
//	}
//}
//
//class ConstructorDemo {
//	public static void main(String args[]) {
//		A a = new A(5);
//	}
//}





//class A{
//	A(int x){
//		System.out.print(x);	
//		this("A");
//	}
//	A(String s) {
//		System.out.print(s);
//		
//	}
//}
//class ConstructorDemo{
//	public static void main(String args[]) {
//		A a=new A(5);
//	}
//}





//class A{
//	A(int x){
//		System.out.print(x);	
//	}
//	public a() {
//		System.out.print("A");
//		
//	}
//}
//class ConstructorDemo{
//	public static void main(String args[]) {
//		A a=new A(5);
//	}
//}




//class A{
//	A(){
//		System. out.print("A");
//	}
//}
//class B extends A{
//	B() {
//		System.out.print("B");
//	}
//}
//public class JavaDemo {
//	public static void main(String[] args) {
//	B b=new B();
//	}
//}




//class A{
//	A(int x){
//		System.out.print("A");
//	}
//}
//class B extends A{
//	B() {
//		System.out.print("B");
//	}
//}
//public class JavaDemo {
//	public static void main(String[] args) {
//	B b=new B();
//	}
//}






//class Animal {
//	public Animal(int y) {
//		System.out.print("Animal");
//	}
//}
//public class Cat extends Animal {
//	public Cat() {
//		System.out.print("Cat");
//	}
//	public static void main(String[] args) {
//		new Animal(3);
//	}
//}
//
//


//interface CanJump{ }
//
//public class Cat implements CanJump {
//	public static void main(String[] args) {
//		________ cat=new PersianCat();
//	}
//}
//	class PersianCat extends Cat{ }
//	class BengalCat extends Cat{ }




//public class Cat {
//	private void drink() {
//		System.out.println("Cat is drinking");
//	}
//	public static void main(String[] args) {
//		Cat pcat=new PersianCat();
//		pcat.drink();
//	}
//}
//class PersianCat extends Cat{ 
//     void drink() {
//		System.out.println("Persian Cat is drinking");	
//	}
//}





//public class Cat {
//	private void drink() {
//		System.out.println("Cat is drinking");
//	}
//	
//}
//class PersianCat extends Cat{ 
//     void drink() {
//		System.out.println("Persian Cat is drinking");	
//	}
//public static void main(String[] args) {
//		Cat pcat=new PersianCat();
//		pcat.drink();
//	}
//}






//public class Cat {
//	public int a=5;
//	public static void main(String[] args) {
//		PersianCat pcat=new PersianCat();
//               pcat.drink();
//	}
//}
//class PersianCat extends Cat{ 
//    void drink() {
//    	int a;
//		System.out.print(a);	
//	}
//}




//public class Cat {
//	public int a=5;
//	public static void main(String[] args) {
//		PersianCat pcat=new PersianCat();
//                pcat.drink();
//	}
//}
//class PersianCat extends Cat{ 
//	int a=3;
//    void drink() {
//		System.out.print(a);	
//	}
//}




//
//public class Cat {
//	 void drink(double d) {
//		System.out.print("Cat");
//	}
//	public static void main(String[] args) {
//		PersianCat pcat=new PersianCat();
//		pcat.drink(12);
//		pcat.drink(12.0);
//	}
//}
//class PersianCat extends Cat{ 
//    void drink(int i) {
//		System.out.print("PersianCat");	
//	}
//}




//public class Cat {
//	protected  static Number drink() throws Exception{
//		System.out.println("Cat is drinking");
//		return 10;
//	}
//	public static void main(String[] args) throws Exception {
//		Cat pcat=new PersianCat();
//		pcat.drink();
//	}
//}
//class PersianCat extends Cat{ 
//	public static Integer drink() throws RuntimeException{
//		System.out.println("Persian Cat is drinking");
//		return 25;
//	}
//}





//public class Cat {
//	 void drink(double d) {
//		System.out.print("Cat");
//	}
//	public static void main(String[] args) {
//		PersianCat pcat=new PersianCat();
//		pcat.drink(12);
//		pcat.drink(12.0);
//	}
//}
//class PersianCat extends Cat{ 
//    void drink(int i) {
//		System.out.print("PersianCat");	
//	}
//}
//



//public class MethodOverloadDemo {
//	void add(int a,Object b)
//	{System.out.println("Object");}
//	
//	void add(Object a,double b)
//	{ System.out.println("Double");}
//	
//   public static void main(String[] args) {
//	   MethodOverloadDemo a=new MethodOverloadDemo();
//	   a.add(12,3.5);
//	}
//}




//public class MethodOverloadDemo {
//	protected void add(int a)
//	{System.out.println("Integer");}
//	
//	private void add(double b)
//	{ System.out.println("Double");}
//	
//	protected void add(Object o)
//	{ System.out.println("Object");}
//	
//	public static void main(String[] args) {
//		MethodOverloadDemo m=new MethodOverloadDemo();
//		m.add(7.5);
//	}
//}



//public class MethodOverloadDemo {
//	int  display(float a)
//	{return a;}
//	
//	double display(double b)
//	{ return b;}
//	
//	float display(int c)
//	{ return c;}
//	
//	public static void main(String[] args) {
//		MethodOverloadDemo m=new MethodOverloadDemo();
//		m.display(72);
//	}
//}





import java.io.FileNotFoundException;
class ValueException extends Exception{}
public class MethodOverloadDemo {
	protected void eat(int a) throws ArithmeticException
	{System.out.println("Throws runtime exception");}
	
	private void eat(double b) throws ValueException
	{ System.out.println("Throws new checked exception");}
	
	protected void eat(Object o) throws FileNotFoundException
	{ System.out.println("Throws new non runtime exception");}
	
	public void eat(float o) throws Exception
	{ System.out.println("Throws a broader exception");}
	
	public static void main(String[] args) throws Exception {
		MethodOverloadDemo m=new MethodOverloadDemo();
		m.eat(7.5);
	}
}
