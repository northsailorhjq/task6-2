package com.jiekexueyuan.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jiekexueyuan.dao.PoetriesDao;
import com.jikexueyuan.model.Poetries;
import com.jikexueyuan.util.DBUtil;

public class PoetriesDaoImpl implements PoetriesDao{

	private Connection connection;
	private java.sql.PreparedStatement ps;
	//用诗人搜索
	public List<Poetries> queryPoetryByName(String name ) {
		String sql = "SELECT a.title , b.name FROM poetries AS a ,poets AS b "+" "
				+ "WHERE b.name=? AND a.poet_id=b.id";
		connection = DBUtil.makeConnection();
		List<Poetries> poetries=new ArrayList<Poetries>();
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rSet = ps.executeQuery();
			
			while(rSet.next()) {
				Poetries p=new Poetries();
				
				p.setTitle(rSet.getString(1));
				p.setName(rSet.getString(2));
			
				poetries.add(p);
			}
			connection.close();
		return poetries;
		
		} catch (SQLException e) {
			System.out.println("捕获到异常信息-----");
			e.printStackTrace();
		}
		try {
			connection.rollback();

		} catch (SQLException e2) {
			System.out.println("事务回滚成功！-----");
			e2.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return poetries;
	}
	//测试用诗人获取作品。
	//public static void main(String[] args) {
		//List<Poetries> poetries=poetriesService.QueryPoetryByName("李世民");
	//	for (Poetries poetries2 : poetries) {
		//	System.out.println(poetries2);
		//}
		
	
//}
	//用题目搜索
	public Poetries queryPeoByTitle(String title) {
		String sql = "SELECT a.title , b.name ,a.content FROM poetries AS a ,poets AS b "+" "
				+ "WHERE a.title=? AND a.poet_id=b.id";
		connection = DBUtil.makeConnection();
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, title);
			ResultSet rSet = ps.executeQuery();
			
		if(rSet.next()) {
				Poetries p=new Poetries();
				
				p.setTitle(rSet.getString(1));
				p.setName(rSet.getString(2));
				p.setContent(rSet.getString(3));
				return p;
			}
		} catch (SQLException e) {
			System.out.println("捕获到异常信息-----");
			e.printStackTrace();
		}
		try {
			connection.rollback();

		} catch (SQLException e2) {
			System.out.println("事务回滚成功！-----");
			e2.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return null;
	}
	
	//测试获取诗的内容。
	//public static void main(String[] args) {
		//PoetriesService poetriesService=new PoetriesService();
		//Poetries p=poetriesService.QueryPoetryByTitle("帝京篇十首");
		//System.out.println(p.getContent());
	//}
	//名句搜索
	public List<Poetries> queryPoetryByContent(String content) {
		   Poetries p=new Poetries();
		String sql = "SELECT a.title , b.name ,a.content FROM poetries AS a  join poets AS b on a.poet_id=b.id WHERE a.content like '%"
				+content+"%'";
		connection = DBUtil.makeConnection();
		try {
			ps = connection.prepareStatement(sql);
			ResultSet rSet = ps.executeQuery();
			List<Poetries> poetries=new ArrayList<Poetries>();
		while (rSet.next()) {
			 
				p.setTitle(rSet.getString(1));
				p.setName(rSet.getString(2));
				p.setContent(rSet.getString(3));
				poetries.add(p);
			}
		return poetries;
		
		} catch (SQLException e) {
			System.out.println("捕获到异常信息-----");
			e.printStackTrace();
		}
		try {
			connection.rollback();

		} catch (SQLException e2) {
			System.out.println("事务回滚成功！-----");
			e2.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return null;
	}
	//public static void main(String[] args) {
		//PoetriesService poetriesService=new PoetriesService();
		//List<Poetries> poetries=poetriesService.QueryPoetryByContent("床前明月光");
		//for (Poetries poetries2 : poetries) {
		//	System.out.println(poetries2);
		//}
		
	//}
}
