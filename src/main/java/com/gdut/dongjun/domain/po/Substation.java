package com.gdut.dongjun.domain.po;

import java.util.LinkedList;
import java.util.List;

public class Substation {
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column substation.id
	 *
	 * @mbggenerated Mon Aug 03 14:03:31 CST 2015
	 */
	private String id;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column substation.name
	 *
	 * @mbggenerated Mon Aug 03 14:03:31 CST 2015
	 */
	private String name;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column substation.company_id
	 *
	 * @mbggenerated Mon Aug 03 14:03:31 CST 2015
	 */
	private String companyId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column substation.id
	 *
	 * @return the value of substation.id
	 *
	 * @mbggenerated Mon Aug 03 14:03:31 CST 2015
	 */
	public String getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column substation.id
	 *
	 * @param id
	 *            the value for substation.id
	 *
	 * @mbggenerated Mon Aug 03 14:03:31 CST 2015
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column substation.name
	 *
	 * @return the value of substation.name
	 *
	 * @mbggenerated Mon Aug 03 14:03:31 CST 2015
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column substation.name
	 *
	 * @param name
	 *            the value for substation.name
	 *
	 * @mbggenerated Mon Aug 03 14:03:31 CST 2015
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column substation.company_id
	 *
	 * @return the value of substation.company_id
	 *
	 * @mbggenerated Mon Aug 03 14:03:31 CST 2015
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column substation.company_id
	 *
	 * @param companyId
	 *            the value for substation.company_id
	 *
	 * @mbggenerated Mon Aug 03 14:03:31 CST 2015
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public static List<String> getNames(List<Substation> substations) {

		List<String> list = new LinkedList<String>();
		if (substations != null) {
			for (Substation substation : substations) {
				list.add(substation.getName());
			}
		}
		return list;
	}

}