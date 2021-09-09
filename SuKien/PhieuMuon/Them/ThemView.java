package qltv.SuKien.PhieuMuon.Them;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import qltv.dao.PhieuMuonDao;
import qltv.dao.SachDao;
import qltv.entity.PhieuMuon;
import qltv.entity.Sach;
import qltv.view.QuanLyPhieuMuonView;

public class ThemView extends JFrame{
	JTextField txtMaPhieu, txtMaDG, txtTenDG, txtNgayMuon, txtNgayHenTra, txtSachMuon, txtThuThu;
	JLabel lblMaPhieu , lblMaDG, lblTenDG, lblSachMuon;
	ArrayList<PhieuMuon> phieuMuons;
	QuanLyPhieuMuonView quanLyPhieuMuonView;
	public JTextField getTxtMaPhieu() {
		return txtMaPhieu;
	}

	public void setTxtMaPhieu(JTextField txtMaPhieu) {
		this.txtMaPhieu = txtMaPhieu;
	}

	public JTextField getTxtMaDG() {
		return txtMaDG;
	}

	public void setTxtMaDG(JTextField txtMaDG) {
		this.txtMaDG = txtMaDG;
	}

	public JTextField getTxtTenDG() {
		return txtTenDG;
	}

	public void setTxtTenDG(JTextField txtTenDG) {
		this.txtTenDG = txtTenDG;
	}

	public JTextField getTxtNgayMuon() {
		return txtNgayMuon;
	}

	public void setTxtNgayMuon(JTextField txtNgayMuon) {
		this.txtNgayMuon = txtNgayMuon;
	}

	public JTextField getTxtNgayHenTra() {
		return txtNgayHenTra;
	}

	public void setTxtNgayHenTra(JTextField txtNgayHenTra) {
		this.txtNgayHenTra = txtNgayHenTra;
	}

	public JTextField getTxtSachMuon() {
		return txtSachMuon;
	}

	public void setTxtSachMuon(JTextField txtSachMuon) {
		this.txtSachMuon = txtSachMuon;
	}

	public JTextField getTxtThuThu() {
		return txtThuThu;
	}

	public void setTxtThuThu(JTextField txtThuThu) {
		this.txtThuThu = txtThuThu;
	}
	JButton btnThem;
	Connection conn=qltv.dao.ConnectMySQL.connect;
	public String tentk="";
	JDateChooser choosedate,choosedate1;
	
	public JDateChooser getChoosedate() {
		return choosedate;
	}

	public void setChoosedate(JDateChooser choosedate) {
		this.choosedate = choosedate;
	}

	public JDateChooser getChoosedate1() {
		return choosedate1;
	}

	public void setChoosedate1(JDateChooser choosedate1) {
		this.choosedate1 = choosedate1;
	}

	public ThemView(String tieude) {
		this.setTitle(tieude);
		addControls();
		if(tentk.length()!=0) {
			hienThi();
		}
	}
	
	public void hienThi() {
		txtThuThu.setText(tentk);
	}
	
