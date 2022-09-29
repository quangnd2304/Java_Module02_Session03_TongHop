import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Nhap vao so dong va so cot, khai bao mang 2 chieu so nguyen
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so dong cua ma tran: ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap vao so cot cua ma tran: ");
        int m = Integer.parseInt(sc.nextLine());
        int[][] matran = new int[n][m];
        //In menu va thuc hien cac chuc nang theo menu
        do {
            System.out.println("********************MENU******************");
            System.out.println("1. Nhap gia tri cho cac phan tu ma tran");
            System.out.println("2. In gia tri cac phan tu ma tran");
            System.out.println("3. In cac phan tu nam tren duong bien");
            System.out.println("4. In cac phan tu nam tren cheo chinh, cheo phu va tinh tong");
            System.out.println("5. Tim min, max");
            System.out.println("6. Sap xep mang tang dan theo cot");
            System.out.println("7. Thoat");
            System.out.print("Su lua chon cua ban: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    Main.inputDataToArray(matran, sc, n, m);
                    break;
                case 2:
                    Main.displayArray(matran, n, m);
                    break;
                case 3:
                    Main.displayArrayBorder(matran,n,m);
                    break;
                case 4:
                    Main.displayMainOfLine(matran,n,m);
                    break;
                case 5:
                    Main.diplayMinMax(matran,n,m);
                    break;
                case 6:
                    Main.sortArrayByColumnASC(matran,n,m);
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.err.println("Vui long nhap tu 1-7");
            }
        } while (true);
    }

    public static void inputDataToArray(int[][] matran, Scanner sc, int n, int m) {
        System.out.println("NHAP GIA TRI CAC PHAN TU CUA MA TRAN: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("matran[%d][%d]=", i, j);
                matran[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
    }

    public static void displayArray(int[][] matran, int n, int m) {
        System.out.println("GIA TRI CAC PHAN TU TRONG MA TRAN: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%d\t", matran[i][j]);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }

    public static void displayArrayBorder(int[][] matran, int n, int m) {
        System.out.println("GIA TRI CAC PHAN TU BIEN TRONG MA TRAN: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    System.out.printf("%d\t", matran[i][j]);
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }
    public static void displayMainOfLine(int[][] matran,int n, int m){
        if (n==m) {
            int sum=0;
            System.out.println("CAC PHAN TU NAM TREN CHEO CHINH CUA MA TRAN:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i==j){
                        //matran[i][j] nam tren duong cheo chinh
                        System.out.printf("%d\t",matran[i][j]);
                        sum+=matran[i][j];
                    }
                }
            }
            System.out.printf("\n");
            System.out.println("Tong cac phan tu nam tren cheo chinh la: "+sum);
            sum = 0;
            System.out.println("CAC PHAN TU NAM TREN CHEO PHU CUA MA TRAN:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i+j==n-1){
                        //matran[i][j] nam tren duong cheo phu
                        System.out.printf("%d\t",matran[i][j]);
                        sum+=matran[i][j];
                    }
                }
            }
            System.out.printf("\n");
            System.out.println("Tong cac phan tu nam tren cheo phu la: "+sum);

        }else{
            System.out.println("Ma tran khong co duong cheo chinh va cheo phu");
        }
    }
    public static void diplayMinMax(int[][] matran,int n,int m){
        int max = matran[0][0], min = matran[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (min>matran[i][j]){
                    min = matran[i][j];
                }
                if (max<matran[i][j]){
                    max = matran[i][j];
                }
            }
        }
        System.out.printf("Gia tri lon nhat: %d - Gia tri nho nhat: %d\n",max,min);
    }

    public static void sortArrayByColumnASC(int[][] matran, int n, int m){
        for (int j = 0; j < m; j++) {
            //Xet tung cot matran[][j] --> Cot j
            for (int i = 0; i < n-1; i++) {
                for (int k = i+1; k < n; k++) {
                    if (matran[i][j]>matran[k][j]){
                        int temp = matran[i][j];
                        matran[i][j] = matran[k][j];
                        matran[k][j] = temp;
                    }
                }
            }
        }
        System.out.println("Da sap xep xong cac cot cua ma tran tang dan");
    }
}