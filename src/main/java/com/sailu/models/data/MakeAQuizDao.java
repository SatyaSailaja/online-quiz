package com.sailu.models.data;


import com.sailu.models.forms.MakeAQuiz;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MakeAQuizDao extends CrudRepository<MakeAQuiz , Integer> {
}
