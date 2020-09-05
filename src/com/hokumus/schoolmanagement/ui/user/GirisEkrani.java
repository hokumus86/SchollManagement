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
import com.hokumus.schoolmanagement.model.util.Operations;
import com.hokumus.schoolmanagement.ui.main.MainScreen;
import com.hokumus.schoolmanagement.utils.Util;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GirisEkrani extends JFrame {
	private JTextField txtKullaniciAdi;
	private JTextField txtSifre;
	private JButton btnGiris;
	private JButton btnIptal;
	private MainScreen openingFrame;

	public GirisEkrani() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				if (Operations.callFrame != openingFrame && Operations.closingFrame != GirisEkrani.this)
					System.exit(0);
			}
		});
		initialize();
	}

	private void initialize() {
		setTitle("Giriþ Ekraný");
		setSize(400, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
						if (users.getUsername().equals(txtKullaniciAdi.getText())
								&& users.getPassword().equals(txtSifre.getText())) {
							durum = true;
							Util.loginedUser = users;
							openingFrame = new MainScreen();
							Operations.callFrame = openingFrame;
							Operations.closingFrame = GirisEkrani.this;
							openingFrame.setVisible(true);
							GirisEkrani.this.dispose();

							break;

						}

					}
					if (!durum) {
						JOptionPane.showMessageDialog(GirisEkrani.this, "kullanýcý hatalý");
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
