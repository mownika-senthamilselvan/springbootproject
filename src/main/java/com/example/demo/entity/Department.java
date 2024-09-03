package com.example.demo.entity;
import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Data
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@Builder
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long departmentID;
	@NotNull(message = "Department name cannot be null")
	@NotBlank(message = "Please Add Department Name")
	private String departmentName;	
	private String departmentAddress;
	private String departmentCode;
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentAddress() {
		return departmentAddress;
	}
	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", departmentName=" + departmentName
				+ ", departmentAddress=" + departmentAddress + ", departmentCode=" + departmentCode + "]";
	}
	public Department() {
		
	}
	
	
	
	
	


	
	
	
	

}
