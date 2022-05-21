package QuanLyMuonSach;

import QuanLyMuonSach.book.Sach;
import QuanLyMuonSach.logic.BanDocService;
import QuanLyMuonSach.logic.ChiTietMuonSach;
import QuanLyMuonSach.logic.SachService;
import QuanLyMuonSach.person.BanDoc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Sach[] sach = new  Sach[50];
    public static BanDoc[] banDoc = new  BanDoc[50];
    public static QLMuonSach[] qlMuonSaches = new  QLMuonSach[50];

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        sMenu();
        luaChon();
    }
    private static void luaChon(){
        boolean cont = true;
        do{
            System.out.print("Mời bạn chọn: ");
            int chon = 0;
            try{
                chon = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.print("Moi nhap lai: ");
            }
            switch (chon){
                case 1:
                    SachService.nhapSach();
                    System.out.println("----------List sách-----------");
                    SachService.showListSach();
                    sMenu();
                    break;
                case 2:
                    System.out.println("---List sách---");
                    SachService.showListSach();
                    sMenu();
                    break;
                case 3:
                    BanDocService.nhapBanDoc();
                    System.out.println("----------List bạn đọc-----------");
                    BanDocService.showBanHoc();
                    sMenu();
                    break;
                case 4:
                    System.out.println("---List bạn đọc---");
                    BanDocService.showBanHoc();
                    sMenu();
                    break;
                case 5:
                    ChiTietMuonSach.muonSach();
                    sMenu();
                    break;
                case 6:
                    ChiTietMuonSach.xapXep();
                    sMenu();
                    break;
                case 7:
                    ChiTietMuonSach.timBanDoc();
                    sMenu();
                    break;
                case 8:
                    cont = false;
            }
        }while (cont);
    }
    private static void sMenu(){
        System.out.println("---Quản lý mượn sách---");
        System.out.println("1. Nhập đầu sách mới. ");
        System.out.println("2. Xem list Sách. ");
        System.out.println("3. Nhập danh sách bạn đọc mới. ");
        System.out.println("4. Xem list bạn đọc. ");
        System.out.println("5. Mượn sách. ");
        System.out.println("6. Sắp xếp quản lý sách. ");
        System.out.println("7. Tìm kiếm bạn đọc. ");
        System.out.println("8. Thoát. ");
        System.out.println("8. Thoát. ");

    }
}



