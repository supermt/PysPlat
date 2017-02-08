package edu.msstudio.pys.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.msstudio.pys.model.Article;

public interface ArticleDAO extends PagingAndSortingRepository<Article, Long> {
	
	@Query(value = "Select A from Article A where A.title like ?1")
	public Page<Article> searchLikeTitle(String title,Pageable pageable);
	
	@Query(value = "Select A from Article A where A.id = ?1")
	public Article findByID(Long id);
	
}
