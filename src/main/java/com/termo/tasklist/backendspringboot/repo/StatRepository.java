package com.termo.tasklist.backendspringboot.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.termo.tasklist.backendspringboot.entity.Stat;

/**
 * Created by Termopsis on 13.08.2020.
 */
@Repository
public interface StatRepository extends CrudRepository<Stat,Long> {

}
