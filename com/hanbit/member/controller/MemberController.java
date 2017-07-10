package com.hanbit.member.controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.hanbit.member.constants.Butt;
import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;
import com.hanbit.member.serviceImpl.MemberServiceImpl;

public class MemberController {
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		MemberBean member = null;
		Butt[] buttons = {Butt.EXIT,Butt.ADD,Butt.LIST,Butt.FIND_NAME,Butt.FIND_ID,Butt.UPDATE,Butt.DEL};
		do{
			flag:
			switch ((Butt) JOptionPane.showInputDialog(null,
					"MEMBER ADMIN",
					"SELECT MENU",
					JOptionPane.QUESTION_MESSAGE,
					null,
					buttons,
					buttons[1]
					)){
			case EXIT:
				return;
			case ADD:
				member = new MemberBean();
				String[] arr = JOptionPane.showInputDialog("name/id/pass/snn").split("/");
				member.setName(arr[0]);
				member.setId(arr[1]);
				member.setPassword(arr[2]);
				member.setSNN(arr[3]);
				service.addMember(member);
				JOptionPane.showMessageDialog(null, "welecome");
				break flag;
			case COUNT:
				JOptionPane.showMessageDialog(null, service.countMembers());
				break flag;

			case LIST:
				JOptionPane.showMessageDialog(null, service.getMembers());
				break flag;

			case FIND_ID:
				JOptionPane.showMessageDialog(null,(service.findById(JOptionPane.showInputDialog("insert id"))).toString());
				break flag;

			case FIND_NAME:
				JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("insert find name")));				
				break flag;

			case UPDATE:
				member = new MemberBean();
				member.setId(JOptionPane.showInputDialog("insert find id"));
				member.setPassword(JOptionPane.showInputDialog("비번"));
				member.setName(JOptionPane.showInputDialog("이름"));
				member.setSNN(JOptionPane.showInputDialog("SSN"));
				service.updatePass(member);
				JOptionPane.showMessageDialog(null, "비밀번호 변경");
				break flag;
			case DEL:
				member = new MemberBean();
				service.delete(JOptionPane.showInputDialog("insert delete id"));
				JOptionPane.showMessageDialog(null, "삭제완료");
				break flag;
			}
		}while (true);
	}
}
