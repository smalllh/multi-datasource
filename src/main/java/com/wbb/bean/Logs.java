package com.wbb.bean;

import java.io.Serializable;
import java.util.Date;

public class Logs implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column logs.id
     *
     * @mbg.generated Wed Jul 25 17:44:26 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column logs.happen_time
     *
     * @mbg.generated Wed Jul 25 17:44:26 CST 2018
     */
    private Date happenTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column logs.message
     *
     * @mbg.generated Wed Jul 25 17:44:26 CST 2018
     */
    private String message;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table logs
     *
     * @mbg.generated Wed Jul 25 17:44:26 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column logs.id
     *
     * @return the value of logs.id
     *
     * @mbg.generated Wed Jul 25 17:44:26 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column logs.id
     *
     * @param id the value for logs.id
     *
     * @mbg.generated Wed Jul 25 17:44:26 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column logs.happen_time
     *
     * @return the value of logs.happen_time
     *
     * @mbg.generated Wed Jul 25 17:44:26 CST 2018
     */
    public Date getHappenTime() {
        return happenTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column logs.happen_time
     *
     * @param happenTime the value for logs.happen_time
     *
     * @mbg.generated Wed Jul 25 17:44:26 CST 2018
     */
    public void setHappenTime(Date happenTime) {
        this.happenTime = happenTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column logs.message
     *
     * @return the value of logs.message
     *
     * @mbg.generated Wed Jul 25 17:44:26 CST 2018
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column logs.message
     *
     * @param message the value for logs.message
     *
     * @mbg.generated Wed Jul 25 17:44:26 CST 2018
     */
    public void setMessage(String message) {
        this.message = message;
    }
}