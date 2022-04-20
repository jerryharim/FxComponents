package relia.arsf.component.base;


/**
 * Used by a component that have 
 * one or many childrens that need to mount 
 * directly by default
 */

public interface DirectChildrens {

	void initialize_childrens();

	void mount_childrens() throws ComponentMountException;
}

