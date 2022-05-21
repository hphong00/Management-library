package QuanLyMuonSach.logic;

import QuanLyMuonSach.Main;
import QuanLyMuonSach.book.Sach;

import java.util.Scanner;

public class SachService {
    private static Scanner scanner = new Scanner(System.in);

    public static void nhapSach(){
        System.out.print("Nhập bao nhiêu quyển sách: ");
        int s = scanner.nextInt();
        for (int i = 0; i <s ; i++) {
            Sach sach = new Sach();
            sach.nhapSach();
            saveSach(sach);
            System.out.println(sach.toString());
        }
    }
    public static void saveSach(Sach sach){
        for (int i = 0; i < Main.sach.length; i++) {
            if(Main.sach[i]==null){
                Main.sach[i] = sach;
                return;
            }
        }
    }
    public static void showListSach(){
        for (int i = 0; i < Main.sach.length; i++) {
            if(Main.sach[i]==null) {
                continue;
            }
            //System.out.println(Main.sach[i]);
            System.out.format( "%7d%20s%20s%30s%30s",Main.sach[i].getId() ,Main.sach[i].getStrTenSach() , Main.sach[i].getStrTacGia(),Main.sach[i].getStrChuyenNganh(),Main.sach[i].getStrNamXuatBan());
            System.out.println("");
        }
    }
    public static boolean checkSach() {
        boolean cont = true;
        for (int i = 0; i < Main.sach.length; i++) {
            if (Main.sach[i] == null) {
                cont = false;
            }
        }
        return cont;
    }
}
