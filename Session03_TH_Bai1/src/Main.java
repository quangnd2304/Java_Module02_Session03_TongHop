import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Nhap so phan tu cua mang va khai bao mang 1 chieu so nguyen gom n phan tu
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so phan tu cua mang: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] arrInt = new int[n];
        //In menu va thuc hien cac chuc nang theo menu
        do {
            System.out.println("************MENU***********************");
            System.out.println("1. Nhap gia tri cac phan tu");
            System.out.println("2. Hien thi gia tri cac phan tu");
            System.out.println("3. In gia tri cac phan tu chan va tinh tong");
            System.out.println("4. In gia tri cac phan tu co chi so le va tinh tong");
            System.out.println("5. In gia tri cac phan tu la so nguyen to trong mang");
            System.out.println("6. In gia tri max, min cua cac phan tu trong mang");
            System.out.println("7. Sap xep mang giam dan");
            System.out.println("8. Thong ke so luong phan tu co gia tri nhap vao");
            System.out.println("9. Thoat");
            System.out.print("Su lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    Main.inputArray(arrInt,sc);
                    break;
                case 2:
                    Main.displayArray(arrInt);
                    break;
                case 3:
                    Main.displayElementEvent(arrInt);
                    break;
                case 4:
                    Main.displayElementByIndexOdd(arrInt);
                    break;
                case 5:
                    Main.displayElementPrime(arrInt);
                    break;
                case 6:
                    Main.displayMaxMinValue(arrInt);
                    break;
                case 7:
                    Main.sortArrayDESC(arrInt);
                    break;
                case 8:
                    Main.countElementByValue(arrInt,sc);
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.err.println("Vui long nhap 1-9");
            }
        }while(true);
    }
    public static void inputArray(int[] arrInt, Scanner sc){
        System.out.println("NHAP GIA TRI CAC PHAN TU CUA MANG: ");
        for (int i = 0; i < arrInt.length; i++) {
            System.out.printf("arrInt[%d]=",i);
            arrInt[i] = Integer.parseInt(sc.nextLine());
        }
    }
    public static void displayArray(int[] arrInt){
        System.out.println("GIA TRI CAC PHAN TU TRONG MANG: ");
        for (int i = 0; i < arrInt.length; i++) {
            System.out.printf("%d\t",arrInt[i]);
        }
        System.out.printf("\n");
    }

    public static  void displayElementEvent(int[] arrInt){
        int sum = 0;
        System.out.println("GIA TRI CAC PHAN TU CHAN TRONG MANG: ");
        for (int i = 0; i < arrInt.length; i++) {
            if(arrInt[i]%2==0){
                System.out.printf("%d\t",arrInt[i]);
                sum+=arrInt[i];
            }
        }
        System.out.printf("\n");
        System.out.println("Tong cac phan tu co gia tri chan trong mang la: "+sum);
    }
    public static void displayElementByIndexOdd(int[] arrInt){
        int sum = 0;
        System.out.println("GIA TRI CAC PHAN TU CO CHI SO LE TRONG MANG: ");
        for (int i = 0; i < arrInt.length; i++) {
            if (i%2!=0){
                System.out.printf("%d\t",arrInt[i]);
                sum+=arrInt[i];
            }
        }
        System.out.printf("\n");
        System.out.println("Tong gia tri cac phan tu co chi so le la: "+sum);
    }
    public static void displayElementPrime(int[] arrInt){
        System.out.println("CAC PHAN TU LA SO NGUYEN TO TRONG MANG LA: ");
        for (int i = 0; i < arrInt.length; i++) {
            //Kiem tra arrInt[i] co phai la so nguyen to hay khong
            if(Main.checkPrime(arrInt[i])){
                System.out.printf("%d\t",arrInt[i]);
            }
        }
        System.out.printf("\n");
    }

    public static boolean checkPrime(int num){
        boolean check = true;
        if(num>=2){
            for (int i = 2; i < num; i++) {
                if(num%i==0){
                    check = false;
                    break;
                }
            }
        }else{
            check = false;
        }
        return check;
    }
    public static void displayMaxMinValue(int[] arrInt){
        int max = arrInt[0], min = arrInt[0];
        for (int i = 1; i < arrInt.length; i++) {
            if (max<arrInt[i]){
                max = arrInt[i];
            }
            if (min>arrInt[i]){
                min = arrInt[i];
            }
        }
        System.out.printf("Gia tri lon nhat trong mang la: %d, gia tri nho nhat la: %d\n",max,min);
    }
    public static void sortArrayDESC(int[] arrInt){
        for (int i = 0; i < arrInt.length-1; i++) {
            for (int j = i+1; j < arrInt.length; j++) {
                if(arrInt[i]<arrInt[j]){
                    int temp = arrInt[i];
                    arrInt[i] = arrInt[j];
                    arrInt[j] = temp;
                }
            }
        }
        System.out.println("Da sap xep xong mang giam dan");
    }
    public static void countElementByValue(int[] arrInt, Scanner sc){
        System.out.println("Nhap vao gia tri can thong ke: ");
        int num = Integer.parseInt(sc.nextLine());
        int cnt=0;
        for (int i = 0; i < arrInt.length; i++) {
            if (num==arrInt[i]){
                cnt++;
            }
        }
        System.out.printf("Co %d phan tu co gia tri la %d trong mang\n",cnt,num);
    }
}