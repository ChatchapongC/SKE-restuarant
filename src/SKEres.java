import java.util.Scanner;

public class SKEres {
	static Scanner sc = new Scanner(System.in);
        static int i=0;
        static int q1 = 0,q2 = 0,q3=0,sum=0;
	static int s1 = 0,s2 = 0,s3=0;
	static int x=1;
        public static void main(String [] args){
	meNu();
            while(i!=5 || x==1)
		{
			choicE();
                    switch (i) {
                        case 1:
                            pizzA();
                            break;
                        case 2:
                            chicKens();
                            break;
                        case 3:
                            cokE();
                            break;
                        case 4:
                            print();
                            break;
                        default:
                            break;
                    }
			x++;
		}
                thX();
        }
        public static void meNu(){
            System.out.println("--------- Welcome to SKE Resaurant ---------");
		System.out.println("1.) Pizza\t250\tBaht.");
		System.out.println("2.) Chickens\t120\tBaht.");
		System.out.println("3.) Coke\t45\tBaht.");
		System.out.println("4.) Total");
		System.out.println("5.) Exit");
        }
        public static void print(){
		System.out.println("+------ Menu ------+-- Qty --+-- Price --+");
		if(q1!=0){System.out.println("| Pizza            |   "+ q1 + "     |    " + s1 + "\t |");}
		if(q2!=0){System.out.println("| Chickens         |   "+ q2 + "     |    " + s2 + "\t |");}
		if(q3!=0){System.out.println("| Coke             |   "+ q3 + "     |    " + s3 + "\t |");}
		System.out.println("+------------------+---------+-----------+");
		System.out.println("| Total                      |    " + sum + "\t |" );
		System.out.println("+------------------+---------+-----------+");
	}
        public static void choicE(){
                System.out.print("Enter your Choice: ");
			i = sc.nextInt();
        }
        public static void pizzA(){
                System.out.print("Enter Quantity: ");
                            q1=sc.nextInt();
                            s1 = 250*q1;
                            sum+=s1;
        }
        public static void chicKens(){
                System.out.print("Enter Quantity: ");
                            q2=sc.nextInt();
                            s2 = 120*q2;
                            sum+=s2;
        }
        public static void cokE(){
                System.out.print("Enter Quantity: ");
                            q3=sc.nextInt();
                            s3 = 45*q3;
                            sum+=s3;
        }
        public static void thX(){
            System.out.print("++++++++++++++.Thank You.+++++++++++++++");
        }
}
