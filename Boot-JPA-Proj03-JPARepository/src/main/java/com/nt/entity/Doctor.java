package com.nt.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Doctor's_Information)")
public class Doctor implements Serializable {
	@Column(name="Doc_Id")
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "gen1",sequenceName="DOC_ID_SEQ1",initialValue=1000,allocationSize = 2)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer docId;
	@Column(name="Doc_Name", length=25)
	private String docName;
	@Column(name="Specialization", length = 25)// Since the Property name and column names are matching so if we not take column name then there is no issue it will take"specialization" as the column name
	private String specialization;
	@Column(name="Income")
	private Double income;

}
