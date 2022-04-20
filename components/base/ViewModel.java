package relia.arsf.component.base;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import static relia.arsf.component.base.ComponentState.*;


@MVVMViewModel
public abstract class ViewModel {

	protected final ObjectProperty<ComponentState> state = new SimpleObjectProperty<>();
	protected final ObjectProperty<Object> user_data = new SimpleObjectProperty<>();

    
    public ViewModel() {
        this.state.set(ComponentState.NOT_YET_READY);
    }

	// getters
	
	public ComponentState getState() {
		return this.state.get();
	}

    public ObjectProperty<ComponentState> state() {
		return state;
	}

    public ObjectProperty<Object> user_data() {
		return user_data;
	}

	public void setState(ComponentState state) {
		this.state.set(state);
	}

	public void setUser_data(Object user_data) {
		this.user_data.set(user_data);
	}
}
