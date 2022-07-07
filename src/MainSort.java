import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class MainSort {
    public static int n=0;
    public static void main(String[] args) {
        boolean tieptuc=true;
        do{
            System.out.println("");
            System.out.println("+-------------------Menu------------------+");
            System.out.println("|      1.Input                            |");
            System.out.println("|      2.Output                           |");
            System.out.println("|      3.Bubble sort                      |");
            System.out.println("|      4.Selection sort                   |");
            System.out.println("|      5.Insertion sort                   |");
            System.out.println("|      6.Search > value                   |");
            System.out.println("|      7.Search = value                   |");
            System.out.println("|      0.Exit                             |");
            System.out.println("+-----------------------------------------+");
            Scanner sc =new Scanner(System.in);
            System.out.print("Chon chuc nang: ");
            int i=sc.nextInt();
            Algorithm al=new Algorithm();
            String input="INPUT.TXT";
            String output1="OUTPUT1.TXT";
            String output2="OUTPUT2.TXT";
            String output3="OUTPUT3.TXT";
            String output4="OUTPUT4.TXT";
            String output5="OUTPUT5.TXT";
            switch(i) {
                case 1:
                    boolean hople=false;
                    System.out.println("Input");
                    do {
                        try {
                            System.out.print("Nhap so luong phan tu: ");
                            n = new Scanner(System.in).nextInt();
                            if(n>0) { hople=true;
                                al.input(input, n);
                            } else System.out.println("So luong phan tu khong hop le");
                        } catch (Exception e) {
                            System.out.println("So luong phan tu khong hop le");
                            hople=false;

                        }
                    }while (!hople);
                    break;
                case 2:
                    System.out.println("Output");
                    double[] a= al.output(input,n);
                    for(double o:a){
                        System.out.print(o+" ");
                    }
                    break;
                case 3:
                    System.out.println("Bubble sort");
                    double[] b= al.output(input,n);
                    al.bubbleSorted(b);
                    al.input(output1,b);
                    break;
                case 4:
                    System.out.println("Selection sort ");
                    double[] c= al.output(input,n);
                    al.selectionSorted(c,true);
                    al.input(output2,c);
                    break;
                case 5:
                    System.out.println("Insertion sort  ");
                    double[] d=al.output(input,n);
                    al.insertSorted(d);
                    al.input(output3,d);
                    break;
                case 6:
                    System.out.println("Linear Search ");
                    System.out.print("Input value:");
                    double val1=sc.nextDouble();
                    double[] e=al.output(input,n);
                    al.linear_Search(e,val1);
                    break;
                case 7:
                    System.out.println("Binary Search");
                    System.out.print("Input value: ");
                    double val2=sc.nextDouble();
                    double[] f=al.output(input,n);
                    f=al.selectionSorted(f, false);
                    System.out.println("Indext of fist element: "+ al.binarySearch(f,val2));
                    break;
                case 0:
                    tieptuc=false;
                    System.out.println("Thanks!!!");
                    break;
            }

        }while(tieptuc);
    }

}
