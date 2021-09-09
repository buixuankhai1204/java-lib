package qltv.SuKien.NguoiDung.Sua;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import qltv.dao.TaiKhoanDao;
import qltv.entity.TaiKhoan;
import qltv.view.QuanLyNguoiDungView;

public class SuaView extends JFrame{
	JTextField txtTaiKhoan, txtHoTen, txtSDT, txtCMND, txtPhanQuyen;
	JLabel lblTaiKhoan, lblHoTen, lblSDT, lblCMND, lblMatKhau;
	ArrayList<TaiKhoan> taiKhoans;
	QuanLyNguoiDungView quanLyNguoiDungView;
	public JTextField getTxtTaiKhoan() {
		return txtTaiKhoan;
	}

	public void setTxtTaiKhoan(JTextField txtTaiKhoan) {
		this.txtTaiKhoan = txtTaiKhoan;
	}

	public JTextField getTxtHoTen() {
		return txtHoTen;
	}

	public void setTxtHoTen(JTextField txtHoTen) {
		this.txtHoTen = txtHoTen;
	}

	public JTextField getTxtSDT() {
		return txtSDT;
	}

	public void setTxtSDT(JTextField txtSDT) {
		this.txtSDT = txtSDT;
	}

	public JTextField getTxtCMND() {
		return txtCMND;
	}

	public void setTxtCMND(JTextField txtCMND) {
		this.txtCMND = txtCMND;
	}

	public JTextField getTxtPhanQuyen() {
		return txtPhanQuyen;
	}

	public void setTxtPhanQuyen(JTextField txtPhanQuyen) {
		this.txtPhanQuyen = txtPhanQuyen;
	}

	public JPasswordField getPwdMatKhau() {
		return pwdMatKhau;
	}

	public void setPwdMatKhau(JPasswordField pwdMatKhau) {
		this.pwdMatKhau = pwdMatKhau;
	}
	JPasswordField pwdMatKhau;
	JButton btnSua;
	Connection connect = qltv.dao.ConnectMySQL.connect;
	public String machon="";
	
	public SuaView(String tieude)
	{
		this.setTitle(tieude);
		addControls();
		if(machon.length() != 0)
		{
			hienThi();
		}
	}
	
