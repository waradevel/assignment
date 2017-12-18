package com.rambert.assignment.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("studentsWithClasses") 
public class Clazz implements GenericModel
{
	private static final long serialVersionUID = 9070903447056987290L;
	private Long id;
	private String code;
	private String title;
	private String description;
	private Set<Student> students = new HashSet<>();

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Set<Student> getStudentsWithClasses()
	{
		return students;
	}

	
	public Set<Student> getStudents()
	{
		Set<Student> studentsToShow = new HashSet<>(students);
		Set<Clazz> emptyList = new HashSet<>();
		for(Student student : studentsToShow)
		{
			student.setClazzes(emptyList);
		}
		return studentsToShow;
	}

	public void setStudents(Set<Student> students)
	{
		this.students = students;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Clazz other = (Clazz) obj;
		if (code == null)
		{
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null)
		{
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public void copyAttributes(GenericModel model)
	{
		Clazz clazzModel = (Clazz) model;
		this.setCode(clazzModel.getCode());
		this.setTitle(clazzModel.getTitle());
		this.setDescription(clazzModel.getDescription());

	}

}
