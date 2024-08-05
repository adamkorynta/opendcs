package lrgs.rtstat.hosts;

import java.io.File;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import lrgs.ldds.LddsClient;

public class LrgsConnectionPanelController {

    private LrgsConnectionPanel view;
    private LrgsConnection selectedConnection = LrgsConnection.BLANK;
    private LrgsConnectionComboBoxModel model = new LrgsConnectionComboBoxModel(new File(LddsClient.getLddsConnectionsFile()));

    /** Defaults do nothing. */
    private Consumer<LrgsConnection> connectionCallBack = c -> {System.out.println("Connecting.");};
    private BiConsumer<LrgsConnection, LrgsConnection> connectionChangedCallback = (old,c) -> {System.out.println("changing connection.");};

    public void setView(LrgsConnectionPanel lrgsConnectionPanel)
    {
        this.view = lrgsConnectionPanel;
        view.setModel(model);
        model.setSelectedItem(LrgsConnection.BLANK);
    }

    public void connect()
    {
        if (selectedConnection != LrgsConnection.BLANK)
        {
            System.out.println("Calling defined connection.");
            connectionCallBack.accept(selectedConnection);
        }
        else
        {
            System.out.println("Connection from fields.");
            connectionCallBack.accept(view.connectionFromFields());
        }
    }

    public void changeConnection(LrgsConnection c)
    {
        LrgsConnection oldConnection = selectedConnection;
        selectedConnection = c;
        connectionChangedCallback.accept(oldConnection, c);
    }

    public void onConnect(Consumer<LrgsConnection> connectCallback)
    {
        this.connectionCallBack = connectCallback;
    }
}
