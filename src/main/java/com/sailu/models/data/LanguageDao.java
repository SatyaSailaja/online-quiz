package com.sailu.models.data;

import com.sailu.models.forms.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface LanguageDao extends CrudRepository<Language, Integer> {
}
