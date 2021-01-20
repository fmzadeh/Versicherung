package com.hska.avg.versicherungsantrag;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class KundeDaten {
	private String prename;
	private String surname;
	//private Date geburtsdatum;
	
	private Long risiko;
	
	public KundeDaten() {
		
	}
	public KundeDaten(String prename, String surname, Long risiko) {
		super();
		this.prename = prename;
		this.surname = surname;
		this.risiko = risiko;
	}
	
	public String getPrename() {
		return prename;
	}
	public void setPrename(String prename) {
		this.prename = prename;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Long getRisiko() {
		return risiko;
	}
	public void setRisiko(Long risiko) {
		this.risiko = risiko;
	}
	
	
}
