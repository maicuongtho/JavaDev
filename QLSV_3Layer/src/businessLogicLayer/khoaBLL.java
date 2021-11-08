package businessLogicLayer;

import java.sql.ResultSet;

import dataAccessLayer.khoaDAL;
import dataTransferObject.khoa;
public class khoaBLL {
	khoaDAL khoa; 
	public ResultSet selectAll() {
		// Có một vài xử lý nghiệp vụ nếu có ở đây
		khoa = new khoaDAL();
		ResultSet  kq=khoa.selectAll();
		return kq;
	}
	
	public void insert(String maKhoa, String tenKhoa) 		{
		
		khoa = new khoaDAL();
		khoa.insert(maKhoa, tenKhoa);
	}
	
	public void insert(khoa khoaObj) 		{
		khoa = new khoaDAL();
		khoa.insert(khoaObj);
	}
	
}
