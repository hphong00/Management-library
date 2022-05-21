package QuanLyMuonSach.book;

import QuanLyMuonSach.Main;

import java.io.StringReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sach {

    public static final String KHTN = "Khoa học tự nhiên";
    public static final String VH_NT = "Văn học – Nghệ thuật";
    public static final String DTVT = "Điện tử Viễn thông";
    public static final String CNTT = "Công nghệ thông tin";

    private static int iMaSach = 10000;

    private int id;
    private String strTenSach;
    private String strTacGia;
    private String strChuyenNganh;
    private String strNamXuatBan;

    Scanner scanner = new Scanner(System.in);

    public Sach() {

    }

    public Sach(int id, String strTenSach, String strTacGia, String strChuyenNganh, String strNamXuatBan) {
        this.id = id;
        this.strTenSach = strTenSach;
        this.strTacGia = strTacGia;
        this.strChuyenNganh = strChuyenNganh;
        this.strNamXuatBan = strNamXuatBan;
    }

    public static int getiMaSach() {
        return iMaSach;
    }

    public static void setiMaSach(int iMaSach) {
        Sach.iMaSach = iMaSach;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStrTenSach() {
        return strTenSach;
    }

    public void setStrTenSach(String strTenSach) {
        this.strTenSach = strTenSach;
    }

    public String getStrTacGia() {
        return strTacGia;
    }

    public void setStrTacGia(String strTacGia) {
        this.strTacGia = strTacGia;
    }

    public String getStrChuyenNganh() {
        return strChuyenNganh;
    }

    public void setStrChuyenNganh(String strChuyenNganh) {
        this.strChuyenNganh = strChuyenNganh;
    }

    public String getStrNamXuatBan() {
        return strNamXuatBan;
    }

    public void setStrNamXuatBan(String strNamXuatBan) {
        this.strNamXuatBan = strNamXuatBan;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "id=" + id +
                ", strTenSach='" + strTenSach + '\'' +
                ", strTacGia='" + strTacGia + '\'' +
                ", strChuyenNganh='" + strChuyenNganh + '\'' +
                ", strNamXuatBan='" + strNamXuatBan + '\'' +
                '}';
    }
    public void nhapSach(){

        this.id = Sach.iMaSach++;

        System.out.println("Nhập tên sách:");
        strTenSach = scanner.nextLine();

        System.out.println("Nhập tác giả: ");
        strTacGia = scanner.nextLine();

        System.out.println("Nhâp năm xuât bản:");
        strNamXuatBan = scanner.nextLine();

        System.out.println("Nhâp chuyên ngành: ");
        this.nhapChuyenNganh();

    }
    public void nhapChuyenNganh(){
        boolean cont = true;
        int chuyenNganh = 0;
        do {
            System.out.println("Nhập chuyên ngành của sách: ");
            System.out.println("1. Khoa học tự nhiên");
            System.out.println("2. Điện tử viễn thông");
            System.out.println("3. Văn học nghệ thuật");
            System.out.println("4. Công nghệ thông tin");
            try {
                Scanner scanner = new Scanner(System.in);
                chuyenNganh = scanner.nextInt();
                if (chuyenNganh <= 4 && chuyenNganh >= 1) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Mơi lựa chọn lại: ");
            }
        }while (cont);
        switch (chuyenNganh) {
            case 1:
                this.strChuyenNganh = Sach.KHTN;
                break;
            case 2:
                this.strChuyenNganh = Sach.VH_NT;
                break;
            case 3:
                this.strChuyenNganh = Sach.DTVT;
                break;
            case 4:
                this.strChuyenNganh = Sach.CNTT;
                break;
        }
    }
}