	private void addControls() 
	{
	
		Container con = getContentPane();
		
		JPanel pnSuaNguoiDung= new JPanel();
		pnSuaNguoiDung.setLayout(new BorderLayout());
		con.add(pnSuaNguoiDung);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("QUẢN LÝ NGƯỜI DÙNG");
		pnTieuDe.add(lblTieuDe);
		pnSuaNguoiDung.add(pnTieuDe, BorderLayout.NORTH);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnSuaNguoiDung.add(pnLienHe, BorderLayout.SOUTH);
		
		JPanel pnHienThiNguoiDung = new JPanel();
		pnHienThiNguoiDung.setLayout(new BorderLayout());
		pnSuaNguoiDung.add(pnHienThiNguoiDung, BorderLayout.CENTER);
		
		
		JPanel pnHinhAnh= new JPanel();
		pnHinhAnh.setLayout(new FlowLayout());
		JLabel lblHinhAnh= new JLabel();
		pnHinhAnh.setBackground(Color.WHITE);
		lblHinhAnh.setIcon(new ImageIcon("Hinh/suand.png"));
		pnHinhAnh.add(lblHinhAnh);
		pnHienThiNguoiDung.add(pnHinhAnh, BorderLayout.WEST);
		
		JPanel pnHienThiChiTiet = new JPanel();
		pnHienThiChiTiet.setLayout(new BoxLayout(pnHienThiChiTiet, BoxLayout.Y_AXIS));
		pnHienThiNguoiDung.add(pnHienThiChiTiet, BorderLayout.CENTER);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblXoaNguoiDung= new JLabel("CHỈNH SỬA NGƯỜI DÙNG");
		pnTitle.add(lblXoaNguoiDung);
		
		JPanel pnTaiKhoan = new JPanel();
		pnTaiKhoan.setLayout(new FlowLayout());
		JLabel lblTaiKhoan = new JLabel("Tài khoản: ");
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setPreferredSize(new Dimension(340, 30));
		pnTaiKhoan.add(lblTaiKhoan);
		pnTaiKhoan.add(txtTaiKhoan);
		
		JPanel pnMatKhau = new JPanel();
		pnMatKhau.setLayout(new FlowLayout());
		JLabel lblMatKhau = new JLabel("Mật khẩu: ");
		pwdMatKhau = new JPasswordField();
		pwdMatKhau.setEchoChar((char)0);
		pwdMatKhau.setPreferredSize(new Dimension(340, 30));
		pnMatKhau.add(lblMatKhau);
		pnMatKhau.add(pwdMatKhau);
		
		JPanel pnHoTen = new JPanel();
		pnHoTen.setLayout(new FlowLayout());
		JLabel lblHoTen = new JLabel("Họ và tên: ");
		txtHoTen = new JTextField();
		txtHoTen.setPreferredSize(new Dimension(340, 30));
		pnHoTen.add(lblHoTen);
		pnHoTen.add(txtHoTen);
		
		JPanel pnSoDienThoai= new JPanel();
		pnSoDienThoai.setLayout(new FlowLayout());
		JLabel lblSoDienThoai = new JLabel("Số điện thoại: ");
		txtSDT = new JTextField();
		txtSDT.setPreferredSize(new Dimension(340, 30));
		pnSoDienThoai.add(lblSoDienThoai);
		pnSoDienThoai.add(txtSDT);
		
		JPanel pnCMND= new JPanel();
		pnCMND.setLayout(new FlowLayout());
		JLabel lblCMND = new JLabel("Số CMND: ");
		txtCMND = new JTextField();
		txtCMND.setPreferredSize(new Dimension(340, 30));
		pnCMND.add(lblCMND);
		pnCMND.add(txtCMND);
		
		JPanel pnPhanQuyen=new JPanel();
		pnPhanQuyen.setLayout(new FlowLayout());
		JLabel lblPhanQuyen = new JLabel("Phân quyền: ");
		txtPhanQuyen = new JTextField();
		txtPhanQuyen.setPreferredSize(new Dimension(340, 30));
		pnPhanQuyen.add(lblPhanQuyen);
		pnPhanQuyen.add(txtPhanQuyen);
		
		
		
		pnHienThiChiTiet.add(pnTitle);
		pnHienThiChiTiet.add(pnTaiKhoan);
		pnHienThiChiTiet.add(pnMatKhau);
		pnHienThiChiTiet.add(pnHoTen);
		pnHienThiChiTiet.add(pnSoDienThoai);
		pnHienThiChiTiet.add(pnCMND);
		pnHienThiChiTiet.add(pnPhanQuyen);
		
		
		Font font1= new Font("SVN-Avo", Font.BOLD, 24); 
		Font font2= new Font("SVN-Avo", Font.BOLD, 30);
		Font font3= new Font("SVN-Avo", Font.TRUETYPE_FONT, 15);
		Font font4= new Font("SVN-Avo", Font.BOLD, 15);
		Font font5= new Font("SVN-Avo", Font.BOLD, 13);
		lblTieuDe.setFont(font1);
		lblXoaNguoiDung.setFont(font2);
		lblTaiKhoan.setFont(font4);
		lblSoDienThoai.setFont(font4);
		lblCMND.setFont(font4);
		lblHoTen.setFont(font4);
		lblMatKhau.setFont(font4);
		lblLienHe.setFont(font4);
		lblPhanQuyen.setFont(font4);
		
		txtTaiKhoan.setFont(font4);
		txtCMND.setFont(font4);
		txtHoTen.setFont(font4);
		txtSDT.setFont(font4);
		pwdMatKhau.setFont(font4);
		txtPhanQuyen.setFont(font4);
		
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		
		pnTitle.setBackground(new java.awt.Color(241, 242, 246));
		lblXoaNguoiDung.setForeground(new java.awt.Color(48, 51, 107));
		pnTaiKhoan.setBackground(new java.awt.Color(241, 242, 246));
		pnCMND.setBackground(new java.awt.Color(241, 242, 246));
		pnMatKhau.setBackground(new java.awt.Color(241, 242, 246));
		pnPhanQuyen.setBackground(new java.awt.Color(241, 242, 246));
		pnSoDienThoai.setBackground(new java.awt.Color(241, 242, 246));
		pnHoTen.setBackground(new java.awt.Color(241, 242, 246));
		pnHinhAnh.setBackground(new java.awt.Color(241, 242, 246));
		
		JPanel pnThaoTac= new JPanel();
		pnThaoTac.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnThaoTac);
		btnSua= new JButton("LƯU");
		btnSua.setPreferredSize(new Dimension(110,35));
		pnThaoTac.add(btnSua);
		pnThaoTac.setBackground(new java.awt.Color(241, 242, 246));
		