	public int DemPhieuMuon()
	{
		int SoLuongPM=0;
		PhieuMuonDao pmsv=new PhieuMuonDao();
		ArrayList<PhieuMuon> ds=pmsv.layThongTinPhieuMuon();
		for(PhieuMuon pm: ds)
		{
			SoLuongPM++;
		}
		return SoLuongPM;
	}
	private void addControls() 
	{
		int kqpm=DemPhieuMuon() + 10;
		Container con = getContentPane();
		
		JPanel pnThemPhieuMuon = new JPanel();
		pnThemPhieuMuon.setLayout(new BorderLayout());
		con.add(pnThemPhieuMuon);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("QUẢN LÝ PHIẾU MƯỢN");
		pnTieuDe.add(lblTieuDe);
		pnThemPhieuMuon.add(pnTieuDe, BorderLayout.NORTH);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnThemPhieuMuon.add(pnLienHe, BorderLayout.SOUTH);
		
		JPanel pnHienThiThemPM = new JPanel();
		pnHienThiThemPM.setLayout(new BorderLayout());
		pnThemPhieuMuon.add(pnHienThiThemPM, BorderLayout.CENTER);
		
		JPanel pnHinhAnh= new JPanel();
		pnHinhAnh.setLayout(new FlowLayout());
		JLabel lblHinhAnh= new JLabel();
		pnHinhAnh.setBackground(Color.WHITE);
		lblHinhAnh.setIcon(new ImageIcon("Hinh/kha.png"));
		pnHinhAnh.add(lblHinhAnh);
		pnHienThiThemPM.add(pnHinhAnh, BorderLayout.WEST);
		
		JPanel pnHienThiChiTiet = new JPanel();
		pnHienThiChiTiet.setLayout(new BoxLayout(pnHienThiChiTiet, BoxLayout.Y_AXIS));
		pnHienThiThemPM.add(pnHienThiChiTiet, BorderLayout.CENTER);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblThemPM= new JLabel("THÊM PHIẾU MƯỢN");
		pnTitle.add(lblThemPM);
		
		JPanel pnMaPM = new JPanel();
		pnMaPM.setLayout(new FlowLayout());
		JLabel lblMaPM = new JLabel("Mã phiếu: ");
		txtMaPhieu= new JTextField("PM"+kqpm);
		txtMaPhieu.setPreferredSize(new Dimension(340, 30));
		pnMaPM.add(lblMaPM);
		pnMaPM.add(txtMaPhieu);
		
		JPanel pnMaDG = new JPanel();
		pnMaDG.setLayout(new FlowLayout());
		JLabel lblMaDG = new JLabel("Mã độc giả: ");
		txtMaDG= new JTextField("DG");
		txtMaDG.setPreferredSize(new Dimension(340, 30));
		pnMaDG.add(lblMaDG);
		pnMaDG.add(txtMaDG);
		
		JPanel pnTenDG = new JPanel();
		pnTenDG.setLayout(new FlowLayout());
		JLabel lblTenDG = new JLabel("Tên độc giả: ");
		txtTenDG = new JTextField();
		txtTenDG.setPreferredSize(new Dimension(340, 30));
		pnTenDG.add(lblTenDG);
		pnTenDG.add(txtTenDG);
		
		JPanel pnNgayMuon= new JPanel();
		pnNgayMuon.setLayout(new FlowLayout());
		JLabel lblNgayMuon = new JLabel("Ngày mượn: ");
		choosedate = new JDateChooser();
		choosedate.setPreferredSize(new Dimension(340, 30));
		choosedate.setDateFormatString("yyyy-MM-dd");
		pnNgayMuon.add(lblNgayMuon);
		pnNgayMuon.add(choosedate);
		
		JPanel pnNgayHenTra= new JPanel();
		pnNgayHenTra.setLayout(new FlowLayout());
		JLabel lblNgayHenTra = new JLabel("Ngày hẹn trả: ");
		choosedate1 = new JDateChooser();
		choosedate1.setPreferredSize(new Dimension(340, 30));
		choosedate1.setDateFormatString("yyyy-MM-dd");
		pnNgayHenTra.add(lblNgayHenTra);
		pnNgayHenTra.add(choosedate1);
		 
		JPanel pnSoSachCM= new JPanel();
		pnSoSachCM.setLayout(new FlowLayout());
		JLabel lblSoSachCM = new JLabel("Số sách mượn: ");
		txtSachMuon= new JTextField();
		txtSachMuon.setPreferredSize(new Dimension(340, 30));
		pnSoSachCM.add(lblSoSachCM);
		pnSoSachCM.add(txtSachMuon);
		
		JPanel pnThuThu = new JPanel();
		pnThuThu.setLayout(new FlowLayout());
		JLabel lblThuThu = new JLabel("Thủ thư: ");
		txtThuThu = new JTextField();
		txtThuThu.setPreferredSize(new Dimension(340, 30));
		pnThuThu.add(lblThuThu);
		pnThuThu.add(txtThuThu);
		
		
		pnHienThiChiTiet.add(pnTitle);
		pnHienThiChiTiet.add(pnMaPM);
		pnHienThiChiTiet.add(pnMaDG);
		//pnHienThiChiTiet.add(pnTenDG);
		pnHienThiChiTiet.add(pnNgayMuon);
		pnHienThiChiTiet.add(pnNgayHenTra);
		pnHienThiChiTiet.add(pnSoSachCM);
		pnHienThiChiTiet.add(pnThuThu);
		
		Font font1= new Font("SVN-Avo", Font.BOLD, 24); 
		Font font2= new Font("SVN-Avo", Font.BOLD, 30);
		Font font3= new Font("SVN-Avo", Font.TRUETYPE_FONT, 15);
		Font font4= new Font("SVN-Avo", Font.BOLD, 15);
		Font font5= new Font("SVN-Avo", Font.BOLD, 13);
		
		lblTieuDe.setFont(font1);
		lblThemPM.setFont(font2);
		lblMaPM.setFont(font4);
		lblMaDG.setFont(font4);
		lblTenDG.setFont(font4);
		lblNgayMuon.setFont(font4);
		lblNgayHenTra.setFont(font4);
		lblSoSachCM.setFont(font4);
		lblThuThu.setFont(font4);
		lblLienHe.setFont(font4);
		
		txtMaDG.setFont(font4);
		txtMaPhieu.setFont(font4);
		txtTenDG.setFont(font4);
		choosedate.setFont(font4);
		choosedate1.setFont(font4);
		txtSachMuon.setFont(font4);
		txtThuThu.setFont(font4);
		txtThuThu.setEditable(false);
		txtMaPhieu.setEditable(false);
		
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		
		pnTitle.setBackground(new java.awt.Color(241, 242, 246));
		lblThemPM.setForeground(new java.awt.Color(48, 51, 107));
		pnMaPM.setBackground(new java.awt.Color(241, 242, 246));
		pnMaDG.setBackground(new java.awt.Color(241, 242, 246));
		pnTenDG.setBackground(new java.awt.Color(241, 242, 246));
		pnNgayMuon.setBackground(new java.awt.Color(241, 242, 246));
		pnNgayHenTra.setBackground(new java.awt.Color(241, 242, 246));
		pnThuThu.setBackground(new java.awt.Color(241, 242, 246));
		pnSoSachCM.setBackground(new java.awt.Color(241, 242, 246));
		pnHinhAnh.setBackground(new java.awt.Color(241, 242, 246));		
		
		JPanel pnThaoTac= new JPanel();
		pnThaoTac.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnThaoTac);
		btnThem= new JButton("THÊM");
		btnThem.setPreferredSize(new Dimension(110,35));
		pnThaoTac.add(btnThem);
		pnThaoTac.setBackground(new java.awt.Color(241, 242, 246));
		
