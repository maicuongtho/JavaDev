package dataTransferObject;

public class khoa {
	String maKhoa;
	String tenKhoa;
	public String getMaKhoa() {
		return maKhoa;
	}
	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}
	public String getTenKhoa() {
		return tenKhoa;
	}
	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}
	public khoa(String maKhoa, String tenKhoa) {
		super();
		this.maKhoa = maKhoa;
		this.tenKhoa = tenKhoa;
	}
	public khoa() {
		super();
	}
	
	
}
