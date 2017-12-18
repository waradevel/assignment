package com.rambert.assignment.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("clazzesWithStudents") 
public class Student implements GenericModel
{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String lastName;
	private String firstName;
	private Set<Clazz> clazzes = new HashSet<>();

	@Override
	public Long getId()
	{
		return id;
	}

	@Override
	public void setId(Long id)
	{
		this.id = id;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public Set<Clazz> getClazzesWithStudents()
	{
		return clazzes;
	}
	
	public Set<Clazz> getClazzes()
	{
		Set<Clazz> clazzesToShow = new HashSet<>(clazzes);
		Set<Student> emptyList = new HashSet<>();
		for(Clazz clazz : clazzesToShow)
		{
			clazz.setStudents(emptyList);
		}
		return clazzesToShow;
	}

	public void setClazzes(Set<Clazz> clazzes)
	{
		this.clazzes = clazzes;
	}

	@Override
	public void copyAttributes(GenericModel model)
	{
		Student studentModel = (Student) model;
		this.setFirstName(studentModel.getFirstName());
		this.setLastName(studentModel.getLastName());
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (firstName == null)
		{
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null)
		{
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

}
