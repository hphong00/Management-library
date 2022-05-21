package QuanLyMuonSach.book;

public class ChiTietSach {
    private Sach sach;
    private int soLuong;

    public ChiTietSach(Sach sach, int soLuong) {
        this.sach = sach;
        this.soLuong = soLuong;
    }

    public ChiTietSach() {

    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "SachChiTiet{" +
                "sach=" + sach +
                ", soLuong=" + soLuong +
                '}';
    }
}
