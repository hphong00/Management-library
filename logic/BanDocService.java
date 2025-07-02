package QuanLyMuonSach.logic;

import QuanLyMuonSach.person.BanDoc;
import QuanLyMuonSach.Main;

import java.util.Scanner;

public class BanDocService {
    private static Scanner scanner = new Scanner(System.in);
    public static void nhapBanDoc(){
        System.out.println("Nhập số bạn đọc:");
        int s = scanner.nextInt();
        for (int i = 0; i < s; i++) {
            BanDoc banDoc = new BanDoc();
            banDoc.nhapBanDoc();
            saveBanDoc(banDoc);
            System.out.println(banDoc.toString());
        }
    }
    public static void saveBanDoc(BanDoc banDoc){
        for (int i = 0; i < Main.banDoc.length; i++) {
            if(Main.banDoc[i] == null){
                Main.banDoc[i] =  banDoc;
                return;
            }
        }
    }
    public static void showBanHoc(){
        for (int i = 0; i < Main.banDoc.length; i++) {
            if(Main.banDoc[i]==null) {
                continue;
            }
            System.out.format( "%7d%20s%20s%30s%30s",Main.banDoc[i].getId() ,Main.banDoc[i].getStrHoTen() , Main.banDoc[i].getStrDiaChi(),Main.banDoc[i].getStrSDT(),Main.banDoc[i].getStrLBanDoc());
            System.out.println("");
        }
    }
    public static boolean checkBanDoc(){
        boolean cont = true;
        for (int i = 0; i < Main.banDoc.length; i++) {
            if(Main.banDoc[i] == null){
                cont =false;
            }
        }
        return cont;
        
    }
}

