
package com.sailu.models.data;


import com.sailu.models.forms.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface QuestionDao extends CrudRepository<Question, Integer> {
}


