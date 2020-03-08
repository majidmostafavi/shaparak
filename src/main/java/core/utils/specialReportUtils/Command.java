package core.utils.specialReportUtils;

/**
 * Created by majid on 6/6/17.
 */
public class Command {

    private Operators key;
    private String title;
    private String value;
    private CommandEnableInf commandEnableInf;
    private CommandActionSupport commandOnComplete;
    private CommandActionSupport commandOnClick;

    public Command(Operators operators, CommandEnableInf commandEnableInf, CommandActionSupport commandOnComplete, CommandActionSupport commandOnClick) {
        this.key = operators;
        this.title = operators.getTitle();
        this.value = operators.getValue();
        this.commandEnableInf = commandEnableInf;
        this.commandOnComplete = commandOnComplete;
        this.commandOnClick = commandOnClick;
    }

    public boolean isEnable(){
        if (commandEnableInf == null)
            return true;
        return commandEnableInf.isEnable();
    }


    public void onClick(){
        if (commandOnClick != null)
            commandOnClick.trigger();
    }

    public void onComplete(){
        if (commandOnComplete != null)
            commandOnComplete.trigger();
    }

    public Operators getKey() {
        return key;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }

}
