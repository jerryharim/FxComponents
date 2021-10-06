package mg.fxComponent.base;



/**
 * Super class for all controller
 * @param <T> : T represent a ViewModel Class
 */

@MVVMView
public abstract class View<T> {
    protected T viewModel;

    public View(T viewModel) {
        this.viewModel = viewModel;
    }


    @ViewModelSynchronisation
    public abstract void sync_with_view_model();


    // getters

    public T getViewModel() {
        return viewModel;
    }
}
