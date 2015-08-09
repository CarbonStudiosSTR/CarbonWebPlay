package actionsssss;

public abstract class PlayerAction extends SimpleAction {

    protected Integer id;

    public Integer getId() {
        return id;
    }


    @Override
    public void executeAction() {
        System.out.println("Unidentified Action: " + this.getClass().toString() + " by Entity: " + id);
    }

}
