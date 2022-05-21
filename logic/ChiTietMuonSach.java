package QuanLyMuonSach.logic;

import QuanLyMuonSach.Main;
import QuanLyMuonSach.QLMuonSach;
import QuanLyMuonSach.book.ChiTietSach;
import QuanLyMuonSach.book.Sach;
import QuanLyMuonSach.person.BanDoc;

import java.lang.management.ManagementFactory;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ChiTietMuonSach {

    private static Scanner scanner = new Scanner(System.in);

    public static void muonSach() {
        if ((SachService.checkSach()) && (BanDocService.checkBanDoc())){
            System.out.println("Không có dữ liệu ban đọc hoặc sách");
            return;
        }

        int numberBanDoc = 0 ;
        do {
            try {
                System.out.println("Sô lượng đầu sách mươn, không được quá 5 đầu sách: ");
                numberBanDoc = scanner.nextInt();
                if(numberBanDoc>=1 && numberBanDoc<=5);
                {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Mời bạn nhập lại");
            }
        }while (true);
        for (int i = 0; i < numberBanDoc; i++) {
            // nhap id ban doc muon muon,luu ban doc
            QLMuonSach qlMuonSach = new QLMuonSach();
            BanDoc banDoc = nhapBanDocMuon(i);
            qlMuonSach.setBanDoc(banDoc);
            System.out.println(qlMuonSach.getBanDoc());

            // nhap id sách va luu chi tiet sac
            ChiTietSach chiTietSach = new ChiTietSach();
            Sach sach = nhapchitietSachmuon(i);
            chiTietSach.setSach(sach);
            System.out.println(chiTietSach.getSach());
            //nhap so luong sach muốn mượn
            int soLuongSach =0;
            boolean cont = true;
            do {
                try {
                    System.out.println("Sô lượng sách muốn mượn, không được quá 3: ");
                    soLuongSach = scanner.nextInt();
                    if(soLuongSach<=3 && soLuongSach>=1);
                    {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Mời bạn nhập lại");
                }
            }while (true);
            // luong so luong sach
            chiTietSach.setSoLuong(soLuongSach);
            // luu thong muon sach
            qlMuonSach.setChiTietSache(chiTietSach);
            System.out.println(qlMuonSach.toString());

            // luu số lần mượn sách
            saveMuonSach(qlMuonSach);
            showAllQLMS();
        }
    }

    public static BanDoc nhapBanDocMuon(int id) {
        System.out.println("Nhập mã bạn đọc: ");
        BanDoc banDoc = null;
        do {
            int IdBanDoc = scanner.nextInt();
            for (int i = 0; i < Main.banDoc.length; i++) {
                if (Main.banDoc[i] != null && Main.banDoc[i].getId() == IdBanDoc) {
                    banDoc = Main.banDoc[i];
                    break;
                }
            }
            if (banDoc != null) {
                break;
            }
            System.out.println("Không tìm thấy bạn đọc:");
        } while (true);
        return banDoc;
    }

    public static Sach nhapchitietSachmuon(int id){
        System.out.println("Nhâp mã sách: ");
        Sach sach = null;
        do {
            int IdSach = scanner.nextInt();
            for (int i = 0; i < Main.sach.length; i++) {
                if (Main.sach[i] != null && Main.sach[i].getId() == IdSach) {
                    sach = Main.sach[i];
                    break;
                }
            }
            if (sach != null) {
                break;
            }
            System.out.println("Không tìm sách:");
        } while (true);
        return sach;
    }

    public static void showAllQLMS(){
        for (int i = 0; i < Main.qlMuonSaches.length; i++) {
            if(Main.qlMuonSaches[i]!=null){
                System.out.println(Main.qlMuonSaches[i]);
            }
        }
    }

    public static void saveMuonSach(QLMuonSach qlMuonSach){
        System.out.println("---Show all QLMS---");
        for (int i = 0; i < Main.qlMuonSaches.length; i++) {
            if (Main.qlMuonSaches[i] == null) {
                Main.qlMuonSaches[i] = qlMuonSach;
                break;
            }
        }
    }

    public static void xapXep(){
        int nhap =0;
        do {
            try {
                System.out.println("Mời bạn chọn: ");
                System.out.println("1. Sắp xếp quản lý sách theo tên bạn đọc. ");
                System.out.println("2. Sắp xếp theo cuốn sách mượn giảm dần. ");
                nhap = scanner.nextInt();
                if (nhap==1 || nhap==2){
                    break;
                }
            } catch (Exception e) {
                System.out.println("Mời nhập lại: ");
            }
        }while (true);
        if (nhap == 1) {
            for (int i = 0; i < Main.qlMuonSaches.length-1; i++) {
                if (Main.qlMuonSaches[i] == null) {
                    continue;
                }
                for (int j = i+1; j < Main.banDoc.length; j++) {
                    if (Main.qlMuonSaches[j] == null) {
                        continue;
                    }
                    if (Main.qlMuonSaches[i].getBanDoc().getStrHoTen().compareTo(Main.qlMuonSaches[j].getBanDoc().getStrHoTen())>0){
                        QLMuonSach qlMuonSach = Main.qlMuonSaches[i];
                        Main.qlMuonSaches[i] = Main.qlMuonSaches[j];
                        Main.qlMuonSaches[j] = qlMuonSach;
                    }
                }
                showAllQLMS();
                break;
            }
        }
        else if (nhap==2){
            int tem;
            for (int i = 0; i <Main.banDoc.length; i++) {
                if (Main.qlMuonSaches[i] == null) {
                    continue;
                }
                for (int j = i+1; j < Main.banDoc.length; j++) {
                    if (Main.qlMuonSaches[j] == null) {
                        continue;
                    }
                    if (Main.qlMuonSaches[i].getChiTietSache().getSoLuong()<Main.qlMuonSaches[j].getChiTietSache().getSoLuong()){
                        tem = Main.qlMuonSaches[i].getChiTietSache().getSoLuong();
                        Main.qlMuonSaches[i].getChiTietSache().setSoLuong(Main.qlMuonSaches[j].getChiTietSache().getSoLuong());
                        Main.qlMuonSaches[j].getChiTietSache().setSoLuong(tem);
                    }
                }
            }
            showAllQLMS();
        }
    }

    public static void timBanDoc(){
        System.out.println("Mời bạn nhập Id ban đọc cần tìm: ");
        do {
            try {
                String s = scanner.nextLine();
                for (int i = 0; i < Main.banDoc.length; i++) {
//                    if(s == Main.qlMuonSaches[i].getBanDoc().getId())
                    if(Main.qlMuonSaches[i].getBanDoc().getStrHoTen().toLowerCase().contains(s.toLowerCase())){
                        System.out.println(Main.qlMuonSaches[i].toString());
                        break;
                    }
                }
            }catch (Exception e){
                System.out.println("Mời bạn nhập lại: ");
            }
        }while (true);
    }
}