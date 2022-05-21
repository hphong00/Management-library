package QuanLyMuonSach;


import QuanLyMuonSach.book.ChiTietSach;
import QuanLyMuonSach.person.BanDoc;

import java.util.Arrays;

public class QLMuonSach {
    private BanDoc banDoc;
    private ChiTietSach chiTietSache;

    public QLMuonSach(BanDoc banDoc, ChiTietSach chiTietSache) {
        this.banDoc = banDoc;
        this.chiTietSache = chiTietSache;
    }

    public QLMuonSach() {

    }

    public BanDoc getBanDoc() {
        return banDoc;
    }

    public void setBanDoc(BanDoc banDoc) {
        this.banDoc = banDoc;
    }

    public ChiTietSach getChiTietSache() {
        return chiTietSache;
    }

    public void setChiTietSache(ChiTietSach chiTietSache) {
        this.chiTietSache = chiTietSache;
    }

    @Override
    public String toString() {
        return "QLMuonSach{" +
                "banDoc=" + banDoc +
                ", chiTietSache=" + chiTietSache +
                '}';
    }
}
