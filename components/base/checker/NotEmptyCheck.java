package relia.arsf.component.base.checker;


/**
 * Check if field is not empty
 */
public class NotEmptyCheck extends Checker {
	

	public NotEmptyCheck() {
		super("Ce champ est obligatoire");
	}


	@Override
	public boolean correct(String message) {
		return !message.isEmpty();
	}

}