		btnSua.setFont(font5);
		
		btnSua.setBackground(new java.awt.Color(255, 177, 66));
		btnSua.setForeground(Color.white);
		btnSua.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 177, 66)));
		
		
		Border borderLogin= BorderFactory.createLineBorder(new java.awt.Color(48, 51, 107));
		TitledBorder titleLogin= new TitledBorder(borderLogin, "");
		titleLogin.setTitleJustification(TitledBorder.LEFT);
		titleLogin.setTitleColor(Color.BLUE);
		pnHienThiNguoiDung.setBorder(titleLogin);
		
		lblTaiKhoan.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblMatKhau.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblHoTen.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblCMND.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblPhanQuyen.setPreferredSize(lblSoDienThoai.getPreferredSize());
		
		txtTaiKhoan.setEditable(false);
		
		this.setSize(900, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	}
	public void hienThi() 
	{
		TaiKhoanDao tksv = new TaiKhoanDao();
		ArrayList<TaiKhoan> dstk= new ArrayList<TaiKhoan>();
		dstk = tksv.layTaiKhoanTheoUser(machon);
		for(TaiKhoan tk: dstk)
		{
			txtTaiKhoan.setText(tk.getUser());
			txtCMND.setText(tk.getCMND());
			txtHoTen.setText(tk.getTenND());
			int phanquyen=tk.getPhanQuyen();
			if(phanquyen == 1 )
			{
				txtPhanQuyen.setText("Admin");
			}
			else
				txtPhanQuyen.setText("Thủ thư");
			txtSDT.setText(tk.getSoDienThoai());
			pwdMatKhau.setText(tk.getPass());
		}
	}
	
	public void update() {
		TaiKhoan taikhoan = new TaiKhoan();
		taikhoan.setUser(txtTaiKhoan.getText());
		taikhoan.setPass(pwdMatKhau.getText());
		taikhoan.setCMND(txtCMND.getText());
		taikhoan.setSoDienThoai(txtSDT.getText());
		TaiKhoanDao taiKhoanDao = new TaiKhoanDao();
		if(taiKhoanDao.insert(taikhoan) > 0) {
			JOptionPane.showMessageDialog(null, "Sửa thành công");
		}
		else{
            JOptionPane.showMessageDialog(null, "Tài khoản [ "+txtTaiKhoan.getText()+" ] đã tồn tại không thể thêm");
        } 
	}
	
	 public boolean valiform() {
	        if (txtTaiKhoan.getText().equals("")) {
	            txtTaiKhoan.requestFocus();
	            lblTaiKhoan.setText("Chưa nhập tên Tài Khoản");
	            return false;
	        }else if (pwdMatKhau.getText().equals("")) {
	            pwdMatKhau.requestFocus();
	            lblMatKhau.setText("Chưa nhập Mật Khẩu");
	            return false;
	        }else if (txtCMND.getText().equals("")) {
	            txtCMND.requestFocus();
	            lblCMND.setText("Chưa nhập CMNN");
	            return false;
	        }else if (txtHoTen.getText().equals("")) {
	            txtHoTen.requestFocus();
	            lblHoTen.setText("Chưa nhập Họ và tên");
	            return false;
	        }else if (txtSDT.getText().equals("")) {
	            txtSDT.requestFocus();
	            lblSDT.setText("Chưa nhập SDT");
	            return false;
	        }else 
	        return true;
	    };
	
	    public void load() {
	    	TaiKhoanDao taiKhoanDao = new TaiKhoanDao();
	    	taiKhoans = taiKhoanDao.layTaiKhoan();
	    	DefaultTableModel model = (DefaultTableModel) quanLyNguoiDungView.gettblNguoiDung().getModel();
	    	model.setRowCount(0);
	    	for(TaiKhoan s: taiKhoans) {
	    		Object[] row = new Object[] {
	    				s.getUser(),s.getPass(),s.getSoDienThoai(),s.getCMND(),s.getTenND()
	    		};
	    		model.addRow(row);
	    	}
	    }
	
	public void addListener(ActionListener listener) {
		btnSua.addActionListener(listener);
	}

	public void setMoDal(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
