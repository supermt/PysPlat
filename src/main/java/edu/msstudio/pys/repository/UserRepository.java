package edu.msstudio.pys.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.msstudio.pys.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{
}
