package com.hanbit.member.serviceImpl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;

public class MemberServiceImpl implements MemberService {
	MemberBean member;
	Map<String,MemberBean>map;
	
	public MemberServiceImpl(){
		member = new MemberBean();
		map = new HashMap<>();
	}
	
	@Override
	public void addMember(MemberBean bean) {
		map.put(bean.getId(), bean);
	}

	@Override
	public List<MemberBean> getMembers() {
		List<MemberBean>list =new ArrayList<>();
		Set<String>keys =map.keySet();
		for(String s:keys){
			list.add(map.get(s));
		}
		return list;
	}

	@Override
	public int countMembers() {
		return map.size();
	}

	@Override
	public MemberBean findById(String id) {
		return map.get(id);
	}

	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean>temp = new ArrayList<>();
		Set<String>keys =map.keySet();
		for(String s:keys){
			if(name.equals(map.get(s).getName())){
				temp.add(map.get(s));
			}	
		}
		return temp;
	}

	@Override
	public void updatePass(MemberBean bean) {
		String key = bean.getId();
		
		if(!bean.getName().equals("")){
			map.get(key).setName(bean.getName());
		}
		if(!bean.getSSN().equals("")){
			map.get(key).setSNN(bean.getSSN());
		}
		if(!bean.getPassword().equals("")){
			map.get(key).setPassword(bean.getPassword());
		}
		
	}
	
	@Override
	public void delete(String id) {
		map.remove(id);
	}
}
