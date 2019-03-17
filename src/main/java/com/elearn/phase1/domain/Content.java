/**
 * 
 */
package com.elearn.phase1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author kloudone
 *
 */
@Entity
@Table(name = "tbl_content")
public class Content {

	@Id
	@GeneratedValue
	private Long id;

	private String describtion;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the describtion
	 */
	public String getDescribtion() {
		return describtion;
	}

	/**
	 * @param describtion the describtion to set
	 */
	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

}
