package com.bizleap.enrollment.domain.utils;

import com.bizleap.enrollment.domain.Section;
import com.bizleap.enrollment.domain.simple.SimpleSection;

public class ConvensionUtils {

	public static Section toSection(SimpleSection simpleSection) {
		Section section = new Section();
		if(simpleSection == null) {
			return null;
		}
		section.setName(simpleSection.getName());
		section.setStartTime(simpleSection.getStartTime());
		section.setEndTime(simpleSection.getEndTime());
		section.setStartDate(simpleSection.getEndDate());
		section.setEndDate(simpleSection.getEndDate());
		return section;
		
	}
}
