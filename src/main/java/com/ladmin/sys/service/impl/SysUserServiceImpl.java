package com.ladmin.sys.service.impl;

import java.nio.charset.Charset;
import java.util.List;
import java.util.UUID;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.ladmin.common.vo.PageObject;
import com.ladmin.sys.dao.SysUserDao;
import com.ladmin.sys.entity.SysUser;
import com.ladmin.sys.service.SysUserService;


@Service
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserDao sysUserDao;
	@Override
	public PageObject<SysUser> findPageObjects(String username, Integer pageCurrent) {
	    //对参数进行校验
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("当前页码指无效");
		//查询总记录数并进行校验
		int rowCount=sysUserDao.getRowCounts(username);
		if(rowCount==0)
			throw new IllegalArgumentException("没有找到相对应的记录");
		//查询当前页记录
		int pageSize=2;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysUser> records=sysUserDao.findPageObjects(username,startIndex,pageSize);
		System.out.println(username);
		System.out.println(startIndex);
		System.out.println(pageSize);
		System.out.println(pageSize);
		System.out.println(records);
//		System.out.println(records.toString());
		//对查询结果进行封装并返回
		return new PageObject<>(pageCurrent,rowCount,pageSize,records);
	}
	@Override
	public int saveObject(SysUser entity) {
		//参数校验
		if(entity==null)
			throw new IllegalArgumentException("邮箱格式不正确");
		if(StringUtils.isEmpty(entity.getUser_name()))
			throw new IllegalArgumentException("昵称不能为空");
		if(StringUtils.isEmpty(entity.getUser_email())) 
			throw new IllegalArgumentException("邮箱不能为空");
		if(StringUtils.isEmpty(entity.getUser_password()))
			throw new IllegalArgumentException("密码必须是6到16 个字符");
		//保存用户自身信息
		//2.1对密码进行加密
		String source=entity.getUser_password();
		String salt=UUID.randomUUID().toString();
		SimpleHash sh=new SimpleHash(
				"MD5",//md5算法
				source,//原密码
				salt,//盐值
				1);//加密次数为一次
		entity.setSalt(salt);
		entity.setUser_password(sh.toHex());
		sysUserDao.insertObject(entity);
		return 0;
	}
	@Override
	public int updateObject(SysUser entity) {
		//验证参数的有效性
		if(entity==null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getUser_email()))
			throw new IllegalArgumentException("邮箱不能为空");
		if(StringUtils.isEmpty(entity.getUser_name()))
			throw new IllegalArgumentException("昵称不能为空");
		if(StringUtils.isEmpty(entity.getUser_password()))
			throw new IllegalArgumentException("密码不能为空");
		int rows=sysUserDao.updateObject(entity);
		return rows;
	}
	@Override
	public int updatePassword(Charset user_pwd, Charset newuser_pwd, Charset cfguser_pwd) {
		//判断新密码和确认密码是否相同
		if(StringUtils.isEmpty(newuser_pwd))
			throw new IllegalArgumentException("新密码不能为空");
		if(StringUtils.isEmpty(cfguser_pwd))
			throw new IllegalArgumentException("确认密码不能为空");
		if(!newuser_pwd.equals(cfguser_pwd))
			throw new IllegalArgumentException("两次输入的密码不一致");
		 //判断原密码是否正确
		if(StringUtils.isEmpty(user_pwd))
			throw new IllegalArgumentException("原密码不能为空");
		//获取登录用户
		SysUser user=(SysUser)SecurityUtils.getSubject().getPrincipal();
		SimpleHash sh=new SimpleHash("MD5",user_pwd,user.getSalt(),1); 
		if(!user.getUser_password().equals(sh.toHex()))
			throw new IllegalArgumentException("原密码不正确");
		//对新密码进行加密
		//获取新的盐值
		String salt=UUID.randomUUID().toString();
		sh=new SimpleHash("MD5",newuser_pwd,salt,1);
		return 0;
	}

}
