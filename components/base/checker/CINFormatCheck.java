package relia.arsf.component.base.checker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CINFormatCheck extends Checker {

	public CINFormatCheck() {
		super("Format du CIN incorrect");
	}

	@Override
	public boolean correct(String message) {
		String regex = "[0-9]{12}";
		Pattern pattern = Pattern.compile( regex, Pattern.CASE_INSENSITIVE );	
		Matcher matcher = pattern.matcher( message.trim() );
		return matcher.find();
	} 
	
}
