package com.hokumus.schoolmanagement.ui.main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.hokumus.schoolmanagement.model.user.UserRole;
import com.hokumus.schoolmanagement.model.util.Operations;
import com.hokumus.schoolmanagement.ui.management.ManagementScreen;
import com.hokumus.schoolmanagement.ui.user.GirisEkrani;
import com.hokumus.schoolmanagement.ui.user.UserManagement;
import com.hokumus.schoolmanagement.utils.Util;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import com.toedter.calendar.JDateChooser;

public class MainScreen extends JFrame {
	private JButton btnUser;
	private JButton btnManager;
	private JButton btnStudent;
	private JButton btnTeacher;
	private ManagementScreen openingFrame;
	private JDateChooser dateChooser;

	public MainScreen() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				if (Operations.callFrame != openingFrame && Operations.closingFrame != MainScreen.this)
					new GirisEkrani().setVisible(true);
			}
		});

		initialize();

	}

	private void initialize() {
		setTitle("Okul Yönetim Ekraný:    " + Util.loginedUser.getUsername() + " " + Util.loginedUser.getRole());
		setSize(525, 599);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnUser());
		getContentPane().add(getBtnManager());
		getContentPane().add(getBtnStudent());
		getContentPane().add(getBtnTeacher());
		getContentPane().add(getDateChooser());
		if (Util.loginedUser.getRole() == UserRole.GENERALMANAGER || Util.loginedUser.getRole() == UserRole.MANAGER
				|| Util.loginedUser.getRole() == UserRole.HUMANRESOURCES) {
			btnUser.setEnabled(false);
		} else if (Util.loginedUser.getRole() == UserRole.STUDENT) {
			btnManager.setEnabled(false);
			btnUser.setEnabled(false);
			btnTeacher.setEnabled(false);
		} else if (Util.loginedUser.getRole() == UserRole.TEACHER) {
			btnManager.setEnabled(false);
			btnUser.setEnabled(false);
		}
	}

	private JButton getBtnUser() {
		if (btnUser == null) {
			btnUser = new JButton("Kullan\u0131c\u0131 Y\u00F6netimi");
			btnUser.setFont(new Font("Arial", Font.BOLD, 17));
			btnUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new UserManagement().setVisible(true);
				}
			});
			btnUser.setBounds(58, 78, 190, 174);
		}
		return btnUser;
	}

	private JButton getBtnManager() {
		if (btnManager == null) {
			btnManager = new JButton("Y\u00F6netim Mod\u00FCl\u00FC");
			btnManager.setFont(new Font("Arial", Font.BOLD, 17));
			btnManager.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					openingFrame = new ManagementScreen();
					Operations.callFrame = openingFrame;
					Operations.closingFrame = MainScreen.this;
					openingFrame.setVisible(true);
					MainScreen.this.dispose();

				}
			});
			btnManager.setBounds(301, 78, 190, 174);
		}
		return btnManager;
	}

	private JButton getBtnStudent() {
		if (btnStudent == null) {
			btnStudent = new JButton("\u00D6\u011Frenci Mod\u00FCl\u00FC");
			btnStudent.setFont(new Font("Arial", Font.BOLD, 17));
			btnStudent.setBounds(58, 263, 190, 174);
		}
		return btnStudent;
	}

	private JButton getBtnTeacher() {
		if (btnTeacher == null) {
			btnTeacher = new JButton("\u00D6\u011Fretmen Mod\u00FCl\u00FC");
			btnTeacher.setFont(new Font("Arial", Font.BOLD, 17));
			btnTeacher.setBounds(301, 263, 190, 174);
		}
		return btnTeacher;
	}
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setBounds(58, 24, 97, 20);
		}
		return dateChooser;
	}
}