		btnThem.setFont(font5);
		btnThem.setBackground(new java.awt.Color(255, 177, 66));
		btnThem.setForeground(Color.white);
		btnThem.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 177, 66)));
		
		
		Border borderLogin= BorderFactory.createLineBorder(new java.awt.Color(48, 51, 107));
		TitledBorder titleLogin= new TitledBorder(borderLogin, "");
		titleLogin.setTitleJustification(TitledBorder.LEFT);
		titleLogin.setTitleColor(Color.BLUE);
		pnHienThiThemPM.setBorder(titleLogin);
		
		lblMaDG.setPreferredSize(lblSoSachCM.getPreferredSize());
		lblMaPM.setPreferredSize(lblSoSachCM.getPreferredSize());
		lblTenDG.setPreferredSize(lblSoSachCM.getPreferredSize());
		lblNgayHenTra.setPreferredSize(lblSoSachCM.getPreferredSize());
		lblNgayMuon.setPreferredSize(lblSoSachCM.getPreferredSize());
		lblThuThu.setPreferredSize(lblSoSachCM.getPreferredSize());
		
		this.setSize(900, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	public void addListener(ActionListener listener) {
		btnThem.addActionListener(listener);
	}

	public void setMoDal(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	public void insert() {
		try 
		{

			String sql = "select * from phieumuon where mapm=?";
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, txtMaPhieu.getText());
			ResultSet rs = pre.executeQuery();

			if (rs.next()) 
			{
				JOptionPane.showMessageDialog(null, "Mã phiếu mượn đã tồn tại!");
				return;
			}
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(choosedate.getDate());
        if( choosedate.getDate() == null || choosedate1.getDate() == null)
        {
        	JOptionPane.showMessageDialog(null,"Không được để trống");
			return;
        }
        PhieuMuon phieuMuon = new PhieuMuon();
        phieuMuon.setMaPM(txtMaPhieu.getText());
        phieuMuon.setMaDG(txtMaDG.getText());
        phieuMuon.setUser(txtThuThu.getText());
        PhieuMuonDao phieuMuonDao = new PhieuMuonDao();
        if(phieuMuonDao.insert(phieuMuon) > 0){
        	JOptionPane.showMessageDialog(null, "Thêm phiếu mượn thành công");
        	String soluong=txtSachMuon.getText();
			int soluong1=Integer.parseInt(soluong);
			for(int i=0;i<soluong1;i++)
			{
				ThemView tView = new ThemView("Thêm sách");
				ThemController tController = new ThemController(tView);
				tController.MaPM = txtMaPhieu.getText();
				tController.tentk = tentk;
				tView.hienThi();
				tController.showThemView();
			}
        }
	}
	
	public boolean valiform() {
        if (txtMaDG.getText().equals("")) {
            txtMaDG.requestFocus();
            lblMaDG.setText("Chưa nhập mã độc giả");
            return false;
        }else if (txtMaPhieu.getText().equals("")) {
            txtMaPhieu.requestFocus();
            lblMaPhieu.setText("Chưa nhập Mã sách");
            return false;
        }else if (txtSachMuon.getText().equals("")) {
            txtSachMuon.requestFocus();
            lblSachMuon.setText("Chưa nhập sách mượn");
            return false;
        }else 
        return true;
    };

    public void load() {
    	PhieuMuonDao phieuMuonDao = new PhieuMuonDao();
    	phieuMuons = phieuMuonDao.layThongTinPhieuMuon();
    	DefaultTableModel model = (DefaultTableModel) quanLyPhieuMuonView.gettblPhieuMuon().getModel();
    	model.setRowCount(0);
    	for(PhieuMuon s: phieuMuons) {
    		Object[] row = new Object[] {
    				s.getMaPM(),s.getMaDG(),s.getNgayMuon(),s.getNgayTra(),s.getSoLuong(),s.getUser()
    		};
    		model.addRow(row);
    	}
    }
}
