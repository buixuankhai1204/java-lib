package qltv.controller;

import java.awt.event.ActionListener;

import qltv.dao.TaiKhoanDao;
import qltv.entity.TaiKhoan;
import qltv.view.LoGinView;
//import quanlythuvien.GUI.QuanLyAdmin;
//import quanlythuvien.GUI.QuanLyThuThu;
import qltv.view.QuanLyAdminView;
import qltv.view.QuanLyThuThuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.text.View;

import org.springframework.jdbc.core.ParameterDisposer;

import qltv.entity.TaiKhoan;
import qltv.controller.LoGinController.LoginListener;

public class LoGinController {
	private LoGinView loginView;
	private int EXIT_ON_CLOSE;
	
	public LoGinController(LoGinView loginView) {
	    this.loginView = loginView;
	   loginView.addLoginListener(new LoginListener()); 
	   loginView.addMouseListener(new LoginListener1());
	   loginView.addMouseListenerr(new LoginListener2());
	}
	public void showLoginView() {
		loginView.setVisible(true);
    }
	
	class LoginListener1 implements MouseListener{
		public void actionPerformed(ActionEvent e) {
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			loginView.getUserNameField().setText(null);;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			loginView.getUserNameField().setText(null);;
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	class LoginListener2 implements MouseListener{
		public void actionPerformed(ActionEvent e) {
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			loginView.getPasswordField().setText(null);
			loginView.getPasswordField().setEchoChar('*');
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			loginView.getPasswordField().setText(null);
			loginView.getPasswordField().setEchoChar('*');
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TaiKhoanDao taiKhoanDao = new TaiKhoanDao();
			ArrayList<TaiKhoan> dsTaiKhoans = new ArrayList<TaiKhoan>();
			dsTaiKhoans = taiKhoanDao.layTaiKhoan();		
			if(loginView.getUserNameField().getText().length() == 0)
			{
				JOptionPane.showMessageDialog(loginView, "Tài khoàn không được để trống");
				return;
			}
			if(loginView.getPasswordField().getText().length() == 0)
			{
				JOptionPane.showMessageDialog(loginView, "Mật khẩu không được để trống");
				return;
			}
			
			for(TaiKhoan tk: dsTaiKhoans)
			{
				if(loginView.getUserNameField().getText().equals(tk.getUser()) && loginView.getPasswordField().getText().equals(tk.getPass()) && tk.getPhanQuyen() == 1)
				{			
					QuanLyAdminView qlav = new QuanLyAdminView("Trang Chủ Phần Mềm Quản Lý Thư Viện");
					QuanLyAdminController qlac = new QuanLyAdminController(qlav);
					qlac.showQuanlyAdminView();
					qlac.tentk = loginView.getUserNameField().getText();
					loginView.dispose();
					return;
				}
				if(loginView.getUserNameField().equals(tk.getUser()) && loginView.getPasswordField().getText().equals(tk.getPass()) && tk.getPhanQuyen() == 2)
				{
					QuanLyThuThuView qlttv = new QuanLyThuThuView("Thủ thư");
					QuanLyThuThuController qlttc = new QuanLyThuThuController(qlttv);
					qlttc.showQuanLyThuThuView();
					qlttc.tentk = loginView.getUserNameField().getText();
				}
			}		
				JOptionPane.showMessageDialog(loginView, "Sai tài khoản hoặc mật khẩu. Vui lòng nhập lại");
				loginView.getUserNameField().setText(null);
				loginView.getPasswordField().setText(null);
		}
			
	}

}
