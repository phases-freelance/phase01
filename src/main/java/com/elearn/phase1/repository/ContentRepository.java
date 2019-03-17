/**
 * 
 */
package com.elearn.phase1.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.elearn.phase1.domain.Content;

/**
 * @author kloudone
 *
 */
public interface ContentRepository extends PagingAndSortingRepository<Content, Long> {

}
