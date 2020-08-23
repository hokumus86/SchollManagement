package com.hokumus.schoolmanagement.ui.main;

import javax.swing.JFrame;

import com.hokumus.schoolmanagement.model.user.UserRole;
import com.hokumus.schoolmanagement.utils.Util;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreen extends JFrame{
	private JButton btnUser;
	private JButton btnManager;
	private JButton btnStudent;
	private JButton btnTeacher;
	
	
	public MainScreen() {
		
		initialize();
		
	}

	private void initialize() {
		setTitle("Giriþ Ekraný:    " + Util.loginedUser.getUsername()+" " + Util.loginedUser.getRole());
		setSize(525, 599);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnUser());
		getContentPane().add(getBtnManager());
		getContentPane().add(getBtnStudent());
		getContentPane().add(getBtnTeacher());
		if(Util.loginedUser.getRole() == UserRole.GENERALMANAGER ||Util.loginedUser.getRole() == UserRole.MANAGER || Util.loginedUser.getRole() == UserRole.HUMANRESOURCES ) {
			btnUser.setEnabled(false);
		}
		else if(Util.loginedUser.getRole() == UserRole.STUDENT) {
			btnManager.setEnabled(false);
			btnUser.setEnabled(false);
			btnTeacher.setEnabled(false);
		}
		else if(Util.loginedUser.getRole() == UserRole.TEACHER) {
			btnManager.setEnabled(false);
			btnUser.setEnabled(false);
		}
	}
	private JButton getBtnUser() {
		if (btnUser == null) {
			btnUser = new JButton("Kullan\u0131c\u0131 Y\u00F6netimi");
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
			btnManager = new JButton("Y\u00F6entim Mod\u00FCl\u00FC");
			btnManager.setBounds(301, 78, 190, 174);
		}
		return btnManager;
	}
	private JButton getBtnStudent() {
		if (btnStudent == null) {
			btnStudent = new JButton("\u00D6\u011Frenci Mod\u00FCl\u00FC");
			btnStudent.setBounds(58, 263, 190, 174);
		}
		return btnStudent;
	}
	private JButton getBtnTeacher() {
		if (btnTeacher == null) {
			btnTeacher = new JButton("\u00D6\u011Fretmen Mod\u00FCl\u00FC");
			btnTeacher.setBounds(301, 263, 190, 174);
		}
		return btnTeacher;
	}
}
