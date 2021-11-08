package presentationLayer;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businessLogicLayer.khoaBLL;

import javax.swing.JTextField;
import javax.swing.JLabel;
import dataTransferObject.khoa;
public class khoaView {

	private JFrame frame;
	private JTable tableKhoa;
	DefaultTableModel dataModel_Khoa;
	private JTextField txtMaKhoa;
	private JTextField txtTenKhoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					khoaView window = new khoaView();
					
					
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public khoaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 629, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLayDuLieuKhoa = new JButton("Lấy toàn bộ dữ liệu ở bảng KHOA");
		btnLayDuLieuKhoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lấy toàn bộ dữ liệu từ bảng Khoa
				khoaBLL kBLL= new khoaBLL();
				ResultSet bKhoa = kBLL.selectAll();
				// Đưa lên bảng
				try {
					while (bKhoa.next())  // trong khi mà còn next được (còn dòng)
					{ // Xử lý mỗi dòng
						// Lấy dữ liệu từng cột
						String maKhoa = bKhoa.getString("MaKhoa"); // Cột số 0
						String tenKhoa = bKhoa.getString("TenKhoa"); // Cột số 1
						Vector row = new Vector<>();
						row.add(maKhoa);
						row.add(tenKhoa);
						dataModel_Khoa.addRow(row);
					}
				} catch (Exception ngoaile) {
					 System.err.print(ngoaile.getMessage());
				}
				// Cập nhật model cho bảng
				tableKhoa.setModel(dataModel_Khoa);
				tableKhoa.updateUI();
			}
		});
		dataModel_Khoa = new DefaultTableModel();
		dataModel_Khoa.addColumn("Mã Khoa");
		dataModel_Khoa.addColumn("Tên Khoa");
		
	
		btnLayDuLieuKhoa.setBounds(87, 89, 196, 23);
		frame.getContentPane().add(btnLayDuLieuKhoa);
		
		tableKhoa = new JTable();
		tableKhoa.setBounds(87, 123, 275, 183);
		frame.getContentPane().add(tableKhoa);
		
		txtMaKhoa = new JTextField();
		txtMaKhoa.setBounds(87, 27, 181, 20);
		frame.getContentPane().add(txtMaKhoa);
		txtMaKhoa.setColumns(10);
		
		txtTenKhoa = new JTextField();
		txtTenKhoa.setBounds(87, 58, 264, 20);
		frame.getContentPane().add(txtTenKhoa);
		txtTenKhoa.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Mã Khoa");
		lblNewLabel.setBounds(31, 26, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Khoa");
		lblNewLabel_1.setBounds(31, 57, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnThemKhoa = new JButton("Thêm mới Khoa");
		btnThemKhoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lấy dữ liệu
				String mK = txtMaKhoa.getText();
				String tK = txtTenKhoa.getText();
				// xử lý dữ liệu nếu có
				
				//thực hiện thêm
				khoaBLL kBLL = new khoaBLL();
				
				khoa K = new khoa(mK, tK);
				kBLL.insert(K);
				//kBLL.insert(mK, tK);
				
				// Cập nhật view Khoa
			}
		});
		btnThemKhoa.setBounds(290, 26, 73, 23);
		frame.getContentPane().add(btnThemKhoa);
		
		JButton btnXoa = new JButton("Xóa");
	    btnXoa.setToolTipText("Nhập vào mã khoa cần xóa");
		btnXoa.setBounds(289, 89, 89, 23);
		frame.getContentPane().add(btnXoa);
	}
}
