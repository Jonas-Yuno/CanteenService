package com.ct.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ct.pojo.User;
import com.ct.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	//登录
	public User getUserByEmailAndPassword(String email, String password) {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("email", email)
		.eq("password", password);
		return userMapper.selectOne(wrapper);
	}
	
	//查询全部用户
	public List<User> getAllUser() {
		return userMapper.selectList(null);
	}
	
	//插入
	public int insertUser(User user){
		return userMapper.insert(user);
	}

	public User getUserById(Integer id) {
		return userMapper.selectById(id);
	}

//	@Override
//	public Result updateAdmin(Admin admin) {
//		// ���µķ���ֵ�� ���µ�����(���ݿ�������˼���)
//		int rows = adminMapper.updateAdmin(admin);
//		if (rows == 0) {
//			// ˵��û�и��³ɹ�!
//			return new Result(1, "�޸�ʧ��!");
//		} else {
//			// ˵�����³ɹ�!
//			return new Result(0, "�޸ĳɹ�!");
//		}
//	}



//	public User getUserByUser(User ser) {
//		return adminMapper.get(id);
//	}
//
//	// ��ȡ���й���Ա ����ҳ
//	@Override
//	public Result getAllAdmins(Integer page, Integer limit) {
//		List<Admin> adminList = adminMapper.getAllAdmins();
//		PageHelper.startPage(page, limit);// ������ҳ����(��ҳ��ѯ�Ĳ��)
//		PageInfo<Admin> pageInfo = new PageInfo<>(adminList);
//		Result result = new Result(0, "��ȡ����Ա�б�ɹ�!");
//		result.setCount(pageInfo.getTotal());
//		result.setData(pageInfo.getList());
//		return result;
//	}
//
//	// �����û�����ѯ�û�
//	@Override
//	public Result getAdminByUsername(String username) {
//		Admin admin = adminMapper.getAdminByUsername(username);
//		if(admin == null) {
//			//˵��û�в鵽�����! ��ζ�ſ����������û�
//			return new Result(0,"û�в鵽����û�!");
//		}else {
//			return new Result(1,"����û��Ѿ�����!");
//		}
//	}
//
//	//��ӹ���Ա�����ݿ�
//	@Override
//	public Result insertAdmin(Admin admin) {
//		//rows�ǲ������ݺ�,���ݿⷵ�ص�Ӱ�������. ���������һ��,rows����1
//				int rows = adminMapper.insertAdmin(admin);
//				if(rows != 0) {
//					//˵������ɹ�
//					return new Result(0,"��ӳɹ�!");
//				}else {
//					return new Result(1,"���ʧ��!");
//				}
//	}
//
//
//	//����idɾ���û�
//	@Override
//	public Result deleteAdminById(Integer id) {
//		// rows��ɾ�����ݺ�,���ݿⷵ�ص�Ӱ�������. ����ɾ����һ��,rows����1
//		int rows = adminMapper.deleteAdminById(id);
//		if (rows != 0) {
//			// ˵��ɾ���ɹ�
//			return new Result(0, "ɾ���ɹ�!");
//		} else {
//			return new Result(1, "ɾ��ʧ��!");
//		}
//	}

	
}
