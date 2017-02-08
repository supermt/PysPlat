package edu.msstudio.pys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.msstudio.pys.model.Article;
import edu.msstudio.pys.service.ArticleService;

@RestController
@RequestMapping("article")
public class ArticleController {
	
	@Autowired
	private ArticleService as;
	
	@GetMapping("")
	public Result index(@RequestParam(value="n",defaultValue="0") Integer pageNum,
			@RequestParam(value="s",defaultValue="20") Integer pageSize){
		return Result.OK_MUTI(as.getAllArticle(pageNum, pageSize));
	}
	
	@PostMapping("")
	public Result save(@RequestBody Article item){
		if (item.getTitle() == null || item.getFilePath()==null) return Result.ILLEGAL_PARAM();
		return Result.OK(as.save(item));
	}
	
	@DeleteMapping("")
	public Result delete(@RequestParam Long id){
		if (as.delete(id)==null) return Result.MISSING_OBJECT();
		return Result.OK();
	}
	
}
