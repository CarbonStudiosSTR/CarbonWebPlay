package Actions;

public abstract class SimpleAction implements java.io.Serializable, Action {

    @Override
    public void executeAction(Integer id) {
        System.out.println("Unidentified Action: " + this.getClass().toString() + " by Entity: " + id);
    }
}
