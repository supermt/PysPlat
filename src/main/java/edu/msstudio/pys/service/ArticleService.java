package edu.msstudio.pys.service;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.msstudio.pys.model.Article;
import edu.msstudio.pys.repository.ArticleDAO;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleDAO aD;
	
	public Page<Article> getAllArticle(int pageNum,int pageSize){
		Pageable pageable = new PageRequest(pageNum, pageSize);
		return aD.findAll(pageable);
		
	}
	
	public Article save(Article input){
		if (input.getId()==null) return aD.save(input);
		else {
			Article target = aD.findOne(input.getId());
			if (target ==null) return aD.save(input);
			for (Field f: input.getClass().getFields()){
				f.setAccessible(true);
				if (Modifier.isStatic(f.getModifiers()) || Modifier.isFinal(f.getModifiers()) || Modifier.isVolatile(f.getModifiers()))
			    	continue;
				else
					try {
						if (f.get(input) == null || f.get(input).equals("")) {
						    continue;
						}
						else {
							f.set(target,f.get(input));
						}
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
			}
			return aD.save(target);
		}
	}
	
	public Long delete(Long id){
		try{
			aD.delete(id);
			return 0L;
		}catch(Exception e){
//			e.printStackTrace();
			return null;
		}
	}
	
	
}
