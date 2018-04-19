package proj;

public class DateConverter {
	
	String convertDate(String oldDate) {
		String newDate;
		boolean month = false;
		boolean day = false;
		String oldDateStr[] = oldDate.split("-");
		int oldDateInt[] = new int[2];
		oldDateInt[0] = Integer.parseInt(oldDateStr[1]);
		oldDateInt[1] = Integer.parseInt(oldDateStr[2]);
		if (oldDateInt[0]<10)
			month = true;
		if (oldDateInt[1]<10)
			day = true;
		
		if (month == true && day == true)
			newDate = oldDateStr[0] + "-0" + oldDateStr[1] + "-0" + oldDateStr[2];
		else if (month == false && day == true)
			newDate = oldDateStr[0] + "-" + oldDateStr[1] + "-0" + oldDateStr[2];
		else if (month == true && day == false)
			newDate = oldDateStr[0] + "-0" + oldDateStr[1] + "-" + oldDateStr[2];
		else 
			newDate = oldDateStr[0] + "-" + oldDateStr[1] + "-" + oldDateStr[2];
		
		return newDate;
	}
}
