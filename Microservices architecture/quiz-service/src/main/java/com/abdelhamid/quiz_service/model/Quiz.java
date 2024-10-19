package com.abdelhamid.quiz_service.model;

import java.util.List;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	private String title ;
	@ElementCollection
	private List<Integer> questionIds ;
	
	

	

}
