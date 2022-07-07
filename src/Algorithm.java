import java.io.*;
import java.util.Calendar;
import java.util.Scanner;

public class Algorithm {
    /**
     * Hàm nhập n phần tử từ bàn phím rồi lưu vào file
     * @param fileName file chứa dữ liệu nhập vào
     * @param n số lượng phần tử nhập vào
     */

    public void input(String fileName, int n){
        try {
            FileWriter fw= new FileWriter(fileName);
            BufferedWriter bw=new BufferedWriter(fw);
            for (int i = 0; i <n ; i++) {
                boolean hople = true;
                do {
                    try {
                        double t = new Scanner(System.in).nextDouble();
                        bw.write(Double.toString(t));
                        bw.newLine();
                        hople=true;
                    } catch (Exception e) {
                        System.out.println("Du lieu khong dung");
                        hople=false;
                    }

                }while (!hople);
            }
            bw.close();
            fw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Hàm lưu các phẩn tử trong mảng vào file
     * @param fileName file chứa dữ liệu nhập vào
     * @param a mảng chứa các phần tử cần lưu
     */

    public void input (String fileName, double[] a){
        try{
            FileWriter fr=new FileWriter(fileName);
            BufferedWriter bw=new BufferedWriter(fr);
            for(double i:a){
                bw.write(Double.toString(i));
                bw.newLine();
            }
            bw.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Hàm đọc n phần tử từ file rồi lưu vào mảng
     * @param fileName file chứa dữ liệu nhập vào
     * @param n số lượng phần tử cần đọc
     * @return mảng double
     */

    public double[] output(String fileName, int n){
        double[] a=new double[n];
        try{
            FileReader fr=new FileReader(fileName);
            BufferedReader br=new BufferedReader(fr);
            for (int i = 0; i <n; i++) {
                double t=Double.parseDouble(br.readLine());
                a[i]=t;
            }
            br.close();
            fr.close();

        } catch ( IOException e) {
            e.printStackTrace();
        }

        return a;
    }

    /**
     * Hàm sắp xếp theo thuật toán bubbleSorted
     * @param a mảng cần sắp xếp
     * @return mảng double đã được sắp xếp
     * Hiệu năng của thuật toán:
     * best case: trong trường hợp mảng đã được sắp xếp theo đúng thứ tự
     * worst case: trong trường hợp mảng có thứ tự sắp xếp ngược lại
     * average case: trường hợp mảng sắp xếp ngẫu nhiên
     */

    public double[] bubbleSorted(double[] a){
        long begin= Calendar.getInstance().getTimeInMillis(); // mốc thời gian bắt đầu thuật toán
        boolean swap=true;
        do{
            swap=false;
            for (int i = 0; i <a.length-1; i++) {
                if(a[i+1]<a[i])
                { double t=a[i+1];
                    a[i+1]=a[i];
                    a[i]=t;
                    swap=true;}

            }
            this.display(a);
        }while(swap);
        long end=Calendar.getInstance().getTimeInMillis(); // mốc thời gian kết thúc sắp xếp
        System.out.println("Times: "+(end-begin)+"ms"); // Thời gian thực hiện = end-begin
        return a;
    }
    /**
     * Hàm sắp xếp theo thuật toán selectionSorted
     * @param a mảng cần sắp xếp
     * @param show nếu true sẽ hiển thị ra kết quả từng bước sắp xếp, ngược lại thì không hiển thị
     * @return mảng double đã được sắp xếp
     * Hiệu năng của thuật toán:
     * best case: trong trường hợp mảng đã được sắp xếp theo đúng thứ tự
     * worst case: trong trường hợp mảng có thứ tự sắp xếp ngược lại
     * average case: trường hợp mảng sắp xếp ngẫu nhiên
     */


    public double[] selectionSorted(double[] a, boolean show){
        long begin= Calendar.getInstance().getTimeInMillis(); // mốc thời gian bắt đầu thuật toán
        for (int i = 0; i <a.length-1; i++) {
            int minIndex=i;
            for (int j = i+1; j <a.length ; j++) {
                if(a[minIndex]>a[j]) { minIndex=j;}
            }
            double t=a[minIndex];
            a[minIndex]=a[i];
            a[i]=t;
            if(show) {display(a);}
        }
        long end=Calendar.getInstance().getTimeInMillis(); // mốc thời gian kết thúc sắp xếp
        if(show) { System.out.println("Times: "+(end-begin)+"ms"); } // Thời gian thực hiện = end-begin
        return a;
    }


    /**
     * Hàm sắp xếp theo thuật toán insertSorted
     * @param a mảng cần sắp xếp
     * @return mảng double đã được sắp xếp
     * Hiệu năng của thuật toán:
     * best case: trong trường hợp mảng đã được sắp xếp theo đúng thứ tự
     * worst case: trong trường hợp mảng có thứ tự sắp xếp ngược lại
     * average case: trường hợp mảng sắp xếp ngẫu nhiên
     */
    public double[] insertSorted(double[] a){
        long begin= Calendar.getInstance().getTimeInMillis(); // mốc thời gian bắt đầu thuật toán
        for (int i = 1; i <a.length; i++) {
            double key=a[i];
            int j=i-1;
            while (j>=0&&a[j]>key){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=key;
            display(a);
        }
        long end=Calendar.getInstance().getTimeInMillis(); // mốc thời gian kết thúc sắp xếp
        System.out.println("Times: "+(end-begin)+"ms"); // Thời gian thực hiện = end-begin
        return a;
    }

    /**
     * Hàm tìm kiếm trả về index của phần từ lớn hơn giá trị val
     * @param a mảng chứa các phần tử cần so sánh
     * @param val giá trị so sánh
     */


    public void linear_Search(double[] a, double val){
        System.out.print("Chi so la: ");
        for (int i = 0; i <a.length; i++) {
            if(a[i]>val) {
                System.out.print(i+" ");
            }
        }
    }

    /**
     * Hàm tìm kiếm trả về index của phần từ bằng với giá trị val
     * @param a mảng chứa các phần tử cần so sánh
     * @param val giá trị so sánh
     * @return  index của phần tử có giá trị bằng với val
     */
    public int binarySearch(double[] a, double val) {
        int result=-1;
        int low=1;
        int hight=a.length;
        while(true){
            if(low>hight) {
                result=-1;
                break;
            }
            else {
                int mid = low + (hight - low) / 2;
                if (a[mid] == val) {
                    result = mid;
                    break;
                } else if (a[mid] > val) {
                    hight = mid - 1;
                } else if (a[mid] < val) {
                    low = mid + 1;
                }
            }
        }
        return  result;
    }

    /**
     * Hàm in các phần tử của mảng ra màn hình
     * @param a mảng chứa các phần tử cần in ra
     */

    public void display(double[] a){
        for(Double i:a){
            System.out.print(i+" ");
        }
        System.out.println("");
    }
}

