package edu.msstudio.pys.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Persistable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
public class User {

	@Getter
    @Setter
    @Id
    @Column(name = "id")
    private Long id;
	
	@Column(name="username",nullable=false)
	private String username;
	
	@Column(name = "password", nullable = false)
    @JsonIgnore
    private String userPass;
	
}
