package dataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dataTransferObject.khoa;

public class khoaDAL {
	Connection ketNoi;
	public khoaDAL()
	{
		ketNoi = ketNoiDB.MoKetNoi("qlsinhvien", "root", "");
	}
	// Xây dựng các phương thức, thao tác trực tiếp với CSDL
	public ResultSet selectAll() {
		
		ResultSet kq;
		String sql = "Select * from khoa";
		try {
			Statement stm = ketNoi.createStatement();
			kq=  stm.executeQuery(sql);
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
	}
	
	public void insert(String maKhoa, String tenKhoa ) {
		String sqlThemKhoa1 ="INSERT INTO khoa(MaKhoa, TenKhoa) VALUES (?,?)";
		PreparedStatement lenhThem;
		try {
			lenhThem = ketNoi.prepareStatement(sqlThemKhoa1);
			// truyen tham so cho truy van
			lenhThem.setString(1,maKhoa);
			lenhThem.setString(2,tenKhoa);
			// Thực hiện lệnh
			lenhThem.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(khoa khoaObj) {
		String sqlThemKhoa1 ="INSERT INTO khoa(MaKhoa, TenKhoa) VALUES (?,?)";
		PreparedStatement lenhThem;
		try {
			lenhThem = ketNoi.prepareStatement(sqlThemKhoa1);
			// truyen tham so cho truy van
			lenhThem.setString(1,khoaObj.getMaKhoa());
			lenhThem.setString(2,khoaObj.getTenKhoa());
			// Thực hiện lệnh
			lenhThem.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
