package com.hokumus.schoolmanagement.ui.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.hokumus.schoolmanagement.dao.users.UserDao;
import com.hokumus.schoolmanagement.model.user.Users;
import com.hokumus.schoolmanagement.ui.main.MainScreen;
import com.hokumus.schoolmanagement.utils.Util;

public class GirisEkrani extends JFrame {
	private JTextField txtKullaniciAdi;
	private JTextField txtSifre;
	private JButton btnGiris;
	private JButton btnIptal;

	public GirisEkrani() {
		initialize();
	}

	private void initialize() {
		setTitle("Giri� Ekran�");
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getTxtKullaniciAdi());
		getContentPane().add(getTxtSifre());
		getContentPane().add(getBtnGiris());
		getContentPane().add(getBtnIptal());
		txtKullaniciAdi.setText("hokumus");
		txtSifre.setText("123");
	}

	private JTextField getTxtKullaniciAdi() {
		if (txtKullaniciAdi == null) {
			txtKullaniciAdi = new JTextField();
			txtKullaniciAdi.setBounds(154, 56, 132, 20);
			txtKullaniciAdi.setColumns(10);
		}
		return txtKullaniciAdi;
	}

	private JTextField getTxtSifre() {
		if (txtSifre == null) {
			txtSifre = new JTextField();
			txtSifre.setBounds(154, 107, 132, 20);
			txtSifre.setColumns(10);
		}
		return txtSifre;
	}

	private JButton getBtnGiris() {
		if (btnGiris == null) {
			btnGiris = new JButton("Giri\u015F");
			btnGiris.setBounds(195, 166, 91, 23);
			btnGiris.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					UserDao dao = new UserDao();
					boolean durum = false;
					List<Users> liste = dao.getir(new Users());
					for (Users users : liste) {
						if(users.getUsername().equals(txtKullaniciAdi.getText())&& 
								users.getPassword().equals(txtSifre.getText())) {
							durum = true;
							Util.loginedUser = users;
							new MainScreen().setVisible(true);
							
							break;
							
						}
						
					}
					if(!durum) {
						JOptionPane.showMessageDialog(GirisEkrani.this, "kullan�c� hatal�");
					}

				}
			});
		}
		return btnGiris;
	}

	private JButton getBtnIptal() {
		if (btnIptal == null) {
			btnIptal = new JButton("\u0130ptal");
			btnIptal.setBounds(80, 166, 91, 23);
		}
		return btnIptal;
	}
}
