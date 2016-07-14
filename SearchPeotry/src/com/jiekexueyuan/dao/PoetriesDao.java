package com.jiekexueyuan.dao;

import java.util.List;

import com.jikexueyuan.model.Poetries;

public interface PoetriesDao {
	public List<Poetries> queryPoetryByName(String name )throws Exception;
	public Poetries queryPeoByTitle(String title) throws Exception;
	public List<Poetries> queryPoetryByContent(String content)throws Exception;
	
}
