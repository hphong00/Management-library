package QuanLyMuonSach.person;


import QuanLyMuonSach.Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BanDoc {
    public static final String SV = "Sinh Viên";
    public static final String HVCH = "Học Vienj Cao Học";
    public static final String GV = "Giáo Viên";

    private static int mBanDoc = 10000;

    private int id;
    private String strHoTen;
    private String strDiaChi;
    private String strSDT;
    private String strLBanDoc;

    Scanner scanner = new Scanner(System.in);

    public BanDoc(){

    }

    public BanDoc(int id, String strHoTen, String strDiaChi, String strSDT, String strLBanDoc) {
        this.id = id;
        this.strHoTen = strHoTen;
        this.strDiaChi = strDiaChi;
        this.strSDT = strSDT;
        this.strLBanDoc = strLBanDoc;
    }

    public static int getmBanDoc() {
        return mBanDoc;
    }

    public static void setmBanDoc(int mBanDoc) {
        BanDoc.mBanDoc = mBanDoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStrHoTen() {
        return strHoTen;
    }

    public void setStrHoTen(String strHoTen) {
        this.strHoTen = strHoTen;
    }

    public String getStrDiaChi() {
        return strDiaChi;
    }

    public void setStrDiaChi(String strDiaChi) {
        this.strDiaChi = strDiaChi;
    }

    public String getStrSDT() {
        return strSDT;
    }

    public void setStrSDT(String strSDT) {
        this.strSDT = strSDT;
    }

    public String getStrLBanDoc() {
        return strLBanDoc;
    }

    public void setStrLBanDoc(String strLBanDoc) {
        this.strLBanDoc = strLBanDoc;
    }

    @Override
    public String toString() {
        return "BanDoc{" +
                "mBanDoc=" + id +
                ", strHoTen='" + strHoTen + '\'' +
                ", strDiaChi='" + strDiaChi + '\'' +
                ", strSDT='" + strSDT + '\'' +
                ", strLBanDoc='" + strLBanDoc + '\'' +
                '}';
    }
    public void nhapBanDoc(){
        this.id = BanDoc.mBanDoc++;

        System.out.println("Nhâp tên bạn đocc: ");
        strHoTen = scanner.nextLine();

        System.out.println("Nhập đia chỉ: ");
        strDiaChi = scanner.nextLine();

        System.out.println("Nhập SDT: ");
        strSDT = scanner.nextLine();

        System.out.println("Nhâp loại bạn đoc: ");
        this.nhapLoaiBanDoc();
    }
    public void nhapLoaiBanDoc(){
        boolean cont = true;
        int s =0;
        do {
            System.out.println("1. Sinh viên");
            System.out.println("2. Học viên cao hocc");
            System.out.println("3. Giáo Viên");

            try{
                Scanner scanner = new Scanner(System.in);
                s = scanner.nextInt();
                if (s <= 3 && s >= 1) {
                    break;
                }
            }catch (InputMismatchException e){
                System.out.println("Mời Nhập lại:");
            }
        }while (cont);
        switch (s) {
            case 1:
                this.strLBanDoc = BanDoc.SV;
                break;
            case 2:
                this.strLBanDoc = BanDoc.HVCH;
                break;
            case 3:
                this.strLBanDoc = BanDoc.GV;
                break;
        }
    }
}
