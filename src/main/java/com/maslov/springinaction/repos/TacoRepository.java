package com.maslov.springinaction.repos;

import com.maslov.springinaction.models.Taco;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> {
}
